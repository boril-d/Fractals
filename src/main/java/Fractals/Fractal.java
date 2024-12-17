/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

import java.awt.image.BufferedImage;
import static java.lang.Math.abs;

/**
 *
 * @author Gate
 */
public class Fractal {
    private FractalOptions options;
   
   public FractalOptions getOptions (){
       return options;
   }
   public void setOptions(FractalOptions options) throws IllegalArgumentException{
       if (options == null) {
           throw new IllegalArgumentException("Options was null!");
       }
       else {
           this.options = options;
       }
   }

   public BufferedImage getFractalImage (ComplexNum a, ComplexNum b, int width, int height){
       return null;
   }
   
    public int getColor(double bound, int precision, int power, ComplexNum c, ComplexNum z0) {
        
        ComplexNum z = new ComplexNum(z0);
        int iterations = 0;
        
        for (int i = 0; i < precision; i++) {
            
            if (abs(z.getX()) > bound && abs(z.getY()) > bound) {
                break;
            }
            else{
                z = ComplexNum.sum(ComplexNum.power(z, power), c);
                iterations++;
            } 
        }
        
        return (iterations/precision);
    }
}
