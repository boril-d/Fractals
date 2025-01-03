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
        "#09012F", "#040449", "#000764", "#0C2C8A",
        "#1852B1", "#397DD1", "#86B5E5", "#D3ECF8",
        "#F1E9BF", "#F8C95F", "#FFAA00", "#CC8000",
        "#995700", "#6A3403", "#421E0F", "#19071A",
    };
    public static final String[] RANDOM_COLOR_ARR = {
        "#FF0000", "#FF6A00", "#FFD800", "#B6FF00",
        "#26FF10", "#00FF90", "#00FFFF", "#0094FF",
        "#0026FF", "#4800FF", "#B200FF", "#FF00DC"
    };
    public static final Colormap DEFAULT_COLORMAP = new Colormap(DEFAULT_COLOR_ARR);
    
    private double upBorder;
    private double downBorder;
    private double leftBorder;
    private double rightBorder;
    
    /**
     * @brief Unless the function exits these bounds, it is considered a part of
     * the fractal set.
     */
    private double bound;
    /**
     * @brief The number of iterations for each pixel.
     */
    private int precision;
    /**
     * @brief The colormap used for coloring the fractal.
     */
    private Colormap colormap;
    
    /*
     * All of the following fields are parts of the formula:
     * z(0) = z0;
     * z(i) = ComplexNum.sum( ComplexNum.power(z(i - 1), power), c );
     */
    
    private int power;
    private ComplexNum c;
    private ComplexNum z0;

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public double getUpBorder() {
        return upBorder;
    }
    public void setUpBorder(double upBorder) {
        this.upBorder = upBorder;
    }

    public double getDownBorder() {
        return downBorder;
    }
    public void setDownBorder(double downBorder) {
        this.downBorder = downBorder;
    }

    public double getLeftBorder() {
        return leftBorder;
    }
    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }
    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    public double getBound() {
        return bound;
    }
    public void setBound(double bound) throws IllegalArgumentException {
        ensureValidBound(bound);
        this.bound = bound;
    }

    public int getPrecision() {
        return precision;
    }
    public void setPrecision(int precision) throws IllegalArgumentException {
        ensureValidPrecision(precision);
        this.precision = precision;
    }

    public Colormap getColormap() {
        return colormap;
    }
    public void setColormap(Colormap colormap) throws IllegalArgumentException {
        ensureValidColormap(colormap);
        this.colormap = colormap;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) throws IllegalArgumentException {
        ensureValidPower(power);
        this.power = power;
    }

    public ComplexNum getC() {
        return c;
    }
    public void setC(ComplexNum c) throws IllegalArgumentException {
        //ensureValidC(c);
        this.c = c;
    }

    public ComplexNum getZ0() {
        return z0;
    }
    public void setZ0(ComplexNum z0) throws IllegalArgumentException {
        //ensureValidZ0(z0);
        this.z0 = z0;
    }
    //</editor-fold>
    
    public FractalOptions() {
        bound = 2.0;
        precision = 50;
        colormap = new Colormap(DEFAULT_COLORMAP);
        power = 2;
        c = new ComplexNum(0.4, 0.3);
        z0 = new ComplexNum(0.0, 0.0);
        defaultBorders();
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
        defaultBorders();
    }
    
    public void set() {
        bound = 2.0;
        precision = 50;
        colormap.set(DEFAULT_COLORMAP);
        power = 2;
        c.set(0.4, 0.3);
        z0.set(0.0, 0.0);
        defaultBorders();
    }
    public void set(double bound, int precision, Colormap clrmap, int power, ComplexNum c, ComplexNum z0) throws IllegalArgumentException {
        setBound(bound);
        setPrecision(precision);
        setColormap(colormap);
        setPower(power);
        setC(c);
        setZ0(z0);
        defaultBorders();
    }
    public void set(FractalOptions other) {
        bound = other.bound;
        precision = other.precision;
        colormap.set(other.colormap);
        power = other.power;
        c.set(other.c);
        z0.set(other.z0);
        defaultBorders();
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
        
        fout.println("bound:");
        fout.println(boundToString());
        fout.println("precision:");
        fout.println(precisionToString());
        fout.println("colormap:");
        fout.println(colormapToString());
        fout.println("power:");
        fout.println(powerToString());
        fout.println("c:");
        fout.println(cToString());
        fout.println("z(0):");
        fout.println(z0ToString());
        
        fout.close();
        
        defaultBorders();
    }
    public void load(File file) throws FileNotFoundException, NumberFormatException, IllegalArgumentException {
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist");
        }
        
        Scanner fin = new Scanner(file);
        try {
            fin.nextLine();
            boundFromString(fin.nextLine());
            fin.nextLine();
            precisionFromString(fin.nextLine());
            fin.nextLine();
            colormapFromString(fin.nextLine());
            fin.nextLine();
            powerFromString(fin.nextLine());
            fin.nextLine();
            cFromString(fin.nextLine());
            fin.nextLine();
            z0FromString(fin.nextLine());
        } catch (IllegalArgumentException err) {
            throw err;
        } finally {            
            fin.close();
            
            defaultBorders();
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
        
        defaultBorders();
    }
    
    @Override
    public String toString() {
        return String.format(
                "bound: %s precision: %d colormap: {%s} power: %d c: {%s} z(0): {%s}",
                Double.toString(bound), precision, colormap.toString(), power, c.toString(), z0.toString()
        );
    }
    
    //<editor-fold defaultstate="collapsed" desc="helper functions">
    
    public static void ensureValidBound(double bound) throws IllegalArgumentException {
        if (bound < 2.0 || 2.0 < bound) {
            throw new IllegalArgumentException("`bound` value out of range");
        }
    }
    public static void ensureValidPrecision(int precision) throws IllegalArgumentException {
        if (precision < 10 || 300 < precision) {
            throw new IllegalArgumentException("`precision` value out of range");
        }
    }
    public static void ensureValidColormap(Colormap colormap) throws IllegalArgumentException {
        if (colormap == null) {
            throw new IllegalArgumentException("`colormap` is null");
        }
    }
    public static void ensureValidPower(int power) throws IllegalArgumentException {
        if (power < -7 || 7 < power) {
            throw new IllegalArgumentException("`power` value out of range");
        }
        if (power == 0 || power == 1) {
            throw new IllegalArgumentException("`power` must not be 0 or 1 (I am sure you see why)");
        }
    }
    public static void ensureValidC(ComplexNum c) throws IllegalArgumentException {
        if (c == null) {
            throw new IllegalArgumentException("`c` is null");
        }
        if (c.getX() < -2 || 2 < c.getX() ||
            c.getY() < -2 || 2 < c.getY()) {
            
            throw new IllegalArgumentException("`c` value out of range");
        }
    }
    public static void ensureValidZ0(ComplexNum z0) throws IllegalArgumentException {
        if (z0 == null) {
            throw new IllegalArgumentException("`z0` is null");
        }
        if (z0.getX() < -2 || 2 < z0.getX() ||
            z0.getY() < -2 || 2 < z0.getY()) {
            
            throw new IllegalArgumentException("`z0` value out of range");
        }
    }
    
    public void boundFromString(String str) throws IllegalArgumentException {
        double bound;
        try {
            bound = Double.parseDouble(str);
            ensureValidBound(bound);
        } catch (NumberFormatException err) {
            throw new IllegalArgumentException("Error during parsing");
        }
        this.bound = bound;
    }
    public void precisionFromString(String str) throws IllegalArgumentException {
        int precision;
        try {
            precision = Integer.parseInt(str);
            ensureValidPrecision(precision);
        } catch (NumberFormatException err) {
            throw new IllegalArgumentException("Error during parsing");
        }
        this.precision = precision;
    }
    public void colormapFromString(String str) throws IllegalArgumentException {
        colormap.fromString(str);
        ensureValidColormap(colormap);
    }
    public void powerFromString(String str) throws IllegalArgumentException {
        int power;
        try {
            power = Integer.parseInt(str);
            ensureValidPower(power);
        } catch (NumberFormatException err) {
            throw new IllegalArgumentException("Error during parsing");
        }
        this.power = power;
    }
    public void cFromString(String str) throws IllegalArgumentException {
        ComplexNum c = new ComplexNum();
        c.fromString(str);
        ensureValidC(c);
        this.c = c;
    }
    public void z0FromString(String str) throws IllegalArgumentException {
        ComplexNum z0 = new ComplexNum();
        z0.fromString(str);
        ensureValidZ0(z0);
        this.z0 = z0;
    }
    
    public String boundToString() {
        return Double.toString(bound);
    }
    public String precisionToString() {
        return Integer.toString(precision);
    }
    public String colormapToString() {
        return colormap.toString();
    }
    public String powerToString() {
        return Integer.toString(power);
    }
    public String cToString() {
        return c.toString();
    }
    public String z0ToString() {
        return z0.toString();
    }
    
    public void defaultBorders() {
        upBorder = 2.0;
        downBorder = -2.0;
        leftBorder = -2.0;
        rightBorder = 2.0;
    }
    
    public void randomizeBound(Random rng) {
        bound = 2.0 + (2.0 - 2.0) * rng.nextDouble();
    }
    public void randomizePrecision(Random rng) {
        precision = rng.nextInt(300 - 10 + 1) + 10;
    }
    public void randomizeColormap(Random rng) {
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
    public void randomizePower(Random rng) {
        power = rng.nextInt(7 - 2 + 1) + 2;
    }
    public void randomizeC(Random rng) {
        double x = -1.0 + (1.0 - -1.0) * rng.nextDouble();
        double y = -1.0 + (1.0 - -1.0) * rng.nextDouble();
        c.setX(x);
        c.setY(y);
    }
    public void randomizeZ0(Random rng) {
        double x = -1.0 + (1.0 - -1.0) * rng.nextDouble();
        double y = -1.0 + (1.0 - -1.0) * rng.nextDouble();
        z0.setX(x);
        z0.setY(y);
    }
    
    //</editor-fold>
}
