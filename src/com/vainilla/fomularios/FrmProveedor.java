package com.vainilla.fomularios;

import com.vainilla.daos.DaoProveedor;
import com.vainilla.entidades.Proveedor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmProveedor extends javax.swing.JInternalFrame {

    private Integer codProveedor = null;
    Integer seleccionarBuscar = 0;

    private String titulos[] = {"Código", "Nombre", "Teléfono", "Ciudad", "Cantidad Productos", "Editar", "Eliminar"};

    private DefaultTableModel modeloTabla = new DefaultTableModel(titulos, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 5 || columnIndex == 6) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };

    public FrmProveedor() {
        initComponents();
        tablaDatos.setModel(modeloTabla);
        lblTotal.setText(armarLineaCantidad());
        cargarDatosProveed("");
    }

    private boolean verificarNombre(String nombre) {
        boolean existencia = true;

        List<Proveedor> arrayProv;
        DaoProveedor dao = new DaoProveedor();
        arrayProv = dao.buscarDato(nombre, "nombre");
        System.out.println("datos: " + arrayProv);

        if (arrayProv.isEmpty()) {
            existencia = false;
        }
        System.out.println("existencia: " + existencia);
        return existencia;
    }
    
    /*
    - BUSCA EN LA BASE DE DATOS LOS CARACTERES QUE INGRESE EL USUARIO
    - TRAE LOS DATOS DE CADA COLUMNA CORRESPONDIENTE
    */

    private void buscarDato(String dato, String campo) {
        List<Proveedor> arrayProv;
        modeloTabla.setNumRows(0);
        DaoProveedor dao = new DaoProveedor();

        String nomElim = "/com/vainilla/iconos/borrar.png";
        String rutaIconElim = this.getClass().getResource(nomElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconElim);

        String nomEdit = "/com/vainilla/iconos/editar.png";
        String rutaIconEdit = this.getClass().getResource(nomEdit).getPath();
        ImageIcon editarIcono = new ImageIcon(rutaIconEdit);

        arrayProv = dao.buscarDato(dato, campo);
        arrayProv.forEach((proveedor) -> {
            Object filita[] = new Object[7];

            filita[0] = proveedor.getCodProveedor();
            filita[1] = proveedor.getNombreProveedor();
            filita[2] = proveedor.getTelefonoProveedor();
            filita[3] = proveedor.getCiudadProveedor();
            filita[4] = proveedor.getCantProductos();
            filita[5] = editarIcono;
            filita[6] = borrarIcono;

            modeloTabla.addRow(filita);

        });
    }

    private void cargarDatosProveed(String ordencito) {

        List<Proveedor> arrayProv;
        DaoProveedor miDao = new DaoProveedor();
        String nomElim = "/com/vainilla/iconos/borrar.png";
        String rutaIconElim = this.getClass().getResource(nomElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconElim);

        String nomEdit = "/com/vainilla/iconos/editar.png";
        String rutaIconEdit = this.getClass().getResource(nomEdit).getPath();
        ImageIcon editarIcono = new ImageIcon(rutaIconEdit);

        modeloTabla.setNumRows(0);

        arrayProv = miDao.consultar(ordencito);

        arrayProv.forEach((proveedor) -> {
            Object filita[] = new Object[7];

            filita[0] = proveedor.getCodProveedor();
            filita[1] = proveedor.getNombreProveedor();
            filita[2] = proveedor.getTelefonoProveedor();
            filita[3] = proveedor.getCiudadProveedor();
            filita[4] = proveedor.getCantProductos();
            filita[5] = editarIcono;
            filita[6] = borrarIcono;

            modeloTabla.addRow(filita);

        });
        tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(350);
        tablaDatos.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaDatos.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(4).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(5).setPreferredWidth(50);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < (tablaDatos.getColumnCount() - 2); i++) {
            tablaDatos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

    }

    private int totalRegistros() {
        DaoProveedor dao = new DaoProveedor();
        int total = dao.totalRegistros();
        return total;
    }

    private String armarLineaCantidad() {
        String cadena = "Se encontraron " + totalRegistros() + " proveedores";
        return cadena;
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

    private boolean siElimino(Integer codigoProv) {
        int opcion;
        Boolean bandera = false;
        String textoBotones[] = {"Aceptar", "Cancelar"};
        DaoProveedor dao = new DaoProveedor();

        Proveedor objProv = dao.buscar(codigoProv);

        opcion = JOptionPane.showOptionDialog(panelCuerpo, "¿Esta seguro de elimnar el proveedor " + objProv.getNombreProveedor()
                + "?", "Aviso", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, textoBotones, textoBotones[1]);

        if (opcion == JOptionPane.YES_OPTION) {

            if (objProv.getCantProductos() > 0) {
                JOptionPane.showMessageDialog(panelCuerpo, "El proveedor contiene productos asociados, no se puede eliminar", "Información", JOptionPane.ERROR_MESSAGE);
                bandera = false;

            } else {
                bandera = true;
            }
        }

        return bandera;
    }

    private void borrarDatos() {
        cajaNombre.setText("");
        cajaCiudad.setText("");
        cajaTelefono.setText("");
        cajaNombre.requestFocus();
    }

    private String campoBuscar(int select) {
        System.out.println("indice: " + select);
        String campo = "";
        switch (select) {
            case 0 -> {
                campo = "cod_proveedor";
            }
            case 1 -> {
                campo = "nombre";
            }
            case 2 -> {
                campo = "telefono";
            }
            case 3 -> {
                campo = "ciudad";
            }

            default ->
                throw new AssertionError();
        }
        return campo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cajaTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cajaCiudad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        cajaBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        cmbOrdenar = new javax.swing.JComboBox<>();
        lblTotal = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();

        panelContenedor.setBackground(new java.awt.Color(225, 241, 255));
        panelContenedor.setLayout(null);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre:");

        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));

        jLabel5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Número de Teléfono: ");

        cajaTelefono.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaTelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));

        jLabel6.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Ciudad:");

        cajaCiudad.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaCiudad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Proveedores en lista");

        btnAgregar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 182, 193));

        jLabel7.setFont(new java.awt.Font("Fredoka", 0, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Proveedores");

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
        cajaBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
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

        lblMensaje.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMensaje.setText("¡Tus mejores productos a cargo de los mejores!");

        cmbOrdenar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        cmbOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar por:", "Ordenar por codigo", "Ordenar por nombre", "Ordenar por telefono", "Ordenar por ciudad" }));
        cmbOrdenar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        cmbOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenarActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("se encontraron * proveedores");

        cmbBuscar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Telefono", "Ciudad" }));
        cmbBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 182, 193), 3, true));
        cmbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelCuerpoLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(79, 79, 79)
                                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cajaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(110, 110, 110)
                                    .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelCuerpoLayout.createSequentialGroup()
                                            .addComponent(cajaCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(56, 56, 56)
                                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(cmbOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(171, 171, 171)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCuerpoLayout.createSequentialGroup()
                                .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCuerpoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(7, 7, 7)
                        .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(cajaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCuerpoLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(666, Short.MAX_VALUE)))
        );

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
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (estaTodoBien()) {
            String nombre = cajaNombre.getText().toUpperCase();
            String telefono = cajaTelefono.getText();
            String ciudad = cajaCiudad.getText().toUpperCase();

            DaoProveedor dao = new DaoProveedor();
            Proveedor objProveedor = new Proveedor(0, nombre, ciudad, telefono, 0);

            if (!verificarNombre(nombre)) {
                System.out.println("existe: " + verificarNombre(nombre));
                if (dao.registrar(objProveedor)) {
                    JOptionPane.showMessageDialog(panelCuerpo, "Registro Exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
                    borrarDatos();
                    cargarDatosProveed("");
                } else {
                    JOptionPane.showMessageDialog(panelCuerpo, "No se pudo registrar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "El proveedor ya ha sido registrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cajaBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyTyped

    }//GEN-LAST:event_cajaBuscarKeyTyped

    private void cajaBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarKeyReleased

        seleccionarBuscar = cmbBuscar.getSelectedIndex();
        String campoSelect = campoBuscar(seleccionarBuscar);
        System.out.println("campo: " + campoSelect);

        buscarDato("%" + cajaBuscar.getText().toUpperCase() + "%", campoSelect);


    }//GEN-LAST:event_cajaBuscarKeyReleased

    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        int columnaSeleccionada = tablaDatos.getSelectedColumn();
        DaoProveedor dao = new DaoProveedor();

        if (columnaSeleccionada == 5) {
            int filaSeleccionada = tablaDatos.getSelectedRow();
            String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
            codProveedor = Integer.valueOf(codTexto);
            Proveedor objProv = dao.buscar(codProveedor);

            FrmProveedorEditar floatante = new FrmProveedorEditar(null, true, objProv);
            floatante.setVisible(true);

            floatante.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cargarDatosProveed("");
                    lblTotal.setText(armarLineaCantidad());
                }

            });
        }

        if (columnaSeleccionada == 6) {
            int filaSeleccionada = tablaDatos.getSelectedRow();

            String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();

            codProveedor = Integer.valueOf(codTexto);

            DaoProveedor miDao = new DaoProveedor();
            Proveedor objProv = miDao.buscar(codProveedor);

            if (objProv == null) {
                JOptionPane.showMessageDialog(panelCuerpo, "No se encontró el proveedor", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {

                if (siElimino(codProveedor)) {
                    DaoProveedor miDaoElim = new DaoProveedor();
                    if (miDaoElim.eliminar(codProveedor)) {
                        cargarDatosProveed("");
                        lblTotal.setText(armarLineaCantidad());
                        JOptionPane.showMessageDialog(panelCuerpo, "Eliminación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panelCuerpo, "No se pudo eliminar el proveedor", "Información", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }


    }//GEN-LAST:event_tablaDatosMouseClicked

    private void cajaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscarActionPerformed

    private void cmbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuscarActionPerformed


    }//GEN-LAST:event_cmbBuscarActionPerformed

    private void cmbOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenarActionPerformed
        Integer seleccionarOrden = cmbOrdenar.getSelectedIndex();
        switch (seleccionarOrden) {
            case 0 -> {
                JOptionPane.showMessageDialog(panelCuerpo, "Seleccione un orden", "Información", JOptionPane.ERROR_MESSAGE);
            }
            case 1 -> {
                cargarDatosProveed("cod_proveedor");
            }
            case 2 -> {
                cargarDatosProveed("nombre");
            }
            case 3 -> {
                cargarDatosProveed("telefono");
            }
            case 4 -> {
                cargarDatosProveed("ciudad");
            }
            default ->
                throw new AssertionError();
        }
    }//GEN-LAST:event_cmbOrdenarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaCiudad;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaTelefono;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbOrdenar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
