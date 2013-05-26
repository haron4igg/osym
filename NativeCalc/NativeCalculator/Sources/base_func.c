//
//  base_func.c
//  NativeCalculator
//
//  Created by Igor Reshetnikov on 15.05.13.
//  Copyright (c) 2013 World Evil Inc. All rights reserved.
//

#include <stdio.h>
#include <math.h>
#include "base_func.h"

void zapolnenie(double* cc, double* bb, double* c, double** b, int mp);

double mk3 = 1.73205080756888;

double Svec(double* v1, double* v2) {
    return (double) (v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2]);
}

void masRK4(double* c, double** b, int mp) {
    double cc[] = {1.0 / 6, 1.0 / 3, 1.0 / 3, 1.0 / 6};
    double bb[] = {1.0 / 2, 0.0, 1.0 / 2, 0.0, 0.0, 1.0};

    zapolnenie(cc, bb, c, b, mp);
}

void masRKB6(double* c, double** b, int mp) {
    double cc[] = {13.0 / 200, 0.0, 11.0 / 40, 11.0 / 40, 4.0 / 25, 4.0 / 25, 13.0 / 200};
    double bb[] = {1.0 / 2, 2.0 / 9, 4.0 / 9, 7.0 / 36, 2.0 / 9, -1.0 / 12, -35.0 / 144, -55.0 / 36, 35.0 / 48, 15.0 / 8, -1.0 / 360, -11.0 / 36, -1.0 / 8, 1.0 / 2, 1.0 / 10, -41.0 / 260, 22.0 / 13, 43.0 / 156, -118.0 / 39, 32.0 / 195, 80.0 / 39};

    zapolnenie(cc, bb, c, b, mp);
}


void masRKF8(double* c, double** b, int mp) {
    double cc[] = {41.0 / 840.0, 0.0, 0.0, 0.0, 0.0, 34.0 / 105.0, 9.0 / 35.0, 9.0 / 35.0, 9.0 / 280, 9.0 / 280.0, 0.0, 0.0, 41.0 / 840};
    double bb[] = {2.0 / 27.0, 1.0 / 36.0, 1.0 / 12.0, 1.0 / 24.0, 0.0, 1.0 / 8.0, 5.0 / 12.0, 0.0, -25.0 / 16.0, 25.0 / 16.0, 1.0 / 20.0, 0.0, 0.0, 1.0 / 4.0, 1.0 / 5.0, -25.0 / 108.0, 0.0, 0.0, 125.0 / 108.0, -65.0 / 27.0, 125.0 / 54.0, 31.0 / 300.0, 0.0, 0.0, 0.0, 61.0 / 225.0, -2.0 / 9.0, 13.0 / 900.0, 2.0, 0.0, 0.0, -53.0 / 6.0, 704.0 / 45.0, -107.0 / 9.0, 67.0 / 90.0, 3.0, -91.0 / 108.0, 0.0, 0.0, 23.0 / 108.0, -976.0 / 135.0, 311.0 / 54, -19.0 / 60, 17.0 / 6, -1.0 / 12, 2383.0 / 4100, 0.0, 0.0, -341.0 / 164, 4496.0 / 1025, -301.0 / 82, 2133.0 / 4100, 45.0 / 82, 45.0 / 164, 18.0 / 41, 3.0 / 205, 0.0, 0.0, 0.0, 0.0, -6.0 / 41, -3.0 / 205, -3.0 / 41, 3.0 / 41, 6.0 / 41, 0.0, -1777.0 / 4100, 0.0, 0.0, -341.0 / 164, 4496.0 / 1025, -289.0 / 82, 2193.0 / 4100, 51.0 / 82, 33.0 / 164, 12.0 / 41, 0.0, 1.0};

    zapolnenie(cc, bb, c, b, mp);
}

void zapolnenie(double* cc, double* bb, double* c, double** b, int mp) {
    int i, j;
    for (i = 0; i < mp; i++)
        c[i] = cc[i];

    b[0][0] = 0;
    int ij = 0;

    for (i = 1; i < mp; i++) {
        for (j = 0; j < i; j++) {
            b[i][j] = bb[ij];
            ij++;
        }
    }
}



double vectorSumm(double* point, int v1, int v2) {
    int r1 = (v1 - 1) * 3;
    int r2 = (v2 - 1) * 3;
    return (double) (point[r1] * point[r2] + point[r1 + 1] * point[r2 + 1] + point[r1 + 2] * point[r2 + 2]);
}

double calculateVector(double* point, int v1, int v2) {
    return (double) (vectorSumm(point, v1, v1) * vectorSumm(point, v2, v2) - vectorSumm(point, v1, v2) * vectorSumm(point, v1, v2));
}
