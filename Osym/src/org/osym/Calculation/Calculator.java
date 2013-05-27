package org.osym.Calculation;


public interface Calculator {

    public interface CalcListener {
        public void calculationStarted(double from, double to);

        public void onReceivePoints(double iteration, double[] input, double step);

        public void calculationPaused();

        public void calculationResumed();

        public void onStop();

        public void calculationFailed(Exception e);

        public void onDone(long executionTime, double[] point, double iteration);
    }

    public boolean isWorking();

    public void runAsync(final double[][] coefs,
                         final double[] coefs2,
                         final double[] input,
                         final double from,
                         final double total,
                         final double step,
                         final CalcListener listener);


    public void pause();

    public void stop();

    public void run(double[][] coefs,
                    double[] coefs2,
                    double[] input,
                    double from,
                    double total,
                    double step,
                    CalcListener listener);

}
