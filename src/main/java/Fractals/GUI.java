/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fractals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author bilyana-kr 
 */
public class GUI extends javax.swing.JFrame {
    private Mandelbrot mandelbrot;
    private Julia julia;
    private Fractal currentFractal;
    
    private int cnvMouseX;
    private int cnvMouseY;
    
    public static final String OPTIONS_DIR = "./saves/";
    
    private File selectFileToLoad() {
        JFileChooser expl = new JFileChooser();
        expl.setCurrentDirectory(new File(OPTIONS_DIR));
        
        int ret = expl.showOpenDialog(this);
        if (ret != JFileChooser.APPROVE_OPTION) {
            System.out.println("garbage");
            return null;
        }
        
        return expl.getSelectedFile();
    }
    private File selectFileToSave() {
        JFileChooser expl = new JFileChooser();
        expl.setCurrentDirectory(new File(OPTIONS_DIR));
        
        int ret = expl.showSaveDialog(this);
        if (ret != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        
        return expl.getSelectedFile();
    }
    
    private void updateOptionsDisplay() {
        txtPrecision.setText(currentFractal.getOptions().precisionToString());
        txtPower.setText(currentFractal.getOptions().powerToString());
        txtZ0.setText(currentFractal.getOptions().z0ToString());
        txtC.setText(currentFractal.getOptions().cToString());
    }

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        mandelbrot = new Mandelbrot();
        julia = new Julia();
        
        currentFractal = mandelbrot;
        txtZ0.setEditable(true);
        txtZ0.setEnabled(true);
        txtC.setEditable(false);
        txtC.setEnabled(false);
        updateOptionsDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlOptions = new javax.swing.JPanel();
        radMandelbrot = new javax.swing.JRadioButton();
        radJulia = new javax.swing.JRadioButton();
        btnRestore = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPrecision = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPower = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtZ0 = new javax.swing.JTextField();
        btnColors = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnDefaultColors = new javax.swing.JButton();
        btnResetZoom = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnRandomOpt = new javax.swing.JButton();
        txtC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pnlCanvas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fractals Generator");

        pnlOptions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        buttonGroup1.add(radMandelbrot);
        radMandelbrot.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        radMandelbrot.setSelected(true);
        radMandelbrot.setText("Mandelbrot set");
        radMandelbrot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMandelbrotActionPerformed(evt);
            }
        });

        buttonGroup1.add(radJulia);
        radJulia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        radJulia.setText("Julia set");
        radJulia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radJuliaActionPerformed(evt);
            }
        });

        btnRestore.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnRestore.setText("Restore Defaults");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("precision =");

        txtPrecision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecisionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel1.setText("Colors");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("power =");

        txtPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPowerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setText("z(0) = ");

        txtZ0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZ0ActionPerformed(evt);
            }
        });

        btnColors.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnColors.setText("Colors list");
        btnColors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorsActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSave.setText("Save File");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnLoad.setText("Load File");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnDefaultColors.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnDefaultColors.setText("Default Palette");
        btnDefaultColors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultColorsActionPerformed(evt);
            }
        });

        btnResetZoom.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnResetZoom.setText("Reset Zoom");
        btnResetZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetZoomActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel6.setText("Fractal's function");

        btnRandomOpt.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnRandomOpt.setText("Randomize Options");
        btnRandomOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomOptActionPerformed(evt);
            }
        });

        txtC.setEditable(false);
        txtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("c =");

        javax.swing.GroupLayout pnlOptionsLayout = new javax.swing.GroupLayout(pnlOptions);
        pnlOptions.setLayout(pnlOptionsLayout);
        pnlOptionsLayout.setHorizontalGroup(
            pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionsLayout.createSequentialGroup()
                        .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRandomOpt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlOptionsLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(47, 47, 47))
                            .addComponent(btnRestore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetZoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlOptionsLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecision))
                            .addGroup(pnlOptionsLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLoad))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlOptionsLayout.createSequentialGroup()
                                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPower)
                                    .addComponent(txtZ0)
                                    .addComponent(txtC))))
                        .addContainerGap())))
            .addGroup(pnlOptionsLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnColors)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDefaultColors)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOptionsLayout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(radMandelbrot)
                .addGap(18, 18, 18)
                .addComponent(radJulia)
                .addGap(12, 12, 12))
        );
        pnlOptionsLayout.setVerticalGroup(
            pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionsLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnRestore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRandomOpt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtZ0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radMandelbrot)
                    .addComponent(radJulia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDefaultColors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnColors)
                .addGap(12, 12, 12)
                .addComponent(btnResetZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnSave))
                .addGap(14, 14, 14))
        );

        pnlCanvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlCanvasMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlCanvasMouseMoved(evt);
            }
        });
        pnlCanvas.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                pnlCanvasMouseWheelMoved(evt);
            }
        });
        pnlCanvas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnlCanvasKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlCanvasLayout = new javax.swing.GroupLayout(pnlCanvas);
        pnlCanvas.setLayout(pnlCanvasLayout);
        pnlCanvasLayout.setHorizontalGroup(
            pnlCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlCanvasLayout.setVerticalGroup(
            pnlCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCActionPerformed
        try {
            currentFractal.getOptions().cFromString(txtC.getText());
        } catch (Exception err) {
            txtC.setText(currentFractal.getOptions().cToString());
        }
        render();
    }//GEN-LAST:event_txtCActionPerformed

    private void btnRandomOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomOptActionPerformed
        currentFractal.getOptions().randomize();
        updateOptionsDisplay();
        render();
    }//GEN-LAST:event_btnRandomOptActionPerformed

    private void render() {
        int width = pnlCanvas.getWidth();
        int height = pnlCanvas.getHeight();
        BufferedImage image = currentFractal.getFractalImage(width, height);
        Graphics graphics = pnlCanvas.getGraphics();
        graphics.drawImage(image, 0, 0, null);
    }
    private void btnResetZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetZoomActionPerformed
        currentFractal.getOptions().defaultBorders();
        render();
    }//GEN-LAST:event_btnResetZoomActionPerformed

    private void btnDefaultColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultColorsActionPerformed
        currentFractal.getOptions().setColormap(new Colormap(currentFractal.getOptions().DEFAULT_COLORMAP));
        render();
    }//GEN-LAST:event_btnDefaultColorsActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        File file = selectFileToLoad();
        if (file == null) {
            return;
        }
        try {
            currentFractal.getOptions().load(file);
        } catch (Exception err) {
            System.out.println("An error occured during load...");
            System.out.println(err.getMessage());
        }

        updateOptionsDisplay();
        render();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        File file = selectFileToSave();
        if (file == null) {
            return;
        }
        try {
            currentFractal.getOptions().save(file);
        } catch (Exception err) {
            System.out.println("An error occured during save...");
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorsActionPerformed
        String temp;
        temp = JOptionPane.showInputDialog("List the desired colours(e.g. #FF0000FF #00FF00FF):");
        if (temp != null) {
            try {
                currentFractal.getOptions().getColormap().fromString(temp);
                render();
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid color format. Please try again.\nColors must be listed as (#rrggbbaa) or (#RRGGBBAA) with a single space between them.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnColorsActionPerformed

    private void txtZ0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZ0ActionPerformed
        try {
            currentFractal.getOptions().z0FromString(txtZ0.getText());
        } catch (Exception err) {
            txtZ0.setText(currentFractal.getOptions().z0ToString());
        }
        render();
    }//GEN-LAST:event_txtZ0ActionPerformed

    private void txtPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPowerActionPerformed
        try {
            currentFractal.getOptions().powerFromString(txtPower.getText());
        } catch (Exception err) {
            txtPower.setText(currentFractal.getOptions().powerToString());
        }
        render();
    }//GEN-LAST:event_txtPowerActionPerformed

    private void txtPrecisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecisionActionPerformed
        try {
            currentFractal.getOptions().precisionFromString(txtPrecision.getText());
        } catch (Exception err) {
            txtPrecision.setText(currentFractal.getOptions().precisionToString());
        }
        render();
    }//GEN-LAST:event_txtPrecisionActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        currentFractal.getOptions().set();
        updateOptionsDisplay();
        render();
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void radJuliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radJuliaActionPerformed
        // TODO add your handling code here:

        if (radJulia.isEnabled()) {
            currentFractal = julia;
            txtZ0.setEditable(false);
            txtZ0.setEnabled(false);
            txtC.setEditable(true);
            txtC.setEnabled(true);
            updateOptionsDisplay();
            render();
        }

    }//GEN-LAST:event_radJuliaActionPerformed

    private void radMandelbrotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMandelbrotActionPerformed
        // TODO add your handling code here:

        if (radMandelbrot.isEnabled()) {
            currentFractal = mandelbrot;
            txtZ0.setEditable(true);
            txtZ0.setEnabled(true);
            txtC.setEditable(false);
            txtC.setEnabled(false);
            updateOptionsDisplay();
            render();
        }
    }//GEN-LAST:event_radMandelbrotActionPerformed

    private void pnlCanvasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlCanvasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlCanvasKeyPressed

    private void pnlCanvasMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_pnlCanvasMouseWheelMoved
        int moveCount = evt.getWheelRotation();
                
        double up = currentFractal.getOptions().getUpBorder();
        double down = currentFractal.getOptions().getDownBorder();
        double left = currentFractal.getOptions().getLeftBorder();
        double right = currentFractal.getOptions().getRightBorder();
        
        ComplexNum center = Fractal.screenToFractalCoords(
                cnvMouseX, cnvMouseY, pnlCanvas.getWidth(), pnlCanvas.getHeight(),
                left, right, down, up
        );
        
        double upOffset = up - center.getY();
        double downOffset = down - center.getY();
        double leftOffset = left - center.getX();
        double rightOffset = right - center.getX();
        
        final double mult = 1.5;
        
        upOffset *= Math.pow(mult, moveCount);
        downOffset *= Math.pow(mult, moveCount);
        leftOffset *= Math.pow(mult, moveCount);
        rightOffset *= Math.pow(mult, moveCount);
        
        currentFractal.getOptions().setUpBorder(center.getY() + upOffset);
        currentFractal.getOptions().setDownBorder(center.getY() + downOffset);
        currentFractal.getOptions().setLeftBorder(center.getX() + leftOffset);
        currentFractal.getOptions().setRightBorder(center.getX() + rightOffset);
        
        render();
    }//GEN-LAST:event_pnlCanvasMouseWheelMoved

    private void pnlCanvasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCanvasMouseMoved
        cnvMouseX = evt.getX();
        cnvMouseY = evt.getY();
    }//GEN-LAST:event_pnlCanvasMouseMoved

    private void pnlCanvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCanvasMouseDragged
        double up = currentFractal.getOptions().getUpBorder();
        double down = currentFractal.getOptions().getDownBorder();
        double left = currentFractal.getOptions().getLeftBorder();
        double right = currentFractal.getOptions().getRightBorder();
        
        double offsetX = (double)(evt.getX() - cnvMouseX) * (right - left) / pnlCanvas.getWidth();
        double offsetY = (double)(evt.getY() - cnvMouseY) * (up - down) / pnlCanvas.getHeight();
        
        currentFractal.getOptions().setLeftBorder(left - offsetX);
        currentFractal.getOptions().setRightBorder(right - offsetX);
        currentFractal.getOptions().setDownBorder(down + offsetY);
        currentFractal.getOptions().setUpBorder(up + offsetY);
        
        cnvMouseX = evt.getX();
        cnvMouseY = evt.getY();
        
        render();
    }//GEN-LAST:event_pnlCanvasMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold> //</editor-fold>

        GUI gui = new GUI();
        gui.setVisible(true);
        gui.render();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //GUI gui = new GUI();
                //gui.setVisible(true);
                //gui.render();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColors;
    private javax.swing.JButton btnDefaultColors;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnRandomOpt;
    private javax.swing.JButton btnResetZoom;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlCanvas;
    private javax.swing.JPanel pnlOptions;
    private javax.swing.JRadioButton radJulia;
    private javax.swing.JRadioButton radMandelbrot;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtPower;
    private javax.swing.JTextField txtPrecision;
    private javax.swing.JTextField txtZ0;
    // End of variables declaration//GEN-END:variables
}
