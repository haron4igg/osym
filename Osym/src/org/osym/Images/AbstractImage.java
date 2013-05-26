package org.osym.Images;

import sun.rmi.server.InactiveGroupException;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: Haron
 * Date: 18.02.12
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
public class AbstractImage {

    protected String myName = "";
    protected int myWidth = 0;
    protected int myHeight = 0;

    AbstractImage(String name, int width, int heigth) {
        myName = name;
        myWidth = width;
        myHeight = heigth;
    }

    public String getMyName() {
        return myName;
    }

    public void draw(Graphics g, int x, int y) {

    }

    public void writeOnDisk(String path) {

    }

}
