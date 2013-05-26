//
//  calculator.c
//  NativeCalculator
//
//  Created by Igor Reshetnikov on 15.05.13.
//  Copyright (c) 2013 World Evil Inc. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include "calculator.h"
#include "triplet_func.h"
#include <unistd.h>

#if defined(WIN32)
#include <windows.h>
#endif

void fillMatrix(double *k[], double* input, int inputLen, double* temp, double step, int index) {
    int dim2 = inputLen / 2;
    int j, i;
    for (j = 0; j < dim2; j++)
        k[j][index] = input[j + dim2] + step * temp[j + dim2];

    for (i = 0; i < dim2; i += 3) {
        for (j = dim2 + i; j < dim2 + i + 3; j++) {
            switch (i / 3) {
                case 0: {
                    k[j][index] = func1(input, j, temp, step);
                    break;
                }
                case 1: {
                    k[j][index] = func2(input, j, temp, step);
                    break;
                }
                case 2: {
                    k[j][index] = func3(input, j, temp, step);
                    break;
                }
                case 3: {
                    k[j][index] = func4(input, j, temp, step);
                    break;
                }
                case 4: {
                    k[j][index] = func5(input, j, temp, step);
                    break;
                }
                case 5: {
                    k[j][index] = func6(input, j, temp, step);
                    break;
                }
                case 6: {
                    k[j][index] = func7(input, j, temp, step);
                    break;
                }
                case 7: {
                    k[j][index] = func8(input, j, temp, step);
                    break;
                }
                default: {

                }
            }
        }
    }
}

double* solveByRK(double* input, int inputLen, double *coefs, int coefLen, double* coefs2, double step) {

    int dim = inputLen;

    int i, j, ss, s;

    double **k1 = (double**)malloc(sizeof(double *) * dim);
    for (i = 0; i < dim; i++) {
        k1[i] = calloc(coefLen,sizeof(double));
    }

    double* temp = calloc(dim,sizeof(double));
    fillMatrix(k1, input, inputLen, temp, step, 0);

    for (j = 1; j < coefLen; j++) {

        free(temp);
        temp = calloc(dim,sizeof(double));

        for (ss = 0; ss < dim; ss++) {
            for (s = 0; s < j; s++)
                temp[ss] += (coefs[j*coefLen + s]) * (k1[ss][s]);
        }

        fillMatrix(k1, input, inputLen, temp, step, j);

    }

    free(temp);
    temp = calloc(dim, sizeof(double));

    for (ss = 0; ss < dim; ss++)
        for (s = 0; s < coefLen; s++)
            temp[ss] += coefs2[s] * (k1[ss][s]);

    for (s = 0; s < dim; s++)
        input[s] = input[s] + step * temp[s];

    free(temp);

    for (i = 0; i < dim; i++) {
        free(k1[i]);
    }
    free(k1);

    return input;
}

void run(double *coefs,
         int coefsLen,
         double* coefs2,
         double* input,
         int inputLen,
         double from,
         double total,
         double step,
         int *paused,
         int *canceled,
         OutputCallback callback,
         DoneCallback doneCallBack) {


    double iteration = from * step;

    //int count = 0;

    while (iteration < total && !*canceled) {

        if (*paused) {
            while (*paused) {

#if defined(WIN32)
    Sleep(1);
#else
    usleep(1000);
#endif
            }
        }

        solveByRK(input, inputLen, coefs, coefsLen, coefs2, step);

        //count++;
        //if (count == 100) {
        if (callback != NULL) {
            callback(iteration, input, step);
        }
        //count = 0;
        //}

        iteration += step;

    }

    if (!*paused) {
        if (doneCallBack != NULL) {
            doneCallBack(input, iteration);
        }
    }
}

























