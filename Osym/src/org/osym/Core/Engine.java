package org.osym.Core;

import org.osym.Calculation.*;
import org.osym.Images.Image2D;
import org.osym.Images.ImageManager;

import java.io.*;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 31.03.12
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */

public class Engine implements ImageManager.ImageManagerDelegate {

    public interface EngineDelegate {

        public void calculationProgressDidChange(int progress);
        public void drawingProgressDidChange(int progress);

        public void coreConfigurationDone(Engine core);

        public void calculationPaused();
        public void calculationResumed();
        public void calculationBegan(int progress);
        public void calculationDone();
        public void calculationFailed(Exception e);

        public void stateRestored();
        public void stateSaved();
    }

    protected EngineDelegate delegate = null;

    protected double[] startPoint = null;
    protected double[] currentPoint = null;
    protected double[][] scope2D = null;
    protected double[][] scope2DMax = null;

    protected double calculationStep = 1e-4;
    protected double startIteration = 0;
    protected double iterationLimit = 10;

    protected long totalExecutionTime = 0;
    protected long totalPointsProduced = 0;

    protected Boolean testMode = true;

    protected Boolean scopeProcessed = false;
    protected Boolean configurationChanged = false;

    protected Calculator calculator = null;
    protected ProgressHandler progressHandler = null;
    protected ImageManager imageManager = null;
    protected Functions functionsManager = null;

    protected HashMap<Integer, Image2D> images = null;

    public enum CalculationMethod {
        CalculationMethodRKLevel4,
        CalculationMethodRKLevel6,
        CalculationMethodRKLevel8
    }

    public static final int RKLevel4 = 4;
    public static final int RKLevel6 = 7;
    public static final int RKLevel8 = 13;

    public enum StartingConditions {
        StartingConditionZeroPotentials,
        StartingConditionZeroDerivatives,
        StartingConditionRandom
    }
    public enum CalculationMode {
        CalculationModeTriplet,
        CalculationModeTripletNative,
        CalculationModeTripletNativeJNI,
        CalculationModeOctplet
    }

    public static final int imagesWidth = 602;
    public static final int imagesHeight = 402;

    public static final int TripletDimension = 18;
    public static final int OctpletDimension = 48;

    protected CalculationMethod calculationMethod = CalculationMethod.CalculationMethodRKLevel8;
    protected StartingConditions startingConditions = StartingConditions.StartingConditionZeroDerivatives;
    protected CalculationMode calculationMode = CalculationMode.CalculationModeTriplet;

    public void begin() {
        if (configurationChanged) {
            resetConfiguration();
            configurationChanged = false;
        }
        clearImages();
        execute();
    }

    public void pause() {
        calculator.pause();
    }

    public void start() {
        calculator.pause();
    }

    public void stop() {
        calculator.stop();
        calculator = null;
        resetConfiguration();
    }

    public void initializeImages() {
        images = new HashMap<Integer, Image2D>();

        int dim = getDimensions(this.calculationMode);

        images.put(0, new Image2D("Вычислительная погрешность", imagesWidth, imagesHeight, dim+1,dim));
    }

    void resetConfiguration() {
        initializeImages();
        if (imageManager != null) {
            imageManager.stop();
        }
        scopeProcessed = false;
        currentPoint = null;
        calculator = null;
        functionsManager = null;
        scope2D = null;
        scope2DMax = null;
        startPoint = null;
    }


    public void clearImages() {
        for (Image2D image : this.getImages().values()) {
            image.clearImage();
        }
    }

    public Engine() {
        resetConfiguration();
    }

    protected void execute() {

        if (calculator == null || !calculator.isWorking()) {

            int dimension = getDimensions(this.calculationMode);
            int rkLevel = RKLevel4;

            this.functionsManager = (calculationMode == CalculationMode.CalculationModeOctplet) ? new OctpletFunctions() : new TripletFunctions();

            double[][] coefsMatrix = null;
            double[] coefsMass = new double[dimension];

            switch (calculationMethod) {
                case CalculationMethodRKLevel4: {
                    rkLevel = RKLevel4;
                    coefsMatrix = new double[dimension][rkLevel];
                    functionsManager.masRK4(coefsMass, coefsMatrix, rkLevel);
                    break;
                }
                case CalculationMethodRKLevel6: {
                    rkLevel = RKLevel6;
                    coefsMatrix = new double[dimension][rkLevel];
                    functionsManager.masRKB6(coefsMass, coefsMatrix, rkLevel);
                    break;
                }
                case CalculationMethodRKLevel8: {
                    rkLevel = RKLevel8;
                    coefsMatrix = new double[dimension][rkLevel];
                    functionsManager.masRKF8(coefsMass, coefsMatrix, rkLevel);
                    break;
                }
            }

            switch (calculationMode) {
                case CalculationModeTripletNative:  {
                    calculator = new CalculatorNativeBridj();
                    break;
                }
                case CalculationModeTripletNativeJNI: {
                    calculator = new JNICalculator();
                    break;
                }
                default:
                    calculator = new CalculatorJava(functionsManager);
            }


            if (startPoint == null) {
                startPoint = new double[dimension];
                functionsManager.setupStartPoint(startPoint, this.startingConditions.ordinal());
            }

            currentPoint = startPoint.clone();

            if (scope2D == null || scope2DMax == null) {
                int dim2 = dimension / 2;

                scope2D = new double[dimension][dim2];
                scope2DMax = new double[dimension + 4][2];

                scope2DMax[dimension][0] = -16;
                scope2DMax[dimension][1] = (this.calculationMode == CalculationMode.CalculationModeOctplet ) ? -10.0 : -5.0;
                scope2DMax[dimension + 1][0] = 0;
                scope2DMax[dimension + 1][1] = iterationLimit;

                for (int i1 = 0; i1 < dim2; i1++) {
                    scope2D[i1 + dim2][i1] = currentPoint[i1];
                    scope2D[i1][i1] = currentPoint[i1];
                    scope2D[i1 + dim2][0] = currentPoint[i1 + dim2];
                    scope2D[i1 + dim2][1] = currentPoint[i1 + dim2];
                }
            }



            this.imageManager = new ImageManager(imagesWidth, imagesHeight, scope2D, scope2DMax, this.functionsManager);
            this.imageManager.setImages2D(this.getImages());
            this.imageManager.setDelegate(this);

            progressHandler = new ProgressHandler();

            totalExecutionTime = System.currentTimeMillis();
            totalPointsProduced = 0;

            if (delegate != null) {
                delegate.coreConfigurationDone(this);
            }

            if (isTestMode()) {
                coefsMatrix = new double[][] {
                        { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.07407407407407407, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.027777777777777776, 0.08333333333333333, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.041666666666666664, 0.0, 0.125, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.4166666666666667, 0.0, -1.5625, 1.5625, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.05, 0.0, 0.0, 0.25, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {-0.23148148148148148, 0.0, 0.0, 1.1574074074074074, -2.4074074074074074, 2.314814814814815, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.10333333333333333, 0.0, 0.0, 0.0, 0.27111111111111114, -0.2222222222222222, 0.014444444444444444, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {2.0, 0.0, 0.0, -8.833333333333334, 15.644444444444444, -11.88888888888889, 0.7444444444444445, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {-0.8425925925925926, 0.0, 0.0, 0.21296296296296297, -7.229629629629629, 5.7592592592592595, -0.31666666666666665, 2.8333333333333335, -0.08333333333333333, 0.0, 0.0, 0.0, 0.0},
                        {0.5812195121951219, 0.0, 0.0, -2.0792682926829267, 4.3863414634146345, -3.6707317073170733, 0.5202439024390244, 0.5487804878048781, 0.27439024390243905, 0.43902439024390244, 0.0, 0.0, 0.0},
                        {0.014634146341463415, 0.0, 0.0, 0.0, 0.0, -0.14634146341463414, -0.014634146341463415, -0.07317073170731707, 0.07317073170731707, 0.14634146341463414, 0.0, 0.0, 0.0},
                        {-0.43341463414634146, 0.0, 0.0, -2.0792682926829267, 4.3863414634146345, -3.524390243902439, 0.5348780487804878, 0.6219512195121951, 0.20121951219512196, 0.2926829268292683, 0.0, 1.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                        {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}
                };

                coefsMass = new double[] {0.04880952380952381, 0.0, 0.0, 0.0, 0.0, 0.3238095238095238, 0.2571428571428571, 0.2571428571428571, 0.03214285714285714, 0.03214285714285714, 0.0, 0.0, 0.04880952380952381, 0.0, 0.0, 0.0, 0.0, 0.0};
                currentPoint = new double[]  {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5446230076646713, 0.257800690054833, 0.25436137854197866, 0.2461605091991794, -0.3193534630602443, 0.628712774525114, 0.5874934622379206, -0.5699922058548407, 0.5867911096969345};
            }

            calculator.runAsync(coefsMatrix, coefsMass, currentPoint, startIteration, iterationLimit, calculationStep, progressHandler);
        }
    }


    @Override
    public void paintOperationDone(double iteration) {
        if (delegate != null) {
            if (iteration < iterationLimit) {
                delegate.drawingProgressDidChange((int)(iteration/iterationLimit * 100));
            } else {
                delegate.drawingProgressDidChange(100);
                delegate.calculationDone();
                System.out.println("Total time: " +(System.currentTimeMillis() - totalExecutionTime) + " Produced points: " + totalPointsProduced);
            }
        }
    }

    @Override
    public void paintOperationFailed(Exception e) {
        if (delegate != null)
            delegate.calculationFailed(e);
    }

    protected class ProgressHandler implements CalculatorJava.CalcListener {
        @Override
        public void calculationStarted(double from, double to) {
            if (delegate != null)
                delegate.calculationBegan((int)(from/to));
        }

        @Override
        public void calculationPaused() {
            if (delegate != null)
                delegate.calculationPaused();
        }

        @Override
        public void calculationResumed() {
            if (delegate != null)
                delegate.calculationResumed();
        }

        @Override
        public void calculationStopped() {
            if (delegate != null)
                delegate.calculationDone();
        }

        @Override
        public void calculationFailed(Exception e) {
            if (delegate != null)
                delegate.calculationFailed(e);
        }

        @Override
        public void calculationReceivedPoints(double iteration, double[] point, double step) {
            totalPointsProduced++;

            functionsManager.kiral_func(point, iteration);

            if (!scopeProcessed) {
                int dim2 = point.length / 2;

                for (int s = 0; s < dim2; s++) {
                    if (point[s] > scope2D[s + dim2][s]) {
                        for (int j = 0; j < dim2; j++) {
                            scope2D[s + dim2][j] = point[j];
                        }
                    } else if (point[s] < scope2D[s][s]) {
                        for (int j = 0; j < dim2; j++) {
                            scope2D[s][j] = point[j];
                        }
                    }

                    if (point[s + dim2] > scope2DMax[s + dim2][1]) {
                        scope2DMax[s + dim2][1] = point[s + dim2];
                    } else if (point[s + dim2] < scope2DMax[s + dim2][0]) {
                        scope2DMax[s + dim2][0] = point[s + dim2];
                    }
                }
            }
            delegate.calculationProgressDidChange((int)(iteration/iterationLimit * 100));
            startIteration = iteration;
            imageManager.paintImagesAsync(iteration, point);
        }

        @Override
        public void calculationDone(long executionTime, double [] point, double iteration) {
            System.out.println("Calculation done in: " + executionTime);
            if (!scopeProcessed) {
                int dim2 = currentPoint.length / 2;
                for (int s = 0; s < dim2; s++) {
                    scope2DMax[s][0] = scope2D[s][s] - Math.abs(scope2D[s + dim2][s] - scope2D[s][s]) * 0.1;
                    scope2DMax[s][1] = scope2D[s + dim2][s] + Math.abs(scope2D[s + dim2][s] - scope2D[s][s]) * 0.2;
                    scope2DMax[s + dim2][0] = scope2DMax[s + dim2][0] - Math.abs(scope2DMax[s + dim2][1] - scope2DMax[s + dim2][0]) * 0.1;
                    scope2DMax[s + dim2][1] = scope2DMax[s + dim2][1] + Math.abs(scope2DMax[s + dim2][1] - scope2DMax[s + dim2][0]) * 0.2;
                }
                scopeProcessed = true;
            }
            delegate.calculationProgressDidChange(100);
            imageManager.paintImagesAsync(iteration, point);
        }
    }


    public double getCalculationStep() {
        return calculationStep;
    }

    public double getStartIteration() {
        return startIteration;
    }

    public double getIterationLimit() {
        return iterationLimit;
    }

    public CalculationMode getCalculationMode() {
        return calculationMode;
    }

    public StartingConditions getStartingConditions() {
        return startingConditions;
    }

    public CalculationMethod getCalculationMethod() {
        return calculationMethod;
    }

    public void setCalculationStep(double calculationStep) {
        if (this.calculationStep != calculationStep) {
            configurationChanged = true;
        }
        this.calculationStep = calculationStep;
    }

    public void setIterationLimit(double iterationLimit) {
        if (this.iterationLimit != iterationLimit) {
            configurationChanged = true;
        }
        this.iterationLimit = iterationLimit;
    }

    public void setCalculationMethod(CalculationMethod calculationMethod) {
        if (this.calculationMethod != calculationMethod) {
            configurationChanged = true;
        }
        this.calculationMethod = calculationMethod;
    }

    public void setCalculationMode(CalculationMode calculationMode) {
        if (this.calculationMode != calculationMode) {
            configurationChanged = true;
        }
        this.calculationMode = calculationMode;
    }

    public void setStartingConditions(StartingConditions startingConditions) {
        if (this.startingConditions != startingConditions) {
            configurationChanged = true;
        }
        this.startingConditions = startingConditions;
    }

    public void setStartIteration(double startIteration) {

        this.startIteration = startIteration;
    }

    public void saveState(String filePath) {
        File file = new File(filePath);
        try {

            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file), 128));

            output.writeDouble(calculationStep);
            output.writeDouble(startIteration);
            output.writeDouble(iterationLimit);

            output.writeUTF(calculationMethod.toString());
            output.writeUTF(startingConditions.toString());
            output.writeUTF(calculationMode.toString());

            output.writeInt(startPoint.length);
            for (int i = 0; i < startPoint.length; i++) {
                output.writeDouble(startPoint[i]);
            }

            output.writeInt(scope2D.length);
            output.writeInt(scope2D[0].length);

            for (int i = 0; i < scope2D.length; i++) {
                for (int j = 0; j < scope2D[0].length; j++) {
                    output.writeDouble(scope2D[i][j]);
                }
            }

            output.writeInt(scope2DMax.length);
            output.writeInt(scope2DMax[0].length);

            for (int i = 0; i < scope2DMax.length; i++) {
                for (int j = 0; j < scope2DMax[0].length; j++) {
                    output.writeDouble(scope2DMax[i][j]);
                }
            }

            output.flush();

        } catch (Exception e) {
            System.out.println("Caused exception: " + e.getLocalizedMessage());
        }
    }
    public void loadState(String filePath) {

        File file = new File(filePath);

        try {

            DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file), 128));

            calculationStep = inputStream.readDouble();
            startIteration = inputStream.readDouble();
            iterationLimit = inputStream.readDouble();

            calculationMethod = CalculationMethod.valueOf(inputStream.readUTF());
            startingConditions = StartingConditions.valueOf(inputStream.readUTF());
            calculationMode = CalculationMode.valueOf(inputStream.readUTF());

            startPoint = new double[inputStream.readInt()];

            for (int i = 0; i < startPoint.length; i++) {
                startPoint[i] = inputStream.readDouble();
            }

            int height = inputStream.readInt();
            int width = inputStream.readInt();

            scope2D = new double[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    scope2D[i][j] = inputStream.readDouble();
                }
            }

            height = inputStream.readInt();
            width = inputStream.readInt();

            scope2DMax = new double[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    scope2DMax[i][j] = inputStream.readDouble();
                }
            }
            configurationChanged = false;
            scopeProcessed = true;
        } catch (Exception e) {
            System.out.println("Caused exception: " + e.getLocalizedMessage());
        }
    }

    public EngineDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(EngineDelegate delegate) {
        this.delegate = delegate;
    }

    public HashMap<Integer, Image2D> getImages() {
        return images;
    }

    public int getDimensions(CalculationMode calcMode) {
        return (calcMode == CalculationMode.CalculationModeOctplet) ? OctpletDimension : TripletDimension;
    }

    public Boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(Boolean testMode) {
        this.testMode = testMode;
    }
}
