/* DO NOT EDIT THIS FILE - it is machine generated */

#if defined(WIN32)
#include <jni.h>
#else
#include <JavaVM/jni.h>
#endif

/* Header for class org_osym_Calculation_JNICalculator */

#ifndef _Included_org_osym_Calculation_JNICalculator
#define _Included_org_osym_Calculation_JNICalculator

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_osym_Calculation_JNICalculator
 * Method:    run
 * Signature: ([[D[D[DDDDLorg/osym/Calculation/JNICalculator/JNICalculatorListener;)V
 */
JNIEXPORT void JNICALL Java_org_osym_Calculation_JNICalculator_run
    (JNIEnv *, jobject, jdoubleArray, jint, jdoubleArray, jdoubleArray, jint, jdouble, jdouble, jdouble, jobject);

JNIEXPORT void JNICALL Java_org_osym_Calculation_JNICalculator_pauseInternal
    (JNIEnv *,jobject);

JNIEXPORT void JNICALL Java_org_osym_Calculation_JNICalculator_cancelInternal
    (JNIEnv *,jobject);

#ifdef __cplusplus
}
#endif
#endif
