package com.vainilla.fomularios;

public class FrmProducto extends javax.swing.JInternalFrame {

    public FrmProducto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCat = new javax.swing.JComboBox<>();
        cmbCat1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cajaNombre1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        panelStock = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cajaNombre2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cajaNombre3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cajaNombre4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelCajas = new javax.swing.JPanel();
        cajaNombre5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cajaNombre6 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cajaNombre7 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cajaNombre8 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Fredoka Medium", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(248, 217, 8));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Productos");

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre:");

        cajaNombre.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Categoria:");

        cmbCat.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cmbCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoria:" }));
        cmbCat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        cmbCat1.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cmbCat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el proveedor:" }));
        cmbCat1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel6.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Proveedor:");

        cajaNombre1.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre1.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel7.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Envio:");

        jLabel8.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Fecha de Compra:");

        jDateChooser1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel9.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Fecha de Vencimiento:");

        jDateChooser2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        panelStock.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Stock:");

        cajaNombre2.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel11.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Precio por unidad:");

        cajaNombre3.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre3.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel12.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Tamaño:");

        cajaNombre4.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel13.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Precio Acumulado:");

        jLabel14.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("10");

        javax.swing.GroupLayout panelStockLayout = new javax.swing.GroupLayout(panelStock);
        panelStock.setLayout(panelStockLayout);
        panelStockLayout.setHorizontalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStockLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cajaNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelStockLayout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14))
                        .addComponent(cajaNombre3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelStockLayout.setVerticalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStockLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel10)
                .addGap(7, 7, 7)
                .addComponent(cajaNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(7, 7, 7)
                .addComponent(cajaNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(47, 47, 47)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(cajaNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        panelCajas.setBackground(new java.awt.Color(255, 251, 227));

        cajaNombre5.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel15.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Número de cajas:");

        cajaNombre6.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre6.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel16.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Unidades por caja:");

        jLabel18.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("10");

        jLabel17.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Total unidades:");

        cajaNombre7.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre7.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel19.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Precio de la Caja:");

        cajaNombre8.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre8.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel20.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Precio por unidad:");

        jLabel21.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Precio Acumulado:");

        jLabel22.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("10");

        javax.swing.GroupLayout panelCajasLayout = new javax.swing.GroupLayout(panelCajas);
        panelCajas.setLayout(panelCajasLayout);
        panelCajasLayout.setHorizontalGroup(
            panelCajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCajasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCajasLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18))
                    .addGroup(panelCajasLayout.createSequentialGroup()
                        .addGroup(panelCajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cajaNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(panelCajasLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22)))
                .addContainerGap())
        );
        panelCajasLayout.setVerticalGroup(
            panelCajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCajasLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel15)
                .addGap(7, 7, 7)
                .addComponent(cajaNombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(7, 7, 7)
                .addComponent(cajaNombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelCajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(7, 7, 7)
                .addComponent(cajaNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(7, 7, 7)
                .addComponent(cajaNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelCajasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Precio Acumulado:");

        jLabel24.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("10");

        btnAgregar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnAgregar.setText("Crear");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCategoria.setBackground(new java.awt.Color(255, 249, 204));
        btnCategoria.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnCategoria.setText("+");
        btnCategoria.setAlignmentY(0.0F);
        btnCategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnProveedor.setBackground(new java.awt.Color(255, 249, 204));
        btnProveedor.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnProveedor.setText("+");
        btnProveedor.setAlignmentY(0.0F);
        btnProveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCat1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaNombre)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCat, 0, 314, Short.MAX_VALUE)
                            .addComponent(cajaNombre1)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addComponent(panelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(623, 623, 623)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addComponent(panelCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );

        panelCuerpoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cajaNombre, cmbCat});

        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(panelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(68, 68, 68))))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addComponent(cajaNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        panelCuerpoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cajaNombre, cmbCat});

        panelCuerpoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cajaNombre1, jDateChooser1});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
//        if (estaTodoBien()) {
//            String nombre = cajaNombre.getText().toUpperCase();
//            String telefono = cajaTelefono.getText();
//            String ciudad = cajaCiudad.getText().toUpperCase();
//
//            DaoProveedor dao = new DaoProveedor();
//            Proveedor objProveedor = new Proveedor(0, nombre, ciudad, telefono, 0);
//
//            if (!verificarNombre(nombre)) {
//                System.out.println("existe: " + verificarNombre(nombre));
//                if (dao.registrar(objProveedor)) {
//                    JOptionPane.showMessageDialog(panelCuerpo, "Registro Exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
//                    borrarDatos();
//                    cargarDatosProveed("");
//                } else {
//                    JOptionPane.showMessageDialog(panelCuerpo, "No se pudo registrar", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {
//                JOptionPane.showMessageDialog(panelCuerpo, "El proveedor ya ha sido registrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
//            }
//
//        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        FrmCategoriaProducto windowCat = new FrmCategoriaProducto(null, true);
        windowCat.setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaNombre1;
    private javax.swing.JTextField cajaNombre2;
    private javax.swing.JTextField cajaNombre3;
    private javax.swing.JTextField cajaNombre4;
    private javax.swing.JTextField cajaNombre5;
    private javax.swing.JTextField cajaNombre6;
    private javax.swing.JTextField cajaNombre7;
    private javax.swing.JTextField cajaNombre8;
    private javax.swing.JComboBox<String> cmbCat;
    private javax.swing.JComboBox<String> cmbCat1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelCajas;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelStock;
    // End of variables declaration//GEN-END:variables
}
