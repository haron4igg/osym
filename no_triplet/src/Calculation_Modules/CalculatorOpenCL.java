package Calculation_Modules;

import static com.nativelibs4java.opencl.JavaCL.createBestContext;

import com.nativelibs4java.opencl.*;
import com.nativelibs4java.util.IOUtils;
import org.bridj.Pointer;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 05.03.12
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorOpenCL {

    CLContext context = null;
    CLQueue queue = null;

    double [] inputMas = null;
    double [][] coefficients = null;
    double [] coefficients2 = null;
    double calcStep = 0.0;
    int work = 0;
    public double [][] resultMatrix;
    public int [][] resultImage;

    String source = null;
    //


    public CalculatorOpenCL(double[] input,  double[][] coefs, double[] coefs2, double step, int totalWork) {
        work = totalWork;
        inputMas = input;
        coefficients = coefs;
        coefficients2 = coefs2;
        calcStep = step;

        context = createBestContext();
        queue = context.createDefaultQueue();
        String src = null;
        try {
            source = IOUtils.readText(CalculatorOpenCL.class.getResourceAsStream("calculate_kernel.cl"));
        } catch (Exception e) {

        }
    }

    public long dispatchToGPU() {
        CLContext context = queue.getContext();
        long startTime = System.currentTimeMillis();

        CLProgram program = null;

        //System.out.println(source);

        try {
            program = context.createProgram(kernel).build();
        } catch (CLBuildException e) {
            System.out.println("Excrption " + e.getLocalizedMessage());
            return -1;
        }



        Pointer<Pointer<Float>> results = Pointer.allocateFloats(18,9).order(context.getByteOrder());
        Pointer<Pointer<Integer>> image = Pointer.allocateInts(602,402).order(context.getByteOrder());

        //Pointer<Double> results = Pointer.allocateDoubles(18*9).order(context.getByteOrder());
        //Pointer<Integer> image = Pointer.allocateInts(602*402).order(context.getByteOrder());

        CLKernel kernel = program.createKernel(
                "calculate",
                inputMas,
                coefficients,
                coefficients2,
                calcStep,
                context.createBuffer(CLMem.Usage.Output, results, false),
                context.createBuffer(CLMem.Usage.Output, image, false)
        );

        kernel.enqueueNDRange(queue, new int[]{1}, new int[]{work});

        for (int i = 0; i < 18; i++) {
            resultMatrix[i] = results.get(i).getDoubles();
        }

        for (int i = 0; i < 602; i++) {
            resultImage[i] = image.get(i).getInts();
        }

        queue.finish();
        long time = System.currentTimeMillis() - startTime;
        return time;
    }




    public String kernel = "\n" +
            "    float Svec(float* v1, float* v2) {\n" +
            "\t    return (float)(v1[0]*v2[0]+v1[1]*v2[1]+v1[2]*v2[2]);\n" +
            "    }\n" +
            "\n" +
            "    float triplet_func1(float *input, int j, float* mas, float step) {\n" +
            "        float v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};\n" +
            "        float v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};\n" +
            "        float v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};\n" +
            "\n" +
            "        return (float) (-v1[j % 3] * (Svec(v2, v2) + Svec(v3, v3)) + v2[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v1, v3));\n" +
            "    }\n" +
            "\n" +
            "    float triplet_func2(float *input, int j, float* mas, float step) {\n" +
            "        float v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};\n" +
            "        float v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};\n" +
            "        float v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};\n" +
            "\n" +
            "        return (float) (-v2[j % 3] * (Svec(v1, v1) + Svec(v3, v3)) + v1[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v2, v3));\n" +
            "    }\n" +
            "\n" +
            "    float triplet_func3(float *input, int j, float* mas, float step) {\n" +
            "        float v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};\n" +
            "        float v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};\n" +
            "        float v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};\n" +
            "\n" +
            "        return (float) (-v3[j % 3] * (Svec(v2, v2) + Svec(v1, v1)) + v2[j % 3] * Svec(v3, v2) + v1[j % 3] * Svec(v1, v3));\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "\n" +
            "    void fillMatrix(float** k, float* input, float* temp, float step, int index) {\n" +
            "        for (int j = 0; j < 9; j++) {\n" +
            "            k[j][index] = input[j + 9] + step * temp[j + 9];\n" +
            "        }\n" +
            "\n" +
            "        for (int j = 9; j < 12; j++) {\n" +
            "            k[j][index] = triplet_func1(input, j, temp, step);\n" +
            "        }\n" +
            "\n" +
            "        for (int j = 12; j < 15; j++) {\n" +
            "            k[j][index] = triplet_func2(input, j, temp, step);\n" +
            "        }\n" +
            "\n" +
            "        for (int j = 15; j < 18; j++) {\n" +
            "            k[j][index] = triplet_func3(input, j, temp, step);\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    void solveByRK(float* input, float** coefs, float* coefs2, float step) {\n" +
            "\n" +
            "        int dim = 18;\n" +
            "        int coefLength = 18;\n" +
            "\n" +
            "        float k1[18][18];\n" +
            "        float temp[18];\n" +
            "\n" +
            "        for (int s = 0; s < dim; s++) {\n" +
            "            temp[s] = 0;\n" +
            "        }\n" +
            "\n" +
            "        fillMatrix(k1, input, temp, step, 0);\n" +
            "\n" +
            "        for (int j = 1; j < coefLength; j++) {\n" +
            "\n" +
            "            for (int ss = 0; ss < dim; ss++) {\n" +
            "                temp[ss] = 0;\n" +
            "                for (int s = 0; s < j; s++)\n" +
            "                    temp[ss] += coefs[j][s] * k1[ss][s];\n" +
            "            }\n" +
            "\n" +
            "            fillMatrix(k1, input, temp, step, j);\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        for (int s = 0; s < dim; s++) {\n" +
            "            temp[s] = 0;\n" +
            "        }\n" +
            "\n" +
            "        for (int ss = 0; ss < dim; ss++) {\n" +
            "            for (int s = 0; s < coefLength; s++) {\n" +
            "                temp[ss] += coefs2[s] * k1[ss][s];\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        for (int s = 0; s < dim; s++) {\n" +
            "            input[s] = input[s] + step * temp[s];\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    float svec(float *input, int v1, int v2) {\n" +
            "        int r1 = (v1 - 1) * 3;\n" +
            "        int r2 = (v2 - 1) * 3;\n" +
            "        return (float) (input[r1] * input[r2] + input[r1 + 1] * input[r2 + 1] + input[r1 + 2] * input[r2 + 2]);\n" +
            "    }\n" +
            "\n" +
            "    float kvvvec(float *input,int v1, int v2) {\n" +
            "        return (float) (svec(input,v1, v1) * svec(input,v2, v2) - svec(input,v1, v2) * svec(input,v1, v2));\n" +
            "    }\n" +
            "\n" +
            "    float U(float *input) {\n" +
            "        return (float) (0.5 * (kvvvec(input, 1, 2) + kvvvec(input, 1, 3) + kvvvec(input, 3, 2)));\n" +
            "    }\n" +
            "\n" +
            "    float K(float *input) {\n" +
            "        return (float) (0.5 * (svec(input, 4, 4) + svec(input, 5, 5) + svec(input, 6, 6)));\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    int wndX(float x, int index, int sizeX, float ** scope) {\n" +
            "        return (int) ((x - scope[index][0]) * 1.0 / (scope[index][1] - scope[index][0]) * sizeX);\n" +
            "    }\n" +
            "\n" +
            "    int wndY(float y, int index, int sizeY, float ** scope) {\n" +
            "        return (int) (sizeY - (y - scope[index][0]) * 1.0 / (scope[index][1] - scope[index][0]) * sizeY);\n" +
            "    }\n" +
            "\n" +
            "__kernel void calculate(__global float *inputd,\n" +
            "    __global float **coefs,\n" +
            "    __global float *coefs2,\n" +
            "    __global float step,\n" +
            "    __global float **outputd,\n" +
            "    __global int **image) {\n" +
            "\n" +
            "    int i = 0;\n" +
            "\n" +
            "    while (i < 9) {\n" +
            "        if (inputd[i] > 0) {\n" +
            "            outputd[i + 9][i] = inputd[i];\n" +
            "            outputd[i][i] = 0.0;\n" +
            "        } else {\n" +
            "            outputd[i][i] = inputd[i];\n" +
            "            outputd[i + 9][i] = 0.0;\n" +
            "        }\n" +
            "        i++;\n" +
            "    }\n" +
            "\n" +
            "    i = 0;\n" +
            "    float st = 0.0;\n" +
            "    int total = get_local_size (0);\n" +
            "\n" +
            "    while (st < total) {\n" +
            "\n" +
            "        solveByRK(inputd, coefs, coefs2, step);\n" +
            "\n" +
            "        int s;\n" +
            "        for (s = 0; s < 9; s++) {\n" +
            "            if (inputd[s] > 0) {\n" +
            "                if (inputd[s] > outputd[s + 9][s]) {\n" +
            "                    for (int j = 0; j < 9; j++) {\n" +
            "                        outputd[s + 9][j] = inputd[j];\n" +
            "                    }\n" +
            "                }\n" +
            "            } else if (inputd[s] < outputd[s][s]) {\n" +
            "                for (int j = 0; j < 9; j++) {\n" +
            "                    outputd[s][j] = inputd[j];\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "         float myE = log10(fabs(K(outputd) + U(outputd) - 1.0));\n" +
            "\n" +
            "         int px = wndX(st, 19, 400, outputd);\n" +
            "         int py = wndY(myE, 18, 400, outputd);\n" +
            "\n" +
            "         if (py < 400 && py > 0) {\n" +
            "            image[px + 1][py + 1] = 1;\n" +
            "         }\n" +
            "\n" +
            "         st += step;\n" +
            "    }\n" +
            "}";
}