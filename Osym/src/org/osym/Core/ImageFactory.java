package org.osym.Core;

import org.osym.Images.Image2D;

import java.util.ArrayList;

/**
 * Copyright (c) 2013. Igor Reshetnikov. All rights reserved.
 */

public interface ImageFactory {

    public ArrayList<Image2D> initializeImages(final int imagesWidth, final int imagesHeight, final int dimension);

}
