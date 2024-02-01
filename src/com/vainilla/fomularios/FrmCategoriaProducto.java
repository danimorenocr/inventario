package com.vainilla.fomularios;

import com.vainilla.daos.DaoCategoriaProducto;
import com.vainilla.entidades.CategoriaProducto;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmCategoriaProducto extends javax.swing.JDialog {

    private Integer codCategoria = null;
    Integer seleccionarBuscar = 0;

    private String titulos[] = {"Código", "Nombre", "Cant Productos"};

    private DefaultTableModel modeloTabla = new DefaultTableModel(titulos, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    public FrmCategoriaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tablaDatos.setModel(modeloTabla);
        cargarDatosCat("");
        lblTotal.setText(armarLineaCantidad());
        actualizarDisabled();
        cmbBuscar.setSelectedIndex(1);

    }

    private int totalRegistros() {
        DaoCategoriaProducto dao = new DaoCategoriaProducto();
        int total = dao.totalRegistros();
        return total;
    }

    private String armarLineaCantidad() {
        String cadena = "Se encontraron " + totalRegistros() + " categorias";
        return cadena;
    }

    private Boolean estaTodoBien() {
        Boolean bandera = true;
        String nombre = cajaNombre.getText();

        if (nombre.equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(panelCuerpo, "Digite el nombre del proveedor",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            cajaNombre.requestFocus();

        }
        return bandera;
    }

    //VERIFICA QUE EL NOMBRE DE LA CATEGORIA A AÑADIR NO ESTE EN LA BASE DE DATOS
    private boolean verificarNombre(String nombre) {
        boolean existencia = true;

        List<CategoriaProducto> arrayCat;
        DaoCategoriaProducto dao = new DaoCategoriaProducto();
        arrayCat = dao.buscarDato(nombre, "nombre");
        System.out.println("datos: " + arrayCat);

        if (arrayCat.isEmpty()) {
            existencia = false;
        }
        System.out.println("existencia: " + existencia);
        return existencia;
    }

    private void borrarDatos() {
        cajaNombre.setText("");
        cajaNombre.requestFocus();
    }

    private void cargarDatosCat(String ordencito) {

        List<CategoriaProducto> arrayCat;
        DaoCategoriaProducto miDao = new DaoCategoriaProducto();

        modeloTabla.setNumRows(0);

        arrayCat = miDao.consultar(ordencito);

        arrayCat.forEach((cat) -> {
            Object filita[] = new Object[4];

            filita[0] = cat.getCodCategoria();
            filita[1] = cat.getNombreCategoria();
            filita[2] = cat.getCantProductos();

            modeloTabla.addRow(filita);

        });

        //DEFINE EL TAMAÑO DE CADA COLUMNA
        tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(350);
        tablaDatos.getColumnModel().getColumn(2).setPreferredWidth(50);

        // CENTRA LOS TITULOS DE CADA COLUMNA, MENOS LOS ICONOS
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < (tablaDatos.getColumnCount()); i++) {
            tablaDatos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

    }

    // SE ELIGE EN QUE COLUMNA SE QUIERE APLICAR LA CONSULTA SQL
    private String campoBuscar(int select) {
        System.out.println("indice: " + select);
        String campo = "";
        switch (select) {
            case 0 -> {
                campo = "cod_categoria";
            }
            case 1 -> {
                campo = "nombre";
            }
            default ->
                throw new AssertionError();
        }
        return campo;
    }

    private void buscarDato(String dato, String campo) {

        List<CategoriaProducto> arrayCat;
        DaoCategoriaProducto dao = new DaoCategoriaProducto();

        modeloTabla.setNumRows(0);

        arrayCat = dao.buscarDato(dato, campo);
        arrayCat.forEach((cat) -> {
            Object filita[] = new Object[3];

            filita[0] = cat.getCodCategoria();
            filita[1] = cat.getNombreCategoria();
            filita[2] = cat.getCantProductos();

            modeloTabla.addRow(filita);

        });
    }

    private boolean siElimino(Integer codigoCat) {
        int opcion;
        Boolean bandera = false;
        String textoBotones[] = {"Aceptar", "Cancelar"};
        DaoCategoriaProducto dao = new DaoCategoriaProducto();

        CategoriaProducto objCat = dao.buscar(codigoCat);

        opcion = JOptionPane.showOptionDialog(panelCuerpo, "¿Esta seguro de elimnar la categoria " + objCat.getNombreCategoria()
                + "?", "Aviso", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {

            if (objCat.getCantProductos() > 0) {
                JOptionPane.showMessageDialog(panelCuerpo, "La categoria contiene productos asociados, no se puede eliminar", "Información", JOptionPane.ERROR_MESSAGE);
                bandera = false;

            } else {
                bandera = true;
            }
        }

        return bandera;
    }

    private void actualizarDisabled() {
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnCancelar.setEnabled(true);

    }

    private void actualizarEnabled() {
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        cajaBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbOrdenar = new javax.swing.JComboBox<>();
        lblTotal = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelContenedor.setBackground(new java.awt.Color(255, 249, 204));
        panelContenedor.setLayout(null);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre:");

        cajaNombre.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Categorias en lista");

        jLabel7.setFont(new java.awt.Font("Fredoka", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 217, 8));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Categorias de los Productos");

        tablaDatos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaDatos.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
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

        jLabel8.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Buscar:");

        cmbOrdenar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        cmbOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar por:", "Codigo", "Nombre" }));
        cmbOrdenar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cmbOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenarActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("se encontraron * categorias");

        cmbBuscar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre" }));
        cmbBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cmbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuscarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(242, 223, 91));

        btnEliminar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        panelCuerpoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cajaBuscar, cmbBuscar});

        panelContenedor.add(panelCuerpo);
        panelCuerpo.setBounds(20, 20, 1480, 790);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1511, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        DaoCategoriaProducto dao = new DaoCategoriaProducto();

        int filaSeleccionada = tablaDatos.getSelectedRow();
        String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
        codCategoria = Integer.valueOf(codTexto);
        CategoriaProducto objCat = dao.buscar(codCategoria);

        cajaNombre.setText(objCat.getNombreCategoria());
        actualizarEnabled();


    }//GEN-LAST:event_tablaDatosMouseClicked

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void cajaBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyReleased
// SE REALIZA LA CONSULTA DE BUSCAR SEGUN LO QUE EL USUARIO DIGITE EN LA CAJA
        seleccionarBuscar = cmbBuscar.getSelectedIndex();
        String campoSelect = campoBuscar(seleccionarBuscar);
        System.out.println("campo: " + campoSelect);

        buscarDato("%" + cajaBuscar.getText().toUpperCase() + "%", campoSelect);
    }//GEN-LAST:event_cajaBuscarKeyReleased

    private void cajaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyTyped

    }//GEN-LAST:event_cajaBuscarKeyTyped

    private void cmbOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenarActionPerformed
        Integer seleccionarOrden = cmbOrdenar.getSelectedIndex();
        switch (seleccionarOrden) {
            case 0 -> {
                JOptionPane.showMessageDialog(panelCuerpo, "Seleccione un orden", "Información", JOptionPane.ERROR_MESSAGE);
            }
            case 1 -> {
                cargarDatosCat("cod_categoria");
            }
            case 2 -> {
                cargarDatosCat("nombre");
            }

            default ->
                throw new AssertionError();
        }
    }//GEN-LAST:event_cmbOrdenarActionPerformed

    private void cmbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuscarActionPerformed

    }//GEN-LAST:event_cmbBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (estaTodoBien()) {
            String nombre = cajaNombre.getText().toUpperCase();

            DaoCategoriaProducto dao = new DaoCategoriaProducto();
            CategoriaProducto objCat = new CategoriaProducto(0, nombre, 0);

            if (!verificarNombre(nombre)) {
                System.out.println("existe: " + verificarNombre(nombre));
                if (dao.registrar(objCat)) {
                    JOptionPane.showMessageDialog(panelCuerpo, "Registro Exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
                    borrarDatos();
                    cargarDatosCat("");
                    lblTotal.setText(armarLineaCantidad());
                } else {
                    JOptionPane.showMessageDialog(panelCuerpo, "No se pudo registrar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "El proveedor ya ha sido registrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int filaSeleccionada = tablaDatos.getSelectedRow();

        String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();

        codCategoria = Integer.valueOf(codTexto);

        DaoCategoriaProducto miDao = new DaoCategoriaProducto();
        CategoriaProducto objCat = miDao.buscar(codCategoria);

        if (objCat == null) {
            JOptionPane.showMessageDialog(panelCuerpo, "No se encontró el proveedor", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {

            if (siElimino(codCategoria)) {
                DaoCategoriaProducto daoElim = new DaoCategoriaProducto();
                if (daoElim.eliminar(codCategoria)) {
                    cargarDatosCat("");
                    lblTotal.setText(armarLineaCantidad());
                    borrarDatos();
                    actualizarDisabled();
                    JOptionPane.showMessageDialog(panelCuerpo, "Eliminación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panelCuerpo, "No se pudo eliminar el proveedor", "Información", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        borrarDatos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (estaTodoBien()) {
            int filaSeleccionada = tablaDatos.getSelectedRow();
            String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
            codCategoria = Integer.valueOf(codTexto);

            String nombre = cajaNombre.getText().toUpperCase();
            DaoCategoriaProducto dao = new DaoCategoriaProducto();
            CategoriaProducto objCat = new CategoriaProducto();

            if (!verificarNombre(nombre)) {
                System.out.println("verificar: " + verificarNombre(nombre));
                objCat.setNombreCategoria(nombre);
                objCat.setCodCategoria(codCategoria);
                System.out.println("nombre: " + nombre);
                if (dao.actualizar(objCat)) {
                    borrarDatos();
                    cargarDatosCat("");
                    JOptionPane.showMessageDialog(panelCuerpo, "La categoria fue actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panelCuerpo, "No se pudo actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "La categoria ya ha sido registrada con ese nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCategoriaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCategoriaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCategoriaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCategoriaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCategoriaProducto dialog = new FrmCategoriaProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbOrdenar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
