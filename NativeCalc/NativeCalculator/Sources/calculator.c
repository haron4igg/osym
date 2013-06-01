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
#include "octplet_func.h"
#include <string.h>

#if defined(WIN32)
#include <windows.h>
#endif

typedef double (*Function)(double* input, int j, double* mas, double step);

Function tripletFunctions[8] = {func1, func2, func3, func4, func5, func6, func7, func8};
Function octpletFunctions[8] = {ofunc1, ofunc2, ofunc3, ofunc4, ofunc5, ofunc6, ofunc7, ofunc8};

Function *functions = tripletFunctions;
int temp2drowLen = 0;
double *temp2dBuffer = NULL;
double *tempBuffer = NULL;

void fillMatrix(double* input, int inputLen, double* temp, double step, int index) {
    int dim2 = inputLen / 2;
    unsigned int j, i;
    for (j = 0; j < dim2; j++)
        temp2dBuffer[j*temp2drowLen + index] = input[j + dim2] + step * temp[j + dim2];

    for (i = 0; i < dim2; i += 3) {
        for (j = dim2 + i; j < dim2 + i + 3; j++) {
            temp2dBuffer[j*temp2drowLen + index] = functions[i / 3](input, j % 3, temp, step);
        }
    }
}

double* solveByRK(double* input, int inputLen, double *coefs, int coefLen, double* coefs2, double step) {
    int j, ss, s;

    memset(temp2dBuffer, 0, sizeof(double) * inputLen * coefLen);
    memset(tempBuffer, 0, sizeof(double) * inputLen);
    fillMatrix(input, inputLen, tempBuffer, step, 0);

    for (j = 1; j < coefLen; j++) {

       
        memset(tempBuffer, 0, sizeof(double) * inputLen);
        for (ss = 0; ss < inputLen; ss++) {          
            for (s = 0; s < j; s++)
                tempBuffer[ss] += (coefs[j*coefLen + s]) * (temp2dBuffer[ss * coefLen + s]);
        }

        fillMatrix(input, inputLen, tempBuffer, step, j);

    }

    memset(tempBuffer, 0, sizeof(double) * inputLen);

    for (ss = 0; ss < inputLen; ss++) {
        for (s = 0; s < coefLen; s++)
            tempBuffer[ss] += coefs2[s] * (temp2dBuffer[ss * coefLen + s]);
    }
    for (s = 0; s < inputLen; s++)
        input[s] = input[s] + step * tempBuffer[s];
    

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

    if (inputLen <= 18) {
        functions = tripletFunctions;
    } else {
        functions = octpletFunctions;
    }    

    double iteration = from * step;

    //int count = 0;
    temp2drowLen = coefsLen;
    temp2dBuffer = calloc(coefsLen * inputLen,sizeof(double));
    tempBuffer = calloc(inputLen,sizeof(double));

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
        if (callback != NULL) {
            callback(iteration, input, step);
        }
        iteration += step;
    }
    
    
    if (!*paused) {
        if (doneCallBack != NULL) {
            doneCallBack(input, iteration);
        }
    }
    free(temp2dBuffer);
    free(tempBuffer);
}

























