package org.osym.Images;

import org.osym.Calculation.Functions;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 03.03.12
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
public class ImageManager {

    public interface ImageManagerDelegate {
        public void paintOperationDone(double iteration);

        public void paintOperationFailed(Exception e);
    }

    protected ImageManagerDelegate delegate = null;

    protected double[][] scope = null;
    protected double[][] scopeMax = null;

    protected int imageWidth = 0;
    protected int imageHeight = 0;

    public Functions funcManager = null;
    protected ThreadedPainter painter = null;

    HashMap<Integer, Image2D> images2D = new HashMap<Integer, Image2D>();


    public HashMap<Integer, Image2D> getImages2D() {
        return images2D;
    }

    public ImageManagerDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(ImageManagerDelegate delegate) {
        this.delegate = delegate;
    }

    public ImageManager(int sizeX, int sizeY, double[][] aScope, double[][] aScopeMax, Functions functions) {
        scope = aScope;
        scopeMax = aScopeMax;
        imageWidth = sizeX;
        imageHeight = sizeY;
        painter = new ThreadedPainter(this);
        painter.setPriority(Thread.MAX_PRIORITY);
        painter.start();
        funcManager = functions;
    }


    public void paintImagesAsync(double iteration, double[] potentials) {
        painter.performPaintOperation(iteration, potentials);
    }

    public void setImages2D(HashMap<Integer, Image2D> images2D) {
        this.images2D = images2D;
    }

    public void paintImages(double iteration, double[] potentials) {
        for (Image2D i : images2D.values()) {

            if (i.getScope() == null) {

                double[][] s = new double[][] {
                        {scopeMax[i.getxScope()][0],scopeMax[i.getxScope()][1]},
                        {scopeMax[i.getyScope()][0],scopeMax[i.getyScope()][1]}
                };

                i.setScope(s);
            }


            i.paintVector(potentials, scopeMax, iteration, funcManager);
            //i.paintPixel(x, y, (short)0);
        }
    }

    public void stop() {
        if (painter != null && !painter.isInterrupted()) {
            try {
                painter.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    class ThreadedPainter extends Thread {

        protected boolean isRunning = false;
        public BlockingQueue<PaintOperation> workQueue = new LinkedBlockingQueue<PaintOperation>(1000);
        protected ImageManager imageManager = null;

        public ThreadedPainter(ImageManager manager) {
            imageManager = manager;
        }

        public void performPaintOperation(double iteration, double[] potentials) {
            try {
                workQueue.put(new PaintOperation(iteration, potentials));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public boolean isRunning() {
            return isRunning;
        }

        @Override
        public void interrupt() {
            super.interrupt();    //To change body of overridden methods use File | Settings | File Templates.
            //workQueue.
        }

        @Override
        public void run() {
            isRunning = true;
            try {
                while (!isInterrupted()) {

                    PaintOperation operation = workQueue.take();
                    if (operation == null) {
                        System.out.println("Sleeping");
                        Thread.sleep(1);
                        continue;
                    }

                    imageManager.paintImages(operation.iteration, operation.potentials);
                    if (delegate != null) {
                        delegate.paintOperationDone(operation.iteration);
                    }


                }
            } catch (Exception e) {
                if (delegate != null) {
                    delegate.paintOperationFailed(e);
                }
            }

            isRunning = false;
        }

        class PaintOperation {
            public double[] potentials = null;
            public double iteration;

            PaintOperation(double iter, double[] potentials) {
                this.potentials = potentials;
                this.iteration = iter;
            }
        }
    }


}
