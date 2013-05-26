package Images;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 18.02.12
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
public class Image2D extends AbstractImage {

    protected BufferedImage image = null;
    protected Graphics graphics = null;

    public Image2D(String name, int width, int heigth) {
        super(name, width, heigth);
        image = new BufferedImage(myWidth, myHeight, BufferedImage.TYPE_USHORT_GRAY);
        graphics = image.getGraphics();
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    public void paintPixel(int x, int y, int color) {
        graphics.setColor(new Color(color,color,color));
        graphics.drawOval(x,y,2,2);
    }

}
