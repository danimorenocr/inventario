package com.vainilla.fomularios;

import com.vainilla.daos.DaoProducto;
import com.vainilla.entidades.Producto;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmProductoList extends javax.swing.JInternalFrame {

    private Integer codProducto = null;
    Integer seleccionarBuscar = 0;

    private String titulos[] = {"Código",
        "Nombre",
        "Stock",
        "Costo ud + envio",
        "Costo envio",
        "Costo ud",
        "Costo Caja",
        "# Caja",
        "# ud Caja",
        "Fecha vencimiento",
        "Proveedor",
        "Categoria",
        "$ Total Compra",
        "Fecha Compra",
        "Costo Final",
        "Tamaño",
        "Costo x Metro",
        "Editar", "Eliminar"};
    private DefaultTableModel modeloTabla = new DefaultTableModel(titulos, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 18 || columnIndex == 19) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };

    public FrmProductoList() {
        initComponents();
        tablaDatos.setModel(modeloTabla);
        cargarDatosProducto("");
    }

    private void cargarDatosProducto(String ordencito) {

        List<Producto> arrayProv;
        DaoProducto miDao = new DaoProducto();
        String nomElim = "/com/vainilla/iconos/borrar.png";
        String rutaIconElim = this.getClass().getResource(nomElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconElim);

        String nomEdit = "/com/vainilla/iconos/editar.png";
        String rutaIconEdit = this.getClass().getResource(nomEdit).getPath();
        ImageIcon editarIcono = new ImageIcon(rutaIconEdit);

        modeloTabla.setNumRows(0);

        arrayProv = miDao.consultar(ordencito);

        arrayProv.forEach((producto) -> {
            Object filita[] = new Object[19];

            filita[0] = producto.getCodProducto();
            filita[1] = producto.getNombreProducto();
            filita[2] = producto.getStock();
            filita[3] = producto.getPrecioUnidadEnvio();
            filita[4] = producto.getEnvio();
            filita[5] = producto.getPrecioUnidad();
            filita[6] = producto.getPrecioCaja();
            filita[7] = producto.getNumeroCajas();
            filita[8] = producto.getUnidadPorCaja();
            filita[9] = producto.getFechaVencimiento();
            filita[10] = producto.getCodProveedor().getNombreProveedor();
            filita[11] = producto.getCodCategoriaProducto().getNombreCategoria();
            filita[12] = producto.getPrecioTotalCompra();
            filita[13] = producto.getFechaCompra();
            filita[14] = producto.getPrecioFinal();
            filita[15] = producto.getTamanno();
            filita[16] = producto.getPrecioMetro();
            filita[17] = editarIcono;
            filita[18] = borrarIcono;

            modeloTabla.addRow(filita);

        });
        tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(3).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(4).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(5).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(6).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(7).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(8).setPreferredWidth(65);
        tablaDatos.getColumnModel().getColumn(9).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(10).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(11).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(12).setPreferredWidth(65);
        tablaDatos.getColumnModel().getColumn(13).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(14).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(15).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(16).setPreferredWidth(100);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < (tablaDatos.getColumnCount() - 2); i++) {
            tablaDatos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelContenedor = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        cajaBuscar = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 249, 204));

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Fredoka", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 217, 8));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de Productos");

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Proveedores en lista");

        jLabel8.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Buscar por:");

        cmbBuscar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Telefono", "Ciudad" }));
        cmbBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cmbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuscarActionPerformed(evt);
            }
        });

        cajaBuscar.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscarActionPerformed(evt);
            }
        });
        cajaBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaBuscarKeyTyped(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("se encontraron * productos");

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

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelContenedorLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal))))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuscarActionPerformed

    }//GEN-LAST:event_cmbBuscarActionPerformed

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void cajaBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyReleased

        //        seleccionarBuscar = cmbBuscar.getSelectedIndex();
        //        String campoSelect = campoBuscar(seleccionarBuscar);
        //        System.out.println("campo: " + campoSelect);
        //
        //        buscarDato("%" + cajaBuscar.getText().toUpperCase() + "%", campoSelect);
    }//GEN-LAST:event_cajaBuscarKeyReleased

    private void cajaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyTyped

    }//GEN-LAST:event_cajaBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
