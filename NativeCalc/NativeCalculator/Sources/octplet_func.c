//
//  File.c
//  NativeCalculator
//
//  Created by Igor Reshetnikov on 01.06.13.
//  Copyright (c) 2013 World Evil Inc. All rights reserved.
//

#include <stdio.h>
#include "octplet_func.h"
#include "base_func.h"


double ofunc1(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (   -v1[j] * (Svec(v2, v2) + Svec(v3, v3) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7))
                        +v2[j] * Svec(v1, v2)
                        +v3[j] * Svec(v1, v3)
                        +v4[j] * (0.25 * Svec(v1, v4) - 0.75 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8))
                        +v5[j] * (0.75 * Svec(v2, v4) + 0.25 * Svec(v1, v5) + 0.75 * Svec(v3, v7) + 0.25 * mk3 * Svec(v7, v8))                     
                        +v6[j] * (-0.75 * Svec(v3, v4) + 0.25 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8))
                        +v7[j] * (-0.75 * Svec(v3, v5) - 0.75 * Svec(v2, v6) + 0.25 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8))
                        +v8[j] * (-0.5 * mk3 * Svec(v4, v6) - 0.5 * mk3 * Svec(v5, v7)));
}

double ofunc2(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (
                         v1[j] * Svec(v1, v2)
                        -v2[j] * (Svec(v1, v1) + Svec(v3, v3) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7))
                        +v3[j] * Svec(v2, v3)
                        +v4[j] * (0.25 * Svec(v2, v4) + 0.75 * Svec(v1, v5) - 0.75 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8))
                        +v5[j] * (-0.75 * Svec(v1, v4) + 0.25 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8))
                        +v6[j] * (-0.75 * Svec(v3, v5) + 0.25 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8))
                        +v7[j] * (0.75 * Svec(v3, v4) + 0.75 * Svec(v1, v6) + 0.25 * Svec(v2, v7) - 0.25 * mk3 * Svec(v4, v8))
                        +v8[j] * (-0.5 * mk3 * Svec(v5, v6) + 0.5 * mk3 * Svec(v4, v7)));
}

double ofunc3(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (
                      v1[j] * Svec(v1, v3)
                     +v2[j] * Svec(v2, v3) -
                      v3[j] * (Svec(v1, v1) + Svec(v2, v2) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7))
                     +v4[j] * (0.25 * Svec(v3, v4) - 0.75 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8))
                     +v5[j] * (0.25 * Svec(v3, v5) - 0.75 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8))
                     +v6[j] * (0.75 * Svec(v1, v4) + 0.75 * Svec(v2, v5) + 0.25 * Svec(v3, v6) - 0.25 * mk3 * Svec(v6, v8))
                     +v7[j] * (-0.75 * Svec(v2, v4) + 0.75 * Svec(v1, v5) + 0.25 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8))
                     +v8[j] * 0.25 * mk3 * (-Svec(v4, v4) - Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)));
}

double ofunc4(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (
                     v1[j] * (0.25 * Svec(v1, v4) - 0.75 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) +
                     v2[j] * (0.25 * Svec(v2, v4) + 0.75 * Svec(v1, v5) - 0.75 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8)) +
                     v3[j] * (0.25 * Svec(v3, v4) - 0.75 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8)) -
                     v4[j] * (0.25 * Svec(v1, v1) + 0.25 * Svec(v2, v2) + 0.25 * Svec(v3, v3) + Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7) + 0.5 * mk3 * Svec(v3, v8) + 0.75 * Svec(v8, v8)) +
                     v5[j] * Svec(v4, v5) +
                     v6[j] * (0.25 * Svec(v4, v6) - 0.75 * Svec(v5, v7) - 0.5 * mk3 * Svec(v1, v8)) +
                     v7[j] * (0.75 * Svec(v5, v6) + 0.25 * Svec(v4, v7) + 0.5 * mk3 * Svec(v2, v8)) +
                     v8[j] * 0.25 * mk3 * (Svec(v3, v4) + Svec(v1, v6) - Svec(v2, v7) + mk3 * Svec(v4, v8)));
}

double ofunc5(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (
                     v1[j] * (0.75 * Svec(v2, v4) + 0.25 * Svec(v1, v5) + 0.75 * Svec(v3, v7) + 0.25 * mk3 * Svec(v7, v8)) +
                     v2[j] * (-0.75 * Svec(v1, v4) + 0.25 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) +
                     v3[j] * (0.25 * Svec(v3, v5) - 0.75 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) +
                     v4[j] * Svec(v4, v5) -
                     v5[j] * (0.25 * Svec(v1, v1) + 0.25 * Svec(v2, v2) + 0.25 * Svec(v3, v3) + Svec(v4, v4) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7) + 0.5 * mk3 * Svec(v3, v8) + 0.75 * Svec(v8, v8)) +
                     v6[j] * (0.25 * Svec(v5, v6) + 0.75 * Svec(v4, v7) - 0.5 * mk3 * Svec(v2, v8)) +
                     v7[j] * (-0.75 * Svec(v4, v6) + 0.25 * Svec(v5, v7) - 0.5 * mk3 * Svec(v1, v8)) +
                     v8[j] * 0.25 * mk3 * (Svec(v3, v5) + Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)));
}

double ofunc6(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (
                     v1[j] * 0.25 * (-3 * Svec(v3, v4) + Svec(v1, v6) + 3 * Svec(v2, v7) + mk3 * Svec(v4, v8)) +
                     v2[j] * 0.25 * (-3 * Svec(v3, v5) + Svec(v2, v6) - 3 * Svec(v1, v7) + mk3 * Svec(v5, v8)) +
                     v3[j] * 0.25 * (3 * Svec(v1, v4) + 3 * Svec(v2, v5) + Svec(v3, v6) - mk3 * Svec(v6, v8)) +
                     v4[j] * 0.25 * (Svec(v4, v6) - 3 * Svec(v5, v7) - 2 * mk3 * Svec(v1, v8)) + v5[j % 3] * 0.25 * (Svec(v5, v6) + 3 * Svec(v4, v7) - 2 * mk3 * Svec(v2, v8)) -
                     v6[j] * 0.25 * (Svec(v1, v1) + Svec(v2, v2) + Svec(v3, v3) + Svec(v4, v4) + Svec(v5, v5) + 4 * Svec(v7, v7) - 2 * mk3 * Svec(v3, v8) + 3 * Svec(v8, v8)) +
                     v7[j] * Svec(v6, v7) +
                     v8[j] * mk3 * 0.25 * (Svec(v1, v4) + Svec(v2, v5) - Svec(v3, v6) + mk3 * Svec(v6, v8)));
}

double ofunc7(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (
                     v1[j] * 0.25 * (-3 * Svec(v3, v5) - 3 * Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)) +
                     v2[j] * 0.25 * (3 * Svec(v3, v4) + 3 * Svec(v1, v6) + Svec(v2, v7) - mk3 * Svec(v4, v8)) +
                     v3[j] * 0.25 * (-3 * Svec(v2, v4) + 3 * Svec(v1, v5) + Svec(v3, v7) - mk3 * Svec(v7, v8)) +
                     v4[j] * 0.25 * (3 * Svec(v5, v6) + Svec(v4, v7) + 2 * mk3 * Svec(v2, v8)) +
                     v5[j] * 0.25 * (-3 * Svec(v4, v6) + Svec(v5, v7) - 2 * mk3 * Svec(v1, v8)) +
                     v6[j] * Svec(v6, v7) -
                     v7[j] * 0.25 * (Svec(v1, v1) + Svec(v2, v2) + Svec(v3, v3) + Svec(v4, v4) + Svec(v5, v5) + 4 * Svec(v6, v6) - 2 * mk3 * Svec(v3, v8) + 3 * Svec(v8, v8)) +
                     v8[j] * mk3 * 0.25 * (-Svec(v2, v4) + Svec(v1, v5) - Svec(v3, v7) + mk3 * Svec(v7, v8)));
}

double ofunc8(double *point, int j, double* mas, double step) {
    double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
    double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
    double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
    double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
    double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
    double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
    double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
    double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};
    
    return (double) (
                     v1[j] * (-0.5) * mk3 * (Svec(v4, v6) + Svec(v5, v7)) +
                     v2[j] * 0.5 * mk3 * (-Svec(v5, v6) + Svec(v4, v7)) +
                     v3[j] * 0.25 * mk3 * (-Svec(v4, v4) - Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)) +
                     v4[j] * 0.25 * mk3 * (Svec(v3, v4) + Svec(v1, v6) - Svec(v2, v7) + mk3 * Svec(v4, v8)) +
                     v5[j] * 0.25 * mk3 * (Svec(v3, v5) + Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)) +
                     v6[j] * 0.25 * mk3 * (Svec(v1, v4) + Svec(v2, v5) - Svec(v3, v6) + mk3 * Svec(v6, v8)) +
                     v7[j] * 0.25 * mk3 * (-Svec(v2, v4) + Svec(v1, v5) - Svec(v3, v7) + mk3 * Svec(v7, v8)) -
                     v8[j] * 0.75 * (Svec(v4, v4) + Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)));
}