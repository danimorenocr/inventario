package com.vainilla.fomularios;

import com.vainilla.daos.DaoCategoriaProducto;
import com.vainilla.daos.DaoProveedor;
import com.vainilla.entidades.CategoriaProducto;
import com.vainilla.entidades.Proveedor;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmCategoriaProducto extends javax.swing.JDialog {

    private Integer codProveedor = null;
    Integer seleccionarBuscar = 0;

    private String titulos[] = {"Código", "Nombre", "Editar", "Eliminar"};

    private DefaultTableModel modeloTabla = new DefaultTableModel(titulos, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 2 || columnIndex == 3) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };

    public FrmCategoriaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tablaDatos.setModel(modeloTabla);
        cargarDatosCat("");
        lblTotal.setText(armarLineaCantidad());

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

        String nomElim = "/com/vainilla/iconos/borrar.png";
        String rutaIconElim = this.getClass().getResource(nomElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconElim);

        String nomEdit = "/com/vainilla/iconos/editar.png";
        String rutaIconEdit = this.getClass().getResource(nomEdit).getPath();
        ImageIcon editarIcono = new ImageIcon(rutaIconEdit);

        modeloTabla.setNumRows(0);

        arrayCat = miDao.consultar(ordencito);

        arrayCat.forEach((cat) -> {
            Object filita[] = new Object[4];

            filita[0] = cat.getCodCategoria();
            filita[1] = cat.getNombreCategoria();
            filita[2] = editarIcono;
            filita[3] = borrarIcono;

            modeloTabla.addRow(filita);

        });

        //DEFINE EL TAMAÑO DE CADA COLUMNA
        tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(350);

        // CENTRA LOS TITULOS DE CADA COLUMNA, MENOS LOS ICONOS
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < (tablaDatos.getColumnCount() - 2); i++) {
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

        String nomElim = "/com/vainilla/iconos/borrar.png";
        String rutaIconElim = this.getClass().getResource(nomElim).getPath();
        ImageIcon borrarIcono = new ImageIcon(rutaIconElim);

        String nomEdit = "/com/vainilla/iconos/editar.png";
        String rutaIconEdit = this.getClass().getResource(nomEdit).getPath();
        ImageIcon editarIcono = new ImageIcon(rutaIconEdit);

        modeloTabla.setNumRows(0);

        arrayCat = dao.buscarDato(dato, campo);
        arrayCat.forEach((cat) -> {
            Object filita[] = new Object[4];

            filita[0] = cat.getCodCategoria();
            filita[1] = cat.getNombreCategoria();
            filita[2] = editarIcono;
            filita[3] = borrarIcono;

            modeloTabla.addRow(filita);

        });
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
        panelContenedor1 = new javax.swing.JPanel();
        panelCuerpo1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cajaNombre1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDatos1 = new javax.swing.JTable();
        cajaBuscar1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbOrdenar1 = new javax.swing.JComboBox<>();
        lblTotal1 = new javax.swing.JLabel();
        cmbBuscar1 = new javax.swing.JComboBox<>();
        btnAgregar1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

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
        btnAgregar.setText("Crear");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(242, 223, 91));

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(cmbOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
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
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        panelContenedor.add(panelCuerpo);
        panelCuerpo.setBounds(20, 20, 1480, 790);

        panelContenedor1.setBackground(new java.awt.Color(255, 249, 204));
        panelContenedor1.setLayout(null);

        panelCuerpo1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nombre:");

        cajaNombre1.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre1.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel6.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Categorias en lista");

        jLabel9.setFont(new java.awt.Font("Fredoka", 0, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 217, 8));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Categorias de los Productos");

        tablaDatos1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaDatos1.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        tablaDatos1.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDatos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaDatos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDatos1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDatos1);

        cajaBuscar1.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaBuscar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaBuscar1ActionPerformed(evt);
            }
        });
        cajaBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaBuscar1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaBuscar1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Buscar:");

        cmbOrdenar1.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        cmbOrdenar1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordenar por:", "Ordenar por codigo", "Ordenar por nombre", "Ordenar por telefono", "Ordenar por ciudad" }));
        cmbOrdenar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cmbOrdenar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenar1ActionPerformed(evt);
            }
        });

        lblTotal1.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        lblTotal1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal1.setText("se encontraron * categorias");

        cmbBuscar1.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        cmbBuscar1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Telefono", "Ciudad" }));
        cmbBuscar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cmbBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuscar1ActionPerformed(evt);
            }
        });

        btnAgregar1.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnAgregar1.setText("Crear");
        btnAgregar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(242, 223, 91));

        javax.swing.GroupLayout panelCuerpo1Layout = new javax.swing.GroupLayout(panelCuerpo1);
        panelCuerpo1.setLayout(panelCuerpo1Layout);
        panelCuerpo1Layout.setHorizontalGroup(
            panelCuerpo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpo1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelCuerpo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(panelCuerpo1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(cmbOrdenar1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCuerpo1Layout.createSequentialGroup()
                        .addComponent(cajaBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cmbBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCuerpo1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        panelCuerpo1Layout.setVerticalGroup(
            panelCuerpo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpo1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(panelCuerpo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cajaNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCuerpo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbOrdenar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cmbBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        panelContenedor1.add(panelCuerpo1);
        panelCuerpo1.setBounds(20, 20, 1490, 790);

        panelContenedor.add(panelContenedor1);
        panelContenedor1.setBounds(0, 0, 0, 0);

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
//        int columnaSeleccionada = tablaDatos.getSelectedColumn();
//        DaoProveedor dao = new DaoProveedor();
//
//        if (columnaSeleccionada == 5) {
//            int filaSeleccionada = tablaDatos.getSelectedRow();
//            String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
//            codProveedor = Integer.valueOf(codTexto);
//            Proveedor objProv = dao.buscar(codProveedor);
//
//            FrmProveedorEditar floatante = new FrmProveedorEditar(null, true, objProv);
//            floatante.setVisible(true);
//
//            floatante.addWindowListener(new WindowAdapter() {
//                @Override
//                public void windowClosed(WindowEvent e) {
//                    cargarDatosProveed("");
//                    lblTotal.setText(armarLineaCantidad());
//                }
//
//            });
//        }
//
//        if (columnaSeleccionada == 6) {
//            int filaSeleccionada = tablaDatos.getSelectedRow();
//
//            String codTexto = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
//
//            codProveedor = Integer.valueOf(codTexto);
//
//            DaoProveedor miDao = new DaoProveedor();
//            Proveedor objProv = miDao.buscar(codProveedor);
//
//            if (objProv == null) {
//                JOptionPane.showMessageDialog(panelCuerpo, "No se encontró el proveedor", "Advertencia", JOptionPane.WARNING_MESSAGE);
//            } else {
//
//                if (siElimino(codProveedor)) {
//                    DaoProveedor miDaoElim = new DaoProveedor();
//                    if (miDaoElim.eliminar(codProveedor)) {
//                        cargarDatosProveed("");
//                        lblTotal.setText(armarLineaCantidad());
//                        JOptionPane.showMessageDialog(panelCuerpo, "Eliminación Exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        JOptionPane.showMessageDialog(panelCuerpo, "No se pudo eliminar el proveedor", "Información", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            }
//
//        }


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

    private void tablaDatos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaDatos1MouseClicked

    private void cajaBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscar1ActionPerformed

    private void cajaBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscar1KeyReleased

    private void cajaBuscar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscar1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaBuscar1KeyTyped

    private void cmbOrdenar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrdenar1ActionPerformed

    private void cmbBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBuscar1ActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar1ActionPerformed

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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JTextField cajaBuscar;
    private javax.swing.JTextField cajaBuscar1;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaNombre1;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbBuscar1;
    private javax.swing.JComboBox<String> cmbOrdenar;
    private javax.swing.JComboBox<String> cmbOrdenar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelContenedor1;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelCuerpo1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTable tablaDatos1;
    // End of variables declaration//GEN-END:variables
}
