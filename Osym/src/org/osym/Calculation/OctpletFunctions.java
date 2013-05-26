package org.osym.Calculation;

/**
 * Created by IntelliJ IDEA.
 * User: steparon
 * Date: 31.03.12
 * Time: 22:07
 * To cstepange tstepis template use File | Settings | File Templates.
 */
public class OctpletFunctions extends Functions {


    public double func1(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (-v1[j % 3] * (Svec(v2, v2) + Svec(v3, v3) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7)) + v2[j % 3] * Svec(v1, v2) + v3[j % 3] * Svec(v1, v3) + v4[j % 3] * (0.25 * Svec(v1, v4) - 0.75 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v5[j % 3] * (0.75 * Svec(v2, v4) + 0.25 * Svec(v1, v5) + 0.75 * Svec(v3, v7) + 0.25 * mk3 * Svec(v7, v8)) + v6[j % 3] * (-0.75 * Svec(v3, v4) + 0.25 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8)) + v7[j % 3] * (-0.75 * Svec(v3, v5) - 0.75 * Svec(v2, v6) + 0.25 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v8[j % 3] * (-0.5 * mk3 * Svec(v4, v6) - 0.5 * mk3 * Svec(v5, v7)));
    }

    public double func2(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (v1[j % 3] * Svec(v1, v2) - v2[j % 3] * (Svec(v1, v1) + Svec(v3, v3) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7)) + v3[j % 3] * Svec(v2, v3) + v4[j % 3] * (0.25 * Svec(v2, v4) + 0.75 * Svec(v1, v5) - 0.75 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8)) + v5[j % 3] * (-0.75 * Svec(v1, v4) + 0.25 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v6[j % 3] * (-0.75 * Svec(v3, v5) + 0.25 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v7[j % 3] * (0.75 * Svec(v3, v4) + 0.75 * Svec(v1, v6) + 0.25 * Svec(v2, v7) - 0.25 * mk3 * Svec(v4, v8)) + v8[j % 3] * (-0.5 * mk3 * Svec(v5, v6) + 0.5 * mk3 * Svec(v4, v7)));
    }

    public double func3(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (v1[j % 3] * Svec(v1, v3) + v2[j % 3] * Svec(v2, v3) - v3[j % 3] * (Svec(v1, v1) + Svec(v2, v2) + 0.25 * Svec(v4, v4) + 0.25 * Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7)) + v4[j % 3] * (0.25 * Svec(v3, v4) - 0.75 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8)) + v5[j % 3] * (0.25 * Svec(v3, v5) - 0.75 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v6[j % 3] * (0.75 * Svec(v1, v4) + 0.75 * Svec(v2, v5) + 0.25 * Svec(v3, v6) - 0.25 * mk3 * Svec(v6, v8)) + v7[j % 3] * (-0.75 * Svec(v2, v4) + 0.75 * Svec(v1, v5) + 0.25 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8)) + v8[j % 3] * 0.25 * mk3 * (-Svec(v4, v4) - Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)));
    }

    public double func4(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (v1[j % 3] * (0.25 * Svec(v1, v4) - 0.75 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v2[j % 3] * (0.25 * Svec(v2, v4) + 0.75 * Svec(v1, v5) - 0.75 * Svec(v3, v7) - 0.25 * mk3 * Svec(v7, v8)) + v3[j % 3] * (0.25 * Svec(v3, v4) - 0.75 * Svec(v1, v6) + 0.75 * Svec(v2, v7) + 0.25 * mk3 * Svec(v4, v8)) - v4[j % 3] * (0.25 * Svec(v1, v1) + 0.25 * Svec(v2, v2) + 0.25 * Svec(v3, v3) + Svec(v5, v5) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7) + 0.5 * mk3 * Svec(v3, v8) + 0.75 * Svec(v8, v8)) + v5[j % 3] * Svec(v4, v5) + v6[j % 3] * (0.25 * Svec(v4, v6) - 0.75 * Svec(v5, v7) - 0.5 * mk3 * Svec(v1, v8)) + v7[j % 3] * (0.75 * Svec(v5, v6) + 0.25 * Svec(v4, v7) + 0.5 * mk3 * Svec(v2, v8)) + v8[j % 3] * 0.25 * mk3 * (Svec(v3, v4) + Svec(v1, v6) - Svec(v2, v7) + mk3 * Svec(v4, v8)));
    }

    public double func5(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (v1[j % 3] * (0.75 * Svec(v2, v4) + 0.25 * Svec(v1, v5) + 0.75 * Svec(v3, v7) + 0.25 * mk3 * Svec(v7, v8)) + v2[j % 3] * (-0.75 * Svec(v1, v4) + 0.25 * Svec(v2, v5) + 0.75 * Svec(v3, v6) + 0.25 * mk3 * Svec(v6, v8)) + v3[j % 3] * (0.25 * Svec(v3, v5) - 0.75 * Svec(v2, v6) - 0.75 * Svec(v1, v7) + 0.25 * mk3 * Svec(v5, v8)) + v4[j % 3] * Svec(v4, v5) - v5[j % 3] * (0.25 * Svec(v1, v1) + 0.25 * Svec(v2, v2) + 0.25 * Svec(v3, v3) + Svec(v4, v4) + 0.25 * Svec(v6, v6) + 0.25 * Svec(v7, v7) + 0.5 * mk3 * Svec(v3, v8) + 0.75 * Svec(v8, v8)) + v6[j % 3] * (0.25 * Svec(v5, v6) + 0.75 * Svec(v4, v7) - 0.5 * mk3 * Svec(v2, v8)) + v7[j % 3] * (-0.75 * Svec(v4, v6) + 0.25 * Svec(v5, v7) - 0.5 * mk3 * Svec(v1, v8)) + v8[j % 3] * 0.25 * mk3 * (Svec(v3, v5) + Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)));
    }

    public double func6(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (v1[j % 3] * 0.25 * (-3 * Svec(v3, v4) + Svec(v1, v6) + 3 * Svec(v2, v7) + mk3 * Svec(v4, v8)) + v2[j % 3] * 0.25 * (-3 * Svec(v3, v5) + Svec(v2, v6) - 3 * Svec(v1, v7) + mk3 * Svec(v5, v8)) + v3[j % 3] * 0.25 * (3 * Svec(v1, v4) + 3 * Svec(v2, v5) + Svec(v3, v6) - mk3 * Svec(v6, v8)) + v4[j % 3] * 0.25 * (Svec(v4, v6) - 3 * Svec(v5, v7) - 2 * mk3 * Svec(v1, v8)) + v5[j % 3] * 0.25 * (Svec(v5, v6) + 3 * Svec(v4, v7) - 2 * mk3 * Svec(v2, v8)) - v6[j % 3] * 0.25 * (Svec(v1, v1) + Svec(v2, v2) + Svec(v3, v3) + Svec(v4, v4) + Svec(v5, v5) + 4 * Svec(v7, v7) - 2 * mk3 * Svec(v3, v8) + 3 * Svec(v8, v8)) + v7[j % 3] * Svec(v6, v7) + v8[j % 3] * mk3 * 0.25 * (Svec(v1, v4) + Svec(v2, v5) - Svec(v3, v6) + mk3 * Svec(v6, v8)));
    }

    public double func7(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (v1[j % 3] * 0.25 * (-3 * Svec(v3, v5) - 3 * Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)) + v2[j % 3] * 0.25 * (3 * Svec(v3, v4) + 3 * Svec(v1, v6) + Svec(v2, v7) - mk3 * Svec(v4, v8)) + v3[j % 3] * 0.25 * (-3 * Svec(v2, v4) + 3 * Svec(v1, v5) + Svec(v3, v7) - mk3 * Svec(v7, v8)) + v4[j % 3] * 0.25 * (3 * Svec(v5, v6) + Svec(v4, v7) + 2 * mk3 * Svec(v2, v8)) + v5[j % 3] * 0.25 * (-3 * Svec(v4, v6) + Svec(v5, v7) - 2 * mk3 * Svec(v1, v8)) + v6[j % 3] * Svec(v6, v7) - v7[j % 3] * 0.25 * (Svec(v1, v1) + Svec(v2, v2) + Svec(v3, v3) + Svec(v4, v4) + Svec(v5, v5) + 4 * Svec(v6, v6) - 2 * mk3 * Svec(v3, v8) + 3 * Svec(v8, v8)) + v8[j % 3] * mk3 * 0.25 * (-Svec(v2, v4) + Svec(v1, v5) - Svec(v3, v7) + mk3 * Svec(v7, v8)));
    }

    public double func8(double []point, int j, double[] mas, double step) {
        double v1[] = {point[0] + step * mas[0], point[1] + step * mas[1], point[2] + step * mas[2]};
        double v2[] = {point[3] + step * mas[3], point[4] + step * mas[4], point[5] + step * mas[5]};
        double v3[] = {point[6] + step * mas[6], point[7] + step * mas[7], point[8] + step * mas[8]};
        double v4[] = {point[9] + step * mas[9], point[10] + step * mas[10], point[11] + step * mas[11]};
        double v5[] = {point[12] + step * mas[12], point[13] + step * mas[13], point[14] + step * mas[14]};
        double v6[] = {point[15] + step * mas[15], point[16] + step * mas[16], point[17] + step * mas[17]};
        double v7[] = {point[18] + step * mas[18], point[19] + step * mas[19], point[20] + step * mas[20]};
        double v8[] = {point[21] + step * mas[21], point[22] + step * mas[22], point[23] + step * mas[23]};

        return (double) (v1[j % 3] * (-0.5) * mk3 * (Svec(v4, v6) + Svec(v5, v7)) + v2[j % 3] * 0.5 * mk3 * (-Svec(v5, v6) + Svec(v4, v7)) + v3[j % 3] * 0.25 * mk3 * (-Svec(v4, v4) - Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)) + v4[j % 3] * 0.25 * mk3 * (Svec(v3, v4) + Svec(v1, v6) - Svec(v2, v7) + mk3 * Svec(v4, v8)) + v5[j % 3] * 0.25 * mk3 * (Svec(v3, v5) + Svec(v2, v6) + Svec(v1, v7) + mk3 * Svec(v5, v8)) + v6[j % 3] * 0.25 * mk3 * (Svec(v1, v4) + Svec(v2, v5) - Svec(v3, v6) + mk3 * Svec(v6, v8)) + v7[j % 3] * 0.25 * mk3 * (-Svec(v2, v4) + Svec(v1, v5) - Svec(v3, v7) + mk3 * Svec(v7, v8)) - v8[j % 3] * 0.75 * (Svec(v4, v4) + Svec(v5, v5) + Svec(v6, v6) + Svec(v7, v7)));
    }

    public double U123(double [] point) {
        return (double) (0.5 * (calculateVector(point,1, 2) + calculateVector(point,3, 1) + calculateVector(point,2, 3)));
    }

    public double U147(double [] point) {
        return (double) (0.125 * (calculateVector(point,1, 4) + calculateVector(point,4, 7) + calculateVector(point,7, 1)));
    }

    public double U156(double [] point) {
        return (double) (0.125 * (calculateVector(point,1, 5) + calculateVector(point,5, 6) + calculateVector(point,6, 1)));
    }

    public double U246(double [] point) {
        return (double) (0.125 * (calculateVector(point,2, 4) + calculateVector(point,4, 6) + calculateVector(point,6, 2)));
    }

    public double U257(double [] point) {
        return (double) (0.125 * (calculateVector(point,2, 5) + calculateVector(point,5, 7) + calculateVector(point,7, 2)));
    }

    public double U3458(double [] point) {
        return (double) (0.125 * (calculateVector(point,3, 4) + calculateVector(point,3, 5) + 4 * calculateVector(point,4, 5) + 3 * calculateVector(point,4, 8) + 3 * calculateVector(point,5, 8) - 2 * mk3 * vectorSumm(point,3, 4) * vectorSumm(point,8, 4) - 2 * mk3 * vectorSumm(point,5, 3) * vectorSumm(point,8, 5) + 2 * mk3 * vectorSumm(point,4, 4) * vectorSumm(point,8, 3) + 2 * mk3 * vectorSumm(point,5, 5) * vectorSumm(point,8, 3)));
    }

    public double U3678(double [] point) {
        return (double) (0.125 * (calculateVector(point,6, 3) + calculateVector(point,3, 7) + 4 * calculateVector(point,7, 6) + 3 * calculateVector(point,6, 8) + 3 * calculateVector(point,7, 8) + 2 * mk3 * vectorSumm(point,6, 3) * vectorSumm(point,8, 6) + 2 * mk3 * vectorSumm(point,7, 3) * vectorSumm(point,8, 7) - 2 * mk3 * vectorSumm(point,8, 3) * vectorSumm(point,6, 6) - 2 * mk3 * vectorSumm(point,8, 3) * vectorSumm(point,7, 7)));
    }

    public double RU(double [] point) {
        return (double) (0.5 * mk3 * (vectorSumm(point,2, 8) * vectorSumm(point,5, 6) - vectorSumm(point,2, 8) * vectorSumm(point,4, 7) + vectorSumm(point,1, 8) * vectorSumm(point,4, 6) + vectorSumm(point,1, 8) * vectorSumm(point,5, 7)) + 0.75 * (vectorSumm(point,5, 7) * vectorSumm(point,4, 6) - vectorSumm(point,4, 7) * vectorSumm(point,5, 6) + vectorSumm(point,3, 4) * vectorSumm(point,1, 6) - vectorSumm(point,3, 4) * vectorSumm(point,2, 7) - vectorSumm(point,1, 6) * vectorSumm(point,2, 7) + vectorSumm(point,1, 7) * vectorSumm(point,3, 5) + vectorSumm(point,2, 6) * vectorSumm(point,1, 7) + vectorSumm(point,2, 6) * vectorSumm(point,3, 5) + vectorSumm(point,2, 5) * vectorSumm(point,1, 4) - vectorSumm(point,2, 5) * vectorSumm(point,3, 6) - vectorSumm(point,1, 4) * vectorSumm(point,3, 6) - vectorSumm(point,1, 5) * vectorSumm(point,2, 4) - vectorSumm(point,3, 7) * vectorSumm(point,1, 5) + vectorSumm(point,3, 7) * vectorSumm(point,2, 4)) + 0.25 * mk3 * (-vectorSumm(point,4, 8) * vectorSumm(point,1, 6) + vectorSumm(point,2, 7) * vectorSumm(point,4, 8) - vectorSumm(point,2, 6) * vectorSumm(point,5, 8) - vectorSumm(point,5, 8) * vectorSumm(point,1, 7) - vectorSumm(point,6, 8) * vectorSumm(point,1, 4) - vectorSumm(point,6, 8) * vectorSumm(point,2, 5) + vectorSumm(point,7, 8) * vectorSumm(point,2, 4) - vectorSumm(point,7, 8) * vectorSumm(point,1, 5)));
    }

    public double U(double [] point) {
        return (double) (U123(point) + U147(point) + U156(point) + U246(point) + U257(point) + U3458(point) + U3678(point) + RU(point));
    }

    public double K(double [] point) {
        return (double) (0.5 * (vectorSumm(point,9, 9) + vectorSumm(point,10, 10) + vectorSumm(point,11, 11) + vectorSumm(point,12, 12) + vectorSumm(point,13, 13) + vectorSumm(point,14, 14) + vectorSumm(point,15, 15) + vectorSumm(point,16, 16)));
    }



    public double EUK(double[] point) {
        return (double) (Math.log10(Math.abs(K(point) + U(point) - 1.0)));
    }

    public void setupStartPoint(double[] point, int state) {

        double UKpot, kappa, betta;
        double[] msign = new double[9];
        int flag = 0;

        for (int i = 0; i < 48; i++)
            point[i] = 0.0;

        switch (state) {

            case 0: {


                kiral_test(point, 24);

                UKpot = K(point);
                betta = 1.0 / Math.pow(UKpot, 1.0 / 2);

                for (int i = 24; i < 48; i++)
                    point[i] *= betta;
            }
            break;

            case 1: {



                kiral_test(point, 0);

                UKpot = U(point);
                kappa = 1.0 / Math.pow(UKpot, 1.0 / 4);

                for (int i = 0; i < 24; i++)
                    point[i] *= kappa;

            }
            break;

            case 2: {
                int index[] = new int[8];
                int myif = 0;

                index[0] = 2;
                index[1] = 3;
                index[2] = 1;
                index[3] = 2;
                index[4] = 2;
                index[5] = 3;
                index[6] = 3;
                index[7] = 1;

                do {
                    for (int i = 24; i < 48; i++)
                        point[i] = Math.random() * 2.0 - 1;

                    kiral_test(point, 0);

                    for (int i = 0; i < 8; i++)
                        point[23 + i * 3 + index[i]] = 0.0;

                    myif = GaussTriplet(point, index);
                } while (myif != 1);

                UKpot = U(point) + K(point);
                kappa = 1.0 / Math.pow(UKpot, 1.0 / 4);
                betta = 1.0 / Math.pow(UKpot, 1.0 / 2);

                for (int i = 0; i < 24; i++) {
                    point[i] *= kappa;
                    point[24 + i] *= betta;
                }
            }
        }


        UKpot = EUK(point);

        System.out.println("начальные условия в для счета");
        for (int i = 0; i < 48; i++)
            System.out.println(i + ": " + point[i]);

        System.out.println("энергия = " + UKpot);

        double ty;
        int ut = 0;
        ty = kiral(point, 1, 2, 3, ut);
        System.out.println("ориентация тройки  123:  " + ty);
        ty = kiral(point, 1, 4, 7, ut);
        System.out.println("ориентация тройки  147:  " + ty);
        ty = kiral(point, 1, 6, 5, ut);
        System.out.println("ориентация тройки  165:  " + ty);
        ty = kiral(point, 2, 4, 6, ut);
        System.out.println("ориентация тройки  246:  " + ty);
        ty = kiral(point, 2, 5, 7, ut);
        System.out.println("ориентация тройки  257:  " + ty);
        ty = kiral(point, 3, 4, 5, ut);
        System.out.println("ориентация тройки  345:  " + ty);
        ty = kiral(point, 3, 7, 6, ut);
        System.out.println("ориентация тройки  376:  " + ty);
        ty = kiral(point, 4, 5, 8, ut);
        System.out.println("ориентация тройки  458:  " + ty);
        ty = kiral(point, 6, 7, 8, ut);
        System.out.println("ориентация тройки  678:  " + ty);

    }

    protected int GaussTriplet(double[] point, int[] mas) {
        double Symb[][] = {{0.0, 0.0, 0.0, -point[6], -point[7], -point[8], point[3], point[4], point[5], -0.5 * point[18], -0.5 * point[19], -0.5 * point[20], 0.5 * point[15], 0.5 * point[16], 0.5 * point[17], -0.5 * point[12], -0.5 * point[13], -0.5 * point[14], 0.5 * point[9], 0.5 * point[10], 0.5 * point[11], 0.0, 0.0, 0.0},
                {point[6], point[7], point[8], 0.0, 0.0, 0.0, -point[0], -point[1], -point[2], -0.5 * point[15], -0.5 * point[16], -0.5 * point[17], -0.5 * point[18], -0.5 * point[19], -0.5 * point[20], 0.5 * point[9], 0.5 * point[10], 0.5 * point[11], 0.5 * point[12], 0.5 * point[13], 0.5 * point[14], 0.0, 0.0, 0.0},
                {-point[3], -point[4], -point[5], point[0], point[1], point[2], 0.0, 0.0, 0.0, -0.5 * point[12], -0.5 * point[13], -0.5 * point[14], 0.5 * point[9], 0.5 * point[10], 0.5 * point[11], 0.5 * point[18], 0.5 * point[19], 0.5 * point[20], -0.5 * point[15], -0.5 * point[16], -0.5 * point[17], 0.0, 0.0, 0.0},
                {0.5 * point[18], 0.5 * point[19], 0.5 * point[20], 0.5 * point[15], 0.5 * point[16], 0.5 * point[17], 0.5 * point[12], 0.5 * point[13], 0.5 * point[14], 0.0, 0.0, 0.0, -0.5 * point[6] - 0.5 * mk3 * point[21], -0.5 * point[7] - 0.5 * mk3 * point[22], -0.5 * point[8] - 0.5 * mk3 * point[23], -0.5 * point[3], -0.5 * point[4], -0.5 * point[5], -0.5 * point[0], -0.5 * point[1], -0.5 * point[2], 0.5 * mk3 * point[12], 0.5 * mk3 * point[13], 0.5 * mk3 * point[14]},
                {-0.5 * point[15], -0.5 * point[16], -0.5 * point[17], 0.5 * point[18], 0.5 * point[19], 0.5 * point[20], -0.5 * point[9], -0.5 * point[10], -0.5 * point[11], 0.5 * point[6] + 0.5 * mk3 * point[21], 0.5 * point[7] + 0.5 * mk3 * point[22], 0.5 * point[8] + 0.5 * mk3 * point[23], 0.0, 0.0, 0.0, 0.5 * point[0], 0.5 * point[1], 0.5 * point[2], -0.5 * point[3], -0.5 * point[4], -0.5 * point[5], -0.5 * mk3 * point[9], -0.5 * mk3 * point[10], -0.5 * mk3 * point[11]},
                {0.5 * point[12], 0.5 * point[13], 0.5 * point[14], -0.5 * point[9], -0.5 * point[10], -0.5 * point[11], -0.5 * point[18], -0.5 * point[19], -0.5 * point[20], 0.5 * point[3], 0.5 * point[4], 0.5 * point[5], -0.5 * point[0], -0.5 * point[1], -0.5 * point[2], 0.0, 0.0, 0.0, 0.5 * point[6] - 0.5 * mk3 * point[21], 0.5 * point[7] - 0.5 * mk3 * point[22], 0.5 * point[8] - 0.5 * mk3 * point[23], 0.5 * mk3 * point[18], 0.5 * mk3 * point[19], 0.5 * mk3 * point[20]},
                {-0.5 * point[9], -0.5 * point[10], -0.5 * point[11], -0.5 * point[12], -0.5 * point[13], -0.5 * point[14], 0.5 * point[15], 0.5 * point[16], 0.5 * point[17], 0.5 * point[0], 0.5 * point[1], 0.5 * point[2], 0.5 * point[3], 0.5 * point[4], 0.5 * point[5], -0.5 * point[6] + 0.5 * mk3 * point[21], -0.5 * point[7] + 0.5 * mk3 * point[22], -0.5 * point[8] + 0.5 * mk3 * point[23], 0.0, 0.0, 0.0, -0.5 * mk3 * point[15], -0.5 * mk3 * point[16], -0.5 * mk3 * point[17]},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.5 * mk3 * point[12], -0.5 * mk3 * point[13], -0.5 * mk3 * point[14], 0.5 * mk3 * point[9], 0.5 * mk3 * point[10], 0.5 * mk3 * point[11], -0.5 * mk3 * point[18], -0.5 * mk3 * point[19], -0.5 * mk3 * point[20], 0.5 * mk3 * point[15], 0.5 * mk3 * point[16], 0.5 * mk3 * point[17], 0.0, 0.0, 0.0}};

        int N = 8;
        double aGauss[][] = new double[N][N];
        double bGauss[][] = new double[N][1];
        double cGauss[][] = new double[N][N + 1];
        double xGauss[][] = new double[N][1];
        double det;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                aGauss[i][j] = Symb[i][j * 3 + mas[j] - 1];

        for (int i = 0; i < N; i++)
            bGauss[i][0] = 0.0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 24; j++)
                bGauss[i][0] -= Symb[i][j] * point[24 + j];

        zapolnenieGauss(aGauss, bGauss, cGauss, N);
        int k = pr_hod(cGauss, N);
        det = opred(cGauss, k, N);

        if (det < 1e-15 && det > -1e-15)
            return 0;
        else {
            obr_hod(cGauss, xGauss, N);

            for (int i = 0; i < N; i++)
                point[23 + i * 3 + mas[i]] = xGauss[i][0];
        }
        return 1;
    }
    protected int pr_hod(double[][] cG, int N) {
        int i, j, k, p = 0, l;
        double m;

        for (i = 0; i < N - 1; i++) {
            l = perectanovka(cG, i, N);
            p += l;

            for (k = i + 1; k < N; k++) {
                m = cG[k][i] / cG[i][i];
                for (j = i; j < N + 1; j++)
                    cG[k][j] = cG[k][j] - m * cG[i][j];
            }
        }

        return p;
    }
    protected int perectanovka(double[][] cG, int i, int N) {
        double max = Math.abs(cG[i][i]);
        int hh = i, j, k;
        double m;

        for (j = i + 1; j < N; j++)
            if (max < Math.abs(cG[j][i])) {
                max = Math.abs(cG[j][i]);
                hh = j;
            }

        if (hh != i) {
            for (k = i; k < N + 1; k++) {
                m = cG[i][k];
                cG[i][k] = cG[hh][k];
                cG[hh][k] = m;
            }
            return 1;
        } else return 0;
    }
    protected void obr_hod(double[][] cG, double[][] xG, int N) {
        int i, j, k;
        double d = 0;

        for (i = N - 2; i >= 0; i--)
            for (j = 0; j < 1; j++) {
                xG[N - 1][j] = cG[N - 1][N + j] / cG[N - 1][N - 1];

                for (k = i + 1; k < N; k++)
                    d += cG[i][k] * xG[k][j];

                xG[i][j] = 1 / cG[i][i] * (cG[i][N + j] - d);
                d = 0;
            }
    }
    protected double opred(double[][] cG, int p, int N) {
        int i;
        double det = 1;

        for (i = 0; i < N; i++)
            det *= cG[i][i];

        det *= Math.pow((double) (-1), p);

        return det;
    }
    protected void zapolnenieGauss(double[][] aG, double[][] bG, double[][] cG, int N) {
        int i, j;

        for (i = 0; i < N; i++)
            for (j = 0; j < N + 1; j++)
                if (j < N)
                    cG[i][j] = aG[i][j];
                else
                    cG[i][j] = bG[i][j - N];
    }
    protected void kiral_test(double[] point, int vv) {
        //double[] msign = new double[9];
        int flag = 0;
        int cch = 0, count = 0, ch = 0;

        do {
            ch++;
            for (int i = 9; i < 24; i++)
                point[i + vv] = Math.random() * 2.0 - 1;

            for (int i = 0; i < 3; i++)
                point[i + vv] = 0.0;

            double ty1, ty2;
            ty1 = kiral(point, 4, 5, 8, vv);
            ty2 = kiral(point, 6, 7, 8, vv);

            if (ty1 > 0 && ty2 < 0) {
                double temp;
                for (int i = 15; i < 18; i++) {
                    temp = point[i + vv];
                    point[i + vv] = point[i + 3 + vv];
                    point[i + 3 + vv] = temp;
                }
            } else if (ty1 < 0 && ty2 > 0) {
                double temp;
                for (int i = 9; i < 12; i++) {
                    temp = point[i + vv];
                    point[i + vv] = point[i + 3 + vv];
                    point[i + 3 + vv] = temp;
                }
            } else if (ty1 < 0 && ty2 < 0) {
                for (int i = 21; i < 24; i++)
                    point[i + vv] *= -1;
            }

            count = 0;
            do {
                step_4(point, 4, 5, 7, 6, 3, vv);

                cch = 0;
                do {
                    step_4(point, 4, 6, 5, 7, 2, vv);
                    flag = step_8(point, 2, 3, 4, 7, 6, 5, 1, vv);
                    cch++;
                } while (flag == 1 && cch < 10);

                count++;
            } while (flag == 1 && count < 10);

        } while (flag == 1);

        System.out.println("step  " + ch * count * cch);
    }
    protected void step_4(double[] point, int n1, int n2, int n3, int n4, int mout, int vv) {
        double[] vc1 = new double[3];
        double[] vc2 = new double[3];

        double[] p = new double[3];
        double[] q = new double[3];
        double[] r = new double[3];

        double pp, qq, ss;
        double alfa, betta, gamma;

        for (int i = 0; i < 3; i++) {
            vc1[i] = point[(n1 - 1) * 3 + i + vv];
            vc2[i] = point[(n2 - 1) * 3 + i + vv];
        }
        pp = vec_pr(vc1, vc2, p);

        for (int i = 0; i < 3; i++) {
            vc1[i] = point[(n3 - 1) * 3 + i + vv];
            vc2[i] = point[(n4 - 1) * 3 + i + vv];
        }
        qq = vec_pr(vc1, vc2, q);

        ss = vec_pr(p, q, r);
        ss = Svec(p, q) * 1.0 / (pp * qq);

        betta = Math.random();
        gamma = Math.random() * 2.0 - 1;

        double g1, g2;
        g1 = -betta * qq * ss / pp;
        g2 = -betta * qq / (pp * ss);

        if (ss > 0)
            alfa = Math.random();
        else
            alfa = Math.random() * (g2 - g1) + g1;

        for (int i = 0; i < 3; i++)
            point[i + (mout - 1) * 3 + vv] = alfa * p[i] + betta * q[i] + gamma * r[i];
    }
    protected int step_8(double[] point, int n1, int n2, int n3, int n4, int n5, int n6, int mout, int vv) {
        double[] vc1 = new double[3];
        double[] vc2 = new double[3];

        double[] p = new double[3];
        double[] q = new double[3];
        double[] r = new double[3];

        double pp, qq, rr, ss1, ss2, ss3;
        double alfa, betta, gamma;

        for (int i = 0; i < 3; i++) {
            vc1[i] = point[(n1 - 1) * 3 + i + vv];
            vc2[i] = point[(n2 - 1) * 3 + i + vv];
        }
        pp = vec_pr(vc1, vc2, p);

        for (int i = 0; i < 3; i++) {
            vc1[i] = point[(n3 - 1) * 3 + i + vv];
            vc2[i] = point[(n4 - 1) * 3 + i + vv];
        }
        qq = vec_pr(vc1, vc2, q);

        for (int i = 0; i < 3; i++) {
            vc1[i] = point[(n5 - 1) * 3 + i + vv];
            vc2[i] = point[(n6 - 1) * 3 + i + vv];
        }
        rr = vec_pr(vc1, vc2, r);

        ss1 = Svec(p, q) * 1.0 / (pp * qq);
        ss2 = Svec(p, r) * 1.0 / (pp * rr);
        ss3 = Svec(q, r) * 1.0 / (rr * qq);

        alfa = betta = gamma = 0;
        int count = 0, flag = 0;

        if (ss1 > 0) {
            if (ss2 > 0) {
                if (ss3 > 0) {
                    betta = Math.random();
                    gamma = Math.random();
                    alfa = Math.random();
                } else {
                    do {
                        flag = 0;
                        betta = Math.random();
                        alfa = Math.random();

                        double g1, g2;
                        g1 = -betta * qq * ss3 / rr - alfa * pp * ss2 / rr;
                        g2 = -(betta + alfa * pp * ss1 / qq) * qq / (rr * ss3);

                        if (g2 > g1)
                            gamma = Math.random() * (g2 - g1) + g1;
                        else
                            flag = 1;
                        count++;
                    } while (flag == 1 && count < 10);
                }
            } else if (ss3 > 0) {
                do {
                    flag = 0;
                    betta = Math.random();
                    gamma = Math.random();

                    double g1, g2;
                    g1 = -gamma * rr * ss2 / pp - betta * qq * ss1 / pp;
                    g2 = -(betta * qq * ss3 / rr + gamma) * rr / (pp * ss2);

                    if (g2 > g1)
                        alfa = Math.random() * (g2 - g1) + g1;
                    else
                        flag = 1;
                    count++;
                } while (flag == 1 && count < 10);
            } else {
                do {
                    flag = 0;
                    betta = Math.random();
                    gamma = Math.random() * (1 + betta * qq * ss3 / rr) - betta * qq * ss3 / rr;

                    double g1, g2, g3;
                    g1 = -gamma * rr * ss2 / pp - betta * qq * ss1 / pp;
                    g2 = (-gamma * rr * ss3 / qq - betta) * qq / (pp * ss1);
                    g3 = -(gamma + betta * qq * ss3 / rr) * rr / (pp * ss2);

                    if (g3 > g2 && g3 > g1) {
                        if (g2 > g1)
                            alfa = Math.random() * (g3 - g2) + g2;
                        else
                            alfa = Math.random() * (g3 - g1) + g1;
                    } else
                        flag = 1;

                    count++;
                } while (flag == 1 && count < 10);
            }
        } else if (ss2 > 0) {
            if (ss3 > 0) {
                do {
                    flag = 0;
                    betta = Math.random();
                    gamma = Math.random();

                    double g1, g2;
                    g1 = -betta * qq * ss1 / pp - gamma * rr * ss2 / pp;
                    g2 = -(betta + gamma * rr * ss3 / qq) * qq / (pp * ss1);

                    if (g2 > g1)
                        alfa = Math.random() * (g2 - g1) + g1;
                    else
                        flag = 1;
                    count++;
                } while (flag == 1 && count < 10);
            } else {
                do {
                    flag = 0;
                    gamma = Math.random();
                    betta = Math.random() * (1 + gamma * rr * ss3 / qq) - gamma * rr * ss3 / qq;

                    double g1, g2, g3;
                    g1 = -betta * qq * ss1 / pp - gamma * rr * ss2 / pp;
                    g2 = -(betta + gamma * rr * ss3 / qq) * qq / (pp * ss1);
                    g3 = (-gamma - betta * qq * ss3 / rr) * rr / (pp * ss2);

                    if (g2 > g1 && g2 > g3) {
                        if (g3 > g1)
                            alfa = Math.random() * (g2 - g3) + g3;
                        else
                            alfa = Math.random() * (g2 - g1) + g1;
                    } else
                        flag = 1;
                    count++;
                } while (flag == 1 && count < 10);
            }
        } else if (ss3 > 0) {
            do {
                flag = 0;
                gamma = Math.random();
                betta = Math.random();

                double g1, g2, g3;
                g1 = -betta * qq * ss1 / pp - gamma * rr * ss2 / pp;
                g2 = -(betta + gamma * rr * ss3 / qq) * qq / (pp * ss1);
                g3 = -(gamma + betta * qq * ss3 / rr) * rr / (pp * ss2);

                if (g2 > g1 && g3 > g1) {
                    if (g3 > g2)
                        alfa = Math.random() * (g2 - g1) + g1;
                    else
                        alfa = Math.random() * (g3 - g1) + g1;
                } else
                    flag = 1;
                count++;
            } while (flag == 1 && count < 10);
        } else {
            do {
                flag = 0;
                betta = Math.random();
                gamma = (Math.random() * (-1.0 / ss3 + ss3) - ss3) * betta * qq / rr;

                double g1, g2, g3;
                g1 = -betta * qq * ss1 / pp - gamma * rr * ss2 / pp;
                g2 = -(betta + gamma * rr * ss3 / qq) * qq / (pp * ss1);
                g3 = -(gamma + betta * qq * ss3 / rr) * rr / (pp * ss2);

                if (g2 > g1 && g3 > g1) {
                    if (g3 > g2)
                        alfa = Math.random() * (g2 - g1) + g1;
                    else
                        alfa = Math.random() * (g3 - g1) + g1;
                } else
                    flag = 1;
                count++;
            } while (flag == 1 && count < 10);
        }

        if (flag == 0)
            for (int i = 0; i < 3; i++)
                point[i + (mout - 1) * 3 + vv] = alfa * p[i] + betta * q[i] + gamma * r[i];

        System.out.println("step8  " + count);
        return flag;
    }
    protected double vec_pr(double[] v1, double[] v2, double[] res) {
        res[0] = v1[1] * v2[2] - v1[2] * v2[1];
        res[1] = v1[2] * v2[0] - v1[0] * v2[2];
        res[2] = v1[0] * v2[1] - v1[1] * v2[0];

        return (double) (Math.sqrt(Svec(res, res)));
    }
    protected double kiral(double[] point, int v1, int v2, int v3, int vv) {
        v1 = (v1 - 1) * 3;
        v2 = (v2 - 1) * 3;
        v3 = (v3 - 1) * 3;
        return (double) (point[v3 + vv] * (point[v1 + 1 + vv] * point[v2 + 2 + vv] - point[v1 + 2 + vv] * point[v2 + 1 + vv]) + point[v3 + 1 + vv] * (point[v1 + 2 + vv] * point[v2 + vv] - point[v1 + vv] * point[v2 + 2 + vv]) + point[v3 + 2 + vv] * (point[v1 + vv] * point[v2 + 1 + vv] - point[v1 + 1 + vv] * point[v2 + vv]));
    }

    protected void test_kiral(double []point, double[] msign, int vv) {
        msign[0] = kiral(point,1, 2, 3, vv);
        msign[1] = kiral(point,1, 4, 7, vv);
        msign[2] = kiral(point,1, 6, 5, vv);
        msign[3] = kiral(point,2, 4, 6, vv);
        msign[4] = kiral(point,2, 5, 7, vv);
        msign[5] = kiral(point,3, 4, 5, vv);
        msign[6] = kiral(point,3, 7, 6, vv);
        msign[7] = kiral(point,4, 5, 8, vv);
        msign[8] = kiral(point,6, 7, 8, vv);
    }

    public double kiral_vec(double[] vec1, double[] vec2, double[] vec3) {
        return (double) (vec3[0] * (vec1[1] * vec2[2] - vec1[2] * vec2[1]) + vec3[1] * (vec1[2] * vec2[0] - vec1[0] * vec2[2]) + vec3[2] * (vec1[0] * vec2[1] - vec1[1] * vec2[0]));
    }

    public void kiral_func(double [] point,double sh) {
        double[] msign = new double[9];
        test_kiral(point,msign, 0);

        double vec1[] = {0.5 * (point[6] + mk3 * point[21]), 0.5 * (point[7] + mk3 * point[22]), 0.5 * (point[8] + mk3 * point[23])};
        double vec2[] = {point[9], point[10], point[11]};
        double vec3[] = {point[12], point[13], point[14]};

        msign[5] = kiral_vec(vec1, vec2, vec3);

        for (int i = 0; i < 3; i++) {
            vec1[i] = 0.5 * (point[6 + i] - mk3 * point[21 + i]);
            vec2[i] = point[18 + i];
            vec3[i] = point[15 + i];
        }
        msign[6] = kiral_vec(vec1, vec2, vec3);

        int flag = 0;
        //String[] st = {"123", "147", "165", "246", "257", "345", "376", "458", "678"};
        String[] st = {"123", "147", "165", "246", "257", "v+45", "v-76"};
        /*
        for (int i = 0; i < 7; i++)
            if (msign[i] < 0) {
                System.out.print(st[i] + "   ");
                flag = 1;
            }

        if (flag == 1) {
            System.out.println();
            for (int j = 24; j < 48; j++)
                point[j] *= -1;
            System.out.println("time " + Math.round(sh * 100000) / 100000.0);
        }
        */
    }

}
