/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Fractals;

/**
 *
 * @author borilad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var c = new ComplexNum(1, 2);
        System.out.println(c);
        System.out.println(c.getX());
        System.out.println(c.getY());
        c.setX(3);
        c.setY(4);
        System.out.println(c);
        System.out.println(c.getX());
        System.out.println(c.getY());
        
        var c2 = new ComplexNum();
        System.out.println(c2);
        System.out.println(c2.getX());
        System.out.println(c2.getY());
        
        var c3 = new ComplexNum(c);
        System.out.println(c2);
        System.out.println(c2.getX());
        System.out.println(c2.getY());
        
        var c4 = ComplexNum.sum(c, c);
        var c5 = ComplexNum.product(c, new ComplexNum(2, 0));
        System.out.println(c4);
        System.out.println(c5);
        var c6 = ComplexNum.product(new ComplexNum(1, 2), new ComplexNum(3, 4));
        System.out.println(c6);
        System.out.println(ComplexNum.reciprocal(c6));
        System.out.println(ComplexNum.power(c6, -1));
        System.out.println(ComplexNum.power(c6, 2));
        System.out.println(ComplexNum.power(c6, -2));
        
        System.out.println(FractalOptions.DEFAULT_OPTIONS);
        FractalOptions opts = new FractalOptions(FractalOptions.DEFAULT_OPTIONS);
        System.out.println(opts);
        opts.setBound(1);
        opts.setPrecision(2);
        opts.setColormap(new Colormap(FractalOptions.DEFAULT_COLORMAP));
        opts.setPower(4);
        opts.setC(new ComplexNum(5, 6));
        opts.setZ0(new ComplexNum(7, 8));
        System.out.println(opts);
    }

}
