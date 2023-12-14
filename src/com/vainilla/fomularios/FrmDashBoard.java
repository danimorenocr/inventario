
package com.vainilla.fomularios;

import static com.vainilla.fomularios.FrmPrincipal.escalarImagen;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
public class FrmDashBoard extends javax.swing.JInternalFrame {

    public FrmDashBoard() {
        initComponents();
        apariencia();
    }
    private void apariencia() {
        cargarImg();

//        panelRedondeado2.cambiarRadioEsquinas(150);
//        btnRegis.cambiarRadioEsquinas(20);
//        btnIniciar.cambiarRadioEsquinas(20);

//        btnRegis.setBackground(new Color(255,182,193));
//        btnRegis.setForeground(Color.WHITE);
    }

    private void cargarImg() {

//        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/com/vainilla/iconos/Bg.jpg"));
//        ImageIcon iconoEscalado = escalarImagen(iconoOriginal, 1600, 810);
//        lblBg.setIcon(iconoEscalado);
        try {
            URL imgU = new URL(" https://i.pinimg.com/564x/84/95/95/849595099caaaebf6de913aeb2c7119b.jpg");
            Image boxesImg = new ImageIcon(imgU).getImage().getScaledInstance(100, 100, 0);
            ImageIcon iconoBox = new ImageIcon(boxesImg);
            lblIconProduc.setIcon(iconoBox);
//            URL imgU = new URL(" factImgfactImg");
//            Image boxesImg = new ImageIcon(imgU).getImage().getScaledInstance(100, 100, 0);
//            ImageIcon iconoBox = new ImageIcon(boxesImg);
            lblIconProduc.setIcon(iconoBox);
            URL imgF = new URL(" https://i.pinimg.com/564x/a2/52/12/a252124709b3cb61358e0951b7b551e1.jpg");
            Image factImg = new ImageIcon(imgF).getImage().getScaledInstance(100, 100, 0);
            ImageIcon factBox = new ImageIcon(factImg);
            lblIconFact.setIcon(factBox);

        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnProduct = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblIconProduc = new javax.swing.JLabel();
        btnDetalle = new javax.swing.JButton();
        lblIconDet = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        lblIconFact = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCuerpo.setBackground(new java.awt.Color(225, 241, 255));
        panelCuerpo.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Fredoka", 0, 36)); // NOI18N
        jLabel1.setText("Bienvenid@");

        jLabel2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText(" ¡Comencemos a organizar tus productos para un mejor control y éxito empresarial!");

        btnProduct.setBackground(new java.awt.Color(255, 236, 97));
        btnProduct.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        btnProduct.setForeground(new java.awt.Color(89, 54, 2));
        btnProduct.setText("Agregar Producto");
        btnProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduct.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(132, 187, 191));

        btnDetalle.setBackground(new java.awt.Color(114, 90, 227));
        btnDetalle.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        btnDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalle.setText("Crear Detalle");
        btnDetalle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(79, 61, 162), 3, true));
        btnDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetalle.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        btnFacturar.setBackground(new java.awt.Color(168, 238, 242));
        btnFacturar.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(89, 54, 2));
        btnFacturar.setText("Facturar Pedido");
        btnFacturar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(132, 187, 191), 3, true));
        btnFacturar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFacturar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblIconProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconDet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(lblIconFact, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIconFact, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIconProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(85, 85, 85)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIconDet, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(441, Short.MAX_VALUE))
        );

        panelCuerpo.add(jPanel1);
        jPanel1.setBounds(6, 17, 1509, 770);

        getContentPane().add(panelCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacturarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIconDet;
    private javax.swing.JLabel lblIconFact;
    private javax.swing.JLabel lblIconProduc;
    private javax.swing.JPanel panelCuerpo;
    // End of variables declaration//GEN-END:variables
}
