package com.vainilla.fomularios;

import com.vainilla.daos.DaoProveedor;
import com.vainilla.entidades.Proveedor;
import java.awt.Dialog;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FrmProveedorEditar extends javax.swing.JDialog {

    private final Proveedor objActualizar;
 

    public FrmProveedorEditar(java.awt.Frame parent, boolean modal, Proveedor objExterno) {
        super(parent, modal);
        quitarHeader(this);
        initComponents();
        objActualizar = objExterno;
        cajaNombre.setText(objExterno.getNombreProveedor());
        cajaTelefono.setText(objExterno.getTelefonoProveedor());
        cajaCiudad.setText(objExterno.getCiudadProveedor());
    }

    private void quitarHeader(JDialog dialog) {
        Dialog ventana = (Dialog) dialog;
        ventana.setUndecorated(true);
    }

    private Boolean estaTodoBien() {
        Boolean bandera = true;
        String nombre = cajaNombre.getText();
        String telefono = cajaTelefono.getText();
        String ciudad = cajaCiudad.getText();

        if (nombre.equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Digite el nombre del proveedor",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            cajaNombre.requestFocus();

        } else {

            if (telefono.equals("") || telefono.length() != 10) {
                bandera = false;
                JOptionPane.showMessageDialog(panelCuerpo, "Número de teléfono incorrecto",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                cajaTelefono.requestFocus();

            } else {

                if (ciudad.equals("")) {
                    bandera = false;
                    JOptionPane.showMessageDialog(panelCuerpo, "Digite el nombre de la ciudad",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    cajaCiudad.requestFocus();
                }

            }

        }
        return bandera;
    }

    private boolean verificarNombre(String nombre) {
        boolean existencia = true;
        List<Proveedor> arrayProv;
        DaoProveedor dao = new DaoProveedor();
        arrayProv = dao.buscarDato(nombre, "nombre");
        System.out.println("nombres: " + arrayProv);
        if (arrayProv.isEmpty()) {
            System.out.println("tamaño: " + arrayProv.size());
            existencia = false;
        }

        System.out.println("tamaño: " + arrayProv.size());
        System.out.println("Existencia: " + existencia);
        return existencia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCerrar = new com.vainilla.apariencia.ButtonOutLine();
        cajaCiudad = new javax.swing.JTextField();
        cajaNombre = new javax.swing.JTextField();
        cajaTelefono = new javax.swing.JTextField();
        btnActualizar = new com.vainilla.apariencia.ButtonOutLine();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Fredoka Medium", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 182, 193));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actualización de datos");

        jLabel2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manten tus registros actualizados");

        btnCerrar.setBackground(new java.awt.Color(255, 182, 193));
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

        cajaCiudad.setBackground(new java.awt.Color(231, 231, 234));
        cajaCiudad.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaCiudad.setForeground(new java.awt.Color(255, 182, 193));
        cajaCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaCiudad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        cajaCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaCiudadMouseClicked(evt);
            }
        });
        cajaCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCiudadActionPerformed(evt);
            }
        });

        cajaNombre.setBackground(new java.awt.Color(231, 231, 234));
        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre.setForeground(new java.awt.Color(255, 182, 193));
        cajaNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
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

        cajaTelefono.setBackground(new java.awt.Color(231, 231, 234));
        cajaTelefono.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaTelefono.setForeground(new java.awt.Color(255, 182, 193));
        cajaTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cajaTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        cajaTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cajaTelefonoMouseClicked(evt);
            }
        });
        cajaTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTelefonoActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 182, 193));
        btnActualizar.setText("Actualizar");
        btnActualizar.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nombre del proveedor:");

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Celular:");

        jLabel5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Ciudad:");

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
                            .addComponent(cajaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
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

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered

    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cajaCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaCiudadMouseClicked

    }//GEN-LAST:event_cajaCiudadMouseClicked

    private void cajaCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCiudadActionPerformed

    private void cajaNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaNombreMouseClicked

    }//GEN-LAST:event_cajaNombreMouseClicked

    private void cajaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNombreActionPerformed

    private void cajaTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cajaTelefonoMouseClicked

    }//GEN-LAST:event_cajaTelefonoMouseClicked

    private void cajaTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaTelefonoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (estaTodoBien()) {
            String nombre = cajaNombre.getText().toUpperCase();
            String telefono = cajaTelefono.getText();
            String ciudad = cajaCiudad.getText().toUpperCase();
            DaoProveedor dao = new DaoProveedor();

            objActualizar.setTelefonoProveedor(telefono);
            objActualizar.setCiudadProveedor(ciudad);

            if (!verificarNombre(nombre)) {
                System.out.println("verificar: " + verificarNombre(nombre));
                objActualizar.setNombreProveedor(nombre);

                if (dao.actualizar(objActualizar)) {
                    JOptionPane.showMessageDialog(panelCuerpo, "El proveedor fue actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(panelCuerpo, "No se pudo actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "El proveedor ya ha sido registrado con ese nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered

    }//GEN-LAST:event_btnActualizarMouseEntered

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
            java.util.logging.Logger.getLogger(FrmProveedorEditar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorEditar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorEditar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorEditar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmProveedorEditar dialog = new FrmProveedorEditar(new javax.swing.JFrame(), true, new Proveedor());
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
    private com.vainilla.apariencia.ButtonOutLine btnActualizar;
    private com.vainilla.apariencia.ButtonOutLine btnCerrar;
    private javax.swing.JTextField cajaCiudad;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelCuerpo;
    // End of variables declaration//GEN-END:variables
}
