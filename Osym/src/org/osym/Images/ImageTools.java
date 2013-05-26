package org.osym.Images;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 03.03.12
 * Time: 20:55
 * To change this template use File | Settings | File Templates.
 */
public class ImageTools {

    static public int wndYAll(double y, int index, int sizeY, double[][] scope3d) {
        return (int) (sizeY - (y - scope3d[index][2]) * 1.0 / (scope3d[index][3] - scope3d[index][2]) * sizeY);
    }

    static public int wndXYAll(double x, int index, int sizeX, int sizeY, double[][] scope3d) {
        return (int) ((x - scope3d[index][0]) * 1.0 / (scope3d[index][1] - scope3d[index][0]) * sizeY);
    }

    static public int wndX(double x, int sizeX, double[] scopeX) {
        return (int) ((x - scopeX[0]) * 1.0 / (scopeX[1] - scopeX[0]) * sizeX);
    }

    static public int wndY(double y, int sizeY, double[] scopeY) {
        return (int) (sizeY - (y - scopeY[0]) * 1.0 / (scopeY[1] - scopeY[0]) * sizeY);
    }


    static public int wndX(double x, int index, int sizeX, double [][] scope) {
        return (int) ((x - scope[index][0]) * 1.0 / (scope[index][1] - scope[index][0]) * sizeX);
    }

    static public int wndY(double y, int index, int sizeY, double [][] scope) {
        return (int) (sizeY - (y - scope[index][0]) * 1.0 / (scope[index][1] - scope[index][0]) * sizeY);
    }

    static public int slow_ravnomer(int nk, double m1, double m2, double m3, double delta) {
        //для равномерного случая
        double p = Math.sqrt(m1 * m1 + m2 * m2 + m3 * m3);
        int ps = nk - (int) (p / delta);

        if (ps > 0)
            return ps;
        return 1;

    }
    /*
    static public void my3D(double xx, double yy, double zz, int in, int[][] mas, double[] delta, double alpha) {
        int px, py, x1, y1, num1;

        px = wndXYAll(xx + zz * Math.cos(alpha), in);
        py = wndYAll(yy + zz * Math.sin(alpha), in);

        num1 = slow_ravnomer(25, xx, yy, zz, delta[in]);

        x1 = px - wndXMin + 10;
        y1 = py - wndYMin + 10;

        if (x1 > -1 && x1 < 420 && y1 > -1 && y1 < 420) {
            if (mas[x1][y1] == 102) {
                if (420 - x1 == y1) {
                    if (yy > 0)
                        mas[x1][y1] = num1;
                } else if (zz < 0)
                    mas[x1][y1] = num1;
            } else {
                if (num1 < mas[x1][y1] && zz < 0)
                    mas[x1][y1] = num1;
                else if ((num1 > mas[x1][y1] || mas[x1][y1] == 100) && zz > 0)
                    mas[x1][y1] = num1;
            }
        }
    }
    */
}
