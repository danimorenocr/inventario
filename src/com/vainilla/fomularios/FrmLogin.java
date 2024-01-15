package com.vainilla.fomularios;

import com.vainilla.daos.DaoLogin;
import com.vainilla.entidades.Login;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JInternalFrame {

    public FrmLogin() {
        initComponents();
        apariencia();
    }

    private void apariencia() {

        panelRedondeado2.cambiarRadioEsquinas(150);
        btnRegis.cambiarRadioEsquinas(20);

    }

    public static ImageIcon escalarImagen(ImageIcon imagenOriginal, int ancho, int alto) {
        Image imagen = imagenOriginal.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimensionada);
    }

    private Boolean validarDatos() {
        Boolean bandera = true;
        String nombre = cajaNombre.getText();
        String contra = cajaContra.getText();

        if (nombre.equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Digite el nombre del usuario",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            cajaNombre.requestFocus();
        } else {

            if (contra.equals("")) {
                bandera = false;
                JOptionPane.showMessageDialog(panelCuerpo, "Digite la contraseña",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                cajaContra.requestFocus();
            }

        }
        return bandera;
    }

    private void borrarDatos() {
        cajaNombre.setText("");
        cajaContra.setText("");
        cajaNombre.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        panelRedondeado2 = new com.vainilla.apariencia.PanelRedondeado();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cajaContra = new javax.swing.JPasswordField();
        btnRegis = new com.vainilla.apariencia.BotonRedon();
        jLabel5 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        panelCuerpo.setBackground(new java.awt.Color(180, 235, 226));
        panelCuerpo.setLayout(null);

        panelRedondeado2.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Fredoka", 0, 36)); // NOI18N
        jLabel1.setText("¡Bienvenid@ de Nuevo!");
        panelRedondeado2.add(jLabel1);
        jLabel1.setBounds(100, 150, 370, 48);

        jLabel2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Contraseña");
        panelRedondeado2.add(jLabel2);
        jLabel2.setBounds(80, 390, 240, 23);

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Es un gusto poder ayudarte");
        panelRedondeado2.add(jLabel3);
        jLabel3.setBounds(10, 200, 548, 23);

        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        panelRedondeado2.add(cajaNombre);
        cajaNombre.setBounds(80, 290, 420, 40);

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Usuario");
        panelRedondeado2.add(jLabel4);
        jLabel4.setBounds(80, 260, 240, 23);

        cajaContra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        panelRedondeado2.add(cajaContra);
        cajaContra.setBounds(80, 430, 420, 40);

        panelCuerpo.add(panelRedondeado2);
        panelRedondeado2.setBounds(520, 80, 560, 570);

        btnRegis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        btnRegis.setText("Iniciar Sesión");
        btnRegis.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });
        panelCuerpo.add(btnRegis);
        btnRegis.setBounds(650, 670, 290, 50);
        panelCuerpo.add(jLabel5);
        jLabel5.setBounds(190, 90, 310, 290);

        getContentPane().add(panelCuerpo);
        panelCuerpo.setBounds(0, 0, 1520, 854);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        if (validarDatos()) {
            String nombre = cajaNombre.getText();
            String contra = cajaContra.getText();

            DaoLogin miDao = new DaoLogin();
            Login objUsuario = miDao.buscar(nombre);
            System.out.println("user: " + miDao.buscar(nombre));

            if (objUsuario == null) {
                JOptionPane.showMessageDialog(panelCuerpo, "No se encontró el usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "No se pudo registrar", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_btnRegisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vainilla.apariencia.BotonRedon btnRegis;
    private javax.swing.JPasswordField cajaContra;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panelCuerpo;
    private com.vainilla.apariencia.PanelRedondeado panelRedondeado2;
    // End of variables declaration//GEN-END:variables
}
