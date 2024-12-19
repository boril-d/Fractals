/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Fractals;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Gate
 */
public class GUI extends javax.swing.JFrame {
    private Mandelbrot mandelbrot;
    private Julia julia;
    private Fractal currentFractal;
    
    public static final String SAVES_DIR = "./saves/";
    public static final String SAVES_EXTENSION = ".fopts";
    
    private File selectSaveToOpen() {
        JFileChooser expl = new JFileChooser();
        expl.setCurrentDirectory(new File(SAVES_DIR));
        
        int ret = expl.showOpenDialog(this);
        if (ret != expl.APPROVE_OPTION) {
            return null;
        }
        
        return expl.getSelectedFile();
    }
    private File selectSaveToSave() {
        JFileChooser expl = new JFileChooser();
        expl.setCurrentDirectory(new File(SAVES_DIR));
        
        int ret = expl.showSaveDialog(this);
        if (ret != expl.APPROVE_OPTION) {
            return null;
        }
        
        return expl.getSelectedFile();
    }
    
    private void updateOptionsDisplay() {
        txtPrecision.setText(Integer.toString(currentFractal.getOptions().getPrecision()));
        txtPower.setText(Integer.toString(currentFractal.getOptions().getPower()));
        txtZ0.setText(currentFractal.getOptions().getZ0().toString());
        txtC.setText(currentFractal.getOptions().getC().toString());
    }

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        mandelbrot = new Mandelbrot();
        julia = new Julia();
        currentFractal = mandelbrot;

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
        btnRender = new javax.swing.JButton();
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
        jLabel2.setText("Precision:");

        txtPrecision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecisionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel1.setText("Colors");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setText("power of z =");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setText("z(0) = ");

        btnColors.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnColors.setText("Colors list");

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

        btnRender.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        btnRender.setText("Render");
        btnRender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenderActionPerformed(evt);
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
                            .addComponent(btnRender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlOptionsLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecision))
                            .addGroup(pnlOptionsLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLoad))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlOptionsLayout.createSequentialGroup()
                                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPower)
                                    .addComponent(txtZ0)
                                    .addComponent(txtC))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(pnlOptionsLayout.createSequentialGroup()
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOptionsLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnColors))
                    .addGroup(pnlOptionsLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnDefaultColors)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnRender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnSave))
                .addGap(14, 14, 14))
        );

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
                .addComponent(pnlCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRenderActionPerformed

    private void radMandelbrotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMandelbrotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radMandelbrotActionPerformed

    private void radJuliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radJuliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radJuliaActionPerformed

    private void txtPrecisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecisionActionPerformed
        try {
            currentFractal.getOptions().setPrecision(Integer.parseInt(txtPrecision.getText()));
        } catch (Exception err) {
            txtPrecision.setText(Integer.toString(currentFractal.getOptions().getPrecision()));
        }
    }//GEN-LAST:event_txtPrecisionActionPerformed

    private void btnRandomOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomOptActionPerformed
        currentFractal.getOptions().randomize();
        updateOptionsDisplay();
    }//GEN-LAST:event_btnRandomOptActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        currentFractal.getOptions().set();
        updateOptionsDisplay();
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        File file = selectSaveToSave();
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

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        File file = selectSaveToOpen();
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
    }//GEN-LAST:event_btnLoadActionPerformed

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
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColors;
    private javax.swing.JButton btnDefaultColors;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnRandomOpt;
    private javax.swing.JButton btnRender;
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
