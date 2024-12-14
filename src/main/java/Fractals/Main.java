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
    public static FractalOptions makeIrregularOptions() {
        FractalOptions result = new FractalOptions();
        result.setBound(1);
        result.setPrecision(2);
        String[] colorArr = { "#ff0000", "#00Ff00" };
        result.setColormap(new Colormap(colorArr));
        result.setPower(3);
        result.setC(new ComplexNum(4, 5));
        result.setZ0(new ComplexNum(6, 7));
        return result;
    }
    public static FractalOptions makeNormalOptions() {
        return new FractalOptions();
    }

    public static void main(String[] args) {
        FractalOptions opts = makeIrregularOptions();
        try {
            opts.load("hello.txt");
            opts.setBound(5);
            opts.save("hello.txt");
        } catch (Exception err) {
            System.out.println("There is an exception... somewhere...");
            System.out.println(err.getMessage());
        }
        System.out.println(opts);
    }
}
