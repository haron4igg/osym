package org.osym.Core;

import org.osym.Calculation.Functions;
import org.osym.Images.Image2D;
import org.osym.Images.ImageTools;

import java.awt.*;
import java.util.ArrayList;

/**
 * Copyright (c) 2013. Igor Reshetnikov. All rights reserved.
 */

public class OctupletImagesFactory implements ImageFactory {

    public ArrayList<Image2D> initializeImages(final int imagesWidth, final int imagesHeight, final int dimension) {

        ArrayList<Image2D> images = new ArrayList<Image2D>();

        images.add(new Image2D("Вычислительная погрешность", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                int x = ImageTools.wndX(iteration, vector.length + 1, imagesWidth, scope);
                int y = ImageTools.wndY(functions.EUK(vector), vector.length, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, false));

        images.add(new Image2D("Зависимость потенциала U11 от времени", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                //px = wndX(st, 49);
                int x = ImageTools.wndX(iteration, vector.length + 1, imagesWidth, scope);
                int y = ImageTools.wndY(vector[0], 0, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, true));

        images.add(new Image2D("Зависимость скорости потенциала U11 от времени", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                int x = ImageTools.wndX(iteration, vector.length + 1, imagesWidth, scope);
                int y = ImageTools.wndY(vector[24], 24, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, true));

        images.add(new Image2D("Фазовая траектория осциллятора для потенциала U11", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                int x = ImageTools.wndX(vector[0], 0, imagesWidth, scope);
                int y = ImageTools.wndY(vector[24], 24, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, true));

        images.add(new Image2D("Траектория осциллятора на плоскости {3678}", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                int x = ImageTools.wndX(vector[0], 0, imagesWidth, scope);
                int y = ImageTools.wndY(vector[24], 24, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, true));

        return images;
    }

}
