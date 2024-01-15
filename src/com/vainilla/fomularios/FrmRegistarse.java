package com.vainilla.fomularios;

import com.vainilla.daos.DaoLogin;
import com.vainilla.entidades.Login;
import static com.vainilla.fomularios.FrmPrincipal.escalarImagen;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmRegistarse extends javax.swing.JInternalFrame {

    private Boolean estado = true;

    public FrmRegistarse() {
        initComponents();
        apariencia();
    }

    private void apariencia() {

        panelRedondeado2.cambiarRadioEsquinas(150);
        btnRegis.cambiarRadioEsquinas(20);
        cargarImg();
    }

    private void cargarImg() {

        try {
            URL imgU = new URL(" https://cdn-icons-png.flaticon.com/512/12288/12288521.png ");
            Image boxesImg = new ImageIcon(imgU).getImage().getScaledInstance(110, 110, 0);
            ImageIcon iconoBox = new ImageIcon(boxesImg);
            lblIcon.setIcon(iconoBox);
            URL imgVer = new URL("    https://cdn-icons-png.flaticon.com/512/8443/8443792.png ");
            Image verImg = new ImageIcon(imgVer).getImage().getScaledInstance(20, 20, 0);
            ImageIcon iconoVer = new ImageIcon(verImg);
            lblVer.setIcon(iconoVer);

        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        lblIcon = new javax.swing.JLabel();
        lblVer = new javax.swing.JLabel();
        btnRegis = new com.vainilla.apariencia.BotonRedon();

        getContentPane().setLayout(null);

        panelCuerpo.setBackground(new java.awt.Color(180, 235, 226));
        panelCuerpo.setLayout(null);

        panelRedondeado2.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Fredoka", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("   ¡Regístrate! ");
        panelRedondeado2.add(jLabel1);
        jLabel1.setBounds(0, 150, 560, 48);

        jLabel2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Contraseña");
        panelRedondeado2.add(jLabel2);
        jLabel2.setBounds(80, 390, 240, 23);

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("   Para comenzar");
        panelRedondeado2.add(jLabel3);
        jLabel3.setBounds(-2, 200, 560, 23);

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
        panelRedondeado2.add(lblIcon);
        lblIcon.setBounds(230, 30, 120, 110);

        lblVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerMouseClicked(evt);
            }
        });
        panelRedondeado2.add(lblVer);
        lblVer.setBounds(40, 440, 20, 20);

        panelCuerpo.add(panelRedondeado2);
        panelRedondeado2.setBounds(520, 80, 560, 570);

        btnRegis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        btnRegis.setText("Registrarse");
        btnRegis.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });
        panelCuerpo.add(btnRegis);
        btnRegis.setBounds(650, 670, 290, 50);

        getContentPane().add(panelCuerpo);
        panelCuerpo.setBounds(0, 0, 1520, 854);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        if (validarDatos()) {
            String nombre = cajaNombre.getText();
            String contra = cajaContra.getText();

            Login objUsuario = new Login(nombre, contra);

            DaoLogin miDao = new DaoLogin();

            if (miDao.registrar(objUsuario)) {
                JOptionPane.showMessageDialog(panelCuerpo, "Registro Exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
                borrarDatos();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "No se pudo registrar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnRegisActionPerformed

    private void lblVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseClicked

        if (estado) {
            try {
                URL imgVer = new URL("      https://cdn-icons-png.flaticon.com/512/9533/9533310.png ");
                Image verImg = new ImageIcon(imgVer).getImage().getScaledInstance(20, 20, 0);
                ImageIcon iconoVer = new ImageIcon(verImg);
                lblVer.setIcon(iconoVer);

            } catch (MalformedURLException ex) {
                Logger.getLogger(FrmRegistarse.class.getName()).log(Level.SEVERE, null, ex);
            }
            estado = false;
        } else {

            try {
                URL imgVer = new URL("    https://cdn-icons-png.flaticon.com/512/8443/8443792.png ");
                Image verImg = new ImageIcon(imgVer).getImage().getScaledInstance(20, 20, 0);
                ImageIcon iconoVer = new ImageIcon(verImg);
                lblVer.setIcon(iconoVer);

            } catch (MalformedURLException ex) {
                Logger.getLogger(FrmRegistarse.class.getName()).log(Level.SEVERE, null, ex);
            }
            estado = true;
        }


    }//GEN-LAST:event_lblVerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vainilla.apariencia.BotonRedon btnRegis;
    private javax.swing.JPasswordField cajaContra;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblVer;
    private javax.swing.JPanel panelCuerpo;
    private com.vainilla.apariencia.PanelRedondeado panelRedondeado2;
    // End of variables declaration//GEN-END:variables
}
