package org.osym.Calculation;


import org.osym.tools.OSTools;

import java.io.*;

/**
 * Date: 18.05.13
 * Time: 17:44
 * Copyright (c) 2013. Igor Reshetnikov. World Evil Ink. All rights reserved.
 */
public class JNICalculator extends CalculatorBase {

    Calculator.CalcListener listener = null;

    public boolean isWorking = false;
    boolean canceInternationall = false;
    boolean pause = false;

    private interface JNICalculatorListener {
        public void calculationReceivedPoints(double iteration, double[] input, double step);

        public void calculationDone(double[] point, double iteration);
    }

    private static final String LIB_BIN = "/lib/";
    private final static String LIB = "libJNICalculator.dylib";
    private final static String LIB_WIN = "JNICalculator.dll";

    private static String getLibPath() {
        String libPath = null;
        if (OSTools.isMac()) {
            libPath = LIB_BIN + LIB;
        } else {
            libPath = LIB_BIN + LIB_WIN;
        }
        return libPath;
    }

    static {
        System.out.println("Loading lib");
        try {
            if (OSTools.isMac()) {
                System.load("/Users/ireshetnikov/Documents/University Projects/OsymRepo/Osym/lib/" + LIB);
            } else {
                System.load("C:/Users/Haron/Documents/GitHub/Osym/Osym/lib/" + LIB_WIN);
            }

            System.out.println("Lib is loaded from memory");
        } catch (Exception e) {
            try {
                loadLibraryFromJar(getLibPath());
            } catch (Exception se) {
                throw new RuntimeException(se);
            }
        }
    }

    public void stop() {
        cancel = true;
        cancelInternal();
    }

    public void pause() {
        pause = !pause;
        pauseInternal();
    }

    public static void loadLibraryFromJar(String path) throws IOException {

        if (!path.startsWith("/")) {
            throw new IllegalArgumentException("The path to be absolute (start with '/').");
        }

        // Obtain filename from path
        String[] parts = path.split("/");
        String filename = (parts.length > 1) ? parts[parts.length - 1] : null;

        // Split filename to prexif and suffix (extension)
        String prefix = "";
        String suffix = null;
        if (filename != null) {
            parts = filename.split("\\.", 2);
            prefix = parts[0];
            suffix = (parts.length > 1) ? "." + parts[parts.length - 1] : null; // Thanks, davs! :-)
        }

        // Check if the filename is okay
        if (filename == null || prefix.length() < 3) {
            throw new IllegalArgumentException("The filename has to be at least 3 characters long.");
        }

        // Prepare temporary file
        File temp = File.createTempFile(prefix, "." + suffix);
        temp.deleteOnExit();

        if (!temp.exists()) {
            throw new FileNotFoundException("File " + temp.getAbsolutePath() + " does not exist.");
        }

        // Prepare buffer for data copying
        byte[] buffer = new byte[1024];
        int readBytes;

        // Open and check input stream
        InputStream is = JNICalculator.class.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException("File " + path + " was not found inside JAR.");
        }

        // Open output stream and copy data between source file in JAR and the temporary file
        OutputStream os = new FileOutputStream(temp);
        try {
            while ((readBytes = is.read(buffer)) != -1) {
                os.write(buffer, 0, readBytes);
            }
        } finally {
            // If read/write fails, close streams safely before throwing an exception
            os.close();
            is.close();
        }

        // Finally, load the library
        System.load(temp.getAbsolutePath());
    }


    private native void cancelInternal();

    private native void pauseInternal();

    private native void run(double[] coefs,
                            int coefsLen,
                            double[] coefs2,
                            double[] input,
                            int inputLen,
                            double from,
                            double total,
                            double step,
                            JNICalculatorListener listener);

    public void run(double[][] coefs,
                    double[] coefs2,
                    double[] input,
                    double from,
                    double total,
                    double step,
                    final Calculator.CalcListener listener) {
        this.listener = listener;
        isWorking = true;

        double[] alignedCoefs = new double[coefs.length * coefs[0].length];
        for (int i = 0; i < coefs.length; i++) {
            System.arraycopy(coefs[i], 0, alignedCoefs, i * coefs[i].length, coefs[i].length);
        }

        final long execStart = System.currentTimeMillis();

        double iteration = from * step;
        if (listener != null) {
            listener.calculationStarted(iteration, total);
        }

        run(alignedCoefs, coefs[0].length, coefs2, input, input.length, from, total, step, new JNICalculatorListener() {
            @Override
            public void calculationReceivedPoints(double iteration, double[] input, double step) {
                if (listener != null) {
                    listener.onReceivePoints(iteration, input, step);
                }
            }

            @Override
            public void calculationDone(double[] point, double iteration) {
                if (listener != null) {
                    if (!cancel) {
                        listener.onDone(System.currentTimeMillis() - execStart, point, iteration);
                    } else {
                        listener.onStop();
                    }
                }
            }
        });

        isWorking = false;
    }

}


