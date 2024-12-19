/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

import java.awt.image.BufferedImage;
import static java.lang.Math.abs;

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

    public BufferedImage getFractalImage(ComplexNum bound1, ComplexNum bound2, int width, int height) {
        return null;
    }
   
    public int getColor() {
        
        ComplexNum z = new ComplexNum(options.getZ0());
        int iterations = 0;
        
        for (int i = 0; i < options.getPrecision(); i++) {
            
            if (abs(z.getX()) > options.getBound() || abs(z.getY()) > options.getBound()) {
                break;
            }
            else {
                z = ComplexNum.sum(ComplexNum.power(z, options.getPower()), options.getC());
                iterations++;
            } 
        }
        
        return options.getColormap().color((double)(iterations)/options.getPrecision());
    }
}
