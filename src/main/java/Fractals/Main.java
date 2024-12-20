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
    public static void main(String[] args) {
        Colormap colormap = new Colormap();
        colormap.fromString("#ff0000 #00ff00");
        System.out.println(Colormap.intToString(colormap.getColor(0.0)));
        System.out.println(Colormap.intToString(colormap.getColor(0.5)));
        System.out.println(Colormap.intToString(colormap.getColor(1.0)));
        System.out.println(colormap);
        System.out.println(Colormap.COLOR_PATTERN);
        System.out.println(Colormap.COLORS_PATTERN);
        //File file = selectSaveToSave();
        //System.out.println(file.getName());
        //System.out.println("save ended.");
    }
}
