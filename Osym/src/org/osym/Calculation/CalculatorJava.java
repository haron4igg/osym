package org.osym.Calculation;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 11.02.12
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */

import sun.awt.Mutex;


public class CalculatorJava extends CalculatorBase implements Calculator {


    protected Functions helperFunctions;

    protected Mutex pauseMutex = new Mutex();
    public void pause() {

        if (!isPaused) {
            pauseMutex.lock();
        } else {
            pauseMutex.unlock();
        }
        isPaused = !isPaused;
    }

    public void stop() {
        if (isPaused) {
            pauseMutex.unlock();
        }
        cancel = true;
    }

    public CalculatorJava(Functions functions) {
        helperFunctions = functions;
    }


    public void fillMatrix(double[][] k, double[] input, double[] temp, double step, int index) {

        int dim2 = input.length / 2;

        for (int j = 0; j < dim2; j++)
            k[j][index] = input[j + dim2] + step * temp[j + dim2];

        for (int i = 0; i < dim2; i += 3) {
            for (int j = dim2 + i; j < dim2 + i + 3; j++) {
                switch (i / 3) {
                    case 0: {
                        k[j][index] = helperFunctions.func1(input, j, temp, step);
                        break;
                    }
                    case 1: {
                        k[j][index] = helperFunctions.func2(input, j, temp, step);
                        break;
                    }
                    case 2: {
                        k[j][index] = helperFunctions.func3(input, j, temp, step);
                        break;
                    }
                    case 3: {
                        k[j][index] = helperFunctions.func4(input, j, temp, step);
                        break;
                    }
                    case 4: {
                        k[j][index] = helperFunctions.func5(input, j, temp, step);
                        break;
                    }
                    case 5: {
                        k[j][index] = helperFunctions.func6(input, j, temp, step);
                        break;
                    }
                    case 6: {
                        k[j][index] = helperFunctions.func7(input, j, temp, step);
                        break;
                    }
                    case 7: {
                        k[j][index] = helperFunctions.func8(input, j, temp, step);
                        break;
                    }
                    default: {

                    }
                }
            }
        }
    }

    public double[] solveByRK(double[] input, double[][] coefs, double[] coefs2, double step) {

        int dim = input.length;
        int coefLength = coefs[0].length;

        double[][] k1 = new double[dim][coefLength];
        double[] temp = new double[dim];

        for (int s = 0; s < dim; s++)
            temp[s] = 0;

        fillMatrix(k1, input, temp, step, 0);

        for (int j = 1; j < coefLength; j++) {

            temp = new double[dim];

            for (int ss = 0; ss < dim; ss++) {
                temp[ss] = 0;
                for (int s = 0; s < j; s++)
                    temp[ss] += coefs[j][s] * k1[ss][s];
            }

            fillMatrix(k1, input, temp, step, j);

        }

        for (int s = 0; s < dim; s++)
            temp[s] = 0;

        for (int ss = 0; ss < dim; ss++)
            for (int s = 0; s < coefLength; s++)
                temp[ss] += coefs2[s] * k1[ss][s];

        for (int s = 0; s < dim; s++)
            input[s] = input[s] + step * temp[s];

        return input;
    }

    public void run(double[][] coefs,
                    double[] coefs2,
                    double[] input,
                    double from,
                    double total,
                    double step,
                    CalcListener listener) {
        isWorking = true;
        isPaused = false;
        cancel = false;

        long execStart = System.currentTimeMillis();

        double iteration = from * step;

        if (listener != null) {
            listener.calculationStarted(iteration, total);
        }

        while (iteration < total && !cancel) {

            if (isPaused) {
                if (listener != null) {
                    listener.calculationPaused();
                }
                pauseMutex.lock();
                pauseMutex.unlock();
                if (listener != null) {
                    listener.calculationResumed();
                }
            }

            solveByRK(input, coefs, coefs2, step);

            if (listener != null) {
                listener.onReceivePoints(iteration, input.clone(), step);
            }

            iteration += step;
        }
        if (listener != null) {
            if (!cancel) {
                listener.onDone(System.currentTimeMillis() - execStart, input, iteration);
            } else {
                listener.onStop();
            }
        }
        isWorking = false;
    }


    /*
public void negolonomnost(double[] input,
                          double[][] negolTest,
                          int negolIndex,
                          double t) {

    double SymbN[][] = {{0.0, 0.0, 0.0, -input[6], -input[7], -input[8], input[3], input[4], input[5]},
            {input[6], input[7], input[8], 0.0, 0.0, 0.0, -input[0], -input[1], -input[2]},
            {-input[3], -input[4], -input[5], input[0], input[1], input[2], 0.0, 0.0, 0.0}};

    for (int i = 0; i < 3; i++)
        negolTest[i][negolIndex] = 0.0;
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 9; j++)
            negolTest[i][negolIndex] += SymbN[i][j] * input[9 + j];

    for (int i = 0; i < 3; i++)
        negolTest[i][negolIndex] = Math.log10(Math.abs(negolTest[i][negolIndex]));
    negolTest[3][negolIndex] = t;
}



public double func(double[] input, int size, int rowIndex) {
    double[][] matrix = new double[size][size];
    double temp = 0;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < input.length; k++) {
                matrix[i][j] = -input[3 * i + k] * input[j * 3 + k];
            }
        }
    }

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            temp = 0;

            for (int k = 0; k < size; k++) {
                for (int p = 0; p < size; p++) {
                    temp += matrix[i][j] * unknownMatrix[k][i][j][p];
                }
            }
            matrix[i][j] = temp;
        }
    }

    for (int i = 0; i < size; i++) {
        temp += matrix[(rowIndex - input.length / 2) / 3][i] * input[i * 3 + rowIndex % 3];
    }

    return temp;
}

protected static void swapCells(int i, int j, int k, double value) {
    stuctComponentsSU3[i][j][k] = stuctComponentsSU3[j][k][i] = stuctComponentsSU3[k][i][j] = value;
    stuctComponentsSU3[j][i][k] = stuctComponentsSU3[k][j][i] = stuctComponentsSU3[i][k][j] = -value;
}

protected static void initializeUnknownMatrix() { //:)
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                for (int p = 0; p < 8; p++) {
                    unknownMatrix[i][j][k][p] = 0;
                    for (int g = 0; g < 8; g++) {
                        unknownMatrix[i][j][k][p] += stuctComponentsSU3[k][i][g] * stuctComponentsSU3[j][p][g];
                    }
                }
            }
        }
    }
}

protected static void initializeU3Components() {
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                stuctComponentsSU3[i][j][k] = 0;
            }
        }
    }

    swapCells(0, 1, 2, 1.0);
    swapCells(0, 3, 6, 0.5);
    swapCells(1, 3, 5, 0.5);
    swapCells(1, 4, 6, 0.5);
    swapCells(2, 3, 4, 0.5);
    swapCells(0, 4, 5, -0.5);
    swapCells(2, 5, 6, -0.5);
    swapCells(3, 4, 7, Math.sqrt(3.0) / 2.0);
    swapCells(5, 6, 7, Math.sqrt(3.0) / 2.0);
}
    */
}
