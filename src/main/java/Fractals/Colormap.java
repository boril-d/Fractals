/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fractals;

import java.awt.Color;

/**
 *
 * @author boril-d
 */
public final class Colormap {
    public static final int ALPHA = 0;
    public static final int RED   = 1;
    public static final int GREEN = 2;
    public static final int BLUE  = 3;
    public static final int VALS_CNT  = 4;
    public static final int VALS_SIZE = Byte.SIZE;

    public static final char COLOR_BEG_CHAR = '#';
    public static final char COLOR_END_CHAR = ' ';

    /**
     * @brief Gets the shift value for a specific value in the integer
     * representation of a color.
     * 
     * @param valType The type of value to be retrieved - `ALPHA`, `RED`,
     * `GREEN` or `BLUE`.
     * 
     * @return The count of bits you need to shift the color value with in order
     * to be able to insert it in the proper position.
     * 
     * @throws IllegalArgumentException if `valType` is other than `ALPHA`,
     * `RED`, `GREEN` or `BLUE`.
     */
    public static int shiftVal(int valType) throws IllegalArgumentException {
        ensureValidType(valType);
        
        final int STORAGE_SIZE = VALS_CNT * VALS_SIZE;
        final int BITS_FROM_BEGIN = (valType + 1) * VALS_SIZE;
        
        return STORAGE_SIZE - BITS_FROM_BEGIN;
    }
    /**
     * @brief Gets the bitmask value for a specific value in the integer
     * representation of a color.
     * 
     * @param valType The type of value to be retrieved - `ALPHA`, `RED`,
     * `GREEN` or `BLUE`.
     * 
     * @return The bitmask value for the specified color value type.
     * 
     * @throws IllegalArgumentException if `valType` is other than `ALPHA`,
     * `RED`, `GREEN` or `BLUE`.
     */
    public static int bitmaskVal(int valType) throws IllegalArgumentException {
        ensureValidType(valType);
        
        final int SHIFT = shiftVal(valType);
        final long BITMASK = ((long)(1) << VALS_SIZE) - 1;
        
        return (int)(BITMASK << SHIFT);
    }

    /**
     * @brief Retrieves information about a color stored in an integer.
     * 
     * @param valType The type of value to be retrieved - `ALPHA`, `RED`,
     * `GREEN` or `BLUE`.
     * @param color A color stored in an integer in format `0xAARRGGBB` where
     * each byte stores `ALPHA`, `RED`, `GREEN` and `BLUE` respectively.
     * 
     * @return The retrieved color value.
     * 
     * @throws IllegalArgumentException if `valType` is other than `ALPHA`,
     * `RED`, `GREEN` or `BLUE`.
     */
    public static byte colorVal(int valType, int color) throws IllegalArgumentException {
        ensureValidType(valType);
                
        return (byte)( (bitWiden(color) & bitmaskVal(valType)) >> shiftVal(valType) );
    }
    /**
     * @brief Encodes a color value into a color stored in an integer.
     * 
     * @param valType The type of value to be encoded - `ALPHA`, `RED`, `GREEN`
     * or `BLUE`.
     * @param color A color stored in an integer in format `0xAARRGGBB` where
     * each byte stores `ALPHA`, `RED`, `GREEN` and `BLUE` respectively.
     * @param val The value to be encoded in `color`.
     * 
     * @return The modified `color` value.
     * 
     * @throws IllegalArgumentException if `valType` is other than `ALPHA`,
     * `RED`, `GREEN` or `BLUE`.
     */
    public static int colorVal(int valType, int color, byte val) throws IllegalArgumentException {
        ensureValidType(valType);
        
        final int COLOR_WITH_BLANK_VAL = color & ~bitmaskVal(valType);
        
        return (int)(COLOR_WITH_BLANK_VAL | (bitWiden(val) << shiftVal(valType)));
    }

    /**
     * @brief Converts a color value stored in an integer to string.
     * 
     * @param color A color stored in an integer in format `0xAARRGGBB` where
     * each byte stores `ALPHA`, `RED`, `GREEN` and `BLUE` respectively.
     * 
     * @return The string value of the color which is `#RRGGBB` if the `ALPHA`
     * value is `255` or `#RRGGBBAA` if the `ALPHA` value is different than
     * `255`. `RRGGBBAA` are all hexadecimal digits (capital letters `ABCDEF`
     * are used for digit values from 10 to 15).
     */
    public static String colorToString(int color) {
        StringBuilder str = new StringBuilder();
        str.append(COLOR_BEG_CHAR);
        
        byte a = colorVal(ALPHA, color);
        byte r = colorVal(RED  , color);
        byte g = colorVal(GREEN, color);
        byte b = colorVal(BLUE , color);
        
        str.append(valToHexStr(r));
        str.append(valToHexStr(g));
        str.append(valToHexStr(b));
        if (a != (byte)(0xff)) {
            str.append(valToHexStr(a));
        }
        
        return str.toString();
    }
    /**
     * @brief Converts a string into a color encoded in an integer.
     * 
     * @param str The string value of a color. It can optionally begin with `#`.
     * Then it is followed by 8 hexadecimal digits for color values `RED`,
     * `GREEN`, `BLUE` and `ALPHA`. If `ALPHA` is equal to `255`, then the last
     * 2 hexadecimal digits can be omitted.
     * 
     * @return An integer value of the color in format `0xAARRGGBB` where each
     * byte stores `ALPHA`, `RED`, `GREEN` and `BLUE` respectively.
     * 
     * @throws IllegalArgumentException if any of the rules mentioned in the
     * parameter description of `str` are not followed.
     */
    public static int stringToColor(String str) throws IllegalArgumentException {
        ensureValidStr(str);
        
        int begI = 0;
        if (str.charAt(0) == COLOR_BEG_CHAR) {
            begI = 1;
        }
        if (str.length() - begI != 6 && str.length() - begI != 8) {
            throw new IllegalArgumentException(
                "'str' contains the wrong number of hexadecimal digits."
            );
        }
        int result = 0xff000000;
        int idx = begI;
        
        result = colorVal(RED  , result, hexStrToVal(str, idx, idx += 2));
        result = colorVal(GREEN, result, hexStrToVal(str, idx, idx += 2));
        result = colorVal(BLUE , result, hexStrToVal(str, idx, idx += 2));
        if (str.length() - begI == 8) {
            result = colorVal(ALPHA, result, hexStrToVal(str, idx, idx + 2));
        }
        return result;
    }

    public Colormap() {
        set();
    }
    public Colormap(int[] colors) throws IllegalArgumentException {
        set(colors);
    }
    public Colormap(Color[] colors) throws IllegalArgumentException {
        set(colors);
    }
    public Colormap(String[] colors) throws IllegalArgumentException {
        set(colors);
    }
    public Colormap(Colormap other) {
        set(other);
    }
    
    public void set() {
        colors = new int[1];
        colors[0] = 0x00000000;
    }
    public void set(int[] colors) throws IllegalArgumentException {
        ensureValidColors(colors);
        
        this.colors = colors;
    }
    public void set(Color[] colors) throws IllegalArgumentException {
        ensureValidColors(colors);
        
        this.colors = new int[colors.length];
        for (int i = 0; i < colors.length; i++) {
            this.colors[i] = colors[i].getRGB();
        }
    }
    public void set(String[] colors) throws IllegalArgumentException {
        ensureValidColors(colors);
        
        this.colors = new int[colors.length];
        for (int i = 0; i < colors.length; i++) {
            this.colors[i] = stringToColor(colors[i]);
        }
    }
    public void set(Colormap other) {
        colors = new int[other.colors.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = other.colors[i];
        }
    }

    public int colorsCount() {
        return colors.length;
    }
    public int color(int index) throws IndexOutOfBoundsException {
        if (colors.length <= index) {
            throw new IndexOutOfBoundsException("'index' out of range.");
        }
        return colors[index];
    }
    /**
     * @brief Uses the colormap to blend a color based on its position from `0`
     * to `1`.
     * 
     * For example if the colormap contains `#ff0000` and `#00ff00` which are
     * the colors red and green and a value of `0.5` is passed, then `#888800`
     * is returned which is dark yellow.
     * 
     * @param val A double value in the range `[0..1]`.
     * 
     * @return A color which is a mixture from the 2 colors around it.
     * @throws IndexOutOfBoundsException 
     */
    public int color(double val) throws IndexOutOfBoundsException {
        if (val < 0.0 || 1.0 < val) {
            throw new IndexOutOfBoundsException(
                    "`val` must be a value in the range `[0..1]`."
            );
        }
        val *= colors.length - 1;
        
        int botI = (int)Math.floor(val);
        int topI = (int)Math.ceil(val);
        
        double botMult = (topI - val);
        double topMult = 1.0 - botMult;
        
        long abot = bitWiden(colorVal(ALPHA, colors[botI]));
        long rbot = bitWiden(colorVal(RED  , colors[botI]));
        long gbot = bitWiden(colorVal(GREEN, colors[botI]));
        long bbot = bitWiden(colorVal(BLUE , colors[botI]));
        
        long atop = bitWiden(colorVal(ALPHA, colors[topI]));
        long rtop = bitWiden(colorVal(RED  , colors[topI]));
        long gtop = bitWiden(colorVal(GREEN, colors[topI]));
        long btop = bitWiden(colorVal(BLUE , colors[topI]));
        
        int resultColor = 0;
        resultColor = colorVal(ALPHA, resultColor, (byte)(topMult * atop + botMult * abot));
        resultColor = colorVal(RED  , resultColor, (byte)(topMult * rtop + botMult * rbot));
        resultColor = colorVal(GREEN, resultColor, (byte)(topMult * gtop + botMult * gbot));
        resultColor = colorVal(BLUE , resultColor, (byte)(topMult * btop + botMult * bbot));
        return resultColor;
    }

    @Override public String toString() {        
        StringBuilder str = new StringBuilder();
        
        str.append(colorToString(colors[0]));
        for (int i = 1; i < colors.length; i++) {
            str.append(COLOR_END_CHAR);
            str.append(colorToString(colors[i]));
        }
        
        return str.toString();
    }

    //<editor-fold defaultstate="collapsed" desc="helper functions">
    private static void ensureValidType(int type) throws IllegalArgumentException {
        if (type < 0 || VALS_CNT <= type) {
            throw new IllegalArgumentException("`type` is not a valid type.");
        }
    }
    private static void ensureValidStr(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("`str` was null.");
        }
        if (str.length() <= 0) {
            throw new IllegalArgumentException("`str` has an invalid length.");
        }
    }
    private static void ensureValidColors(int[] colors) throws IllegalArgumentException {
        if (colors == null) {
            throw new IllegalArgumentException("`colors` was null.");
        }
        if (colors.length <= 0) {
            throw new IllegalArgumentException("`colors` has an invalid length.");
        }
    }
    private static void ensureValidColors(Object[] colors) throws IllegalArgumentException {
        if (colors == null) {
            throw new IllegalArgumentException("`colors` was null.");
        }
        if (colors.length <= 0) {
            throw new IllegalArgumentException("`colors` has an invalid length.");
        }
    }

    private static long bitWiden(byte n) {
        long wideN = n;
        if (wideN < 0) {
            return wideN - (long)(Byte.MIN_VALUE) * 2;
        }
        return wideN;
    }
    private static long bitWiden(short n) {
        long wideN = n;
        if (wideN < 0) {
            return wideN - (long)(Short.MIN_VALUE) * 2;
        }
        return wideN;
    }
    private static long bitWiden(int n) {
        long wideN = n;
        if (wideN < 0) {
            return wideN - (long)(Integer.MIN_VALUE) * 2;
        }
        return wideN;
    }

    private static String valToHexStr(byte val) {        
        long wideVal = bitWiden(val);
        StringBuilder str = new StringBuilder();
        
        do {
            long digit = wideVal % 16;
            wideVal /= 16;
            if (0 <= digit && digit < 10) {
                str.append((char)('0' + digit));
            } else {
                str.append((char)('A' + digit - 10));
            }
        } while (wideVal != 0);
        
        if (str.length() == 1) {
            str.append('0');
        }
        
        str.reverse();
        return str.toString();
    }
    private static byte hexStrToVal(String hexStr, int begI, int endI) throws IllegalArgumentException {
        int result = 0;
        for (int i = begI; i != endI; i++) {
            result *= 16;
            char ch = hexStr.charAt(i);
            if ('0' <= ch && ch <= '9') {
                result += ch - '0';
            } else if ('a' <= ch && ch <= 'f') {
                result += ch - 'a' + 10;
            } else if ('A' <= ch && ch <= 'F') {
                result += ch - 'A' + 10;
            } else {
                throw new IllegalArgumentException(
                    "'hexStr' contains a character which is not a hexadecimal digit."
                );
            }
        }
        return (byte)(result);
    }
    //</editor-fold>

    private int[] colors;
}