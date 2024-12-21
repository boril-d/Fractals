/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

import java.awt.image.BufferedImage;

/**
 *
 * @author bilyana-kr 
 */
public class Fractal { 
    private FractalOptions options;
   
    public FractalOptions getOptions() {
        return options;
    }
    public void setOptions(FractalOptions options) throws IllegalArgumentException {
        if (options == null) {
            throw new IllegalArgumentException("Options was null!");
        }
        else {
            this.options = options;
        }
    }
    
    public Fractal() {
        options = new FractalOptions();
    }
    public Fractal(FractalOptions options) {
        set(options);
    }
    public Fractal(Fractal other) {
        this.options = new FractalOptions(other.options);
    }
    
    public void set() {
        options.set();
    }
    public void set(FractalOptions options) {
        this.options = options;
    }
    public void set(Fractal other) {
        this.options.set(other.options);
    }

    public BufferedImage getFractalImage(int width, int height) {
        return null;
    }
    
    public static ComplexNum screenToFractalCoords(int x, int y, int w, int h, double left, double right, double down, double up) {
        ComplexNum result = new ComplexNum();
        
        result.setX( (double)(x) / w * (right - left) + left );
        result.setY( (double)(h - y - 1) / h * (up - down) + down );
        
        return result;
    }
   
    public int getColor(FractalOptions options) {
        
        ComplexNum z = new ComplexNum(options.getZ0());
        int iterations = 0;
        
        for (int i = 0; i < options.getPrecision(); i++) {
            
            if (z.getX() * z.getX() + z.getY() * z.getY() > options.getBound() * options.getBound()) {
                break;
            }
            else {
                z = ComplexNum.sum(ComplexNum.power(z, options.getPower()), options.getC());
                iterations++;
            } 
        }
        
        return options.getColormap().getColor((double)(iterations)/options.getPrecision());
    }
}
