//
//  calculator.h
//  NativeCalculator
//
//  Created by Igor Reshetnikov on 15.05.13.
//  Copyright (c) 2013 World Evil Inc. All rights reserved.
//

#ifndef NativeCalculator_calculator_h
#define NativeCalculator_calculator_h
#ifdef __cplusplus
extern "C" {
#endif

    typedef void (*OutputCallback)(double iteration, double* input, double step);
    
    typedef void (*DoneCallback)(double* point, double iteration);
    
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
             DoneCallback doneCallBack);
    
#ifdef __cplusplus
}
#endif



#endif
