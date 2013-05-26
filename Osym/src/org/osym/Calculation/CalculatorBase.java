package org.osym.Calculation;

import sun.awt.Mutex;


public abstract class CalculatorBase implements Calculator {

    protected boolean isPaused = false;
    protected Thread runThread = null;
    protected boolean cancel = false;
    public boolean isWorking = false;

    public boolean isWorking() {
        return isWorking;
    }

    public void runAsync(final double[][] coefs,
                         final double[] coefs2,
                         final double[] input,
                         final double from,
                         final double total,
                         final double step,
                         final CalcListener listener) {

        final CalculatorBase self = this;

        runThread = new Thread(new Runnable() {
            public void run() {
                try {
                    self.run(coefs, coefs2, input, from, total, step, listener);
                } catch (Exception e) {
                    listener.calculationFailed(e);
                    System.out.println(e);
                }
            }

        });
        runThread.setPriority(Thread.MAX_PRIORITY);
        runThread.start();
    }






}
