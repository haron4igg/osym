package org.osym.Calculation;

import nativecalculator.NativeCalculatorLibrary;
import org.bridj.Pointer;

import java.nio.DoubleBuffer;
import java.util.Arrays;


public class CalculatorNative extends CalculatorBase {

    protected Pointer<Integer> paused = Pointer.allocateInt();
    CalcListener listener = null;

    int dimension;

    protected Thread runThread = null;
    protected Pointer<Integer> canceled = Pointer.allocateInt();

    public boolean isWorking = false;

    public void pause() {
        if (paused.get() == 0) {
            paused.set(1);
            if (listener != null) {
                listener.calculationPaused();
            }
        } else {
            paused.set(0);
            if (listener != null) {
                listener.calculationResumed();
            }
        }

    }

    public void stop() {
        canceled.set(1);
        paused.set(0);
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void run(double[][] coefs,
                    double[] coefs2,
                    double[] input,
                    double from,
                    double total,
                    double step,
                    final CalcListener listener) {

        dimension = input.length;

        this.listener = listener;
        isWorking = true;
        paused.set(0);
        canceled.set(0);

        double [] alignedCoefs = new double[coefs.length * coefs[0].length];
        for (int i = 0; i < coefs.length; i++) {
            System.arraycopy(coefs[i], 0, alignedCoefs, i * coefs[i].length, coefs[i].length);
        }

        final long execStart = System.currentTimeMillis();

        double iteration = from * step;

        if (listener != null) {
            listener.calculationStarted(iteration, total);
        }

        Pointer<Double> coefs2Ptr = Pointer.pointerToDoubles(coefs2);
        Pointer<Double> inputPtr = Pointer.pointerToDoubles(input);
        Pointer<Double> coefsPtr = Pointer.pointerToDoubles(alignedCoefs);


        NativeCalculatorLibrary.OutputCallback callback = new NativeCalculatorLibrary.OutputCallback() {
            @Override
            public void apply(double v, Pointer<Double> doubles, double v2) {
                if (doubles != null && listener != null) {
                    listener.calculationReceivedPoints(v, doubles.getDoubles(dimension), v2);
                }
            }
        };

        NativeCalculatorLibrary.DoneCallback doneCallback = new NativeCalculatorLibrary.DoneCallback() {
            @Override
            public void apply(Pointer<Double> doubles, double v) {
                if (listener != null) {
                    if (canceled.get() != 1) {
                        listener.calculationDone(System.currentTimeMillis() - execStart, doubles.getDoubles(dimension), v);
                    } else {
                        listener.calculationStopped();
                    }
                }
            }
        };

        Pointer<NativeCalculatorLibrary.OutputCallback> callbackPtr = Pointer.pointerTo(callback);
        Pointer<NativeCalculatorLibrary.DoneCallback> doneCallbackPtr = Pointer.pointerTo(doneCallback);

        NativeCalculatorLibrary.run(coefsPtr, coefs[0].length, coefs2Ptr, inputPtr, dimension, from, total, step, paused, canceled, callbackPtr, doneCallbackPtr);

        isWorking = false;
    }
}
