/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

/**
 *
 * @author boril-d
 */
public class FractalOptions {
    private static final String[] DEFAULT_COLOR_ARR = {
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
    public static final FractalOptions DEFAULT_OPTIONS = new FractalOptions();
    
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
     * z(i) = ComplexNum.power(z(i - 1), power) + c;
     */
    
    private int power;
    private ComplexNum c;
    private ComplexNum z0;

    public double getBound() {
        return bound;
    }
    public void setBound(double bound) throws IllegalArgumentException {
        if (bound <= 0) {
            throw new IllegalArgumentException("`bound` must be > 0");
        }
        this.bound = bound;
    }

    public int getPrecision() {
        return precision;
    }
    public void setPrecision(int precision) throws IllegalArgumentException {
        if (precision <= 0) {
            throw new IllegalArgumentException("`precision` must be > 0");
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
        this.power = power;
    }

    public ComplexNum getC() {
        return c;
    }
    public void setC(ComplexNum c) throws IllegalArgumentException {
        if (c == null) {
            throw new IllegalArgumentException("`c` was null");
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
    public FractalOptions(double bound, int precision, Colormap clrmap, int power, ComplexNum c, ComplexNum z0) {
       setBound(bound);
       setPrecision(precision);
       setColormap(colormap);
       setPower(power);
       setC(c);
       setZ0(z0);
    }
    public FractalOptions(FractalOptions other) {
        bound = other.bound;
        precision = other.precision;
        colormap = new Colormap(other.colormap);
        power = other.power;
        c = new ComplexNum(other.c);
        z0 = new ComplexNum(other.z0);
    }
    
    @Override
    public String toString() {
        return String.format(
                "bound: %f, precision: %d, colormap: {%s}, power: %d, c: {%s}, z(0): {%s};",
                bound, precision, colormap.toString(), power, c.toString(), z0.toString()
        );
    }
}
