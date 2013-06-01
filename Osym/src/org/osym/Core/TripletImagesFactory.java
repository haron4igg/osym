package org.osym.Core;

import org.osym.Calculation.Functions;
import org.osym.Images.Image2D;
import org.osym.Images.ImageTools;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Copyright (c) 2013. Igor Reshetnikov. All rights reserved.
 */

public class TripletImagesFactory implements ImageFactory {

    /*


        vision.addItem("зависимость потенциала U12 от времени");
        vision.addItem("зависимость потенциала U13 от времени");
        vision.addItem("зависимость потенциала U21 от времени");
        vision.addItem("зависимость потенциала U22 от времени");
        vision.addItem("зависимость потенциала U23 от времени");
        vision.addItem("зависимость потенциала U31 от времени");
        vision.addItem("зависимость потенциала U32 от времени");
        vision.addItem("зависимость потенциала U33 от времени");
        vision.addItem("зависимость скорости потенциала U11 от времени");
        vision.addItem("зависимость скорости потенциала U12 от времени");
        vision.addItem("зависимость скорости потенциала U13 от времени");
        vision.addItem("зависимость скорости потенциала U21 от времени");
        vision.addItem("зависимость скорости потенциала U22 от времени");
        vision.addItem("зависимость скорости потенциала U23 от времени");
        vision.addItem("зависимость скорости потенциала U31 от времени");
        vision.addItem("зависимость скорости потенциала U32 от времени");
        vision.addItem("зависимость скорости потенциала U33 от времени");
        vision.addItem("фазовая траектория осциллятора для потенциала U11");
        vision.addItem("фазовая траектория осциллятора для потенциала U12");
        vision.addItem("фазовая траектория осциллятора для потенциала U13");
        vision.addItem("фазовая траектория осциллятора для потенциала U21");
        vision.addItem("фазовая траектория осциллятора для потенциала U22");
        vision.addItem("фазовая траектория осциллятора для потенциала U23");
        vision.addItem("фазовая траектория осциллятора для потенциала U31");
        vision.addItem("фазовая траектория осциллятора для потенциала U32");
        vision.addItem("фазовая траектория осциллятора для потенциала U33");
        vision.addItem("траектория осциллятора на плоскости {U11,U12,U13}");
        vision.addItem("траектория осциллятора на плоскости {U21,U22,U23}");
        vision.addItem("траектория осциллятора на плоскости {U31,U32,U33}");
        vision.addItem("траектория осциллятора на плоскости {U11,U21,U31}");
        vision.addItem("траектория осциллятора на плоскости {U12,U22,U32}");
        vision.addItem("траектория осциллятора на плоскости {U13,U23,U33}");
        vision.addItem("траектория осциллятора на плоскости {U1,U2,U3}");
        vision.addItem("неголономные связи");
        vision.addItem("локальные максимумы и минимумы");
        vision.addItem("локальные максимумы и минимумы для u1");
        vision.addItem("локальные максимумы и минимумы для u2");
        vision.addItem("локальные максимумы и минимумы для u3");
        vision.addItem("инверсия по z координате для {U11,U12,U13}");
        vision.addItem("инверсия по z координате для {U21,U22,U23}");
        vision.addItem("инверсия по z координате для {U31,U32,U33}");
        vision.addItem("инверсия по z координате для {U11,U21,U31}");
        vision.addItem("инверсия по z координате для {U12,U22,U32}");
        vision.addItem("инверсия по z координате для {U13,U23,U33}");
        vision.addItem("инверсия по z координате для {U1,U2,U3}");
        vision.addItem("лучики для {U11,U12,U13}");
        vision.addItem("лучики для {U21,U22,U23}");
        vision.addItem("лучики для {U31,U32,U33}");
        vision.addItem("лучики для {U11,U21,U31}");
        vision.addItem("лучики для {U12,U22,U32}");
        vision.addItem("лучики для {U13,U23,U33}");
        vision.addItem("лучики для {U1,U2,U3}");
     */

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

        images.add(new Image2D("Зависимость потенциала U33 от времени", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                //px = wndX(st, 49);
                int x = ImageTools.wndX(iteration, vector.length + 1, imagesWidth, scope);
                int y = ImageTools.wndY(vector[8], 8, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, true));

        images.add(new Image2D("Зависимость скорости потенциала U11 от времени", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                //px = wndX(st, 49);
                //py = wndY(input[9], 9);
                int x = ImageTools.wndX(iteration, vector.length + 1, imagesWidth, scope);
                int y = ImageTools.wndY(vector[9], 9, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, true));

        images.add(new Image2D("Фазовая траектория осциллятора для потенциала U11", imagesWidth, imagesHeight, dimension+1,dimension, new Image2D.PointTransformer() {
            @Override
            public Image2D.ImagePoint transform(double[] vector, double[][] scope, double iteration, Functions functions) {
                //px = wndX(st, 49);
                //py = wndY(input[9], 9);
                //pz = wndX(input[0], 0);
                int x = ImageTools.wndX(vector[0], 0, imagesWidth, scope);
                int y = ImageTools.wndY(vector[9], 9, imagesHeight, scope);
                return new Image2D.ImagePoint(x, y, new Color(0));
            }
        }, true));

        return images;
    }


}
