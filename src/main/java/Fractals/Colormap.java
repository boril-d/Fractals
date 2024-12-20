/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

import java.awt.Color;

/**
 * @brief A class representing a colormap.
 * 
 * The colormap is generated from an array of colors. It attempts to blend the
 * colors to make the transition between them look more smooth and natural.
 * 
 * There are 3 methods of storing a color recognized by this class:
 * * In an integer - `aarrggbb`;
 * * In a string - `"#rrggbbaa"`; the `#` and `aa` are optional;
 * * In java.awt.Color - there are methods for getting and setting each
 * individual value;
 * 
 * In the examples `aa` means 2 hexadecimal digits representing the alpha value;
 * `rr` - the red value; `gg` - the green value; `bb` - the blue value.
 * 
 * @author borilad
 */
public final class Colormap {
    public static final String COLOR_PATTERN = "#?[0-9a-fA-F]{6}([0-9a-fA-F]{2})?";
    public static final String COLORS_PATTERN = "(" + COLOR_PATTERN + "\\s)+";
    
    private int[] colors;

    public int[] get() {
        return colors;
    }
    public void set() {
        colors = new int[1];
        colors[0] = 0x00000000;
    }
    public void set(int[] colors) throws IllegalArgumentException {
        ensureValid(colors);
        
        this.colors = colors;
    }
    public void set(String[] colors) throws IllegalArgumentException {
        ensureValid(colors);
        
        this.colors = new int[colors.length];
        for (int i = 0; i < colors.length; i++) {
            this.colors[i] = stringToInt(colors[i]);
        }
    }
    public void set(Color[] colors) throws IllegalArgumentException {
        ensureValid(colors);
        
        this.colors = new int[colors.length];
        for (int i = 0; i < colors.length; i++) {
            this.colors[i] = colorToInt(colors[i]);
        }
    }
    public void set(Colormap other) {
        this.colors = new int[other.colors.length];
        for (int i = 0; i < colors.length; i++) {
            this.colors[i] = other.colors[i];
        }
    }
    
    public Colormap() {
        set();
    }
    public Colormap(int[] colors) throws IllegalArgumentException {
        set(colors);
    }
    public Colormap(String[] colors) throws IllegalArgumentException {
        set(colors);
    }
    public Colormap(Color[] colors) throws IllegalArgumentException {
        set(colors);
    }
    public Colormap(Colormap other) {
        set(other);
    }
    
    /**
     * @brief Returns a color based on a value in the range `[0, 1]`
     * 
     * For example if the colormap contains `#ff0000` and `#00ff00` which are
     * the colors red and green and a value of `0.5` is passed, then `#7f7f00`
     * is returned which is dark yellow - a mixture of the 2 values around it.
     * 
     * @param pos A double value in the range `[0, 1]`.
     * 
     * @return A color which is a mixture from the 2 colors around it.
     * @throws IllegalArgumentException if `pos` is not in the range `[0, 1]`.
     */
    public int getColor(double pos) throws IllegalArgumentException {
        if (pos < 0.0 || 1.0 < pos) {
            throw new IllegalArgumentException(
                    "`pos` must be a value in the range `[0, 1]`."
            );
        }
        pos *= colors.length - 1;
        
        // index of the bottom color
        int botIdx = (int)Math.floor(pos);
        // index of the top color
        int topIdx = (int)Math.ceil(pos);
        
        // how strong is the impact of the bottom color
        double botMult = (topIdx - pos);
        // how strong is the impact of the top color
        double topMult = 1.0 - botMult;
        
        // bottom color components
        int abot = (colors[botIdx] & 0xff000000) >>> 24;
        int rbot = (colors[botIdx] & 0x00ff0000) >>> 16;
        int gbot = (colors[botIdx] & 0x0000ff00) >>> 8;
        int bbot = (colors[botIdx] & 0x000000ff);
        
        // top color components
        int atop = (colors[topIdx] & 0xff000000) >>> 24;
        int rtop = (colors[topIdx] & 0x00ff0000) >>> 16;
        int gtop = (colors[topIdx] & 0x0000ff00) >>> 8;
        int btop = (colors[topIdx] & 0x000000ff);
        
        // result color components - a mixture of the bottom & top color
        int ares = (int)(abot * botMult + atop * topMult);
        int rres = (int)(rbot * botMult + rtop * topMult);
        int gres = (int)(gbot * botMult + gtop * topMult);
        int bres = (int)(bbot * botMult + btop * topMult);
        
        int resultColor = 0x00000000;
        
        resultColor |= ares << 24;
        resultColor |= rres << 16;
        resultColor |= gres << 8;
        resultColor |= bres;
        
        return resultColor;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        result.append(intToString(colors[0]));
        for (int i = 1; i < colors.length; i++) {
            result.append(' ');
            result.append(intToString(colors[i]));
        }
        
        return result.toString();
    }
    public void fromString(String str) throws IllegalArgumentException {
        if (!(str + "\n").matches(COLORS_PATTERN)) {
            throw new IllegalArgumentException("Invalid string colors format");
        }
        
        set(str.split("\\s"));
    }
    
    public static String intToString(int color) {
        StringBuilder result = new StringBuilder();
        result.append('#');
        
        int rgb = color & 0x00ffffff;
        int a =  (color & 0xff000000) >>> 24;
        
        String rgbStr = Integer.toUnsignedString(rgb, 16);
        // fill the front with 0's
        for (int i = rgbStr.length(); i < 6; i++) {
            result.append('0');
        }
        result.append(rgbStr);
        
        if (a != 255) {
            String aStr = Integer.toUnsignedString(a, 16);
            // fill the front with 0's
            for (int i = aStr.length(); i < 2; i++) {
                result.append('0');
            }
            result.append(aStr);
        }
        
        return result.toString();
    }
    public static int stringToInt(String color) throws IllegalArgumentException {
        ensureValid(color);
        
        boolean hasHashtag = color.charAt(0) == '#';
        boolean hasAlpha = color.length() >= 8;
        int rgbBegin = hasHashtag ? 1 : 0;
        int aBegin = rgbBegin + 6;
        int end = aBegin + 2;
        
        int result = Integer.parseUnsignedInt(color, rgbBegin, aBegin, 16);
        if (hasAlpha) {
            result |= Integer.parseUnsignedInt(color, aBegin, end, 16) << 24;
        } else {
            result |= 0xff000000;
        }
        
        return result;
    }
    public static int colorToInt(Color color) {
        return color.getRGB();
    }
    public static Color intToColor(int color) {
        return new Color(color, true);
    }
    public static String colorToString(Color color) {
        return intToString(colorToInt(color));
    }
    public static Color stringToColor(String color) throws IllegalArgumentException {
        return intToColor(stringToInt(color));
    }
    
    private static void ensureValid(int[] arr) throws IllegalArgumentException {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("`null` or empty array");
        }
    }
    private static void ensureValid(Object[] arr) throws IllegalArgumentException {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("`null` or empty array");
        }
    }
    private static void ensureValid(String str) throws IllegalArgumentException {
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("`null` or empty string");
        }
        if (!str.matches(COLOR_PATTERN)) {
            throw new IllegalArgumentException("Invalid string color format");
        }
    }
}