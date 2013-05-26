package org.osym.Gui;

import org.osym.Images.Image2D;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 09.04.12
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
public class ImagePanel extends JPanel {

    protected Image2D imageToDisplay = null;


    public Image2D getImageToDisplay() {
        return imageToDisplay;
    }

    public void setImageToDisplay(Image2D imageToDisplay) {
        synchronized (this) {
            if (this.imageToDisplay != null) {
                this.imageToDisplay.linkGraphics(null);
            }
            this.imageToDisplay = imageToDisplay;
        }
    }

    public ImagePanel(Image2D imageToDisplay) {
        this.imageToDisplay = imageToDisplay;
    }

    public void clearUI() {
        if (this.imageToDisplay != null) {
            this.imageToDisplay.clearImage();
        } else {
            updateUI();
        }
    }

    @Override
    public void paint(Graphics graphics) {

        super.paint(graphics);
        Image2D image = null;

        synchronized (this) {
            image = imageToDisplay;
        }

        if (image != null) {
            if (image.getLinkedGraphics() != this.getGraphics()) {
                image.linkGraphics(this.getGraphics());
            }
            image.draw(graphics, 0, 0);
        } else {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        }


    }
}
