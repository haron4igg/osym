//
//  File.c
//  JNICalculator
//
//  Created by Igor Reshetnikov on 19.05.13.
//  Copyright (c) 2013 World Evil Inc. All rights reserved.
//

#include <stdio.h>
#include "org_osym_Calculation_JNICalculator.h"
#include "calculator.h"

int paused = 0;
int canceled = 0;

int arrayLen = 0;

jobject delegate = NULL;
jmethodID delegate_method_produce;
jmethodID delegate_method_done;
JNIEnv *delegate_env;

void didProduceVector(double iteration, double* input, double step) {
    jdoubleArray inputObj = delegate_env->NewDoubleArray(arrayLen);
    delegate_env->SetDoubleArrayRegion(inputObj, 0, arrayLen, input);
    delegate_env->CallVoidMethod(delegate, delegate_method_produce, iteration, inputObj, step);
    //delegate_env->DeleteLocalRef(inputObj);
}

void didDone(double* input, double iteration) {
    jdoubleArray inputObj = delegate_env->NewDoubleArray(arrayLen);
    delegate_env->SetDoubleArrayRegion(inputObj, 0, arrayLen, input);
    delegate_env->CallVoidMethod(delegate, delegate_method_done, inputObj, iteration);
}

void JNICALL Java_org_osym_Calculation_JNICalculator_pause(JNIEnv *env, jobject caller) {
    paused = (paused == 0) ? 1 : 0;
}

void JNICALL Java_org_osym_Calculation_JNICalculator_cancel(JNIEnv *env, jobject caller) {
    paused = 0;
    canceled = 1;
}

/*
 public void calculationReceivedPoints(double iteration, double[] input, double step);

 public void calculationDone(double[] point, double iteration);
 */

void JNICALL Java_org_osym_Calculation_JNICalculator_run(
                                                         JNIEnv *env,
                                                         jobject caller,
                                                         jdoubleArray coefs,
                                                         jint coefsLen,
                                                         jdoubleArray coefs2,
                                                         jdoubleArray input,
                                                         jint inputLen,
                                                         jdouble from,
                                                         jdouble to,
                                                         jdouble step,
                                                         jobject listener) {
    arrayLen = inputLen;
    jclass objclass = env->GetObjectClass(listener);

    delegate_method_produce = env->GetMethodID(objclass, "calculationReceivedPoints", "(D[DD)V");
    delegate_method_done = env->GetMethodID(objclass, "calculationDone", "([DD)V");
    delegate = listener;
    delegate_env = env;


    double *cCoefs = env->GetDoubleArrayElements(coefs, NULL);
    double *cCoefs2 = env->GetDoubleArrayElements(coefs2, NULL);
    double *cInput = env->GetDoubleArrayElements(input, NULL);


    run(cCoefs, coefsLen, cCoefs2, cInput, inputLen, from, to, step, &paused, &canceled, didProduceVector, didDone);

}



