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
public class Mandelbrot extends Fractal {
    public Mandelbrot() {
        super();
    }
    public Mandelbrot(FractalOptions options) {
        super(options);
    }
    public Mandelbrot(Mandelbrot other) {
        super(other);
    }
    
    public BufferedImage getFractalImage(int width, int height) {
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                
        double left = getOptions().getLeftBorder();
        double right = getOptions().getRightBorder();
        double down = getOptions().getDownBorder();
        double up = getOptions().getUpBorder();
        
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getOptions().setC(screenToFractalCoords(x, y, width, height, left, right, down, up));
                result.setRGB(x, y, getColor(getOptions()));
            }
        }
        
        return result;
    }
}
