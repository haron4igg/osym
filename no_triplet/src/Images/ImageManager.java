package Images;

import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import sun.rmi.runtime.NewThreadAction;

import javax.naming.OperationNotSupportedException;
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

    protected double[][] scope = null;
    protected double[][] scope3d = null;

    protected int imageWidth = 0;
    protected int imageHeight = 0;

    protected ThreadedPainter painter = null;


    HashMap<Integer, Image2D> images2D = new HashMap<Integer, Image2D>();
    HashMap<Integer, Image3D> images3D = new HashMap<Integer, Image3D>();


    public ImageManager(int sizeX, int sizeY, double[][] aScope, double[][] aScope3d) {
        scope = aScope.clone();
        scope3d = aScope3d.clone();
        imageWidth = sizeX;
        imageHeight = sizeY;
        painter = new ThreadedPainter(this);
    }

    public void paintImagesAsync(double[] potentials) {
        painter.performPaintOperation(potentials);

        if (!painter.isRunning()) {
            painter.start();
        }
    }

    public void paintImages(double[] potentials) {

    }

    class ThreadedPainter extends Thread {

        protected boolean isRunning = false;
        public BlockingQueue<PaintOperation> workQueue = new LinkedBlockingQueue<PaintOperation>();
        protected ImageManager imageManager = null;

        public ThreadedPainter(ImageManager manager) {
            imageManager = manager;
        }

        public void performPaintOperation(double[] potentials) {
            workQueue.add(new PaintOperation(potentials));
        }

        public boolean isRunning() {
            return isRunning;
        }

        @Override
        public void run() {
            isRunning = true;

            while (!isInterrupted()) {
                PaintOperation operation = workQueue.poll();
                if (operation == null) {
                    try {
                        wait(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                imageManager.paintImages(operation.potentials);
            }

            isRunning = false;
        }

        class PaintOperation {
            protected double[] potentials = null;

            PaintOperation(double[] potentials) {
                this.potentials = potentials.clone();
            }

            public double[] getPotentials() {
                return potentials;
            }
        }
    }


}
