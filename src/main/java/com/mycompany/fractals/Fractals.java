
package com.mycompany.fractals;

/**
 *
 * @author boril.d & bilyana.kr
 */
public class Fractals {
    public static void main(String[] args) {
        int[] clrs = {
            /* red color:   */ 0xffff0000,
            /* green color: */ 0xff00ff00,
            /* blue color:  */ 0xff0000ff,
        };
        System.out.println("Testing git");
        
        Colormap clrmap = new Colormap();
        clrmap.set(clrs);
        System.out.println(clrmap.colorsCount());
        System.out.println();
        System.out.println(Colormap.colorToString(clrmap.color(0)));
        System.out.println(Colormap.colorToString(clrmap.color(1)));
        System.out.println(Colormap.colorToString(clrmap.color(2)));
        System.out.println();
        System.out.println(clrmap);
        System.out.println();
        System.out.println(Colormap.colorToString(clrmap.color(0.0)));
        System.out.println(Colormap.colorToString(clrmap.color(0.125)));
        System.out.println(Colormap.colorToString(clrmap.color(0.25)));
        System.out.println(Colormap.colorToString(clrmap.color(0.375)));
        System.out.println(Colormap.colorToString(clrmap.color(0.5)));
        System.out.println(Colormap.colorToString(clrmap.color(0.625)));
        System.out.println(Colormap.colorToString(clrmap.color(0.75)));
        System.out.println(Colormap.colorToString(clrmap.color(0.875)));
        System.out.println(Colormap.colorToString(clrmap.color(1.0)));
        System.out.println();
    }
}
