package org.osym.Images;

import org.osym.Calculation.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 18.02.12
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
public class Image2D extends AbstractImage {

    public static class ImagePoint extends Point {
        Color color;

        public ImagePoint(int x, int y, Color color) {
            super(x,y);
            this.color = color;
        }
    }

    public interface PointTransformer {
        public ImagePoint transform(double [] vector, double [][] scope, double iteration, Functions functions);
    }

    protected PointTransformer transformer = null;
    protected BufferedImage image = null;
    protected Graphics graphics = null;

    protected int imageMas[][] = null;

    protected double[][] scope = null;

    protected int xScope = 0;
    protected int yScope = 0;

    protected static final int xOffset = 40;
    protected static final int yOffset = 40;
    protected static final int padding = 3;

    boolean requireScope;

    public boolean isRequireScope() {
        return requireScope;
    }

    public void setRequireScope(boolean requireScope) {
        this.requireScope = requireScope;
    }

    public int getxScope() {
        return xScope;
    }

    public int getyScope() {
        return yScope;
    }

    public double[][] getScope() {
        return scope;
    }

    public void setScope(double[][] scope) {
        this.scope = scope;
        if (graphics != null) {
            draw(graphics, 0, 0);
        }
    }

    public Image2D(String name, int width, int height, int scopeX, int scopeY, PointTransformer transformer, boolean isRequireScope) {
        super(name, width, height);

        this.transformer = transformer;

        requireScope = isRequireScope;

        xScope = scopeX;
        yScope = scopeY;


        imageMas = new int[height + 1][width + 1];

        clearImage();

    }

    public void clearImage() {

        if (graphics != null) {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, myWidth + xOffset, myHeight + yOffset);
        }
        for (int i = 0; i < myHeight + 1; i++) {
            for (int j = 0; j < myWidth + 1; j++) {
                imageMas[i][j] = -1;
            }
        }
    }

    public void linkGraphics(Graphics graph) {
        graphics = graph;
    }

    public Graphics getLinkedGraphics() {
        return graphics;
    }

    public void drawScopeLines(Graphics g, int x, int y) {

        g.setColor(Color.BLACK);
        g.drawRect(x + xOffset, y + yOffset, myWidth, myHeight);

        if (scope == null) return;

        double minX = scope[0][0];
        double maxX = scope[0][1];
        double minY = scope[1][0];
        double maxY = scope[1][1];


        int rline = 20;

        double sX = (maxX - minX) / rline;

        for (double xx = minX; xx < maxX; xx += sX) {

            int rX = ImageTools.wndX(xx, myWidth, new double[]{minX, maxX}) + xOffset;

            g.drawLine(rX, myHeight + yOffset, rX, myHeight + yOffset+padding);
            g.drawLine(rX, yOffset, rX, yOffset - padding);

            String string = "" + xx;

            Rectangle2D rect = g.getFontMetrics().getStringBounds(string, g);

            g.drawString(string, (int) (rX - rect.getCenterX()), (int) ((myHeight + yOffset+padding*2) + rect.getHeight()));
            g.drawString(string, (int) (rX - rect.getWidth() / 2), yOffset-padding*2);
        }

        double sY = Math.abs(Math.abs(maxY) - Math.abs(minY)) / rline;

        for (double yy = minY; yy < maxY; yy += sY) {

            int rY = ImageTools.wndY(yy, myHeight, new double[]{minY, maxY}) + yOffset;

            g.drawLine(xOffset, rY, xOffset-padding, rY);
            g.drawLine(xOffset+myWidth, rY, xOffset+myWidth+padding, rY);

            String string = String.format("%.0f",yy);

            Rectangle2D rect = g.getFontMetrics().getStringBounds(string, g);

            g.drawString(string, (int) (xOffset + padding*2 + myWidth), (int) (rY-rect.getCenterY()));
            g.drawString(string, (int) (xOffset - (rect.getWidth()+padding*2)), (int) (rY-rect.getCenterY()));
        }
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, myWidth + xOffset*2, myHeight + yOffset*2);
        drawScopeLines(g, x, y);

        for (int i = 0; i < myHeight + 1; i++) {
            for (int j = 0; j < myWidth + 1; j++) {

                if (imageMas[i][j] != -1) {
                    g.setColor(new Color(imageMas[i][j]));
                    g.drawOval(j + xOffset, i + yOffset, 1, 1);
                }
            }
        }
    }

    public void paintPixel(final int x, final int y, Color color) {
        if (x >= 0 && x <= myWidth && y >= 0 && y <= myHeight) {
            if (imageMas[y][x] == -1) {
                imageMas[y][x] = color.getRGB();
                if (graphics != null) {
                    graphics.setColor(color);
                    graphics.drawOval(x + xOffset, y + yOffset, 1, 1);
                }
            }
        }
    }

    public void paintPixel(final int x, final int y, final short color) {
        paintPixel(x,y, new Color(color));
    }

    public void paintVector(double [] input, double [][] scoupe, double interaction, Functions functionsManager) {
        ImagePoint point = transformer.transform(input, scoupe, interaction, functionsManager);
        paintPixel(point.x, point.y, point.color);
    }
}
