import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 31.03.12
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class Enjine {

    protected double [] startPoint = null;
    protected double [] currentPoint = null;
    protected double [][] scope2D = null;
    protected double [][] scope3D = null;

    protected double calculationStep = 1e-4;
    protected double lastIteration = 0;
    protected double iterationLimit = 100000;

    enum CalculationMethod {
        CalculationMethodRKLevel4,
        CalculationMethodRKLevel6,
        CalculationMethodRKLevel8
    };

    enum StartingConditions {
        StartingConditionZeroPotentials,
        StartingConditionZeroDerivatives,
        StartingConditionRandom
    };

    enum CalculationMode {
        CalculationModeTriplet,
        CalculationModeOctplet
    }

    public static final int TripletDimension = 18;
    public static final int OctpletDimension = 48;

    protected CalculationMethod calculationMethod = CalculationMethod.CalculationMethodRKLevel4;
    protected StartingConditions startingConditions = StartingConditions.StartingConditionZeroDerivatives;
    protected CalculationMode calculationMode = CalculationMode.CalculationModeTriplet;


    public void begin(CalculationMethod method,
                      StartingConditions conditions,
                      CalculationMode mode,
                      int totalLimit,
                      double step) {

        calculationMethod = method;
        startingConditions = conditions;
        calculationMode = mode;
        iterationLimit = totalLimit;
        calculationStep = step;
    }

    public void begin(Boolean loadFromFile) {

    }

    public double getCalculationStep() {
        return calculationStep;
    }

    public double getLastIteration() {
        return lastIteration;
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

    public void saveState(String filePath) {
        File file = new File(filePath);
        try {

            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file),128));

            FileOutputStream stream = null;

            output.writeDouble(calculationStep);
            output.writeDouble(lastIteration);
            output.writeDouble(iterationLimit);

            output.writeUTF(calculationMethod.toString());
            output.writeUTF(startingConditions.toString());
            output.writeUTF(calculationMode.toString());

            output.writeInt(currentPoint.length);
            for (int i = 0; i < currentPoint.length; i++) {
                output.writeDouble(currentPoint[i]);
            }

            output.writeInt(scope2D.length);
            output.writeInt(scope2D[0].length);

            for (int i = 0; i < scope2D.length; i++) {
                for (int j = 0; j < scope2D[0].length; j++) {
                    output.writeDouble(scope2D[i][j]);
                }
            }

            output.writeInt(scope3D.length);
            output.writeInt(scope3D[0].length);

            for (int i = 0; i < scope3D.length; i++) {
                for (int j = 0; j < scope3D[0].length; j++) {
                    output.writeDouble(scope3D[i][j]);
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

            DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file),128));

            calculationStep = inputStream.readDouble();
            lastIteration = inputStream.readDouble();
            iterationLimit = inputStream.readDouble();

            calculationMethod = CalculationMethod.valueOf(inputStream.readUTF());
            startingConditions = StartingConditions.valueOf(inputStream.readUTF());
            calculationMode = CalculationMode.valueOf(inputStream.readUTF());

            startPoint = new double[inputStream.readInt()];

            for (int i = 0; i < currentPoint.length; i++) {
                currentPoint[i] = inputStream.readDouble();
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

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    scope3D[i][j] = inputStream.readDouble();
                }
            }
        } catch (Exception e) {
            System.out.println("Caused exception: " + e.getLocalizedMessage());
        }
    }
}
