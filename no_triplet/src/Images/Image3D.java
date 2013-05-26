package Images;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 03.03.12
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
public class Image3D extends AbstractImage {

    protected BufferedImage image = null;
    protected Graphics graphics = null;

    public Image3D(String name, int width, int heigth) {
        super(name, width, heigth);
        image = new BufferedImage(myWidth, myHeight, BufferedImage.TYPE_USHORT_GRAY);
        graphics = image.getGraphics();
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    public void paintPixel(int x, int y, int z, int r, int g, int b) {

        /*
        int px, py, x1, y1, num1;

        px = wndXYAll(x + z * Math.cos(angle), in);
        py = wndYAll(y + z * Math.sin(angle), in);

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
        */

        graphics.setColor(new Color(r,g,b));
        graphics.drawOval(x,y,2,2);
    }
}
