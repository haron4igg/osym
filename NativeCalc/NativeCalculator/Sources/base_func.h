//
//  base_func.h
//  NativeCalculator
//
//  Created by Igor Reshetnikov on 15.05.13.
//  Copyright (c) 2013 World Evil Inc. All rights reserved.
//

#ifndef NativeCalculator_base_func_h
#define NativeCalculator_base_func_h

double vectorSumm(double* point, int v1, int v2);
double calculateVector(double* point, int v1, int v2);

double Svec(double* v1, double* v2);

void masRK4(double* c, double** b, int mp);
void masRKB6(double* c, double** b, int mp);
void masRKF8(double* c, double** b, int mp);

#endif
