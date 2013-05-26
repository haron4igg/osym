package Calculation_Modules;

/**
 * Created by IntelliJ IDEA.
 * User: steparon
 * Date: 31.03.12
 * Time: 22:07
 * To cstepange tstepis template use File | Settings | File Templates.
 */
public class OctpletFunctions extends Functions {

    protected double mk3 = Math.sqrt(3);

    public double func1(double[] input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (-v1[j % 3] * (Svec(v2, v2) + Svec(v3, v3) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7)) + v2[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v1, v3) + v4[j % 3] * (0.25 * Svec(v1, v4) - 0.75 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v5[j % 3] * (0.75 * Svec(v2, v4) + 0.25 * Svec(v1, v5) + 0.75 * Svec(v3, v7) + 0.25 * mk3 * Svec(v7, v8)) + v6[j % 3] * (-0.75 * Svec(v3, v4) + 0.25 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8)) + v7[j % 3] * (-0.75 * Svec(v3, v5) - 0.75 * Svec(v2, v6) + 0.25 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v8[j % 3] * (-0.5 * mk3 * Svec(v4, v6) - 0.5 * mk3 * Svec(v5, v7)));
    }

    public double func2(double[] input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (v1[j % 3] * Svec(v1, v2) - v2[j % 3] * (Svec(v1, v1) + Svec(v3, v3) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7)) + v3[j % 3] * Svec(v2, v3) + v4[j % 3] * (0.25 * Svec(v2, v4) + 0.75 * Svec(v1, v5) - 0.75 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8)) + v5[j % 3] * (-0.75 * Svec(v1, v4) + 0.25 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v6[j % 3] * (-0.75 * Svec(v3, v5) + 0.25 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v7[j % 3] * (0.75 * Svec(v3, v4) + 0.75 * Svec(v1, v6) + 0.25 * Svec(v2, v7) - 0.25 * mk3 * Svec(v4, v8)) + v8[j % 3] * (-0.5 * mk3 * Svec(v5, v6) + 0.5 * mk3 * Svec(v4, v7)));
    }

    public double func3(double[] input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (v1[j % 3] * Svec(v1, v3) + v2[j % 3] * Svec(v2, v3) - v3[j % 3] * (Svec(v1, v1) + Svec(v2, v2) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7)) + v4[j % 3] * (0.25 * Svec(v3, v4) - 0.75 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8)) + v5[j % 3] * (0.25 * Svec(v3, v5) - 0.75 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v6[j % 3] * (0.75 * Svec(v1, v4) + 0.75 * Svec(v2, v5) + 0.25 * Svec(v3, v6) - 0.25 * mk3 * Svec(v6, v8)) + v7[j % 3] * (-0.75 * Svec(v2, v4) + 0.75 * Svec(v1, v5) + 0.25 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8)) + v8[j % 3] * 0.25 * mk3 * (-Svec(v4, v4) - Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)));
    }

    public double func4(double[] input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (v1[j % 3] * (0.25 * Svec(v1, v4) - 0.75 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v2[j % 3] * (0.25 * Svec(v2, v4) + 0.75 * Svec(v1, v5) - 0.75 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8)) + v3[j % 3] * (0.25 * Svec(v3, v4) - 0.75 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8)) - v4[j % 3] * (0.25 * Svec(v1, v1) + 0.25 * Svec(v2, v2) + 0.25 * Svec(v3, v3) + Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7) + 0.5 * mk3 * Svec(v3, v8) + 0.75 * Svec(v8, v8)) + v5[j % 3] * Svec(v4, v5) + v6[j % 3] * (0.25 * Svec(v4, v6) - 0.75 * Svec(v5, v7) - 0.5 * mk3 * Svec(v1, v8)) + v7[j % 3] * (0.75 * Svec(v5, v6) + 0.25 * Svec(v4, v7) + 0.5 * mk3 * Svec(v2, v8)) + v8[j % 3] * 0.25 * mk3 * (Svec(v3, v4) + Svec(v1, v6) - Svec(v2, v7) + mk3 * Svec(v4, v8)));
    }

    public double func5(double[] input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (v1[j % 3] * (0.75 * Svec(v2, v4) + 0.25 * Svec(v1, v5) + 0.75 * Svec(v3, v7) + 0.25 * mk3 * Svec(v7, v8)) + v2[j % 3] * (-0.75 * Svec(v1, v4) + 0.25 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v3[j % 3] * (0.25 * Svec(v3, v5) - 0.75 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v4[j % 3] * Svec(v4, v5) - v5[j % 3] * (0.25 * Svec(v1, v1) + 0.25 * Svec(v2, v2) + 0.25 * Svec(v3, v3) + Svec(v4, v4) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7) + 0.5 * mk3 * Svec(v3, v8) + 0.75 * Svec(v8, v8)) + v6[j % 3] * (0.25 * Svec(v5, v6) + 0.75 * Svec(v4, v7) - 0.5 * mk3 * Svec(v2, v8)) + v7[j % 3] * (-0.75 * Svec(v4, v6) + 0.25 * Svec(v5, v7) - 0.5 * mk3 * Svec(v1, v8)) + v8[j % 3] * 0.25 * mk3 * (Svec(v3, v5) + Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)));
    }

    public double func6(double[] input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (v1[j % 3] * 0.25 * (-3 * Svec(v3, v4) + Svec(v1, v6) + 3 * Svec(v2, v7) + mk3 * Svec(v4, v8)) + v2[j % 3] * 0.25 * (-3 * Svec(v3, v5) + Svec(v2, v6) - 3 * Svec(v1, v7) + mk3 * Svec(v5, v8)) + v3[j % 3] * 0.25 * (3 * Svec(v1, v4) + 3 * Svec(v2, v5) + Svec(v3, v6) - mk3 * Svec(v6, v8)) + v4[j % 3] * 0.25 * (Svec(v4, v6) - 3 * Svec(v5, v7) - 2 * mk3 * Svec(v1, v8)) + v5[j % 3] * 0.25 * (Svec(v5, v6) + 3 * Svec(v4, v7) - 2 * mk3 * Svec(v2, v8)) - v6[j % 3] * 0.25 * (Svec(v1, v1) + Svec(v2, v2) + Svec(v3, v3) + Svec(v4, v4) + Svec(v5, v5) + 4 * Svec(v7, v7) - 2 * mk3 * Svec(v3, v8) + 3 * Svec(v8, v8)) + v7[j % 3] * Svec(v6, v7) + v8[j % 3] * mk3 * 0.25 * (Svec(v1, v4) + Svec(v2, v5) - Svec(v3, v6) + mk3 * Svec(v6, v8)));
    }

    public double func7(double[] input, int j, double[] mas, double step) {


        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (v1[j % 3] * 0.25 * (-3 * Svec(v3, v5) - 3 * Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)) + v2[j % 3] * 0.25 * (3 * Svec(v3, v4) + 3 * Svec(v1, v6) + Svec(v2, v7) - mk3 * Svec(v4, v8)) + v3[j % 3] * 0.25 * (-3 * Svec(v2, v4) + 3 * Svec(v1, v5) + Svec(v3, v7) - mk3 * Svec(v7, v8)) + v4[j % 3] * 0.25 * (3 * Svec(v5, v6) + Svec(v4, v7) + 2 * mk3 * Svec(v2, v8)) + v5[j % 3] * 0.25 * (-3 * Svec(v4, v6) + Svec(v5, v7) - 2 * mk3 * Svec(v1, v8)) + v6[j % 3] * Svec(v6, v7) - v7[j % 3] * 0.25 * (Svec(v1, v1) + Svec(v2, v2) + Svec(v3, v3) + Svec(v4, v4) + Svec(v5, v5) + 4 * Svec(v6, v6) - 2 * mk3 * Svec(v3, v8) + 3 * Svec(v8, v8)) + v8[j % 3] * mk3 * 0.25 * (-Svec(v2, v4) + Svec(v1, v5) - Svec(v3, v7) + mk3 * Svec(v7, v8)));
    }

    public double func8(double[] input, int j, double[] mas, double step) {
        double v1[] = {input[0] + step * mas[0], input[1] + step * mas[1], input[2] + step * mas[2]};
        double v2[] = {input[3] + step * mas[3], input[4] + step * mas[4], input[5] + step * mas[5]};
        double v3[] = {input[6] + step * mas[6], input[7] + step * mas[7], input[8] + step * mas[8]};
        double v4[] = {input[9] + step * mas[9], input[10] + step * mas[10], input[11] + step * mas[11]};
        double v5[] = {input[12] + step * mas[12], input[13] + step * mas[13], input[14] + step * mas[14]};
        double v6[] = {input[15] + step * mas[15], input[16] + step * mas[16], input[17] + step * mas[17]};
        double v7[] = {input[18] + step * mas[18], input[19] + step * mas[19], input[20] + step * mas[20]};
        double v8[] = {input[21] + step * mas[21], input[22] + step * mas[22], input[23] + step * mas[23]};

        return (double) (v1[j % 3] * (-0.5) * mk3 * (Svec(v4, v6) + Svec(v5, v7)) + v2[j % 3] * 0.5 * mk3 * (-Svec(v5, v6) + Svec(v4, v7)) + v3[j % 3] * 0.25 * mk3 * (-Svec(v4, v4) - Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)) + v4[j % 3] * 0.25 * mk3 * (Svec(v3, v4) + Svec(v1, v6) - Svec(v2, v7) + mk3 * Svec(v4, v8)) + v5[j % 3] * 0.25 * mk3 * (Svec(v3, v5) + Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)) + v6[j % 3] * 0.25 * mk3 * (Svec(v1, v4) + Svec(v2, v5) - Svec(v3, v6) + mk3 * Svec(v6, v8)) + v7[j % 3] * 0.25 * mk3 * (-Svec(v2, v4) + Svec(v1, v5) - Svec(v3, v7) + mk3 * Svec(v7, v8)) - v8[j % 3] * 0.75 * (Svec(v4, v4) + Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)));
    }

}
