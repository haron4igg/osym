package Calculation_Modules;


import com.nativelibs4java.util.NIOUtils;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.PointerByReference;
import org.bridj.Pointer;

import java.applet.Applet;
import java.nio.DoubleBuffer;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 06.03.12
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorNative {

    CalcLib library = null;

    public interface CalcLib extends Library {

        public interface CallbackHandler extends Callback {
            public void callback();
        }

        void run(double [] coefs,
                 double [] coefs2,
                 double [] input,
                 double [] scope,
                 int dimensions,
                 double from,
                 double to,
                 double step);

        void setPaused();
        void setStarted();
        void setCanceled();
        double getProgress();
        void registerCallback(CallbackHandler myc);

    }

    public CalculatorNative(CalcLib.CallbackHandler handler) {

        String path = "C:\\";
        System.out.println(path);
        System.setProperty("jna.library.path", path);
        System.setProperty("jna.nosys","true");

        library = (CalcLib) Native.loadLibrary("libCalculator", CalcLib.class);

        if (handler != null) {
            library.registerCallback(handler);
        }
    }

    double [] convertMatrixToArray(double [][] matrix) {
        double [] initialMatrixArray = new double[matrix.length * matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                initialMatrixArray[j+matrix[0].length*i] = matrix[i][j];
            }
        }

        return initialMatrixArray;
    }

    public long run(double [][] coefs,
                    double []coefs2,
                    double [][] scope,
                    double [] input,
                    double from,
                    double total,
                    double step) {

        long time = System.currentTimeMillis();


        double [] initialMatrixArray = convertMatrixToArray(coefs);
        double [] initialScopeArray = convertMatrixToArray(scope);

        //com.sun.jna.Pointer pointer = new com.sun.jna.Pointer(initialMatrixArray.length);



       //Pointer<Double> initMatrix = Pointer.allocateDoubles(initialMatrixArray.length);
        //initMatrix.setDoubles(initialMatrixArray);

        //Pointer<Double> initScope = Pointer.allocateDoubles(initialScopeArray.length);
       // initMatrix.setDoubles(initialScopeArray);
        //

        library.run(initialMatrixArray,
                 coefs2,
                 input,
                 initialScopeArray,
                 input.length,
                 from,
                 total,
                 step);

        return System.currentTimeMillis() - time;
    }
}
