package com.vainilla.fomularios;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class FrmLogin extends javax.swing.JInternalFrame {

    public FrmLogin() {
        initComponents();
        apariencia();
    }
    
    
     private void apariencia() {

        panelRedondeado2.cambiarRadioEsquinas(150);
        btnRegis.cambiarRadioEsquinas(20);

//        btnRegis.setBackground(new Color(255,182,193));
//        btnRegis.setForeground(Color.WHITE);
    }
    
        
        
          
    

    public static ImageIcon escalarImagen(ImageIcon imagenOriginal, int ancho, int alto) {
        Image imagen = imagenOriginal.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimensionada);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        panelRedondeado2 = new com.vainilla.apariencia.PanelRedondeado();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnRegis = new com.vainilla.apariencia.BotonRedon();

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

        jTextField1.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        panelRedondeado2.add(jTextField1);
        jTextField1.setBounds(80, 420, 420, 40);

        jTextField2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        panelRedondeado2.add(jTextField2);
        jTextField2.setBounds(80, 290, 420, 40);

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Usuario");
        panelRedondeado2.add(jLabel4);
        jLabel4.setBounds(80, 260, 240, 23);

        panelCuerpo.add(panelRedondeado2);
        panelRedondeado2.setBounds(520, 130, 560, 570);

        btnRegis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        btnRegis.setText("Registrarse");
        btnRegis.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        panelCuerpo.add(btnRegis);
        btnRegis.setBounds(670, 730, 290, 50);

        getContentPane().add(panelCuerpo);
        panelCuerpo.setBounds(0, 0, 1520, 854);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vainilla.apariencia.BotonRedon btnRegis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelCuerpo;
    private com.vainilla.apariencia.PanelRedondeado panelRedondeado2;
    // End of variables declaration//GEN-END:variables
}
