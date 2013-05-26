package Calculation_Modules;

import com.sun.org.apache.xpath.internal.functions.Function;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 18.02.12
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
public class TripletFunctions extends Functions {


    public double func1(double []input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

        return (double) (-v1[j % 3] * (Svec(v2, v2) + Svec(v3, v3)) + v2[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v1, v3));
    }

    public double func2(double []input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

        return (double) (-v2[j % 3] * (Svec(v1, v1) + Svec(v3, v3)) + v1[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v2, v3));
    }

    public double func3(double []input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};

        return (double) (-v3[j % 3] * (Svec(v2, v2) + Svec(v1, v1)) + v2[j % 3] * Svec(v3, v2) + v1[j % 3] * Svec(v1, v3));
    }






}
