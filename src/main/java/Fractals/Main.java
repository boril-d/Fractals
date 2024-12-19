/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Fractals;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author borilad
 */
public class Main {
    public static final String SAVES_DIR = "./saves/";
    public static final String SAVES_EXTENSION = ".fopts";
    
    static private File selectSaveToOpen() {
        JFileChooser expl = new JFileChooser();
        expl.setCurrentDirectory(new File(SAVES_DIR));
        
        int ret = expl.showOpenDialog(null);
        if (ret != expl.APPROVE_OPTION) {
            return null;
        }
        
        return expl.getSelectedFile();
    }
    static private File selectSaveToSave() {
        JFileChooser expl = new JFileChooser();
        expl.setCurrentDirectory(new File(SAVES_DIR));
        
        int ret = expl.showSaveDialog(null);
        if (ret != expl.APPROVE_OPTION) {
            return null;
        }
        
        return expl.getSelectedFile();
    }
    
    public static void main(String[] args) {
        File file = selectSaveToSave();
        System.out.println(file.getName());
        System.out.println("save ended.");
    }
}
