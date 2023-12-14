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

            URL imgDet = new URL(" https://i.pinimg.com/564x/cf/51/a7/cf51a7c4bc854f7d93338921e6997975.jpg");
            Image detImg = new ImageIcon(imgDet).getImage().getScaledInstance(100, 100, 0);
            ImageIcon iconoDet = new ImageIcon(detImg);
            lblIconDet.setIcon(iconoDet);

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
        panelContenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnProduct = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblIconProduc = new javax.swing.JLabel();
        btnDetalle = new javax.swing.JButton();
        lblIconDet = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        lblIconFact = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnVerMas = new javax.swing.JButton();
        lblIconVer = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCuerpo.setBackground(new java.awt.Color(225, 241, 255));
        panelCuerpo.setLayout(null);

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 36)); // NOI18N
        jLabel3.setText("Productos en Stock");

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaDatos);

        jLabel5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("¡Recuerda abastecerte para satisfacer la demanda!");

        btnVerMas.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnVerMas.setText("Ver más");
        btnVerMas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(42, 198, 182), 2, true));
        btnVerMas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblIconProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(lblIconDet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconFact, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblIconVer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(736, 736, 736))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIconFact, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconDet, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIconVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(btnVerMas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCuerpo.add(panelContenedor);
        panelContenedor.setBounds(6, 7, 1520, 780);

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
    private javax.swing.JButton btnVerMas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIconDet;
    private javax.swing.JLabel lblIconFact;
    private javax.swing.JLabel lblIconProduc;
    private javax.swing.JLabel lblIconVer;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
