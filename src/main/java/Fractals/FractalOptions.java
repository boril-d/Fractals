/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileSystemException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author boril-d
 */
public class FractalOptions {
    public static final String[] DEFAULT_COLOR_ARR = {
        "#09012F",
        "#040449",
        "#000764",
        "#0C2C8A",
        "#1852B1",
        "#397DD1",
        "#86B5E5",
        "#D3ECF8",
        "#F1E9BF",
        "#F8C95F",
        "#FFAA00",
        "#CC8000",
        "#995700",
        "#6A3403",
        "#421E0F",
        "#19071A"
    };
    public static final Colormap DEFAULT_COLORMAP = new Colormap(DEFAULT_COLOR_ARR);
    public static final String FILE_DIR = "data\\";
    
    /**
     * @brief Unless the function exits these bounds, it is considered a part of
     * the fractal set.
     */
    private double bound;
    public static final double MIN_BOUND = 2.0;
    public static final double MAX_BOUND = 2.0;
    /**
     * @brief The number of iterations for each pixel.
     */
    private int precision;
    public static final int MIN_PRECISION = 10;
    public static final int MAX_PRECISION = 100;
    /**
     * @brief The colormap used for coloring the fractal.
     */
    private Colormap colormap;
    public static final String[] RANDOM_COLOR_ARR = {
        "#FF0000",
        "#FF6A00",
        "#FFD800",
        "#B6FF00",
        "#26FF10",
        "#00FF90",
        "#00FFFF",
        "#0094FF",
        "#0026FF",
        "#4800FF",
        "#B200FF",
        "#FF00DC"
    };
    
    /*
     * All of the following fields are parts of the formula:
     * z(0) = z0;
     * z(i) = ComplexNum.sum( ComplexNum.power(z(i - 1), power), c );
     */
    
    private int power;
    private static final int MIN_POWER = 2;
    private static final int MAX_POWER = 7;
    private ComplexNum c;
    private static final ComplexNum MIN_C = new ComplexNum(-1, -1);
    private static final ComplexNum MAX_C = new ComplexNum( 1,  1);
    private ComplexNum z0;
    private static final ComplexNum MIN_Z0 = new ComplexNum(-1, -1);
    private static final ComplexNum MAX_Z0 = new ComplexNum( 1,  1);

    public double getBound() {
        return bound;
    }
    public void setBound(double bound) throws IllegalArgumentException {
        if (bound < MIN_BOUND || MAX_BOUND < bound) {
            throw new IllegalArgumentException("`bound` value out of range");
        }
        this.bound = bound;
    }

    public int getPrecision() {
        return precision;
    }
    public void setPrecision(int precision) throws IllegalArgumentException {
        if (precision < MIN_PRECISION || MAX_PRECISION < precision) {
            throw new IllegalArgumentException("`precision` value out of range");
        }
        this.precision = precision;
    }

    public Colormap getColormap() {
        return colormap;
    }
    public void setColormap(Colormap colormap) throws IllegalArgumentException {
        if (colormap == null) {
            throw new IllegalArgumentException("`colormap` was null");
        }
        if (colormap.colorsCount() <= 1) {
            throw new IllegalArgumentException("`colormap.colorsCount()` must be > 1");
        }
        this.colormap = colormap;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) throws IllegalArgumentException {
        if (power == -1 || power == 0 || power == 1) {
            throw new IllegalArgumentException(
                    "`power` must NOT be -1, 0 or 1"
            );
        }
        if (power < MIN_POWER || MAX_POWER < power) {
            throw new IllegalArgumentException("`power` value out of range");
        }
        this.power = power;
    }

    public ComplexNum getC() {
        return c;
    }
    public void setC(ComplexNum c) throws IllegalArgumentException {
        if (c == null) {
            throw new IllegalArgumentException("`c` was null");
        }
        if (c.getX() < MIN_C.getX() || MAX_C.getX() < c.getX() || 
            c.getY() < MIN_C.getY() || MAX_C.getY() < c.getY()) {
            
            throw new IllegalArgumentException("`c` value out of range");
        }
        this.c = c;
    }

    public ComplexNum getZ0() {
        return z0;
    }
    public void setZ0(ComplexNum z0) throws IllegalArgumentException {
        if (z0 == null) {
            throw new IllegalArgumentException("`z0` was null");
        }
        if (z0.getX() < MIN_Z0.getX() || MAX_Z0.getX() < z0.getX() || 
            z0.getY() < MIN_Z0.getY() || MAX_Z0.getY() < z0.getY()) {
            
            throw new IllegalArgumentException("`z0` value out of range");
        }

        this.z0 = z0;
    }
    
    public FractalOptions() {
        bound = 2.0;
        precision = 50;
        colormap = new Colormap(DEFAULT_COLORMAP);
        power = 2;
        c = new ComplexNum(0.0, 0.0);
        z0 = new ComplexNum(0.0, 0.0);
    }
    public FractalOptions(double bound, int precision, Colormap clrmap, int power, ComplexNum c, ComplexNum z0) throws IllegalArgumentException {
       set(bound, precision, clrmap, power, c, z0);
    }
    public FractalOptions(FractalOptions other) {
        bound = other.bound;
        precision = other.precision;
        colormap = new Colormap(other.colormap);
        power = other.power;
        c = new ComplexNum(other.c);
        z0 = new ComplexNum(other.z0);
    }
    
    public void set() {
        bound = 2.0;
        precision = 50;
        colormap.set(DEFAULT_COLORMAP);
        power = 2;
        c.set(0.0, 0.0);
        z0.set(0.0, 0.0);
    }
    public void set(double bound, int precision, Colormap clrmap, int power, ComplexNum c, ComplexNum z0) throws IllegalArgumentException {
        setBound(bound);
        setPrecision(precision);
        setColormap(colormap);
        setPower(power);
        setC(c);
        setZ0(z0);
    }
    public void set(FractalOptions other) {
        bound = other.bound;
        precision = other.precision;
        colormap.set(other.colormap);
        power = other.power;
        c.set(other.c);
        z0.set(other.z0);
    }
    
    public void save(File file) throws FileSystemException, FileNotFoundException, IOException {
        if (file.exists()) {
            if (!file.delete()) {
                throw new FileSystemException("File deletion failed");
            }
        }
        if (!file.createNewFile()) {
            throw new FileSystemException("File creation failed");
        }
        PrintStream fout = new PrintStream(file);
        try {
            printBound(fout);
            printPrecision(fout);
            printColormap(fout);
            printPower(fout);
            printC(fout);
            printZ0(fout);
        } catch (Exception err) {
            throw err;
        } finally {
            fout.close();
        }
    }
    public void load(File file) throws FileNotFoundException, NumberFormatException, IllegalArgumentException {
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        Scanner fin = new Scanner(file);
        try {
            parseBound(fin);
            parsePrecision(fin);
            parseColormap(fin);
            parsePower(fin);
            parseC(fin);
            parseZ0(fin);
        } catch (Exception err) {
            throw err;
        } finally {            
            fin.close();
        }
    }
    
    public void randomize() {
        Random rng = new Random();
        randomizeBound(rng);
        randomizePrecision(rng);
        randomizeColormap(rng);
        randomizePower(rng);
        randomizeC(rng);
        randomizeZ0(rng);
    }
    
    @Override
    public String toString() {
        return String.format(
                "bound: %s precision: %d colormap: {%s} power: %d c: {%s} z(0): {%s}",
                Double.toString(bound), precision, colormap.toString(), power, c.toString(), z0.toString()
        );
    }
    
    // ctrl+shift+minus
    //<editor-fold defaultstate="collapsed" desc="helper functions">
    
    private void parseBound(Scanner in) throws NumberFormatException, IllegalArgumentException {
        in.nextLine(); // the comment describing it
        String line = in.nextLine();
        double val = Double.parseDouble(line);
        setBound(val);
    }
    private void parsePrecision(Scanner in) throws NumberFormatException, IllegalArgumentException {
        in.nextLine(); // the comment describing it
        String line = in.nextLine();
        int val = Integer.parseInt(line);
        setPrecision(val);
    }
    private void parseColormap(Scanner in) throws NumberFormatException, IllegalArgumentException {
        in.nextLine(); // the comment describing it
        String line = in.nextLine();
        String[] val = line.split(" ");
        setColormap(new Colormap(val));
    }
    private void parsePower(Scanner in) throws NumberFormatException, IllegalArgumentException {
        in.nextLine(); // the comment describing it
        String line = in.nextLine();
        int val = Integer.parseInt(line);
        setPower(val);
    }
    private void parseC(Scanner in) throws NumberFormatException, IllegalArgumentException {
        in.nextLine(); // the comment describing it
        String line = in.nextLine();
        String[] val = line.split(" ");
        if (val.length < 2) {
            throw new NumberFormatException(
                    "There must be at least 2 numbers to parse a complex num."
            );
        }
        double real = Double.parseDouble(val[0]);
        double imag = Double.parseDouble(val[0]);
        setC(new ComplexNum(real, imag));
    }
    private void parseZ0(Scanner in) throws NumberFormatException, IllegalArgumentException {
        in.nextLine(); // the comment describing it
        String line = in.nextLine();
        String[] val = line.split(" ");
        if (val.length < 2) {
            throw new NumberFormatException(
                    "There must be at least 2 numbers to parse a complex num."
            );
        }
        double real = Double.parseDouble(val[0]);
        double imag = Double.parseDouble(val[0]);
        setZ0(new ComplexNum(real, imag));
    }
    
    private void printBound(PrintStream out) {
        out.println("Bound:");
        out.println(getBound());
    }
    private void printPrecision(PrintStream out) {
        out.println("Precision (max iterations):");
        out.println(getPrecision());
    }
    private void printColormap(PrintStream out) {
        out.println("Colormap:");
        out.println(getColormap());
    }
    
    private void printPower(PrintStream out) {
        out.println("Power:");
        out.println(getPower());
    }
    private void printC(PrintStream out) {
        out.println("c:");
        out.println(getC());
    }
    private void printZ0(PrintStream out) {
        out.println("z(0):");
        out.println(getZ0());
    }
    
    private void randomizeBound(Random rng) {
        bound = MIN_BOUND + (MAX_BOUND - MIN_BOUND) * rng.nextDouble();
    }
    private void randomizePrecision(Random rng) {
        precision = rng.nextInt(MAX_PRECISION - MIN_PRECISION + 1) + MIN_PRECISION;
    }
    private void randomizeColormap(Random rng) {
        int index1 = rng.nextInt(RANDOM_COLOR_ARR.length);
        int index2 = rng.nextInt(RANDOM_COLOR_ARR.length - 1);
        
        // ensure the same color is not picked
        if (index2 >= index1) {
            index2++;
        }
        
        String[] colorArr = {
            RANDOM_COLOR_ARR[index1],
            RANDOM_COLOR_ARR[index2]
        };
        colormap.set(colorArr);
    }
    private void randomizePower(Random rng) {
        power = rng.nextInt(MAX_POWER - MIN_POWER + 1) + MIN_POWER;
    }
    private void randomizeC(Random rng) {
        double x = MIN_C.getX() + (MAX_C.getX() - MIN_C.getX()) * rng.nextDouble();
        double y = MIN_C.getY() + (MAX_C.getY() - MIN_C.getY()) * rng.nextDouble();
        c.setX(x);
        c.setY(y);
    }
    private void randomizeZ0(Random rng) {
        double x = MIN_Z0.getX() + (MAX_Z0.getX() - MIN_Z0.getX()) * rng.nextDouble();
        double y = MIN_Z0.getY() + (MAX_Z0.getY() - MIN_Z0.getY()) * rng.nextDouble();
        z0.setX(x);
        z0.setY(y);
    }
    
    //</editor-fold>
}
