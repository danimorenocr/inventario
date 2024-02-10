package com.vainilla.fomularios;

import com.vainilla.daos.DaoProducto;
import com.vainilla.entidades.Producto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
            if (columnIndex == 17 || columnIndex == 18) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };

    public FrmProductoList() {
        initComponents();
        tablaDatos.setModel(modeloTabla);
        cargarDatosProducto("");
        cmbBuscar.setSelectedIndex(10);
        lblTotal.setText(armarLineaCantidad());
    }

    private int totalRegistros() {
        DaoProducto dao = new DaoProducto();
        int total = dao.totalRegistros();
        return total;
    }

    private String armarLineaCantidad() {
        String cadena = "Se encontraron " + totalRegistros() + " productos";
        return cadena;
    }

    private void cargarDatosProducto(String ordencito) {

        List<Producto> arrayProd;
        DaoProducto miDao = new DaoProducto();
        String nomElim = "/com/vainilla/iconos/borrar.png";
        String rutaIconElim = this.getClass().getResource(nomElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconElim);

        String nomEdit = "/com/vainilla/iconos/editar.png";
        String rutaIconEdit = this.getClass().getResource(nomEdit).getPath();
        ImageIcon editarIcono = new ImageIcon(rutaIconEdit);

        modeloTabla.setNumRows(0);

        arrayProd = miDao.consultar(ordencito);

        arrayProd.forEach((producto) -> {
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

    private String campoBuscar(int select) {
        System.out.println("indice: " + select);
        String campo = "";
        switch (select) {
            case 0 -> {
                campo = "c.nombre_categoria";
            }
            case 1 -> {
                campo = "cod_producto";
            }
            case 2 -> {
                campo = "precio_caja";
            }
            case 3 -> {
                campo = "envio";
            }
            case 4 -> {
                campo = "precio_unidad";
            }
            case 5 -> {
                campo = "precio_unidad_con_envio";
            }
            case 6 -> {
                campo = "precio_fina";
            }
            case 7 -> {
                campo = "precio_total_compra";
            }
            case 8 -> {
                campo = "fecha_compra";
            }
            case 9 -> {
                campo = "fecha_vencimiento";
            }
            case 10 -> {
                campo = "nombre_producto";
            }
            case 11 -> {
                campo = "num_cajas";
            }
            case 12 -> {
                campo = "precioMetro";
            }
            case 13 -> {
                campo = "s.nombre_proveedor";
            }
            case 14 -> {
                campo = "stock";
            }
            case 15 -> {
                campo = "tamanno";
            }
            case 16 -> {
                campo = "num_unidad_cajas";
            }
            default ->
                throw new AssertionError();
        }
        return campo;
    }

    private void buscarDato(String dato, String campo) {

        List<Producto> arrayProv;
        DaoProducto miDao = new DaoProducto();
        String nomElim = "/com/vainilla/iconos/borrar.png";
        String rutaIconElim = this.getClass().getResource(nomElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconElim);

        String nomEdit = "/com/vainilla/iconos/editar.png";
        String rutaIconEdit = this.getClass().getResource(nomEdit).getPath();
        ImageIcon editarIcono = new ImageIcon(rutaIconEdit);

        modeloTabla.setNumRows(0);

        arrayProv = miDao.buscarDato(dato, campo);

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

    private boolean siElimino(Integer codigoProd) {
        int opcion;
        Boolean bandera = false;
        String textoBotones[] = {"Aceptar", "Cancelar"};
        DaoProducto dao = new DaoProducto();

        Producto objProd = dao.buscar(codigoProd);

        opcion = JOptionPane.showOptionDialog(panelCuerpo, "¿Esta seguro de elimnar el producto " + objProd.getNombreProducto()
                + "?", "Aviso", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {

            bandera = true;

        }

        return bandera;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        cajaBuscar = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 249, 204));

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

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
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Codigo", "Costo de la caja", "Costo del envio", "Costo de la unidad", "Costo unidad + envio", "Costo final", "Costo total de la compra", "Fecha de compra", "Fecha de vencimiento", "Nombre", "Numero de cajas", "Precio x metro", "Proveedor", "Stock", "Tamaño", "Unidades por caja" }));
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
        tablaDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
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
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Integer seleccionarOrden = cmbBuscar.getSelectedIndex();
        switch (seleccionarOrden) {
            case 0 -> {
                cargarDatosProducto("cod_categoria");
            }
            case 1 -> {
                cargarDatosProducto("cod_producto");
            }
            case 2 -> {
                cargarDatosProducto("precio_caja");
            }
            case 3 -> {
                cargarDatosProducto("envio");
            }
            case 4 -> {
                cargarDatosProducto("precio_unidad");
            }
            case 5 -> {
                cargarDatosProducto("precio_unidad_con_envio");
            }
            case 6 -> {
                cargarDatosProducto("precio_final");
            }
            case 7 -> {
                cargarDatosProducto("precio_total_compra");
            }
            case 8 -> {
                cargarDatosProducto("fecha_compra");
            }
            case 9 -> {
                cargarDatosProducto("fecha_vencimiento");
            }
            case 10 -> {
                cargarDatosProducto("nombre_producto");
            }
            case 11 -> {
                cargarDatosProducto("num_cajas");
            }
            case 12 -> {
                cargarDatosProducto("precioMetro");
            }
            case 13 -> {
                cargarDatosProducto("cod_proveedor");
            }
            case 14 -> {
                cargarDatosProducto("stock");
            }
            case 15 -> {
                cargarDatosProducto("tamanno");
            }
            case 16 -> {
                cargarDatosProducto("num_unidad_cajas");
            }
            default ->
                throw new AssertionError();
        }

    }//GEN-LAST:event_cmbBuscarActionPerformed

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void cajaBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyReleased
        seleccionarBuscar = cmbBuscar.getSelectedIndex();
        String campoSelect = campoBuscar(seleccionarBuscar);
        System.out.println("campo: " + campoSelect);

        buscarDato("%" + cajaBuscar.getText().toUpperCase() + "%", campoSelect);
    }//GEN-LAST:event_cajaBuscarKeyReleased

    private void cajaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyTyped

    }//GEN-LAST:event_cajaBuscarKeyTyped

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        int columnaSeleccionada = tablaDatos.getSelectedColumn();

        if (columnaSeleccionada == 17) {
            int filaSeleccionada = tablaDatos.getSelectedRow();
            String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
            codProducto = Integer.valueOf(codTexto);

            DaoProducto dao = new DaoProducto();
            Producto objProd = dao.buscar(codProducto);

            FrmProductoEditar floatante = new FrmProductoEditar(null, true, objProd);
            floatante.setVisible(true);

            floatante.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cargarDatosProducto("");
                    lblTotal.setText(armarLineaCantidad());
                }

            });
        }

        if (columnaSeleccionada == 18) {
            int filaSeleccionada = tablaDatos.getSelectedRow();

            String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();

            codProducto = Integer.valueOf(codTexto);

            DaoProducto dao = new DaoProducto();
            Producto objProd = dao.buscar(codProducto);

            if (objProd == null) {
                JOptionPane.showMessageDialog(panelCuerpo, "No se encontró el producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                if (siElimino(codProducto)) {
                    DaoProducto daoElim = new DaoProducto();
                    if (daoElim.eliminar(codProducto)) {
                        cargarDatosProducto("");
                        lblTotal.setText(armarLineaCantidad());
                        JOptionPane.showMessageDialog(panelCuerpo, "Eliminación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panelCuerpo, "No se pudo eliminar el producto", "Información", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }
    }//GEN-LAST:event_tablaDatosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
