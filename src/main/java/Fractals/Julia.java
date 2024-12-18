/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

import java.awt.image.BufferedImage;

/**
 *
 * @author borilad
 */
public class Julia extends Fractal {
    public BufferedImage getFractalImage(ComplexNum bound1, ComplexNum bound2, int width, int height) {
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        double left;
        double right;
        double up;
        double down;
        if (bound1.getX() < bound2.getX()) {
            left = (bound1.getX());
            right = (bound2.getX());
        } else {
            left = (bound2.getX());
            right = (bound1.getX());
        }
        if (bound1.getY() < bound2.getY()) {
            down = (bound1.getY());
            up = (bound2.getY());
        } else {
            down = (bound2.getY());
            up = (bound1.getY());
        }
        
        ComplexNum currCoord = new ComplexNum();
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                currCoord.setX((double)(x) / width * (right - left) + left);
                currCoord.setY((double)(y) / height * (up - down) + down);
                getOptions().getZ0().setX(currCoord.getX());
                getOptions().getZ0().setY(currCoord.getY());
                result.setRGB(x, height - y - 1, getColor());
            }
        }
        
        return result;
    }
}
