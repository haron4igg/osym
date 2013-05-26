//
//  File.c
//  NativeCalculator
//
//  Created by Igor Reshetnikov on 15.05.13.
//  Copyright (c) 2013 World Evil Inc. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include "triplet_func.h"
#include "base_func.h"
#include <math.h>
#include <time.h>

double func1(double* input, int j, double* mas, double step) {
    double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
    double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
    double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

    return (double) (-v1[j % 3] * (Svec(v2, v2) + Svec(v3, v3)) + v2[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v1, v3));
}

double func2(double* input, int j, double* mas, double step) {
    double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
    double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
    double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

    return (double) (-v2[j % 3] * (Svec(v1, v1) + Svec(v3, v3)) + v1[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v2, v3));
}

double func3(double* input, int j, double* mas, double step) {
    double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
    double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
    double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

    return (double) (-v3[j % 3] * (Svec(v2, v2) + Svec(v1, v1)) + v2[j % 3] * Svec(v3, v2) + v1[j % 3] * Svec(v1, v3));
}

double func4(double* input, int j, double* mas, double step) {
    return 0;
}

double func5(double* input, int j, double* mas, double step) {
    return 0;
}

double func6(double* input, int j, double* mas, double step) {
    return 0;
}

double func7(double* input, int j, double* mas, double step) {
    return 0;
}

double func8(double* input, int j, double* mas, double step) {
    return 0;
}


double U(double* point) {
    return (double) (0.5 * (calculateVector(point, 1, 2) + calculateVector(point, 1, 3) + calculateVector(point, 3, 2)));
}

double K(double* point) {
    return (double) (0.5 * (vectorSumm(point, 4, 4) + vectorSumm(point, 5, 5) + vectorSumm(point, 6, 6)));
}

double EUK(double* point) {
    return (double) (log10(fabs(K(point) + U(point) - 1.0)));
}

double DoubleRand() {
  return ((double)rand()/(double)RAND_MAX);
}

void setupStartPoint(double* point, int state) {
    double UKpot, betta;

    int i;

    for (i = 0; i < 9; i++)
        point[i] = 0.0;

    srand((int)time(NULL));

    for (i = 9; i < 18; i++)
        point[i] = DoubleRand() * 2.0 - 1;

    UKpot = K(point);
    betta = 1.0 / pow(UKpot, 1.0 / 2);

    for (i = 9; i < 18; i++)
        point[i] *= betta;

    UKpot = EUK(point);

    printf("начальные условия в для счета\n");

    for (i = 0; i < 18; i++)
        printf("%d : %f",i, point[i]);

    printf("энергия = %f", UKpot);
}
