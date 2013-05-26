
    float Svec(float* v1, float* v2) {
	    return (float)(v1[0]*v2[0]+v1[1]*v2[1]+v1[2]*v2[2]);
    }

    float triplet_func1(float *input, int j, float* mas, float step) {
        float v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        float v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        float v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

        return (float) (-v1[j % 3] * (Svec(v2, v2) + Svec(v3, v3)) + v2[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v1, v3));
    }

    float triplet_func2(float *input, int j, float* mas, float step) {
        float v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        float v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        float v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

        return (float) (-v2[j % 3] * (Svec(v1, v1) + Svec(v3, v3)) + v1[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v2, v3));
    }

    float triplet_func3(float *input, int j, float* mas, float step) {
        float v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        float v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        float v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

        return (float) (-v3[j % 3] * (Svec(v2, v2) + Svec(v1, v1)) + v2[j % 3] * Svec(v3, v2) + v1[j % 3] * Svec(v1, v3));
    }



    void fillMatrix(float** k, float* input, float* temp, float step, int index) {
        for (int j = 0; j < 9; j++) {
            k[j][index] = input[j + 9] + step * temp[j + 9];
        }

        for (int j = 9; j < 12; j++) {
            k[j][index] = triplet_func1(input, j, temp, step);
        }

        for (int j = 12; j < 15; j++) {
            k[j][index] = triplet_func2(input, j, temp, step);
        }

        for (int j = 15; j < 18; j++) {
            k[j][index] = triplet_func3(input, j, temp, step);
        }
    }

    void solveByRK(float* input, float** coefs, float* coefs2, float step) {

        int dim = 18;
        int coefLength = 18;

        float k1[18][18];
        float temp[18];

        for (int s = 0; s < dim; s++) {
            temp[s] = 0;
        }

        fillMatrix(k1, input, temp, step, 0);

        for (int j = 1; j < coefLength; j++) {

            for (int ss = 0; ss < dim; ss++) {
                temp[ss] = 0;
                for (int s = 0; s < j; s++)
                    temp[ss] += coefs[j][s] * k1[ss][s];
            }

            fillMatrix(k1, input, temp, step, j);

        }

        for (int s = 0; s < dim; s++) {
            temp[s] = 0;
        }

        for (int ss = 0; ss < dim; ss++) {
            for (int s = 0; s < coefLength; s++) {
                temp[ss] += coefs2[s] * k1[ss][s];
            }
        }

        for (int s = 0; s < dim; s++) {
            input[s] = input[s] + step * temp[s];
        }
    }

    float svec(float *input, int v1, int v2) {
        int r1 = (v1 - 1) * 3;
        int r2 = (v2 - 1) * 3;
        return (float) (input[r1] * input[r2] + input[r1 + 1] * input[r2 + 1] + input[r1 + 2] * input[r2 + 2]);
    }

    float kvvvec(float *input,int v1, int v2) {
        return (float) (svec(input,v1, v1) * svec(input,v2, v2) - svec(input,v1, v2) * svec(input,v1, v2));
    }

    float U(float *input) {
        return (float) (0.5 * (kvvvec(input, 1, 2) + kvvvec(input, 1, 3) + kvvvec(input, 3, 2)));
    }

    float K(float *input) {
        return (float) (0.5 * (svec(input, 4, 4) + svec(input, 5, 5) + svec(input, 6, 6)));
    }


    int wndX(float x, int index, int sizeX, float ** scope) {
        return (int) ((x - scope[index][0]) * 1.0 / (scope[index][1] - scope[index][0]) * sizeX);
    }

    int wndY(float y, int index, int sizeY, float ** scope) {
        return (int) (sizeY - (y - scope[index][0]) * 1.0 / (scope[index][1] - scope[index][0]) * sizeY);
    }

__kernel void calculate(
    __global float *inputd,
    __global float *coefs,
    __global float *coefs2,
    const float step,
    __global float *outputd,
    __global int **image) {

    int i = 0;

    while (i < 9) {
        if (inputd[i] > 0) {
            outputd[i + 9][i] = inputd[i];
            outputd[i][i] = 0.0;
        } else {
            outputd[i][i] = inputd[i];
            outputd[i + 9][i] = 0.0;
        }
        i++;
    }

    i = 0;
    float st = 0.0;
    int total = get_local_size (0);

    while (st < total) {

        solveByRK(inputd, coefs, coefs2, step);

        int s;
        for (s = 0; s < 9; s++) {
            if (inputd[s] > 0) {
                if (inputd[s] > outputd[s + 9][s]) {
                    for (int j = 0; j < 9; j++) {
                        outputd[s + 9][j] = inputd[j];
                    }
                }
            } else if (inputd[s] < outputd[s][s]) {
                for (int j = 0; j < 9; j++) {
                    outputd[s][j] = inputd[j];
                }
            }
        }

         float myE = log10(fabs(K(outputd) + U(outputd) - 1.0));

         int px = wndX(st, 19, 400, outputd);
         int py = wndY(myE, 18, 400, outputd);

         if (py < 400 && py > 0) {
            image[px + 1][py + 1] = 1;
         }

         st += step;
    }
}