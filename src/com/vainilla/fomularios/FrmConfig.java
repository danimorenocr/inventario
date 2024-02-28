package com.vainilla.fomularios;

import com.vainilla.configuracion.Credenciales;
import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FrmConfig extends javax.swing.JDialog {

    Credenciales datosConfig = new Credenciales();

    public FrmConfig(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        quitarHeader(this);
        initComponents();
        cargarDatos();
        Deshabilitar();
    }

    private void quitarHeader(JDialog dialog) {
        Dialog ventana = (Dialog) dialog;

        ventana.setUndecorated(true);
    }

    private void Deshabilitar() {
        cajaNombre.setEnabled(false);
        cajaContra.setEnabled(false);
        cajaUsuario.setEnabled(false);
        btnEditar.setVisible(true);
        btnGuardar.setVisible(false);
        btnCerrar.setVisible(true);
        btnCancelar.setVisible(false);
    }

    private void habilitar() {
        cajaNombre.setEnabled(true);
        cajaContra.setEnabled(true);
        cajaUsuario.setEnabled(true);
        btnEditar.setVisible(false);
        btnGuardar.setVisible(true);
        btnCerrar.setVisible(false);
        btnCancelar.setVisible(true);

    }

    private void cargarDatos() {
        cajaContra.setText(datosConfig.getClave());
        cajaNombre.setText(datosConfig.getNombreBase());
        cajaUsuario.setText(datosConfig.getUsuario());
    }

    private Boolean vericarCampos() {
        Boolean bandera = true;
        String nombre = cajaNombre.getText();
        String user = cajaUsuario.getText();
        String clave = cajaContra.getText();

        if (nombre.equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Digite el nombre de la base de datos",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            cajaNombre.requestFocus();
        } else {

            if (user.equals("")) {
                bandera = false;
                JOptionPane.showMessageDialog(panelCuerpo, "Digite el usuario de la base",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                cajaUsuario.requestFocus();
            } else {
                if (clave.equals("")) {
                    bandera = false;
                    JOptionPane.showMessageDialog(panelCuerpo, "Digite la contraseña de la base",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    cajaContra.requestFocus();
                }
            }

        }
        return bandera;
    }

    private void borrarDatos() {
        cajaContra.setText("");
        cajaNombre.setText("");
        cajaUsuario.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEditar = new com.vainilla.apariencia.ButtonOutLine();
        btnCerrar = new com.vainilla.apariencia.ButtonOutLine();
        cajaContra = new javax.swing.JTextField();
        cajaNombre = new javax.swing.JTextField();
        cajaUsuario = new javax.swing.JTextField();
        btnCancelar = new com.vainilla.apariencia.ButtonOutLine();
        btnGuardar = new com.vainilla.apariencia.ButtonOutLine();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Fredoka Medium", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 61, 162));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configuración");

        jLabel2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Conexión a la base de datos");

        btnEditar.setBackground(new java.awt.Color(114, 90, 227));
        btnEditar.setText("Editar");
        btnEditar.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(114, 90, 227));
        btnCerrar.setText("Cerrar");
        btnCerrar.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        cajaContra.setBackground(new java.awt.Color(231, 231, 234));
        cajaContra.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaContra.setForeground(new java.awt.Color(55, 28, 185));
        cajaContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaContra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(114, 90, 227), 3, true));
        cajaContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaContraMouseClicked(evt);
            }
        });
        cajaContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaContraActionPerformed(evt);
            }
        });

        cajaNombre.setBackground(new java.awt.Color(231, 231, 234));
        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre.setForeground(new java.awt.Color(55, 28, 185));
        cajaNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(114, 90, 227), 3, true));
        cajaNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaNombreMouseClicked(evt);
            }
        });
        cajaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNombreActionPerformed(evt);
            }
        });

        cajaUsuario.setBackground(new java.awt.Color(231, 231, 234));
        cajaUsuario.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaUsuario.setForeground(new java.awt.Color(55, 28, 185));
        cajaUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(114, 90, 227), 3, true));
        cajaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaUsuarioMouseClicked(evt);
            }
        });
        cajaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaUsuarioActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(114, 90, 227));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(114, 90, 227));
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nombre de la base de datos:");

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Usuario:");

        jLabel5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Contraseña:");

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(161, 161, 161))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(cajaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        habilitar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cajaContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaContraActionPerformed

    private void cajaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNombreActionPerformed

    private void cajaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaUsuarioActionPerformed

    private void cajaNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaNombreMouseClicked
    }//GEN-LAST:event_cajaNombreMouseClicked

    private void cajaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaUsuarioMouseClicked
    }//GEN-LAST:event_cajaUsuarioMouseClicked

    private void cajaContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaContraMouseClicked
    }//GEN-LAST:event_cajaContraMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cajaContra.setText(datosConfig.getClave());
        cajaNombre.setText(datosConfig.getNombreBase());
        cajaUsuario.setText(datosConfig.getUsuario());
        cajaNombre.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (vericarCampos()) {
            Deshabilitar();
            datosConfig.setClave(cajaContra.getText());
            datosConfig.setNombreBase(cajaNombre.getText());
            datosConfig.setUsuario(cajaUsuario.getText());
            JOptionPane.showMessageDialog(panelCuerpo, "Actulización Exitosa", "Completado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
    }//GEN-LAST:event_btnEditarMouseExited

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
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmConfig dialog = new FrmConfig(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vainilla.apariencia.ButtonOutLine btnCancelar;
    private com.vainilla.apariencia.ButtonOutLine btnCerrar;
    private com.vainilla.apariencia.ButtonOutLine btnEditar;
    private com.vainilla.apariencia.ButtonOutLine btnGuardar;
    private javax.swing.JTextField cajaContra;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelCuerpo;
    // End of variables declaration//GEN-END:variables
}
