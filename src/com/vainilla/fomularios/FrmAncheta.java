package com.vainilla.fomularios;

import com.vainilla.daos.DaoAncheta;
import com.vainilla.daos.DaoCategoriaProducto;
import com.vainilla.daos.DaoProducto;
import com.vainilla.entidades.Ancheta;
import com.vainilla.entidades.CategoriaProducto;
import com.vainilla.entidades.Producto;
import com.vainilla.entidades.ProductoAncheta;
import com.vainilla.funciones.Funciones;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmAncheta extends javax.swing.JInternalFrame {

    private Map<Integer, Integer> codigosCategoria = new HashMap<>();

    private DefaultComboBoxModel modeloComboCat = new DefaultComboBoxModel();

    private Integer codProducto = null;
    Integer columnaSeleccionada;

    private String titulos[] = {"Nombre", "Stock", "Precio", "# Agregar", "Agregar"};
    private String titulosCanasta[] = {"Nombre", "Cantidad", "Precio Total", "Eliminar"};

    private DefaultTableModel modeloTablaProducto = new DefaultTableModel(titulos, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            //LA COLUMNA #3 LA HACE EDITABLE
            return column == 3;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 4) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };
    private DefaultTableModel modeloTablaCanasta = new DefaultTableModel(titulosCanasta, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;

        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 3) {
                return ImageIcon.class;
            }
            return Object.class;
        }
    };

    public FrmAncheta() {
        initComponents();
        tablaProductos.setModel(modeloTablaProducto);
        tablaCanasta.setModel(modeloTablaCanasta);
        cargarDatosProducto("nombre_producto");
        cargarCategoria();
        formatoCajas();
        anchetaPersonalizada();

    }

    private void formatoCajas() {
        Funciones.formatoMondeaCajas(cajaPublicidad);
        Funciones.formatoMondeaCajas(cajaOtros);
        Funciones.formatoMondeaCajas(cajaDomicilio);
        Funciones.formatoMondeaCajas(cajaUtilidad);
    }

    private void cargarDatosProducto(String ordencito) {
        List<Producto> arrayProd;
        DaoProducto miDao = new DaoProducto();

        String nomAdd = "/com/vainilla/iconos/add.png";
        String rutaIconAdd = this.getClass().getResource(nomAdd).getPath();
        ImageIcon addIcono = new ImageIcon(rutaIconAdd);

        modeloTablaProducto.setNumRows(0);

        arrayProd = miDao.consultar(ordencito);

        arrayProd.forEach((producto) -> {
            Object filita[] = new Object[5];

            filita[0] = producto.getNombreProducto();
            filita[1] = producto.getStock();
            filita[2] = Funciones.formatoNumero(producto.getPrecioUnidadEnvio());
            filita[4] = addIcono;

            modeloTablaProducto.addRow(filita);

        });

        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(200);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
        tablaProductos.getColumnModel().getColumn(1).setCellRenderer(centrado);
        tablaProductos.getColumnModel().getColumn(3).setCellRenderer(centrado);
    }

    private void cargarCategoria() {
        List<CategoriaProducto> arrayCategorias;
        Integer indice = 0;

        DaoCategoriaProducto dao = new DaoCategoriaProducto();
        arrayCategorias = dao.consultar("");

        codigosCategoria.put(0, 0);
        modeloComboCat.addElement("Seleccione la Categoria");

        for (CategoriaProducto miCategoria : arrayCategorias) {
            indice++;

            codigosCategoria.put(indice, miCategoria.getCodCategoria());
            modeloComboCat.addElement(miCategoria.getNombreCategoria());
        }

    }

    private void agregarCarrito() {
        int filaSeleccionada = tablaProductos.getSelectedRow();

        String nombreProduct, cantDigitadaTexto, precioUniTexto, precioCanastaTexto;
        Integer stock, precioUni, cantDigitada, stockResultante, precioTotal;

        String nomAdd = "/com/vainilla/iconos/borrar.png";
        String rutaIconAdd = this.getClass().getResource(nomAdd).getPath();
        ImageIcon addIcono = new ImageIcon(rutaIconAdd);

        DefaultTableModel modelTablaProducto = (DefaultTableModel) tablaProductos.getModel();
        DefaultTableModel modelTablaCanasta = (DefaultTableModel) tablaCanasta.getModel();

        Object[] datosFila = new Object[modelTablaProducto.getColumnCount()];

        for (int i = 0; i < datosFila.length - 2; i++) {
            datosFila[i] = modelTablaProducto.getValueAt(filaSeleccionada, i);
        }

        // OBTENER DATOS
        nombreProduct = (String) modelTablaProducto.getValueAt(filaSeleccionada, 0);
        stock = (int) modelTablaProducto.getValueAt(filaSeleccionada, 1);
        precioUniTexto = Funciones.formatoNatural((String) modelTablaProducto.getValueAt(filaSeleccionada, 2));
        cantDigitadaTexto = (String) modelTablaProducto.getValueAt(filaSeleccionada, 3);

        //VERIFICAR QUE LA ENTRADA DE AGREGAR NO ESTE NULA
        if (cantDigitadaTexto == null || cantDigitadaTexto == "") {
            cantDigitadaTexto = "1";
        }

        cantDigitada = Integer.valueOf(cantDigitadaTexto);
        precioUni = Integer.valueOf(precioUniTexto);

        //HACER OPERACIONES
        stockResultante = stock - cantDigitada;
        precioTotal = cantDigitada * precioUni;

        //VERIFICAR SI LA CANTIDAD A AGREGAR EXISTE EN EL STOCK
        if (cantDigitada <= stock && cantDigitada != 0) {

            for (int i = 0; i < modelTablaCanasta.getRowCount(); i++) {
                if (modelTablaCanasta.getValueAt(i, 0).equals(nombreProduct)) {

                    //OBTENER DATOS TABLA CANASTA
                    int cantCanasta, precioCanasta;
                    cantCanasta = (int) modelTablaCanasta.getValueAt(i, 1);
                    precioCanastaTexto = Funciones.formatoNatural((String) modelTablaCanasta.getValueAt(i, 2));

                    precioCanasta = Integer.parseInt(precioCanastaTexto);

                    //HACER OPERACIONES
                    cantDigitada = cantDigitada + cantCanasta;
                    precioTotal = precioTotal + precioCanasta;
                    modelTablaCanasta.removeRow(i);
                    break;

                }
            }

            //ACTUALIZAR DATOS
            datosFila[1] = cantDigitada;
            datosFila[2] = Funciones.formatoNumero(precioTotal);

            //AGREGAR NUEVO STOCK A LA TABLA PRODUCTOS Y SETEAR EL CAMPO DE AGREGAR CANTIDAD DE PRODUCTOS
            modelTablaProducto.setValueAt(stockResultante, filaSeleccionada, 1);
            modelTablaProducto.setValueAt("", filaSeleccionada, 3);

//          AGREGAR LA IMAGEN A LA COLUMNA
            datosFila[datosFila.length - 2] = addIcono;

            // Agregar datos a la segunda tabla 
            modelTablaCanasta.addRow(datosFila);

            int cantProductosTotal = sumarColumnaCant(tablaCanasta, 1);
            int precioCanasta = sumarColumnaPrecios(tablaCanasta, 2);

            lblCantProductos.setText(cantProductosTotal + "");
            lblValorCanasta.setText(Funciones.formatoNumero(precioCanasta) + "");

        } else {
            JOptionPane.showMessageDialog(panelCuerpo, "No existe la cantidad de productos ingresada", "Error", JOptionPane.ERROR_MESSAGE);
            modelTablaProducto.setValueAt("", filaSeleccionada, 3);
        }

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);

        tablaCanasta.getColumnModel().getColumn(1).setCellRenderer(centrado);
        tablaCanasta.getColumnModel().getColumn(0).setPreferredWidth(150);
        tablaCanasta.getColumnModel().getColumn(3).setPreferredWidth(50);
        descripcionCargar();
    }

    private void eliminarCanasta() {
        int filaSeleccionadaCanasta = tablaCanasta.getSelectedRow();
        DefaultTableModel modelTablaCanasta = (DefaultTableModel) tablaCanasta.getModel();
        DefaultTableModel modelTablaProducto = (DefaultTableModel) tablaProductos.getModel();

        int cantAgregada, stock, stockFinal, cantProductos, cantProductosFinal, precioTotal, precioCanasta;
        String nombreProduct, precio;

        nombreProduct = (String) modelTablaCanasta.getValueAt(filaSeleccionadaCanasta, 0);
        cantAgregada = (int) modelTablaCanasta.getValueAt(filaSeleccionadaCanasta, 1);
        cantProductos = Integer.parseInt(lblCantProductos.getText());
        precio = (String) modelTablaCanasta.getValueAt(filaSeleccionadaCanasta, 2);
        precio = Funciones.formatoNatural(precio);
        precioTotal = Integer.parseInt(precio);

        precioCanasta = Integer.parseInt(Funciones.formatoNatural(lblValorCanasta.getText()));

        for (int i = 0; i < modeloTablaProducto.getRowCount(); i++) {
            if (modeloTablaProducto.getValueAt(i, 0).equals(nombreProduct)) {

                //OBTENER DATOS TABLA PRODUCTO
                stock = (int) modelTablaProducto.getValueAt(i, 1);

                //HACER OPERACIONES
                stockFinal = stock + cantAgregada;
                modelTablaProducto.setValueAt(stockFinal, i, 1);

                cantProductosFinal = cantProductos - cantAgregada;
                lblCantProductos.setText(cantProductosFinal + "");

                precioTotal = precioCanasta - precioTotal;
                lblValorCanasta.setText(Funciones.formatoNumero(precioTotal));
                break;

            }
        }

        modelTablaCanasta.removeRow(filaSeleccionadaCanasta);
        descripcionCargar();

    }

    public static int sumarColumnaPrecios(JTable tabla, int columna) {
        int total = 0, totalEntero;
        int filas = tabla.getRowCount();
        String num;

        // Iterar sobre cada fila y sumar el valor de la columna especificada
        for (int i = 0; i < filas; i++) {
            num = (String) tabla.getValueAt(i, columna);
            num = num.replaceAll("[^0-9]", "");
            totalEntero = Integer.parseInt(num);
            total += totalEntero;
        }

        return total;
    }

    public static int sumarColumnaCant(JTable tabla, int columna) {
        int total = 0;
        int rowCount = tabla.getRowCount();

        // Iterar sobre cada fila y sumar el valor de la columna especificada
        for (int i = 0; i < rowCount; i++) {
            total += (int) tabla.getValueAt(i, columna);
        }

        return total;
    }

    private void buscarDato(String dato, String campo) {

        List<Producto> arrayProd;
        DaoProducto miDao = new DaoProducto();

        String nomAdd = "/com/vainilla/iconos/add.png";
        String rutaIconAdd = this.getClass().getResource(nomAdd).getPath();
        ImageIcon addIcono = new ImageIcon(rutaIconAdd);

        modeloTablaProducto.setNumRows(0);

        arrayProd = miDao.buscarDato(dato, campo);

        arrayProd.forEach((producto) -> {
            Object filita[] = new Object[5];

            filita[0] = producto.getNombreProducto();
            filita[1] = producto.getStock();
            filita[2] = Funciones.formatoNumero(producto.getPrecioUnidadEnvio());
            filita[4] = addIcono;

            modeloTablaProducto.addRow(filita);

        });
        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(200);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(JLabel.CENTER);
        tablaProductos.getColumnModel().getColumn(1).setCellRenderer(centrado);
        tablaProductos.getColumnModel().getColumn(3).setCellRenderer(centrado);
    }

    private void descripcionCargar() {
        try {
            Integer canasta, publicidad, otros, domicilio, subTotal;
            String publicidadT, otrosT, domicilioT;

            publicidadT = Funciones.formatoNatural(cajaPublicidad.getText());
            otrosT = Funciones.formatoNatural(cajaOtros.getText());
            domicilioT = Funciones.formatoNatural(cajaDomicilio.getText());

            if (publicidadT.equals("")) {
                publicidadT = "0";
            }
            if (otrosT.equals("")) {
                otrosT = "0";
            }
            if (domicilioT.equals("")) {
                domicilioT = "0";
            }

            canasta = Integer.valueOf(Funciones.formatoNatural(lblValorCanasta.getText()));
            publicidad = Integer.valueOf(publicidadT);
            otros = Integer.valueOf(otrosT);
            domicilio = Integer.valueOf(domicilioT);
            subTotal = canasta + publicidad + otros + domicilio;
            lblSubtotal.setText(Funciones.formatoNumero(subTotal));
            descripcionTotal();
        } catch (NumberFormatException e) {
        }
    }

    private void descripcionTotal() {
        try {
            Integer subtotal, utilidad, total;
            String utilidadT;

            utilidadT = Funciones.formatoNatural(cajaUtilidad.getText());
            if (utilidadT.equals("")) {
                utilidadT = "0";
            }

            subtotal = Integer.valueOf(Funciones.formatoNatural(lblSubtotal.getText()));
            utilidad = Integer.valueOf(utilidadT);
            total = subtotal + utilidad;
            lblTotal.setText(Funciones.formatoNumero(total));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panelCuerpo, "Ingresa datos validos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void anchetaPersonalizada() {
        cmbAnchetas.setEnabled(false);
    }

    private void asignarValorDefaultSiEstaVacio(JTextField textField) {
        // Verificar si el TextField está vacío y asignar 0 si es el caso
        if (textField.getText().isEmpty()) {
            textField.setText("0");
        }
    }

    private boolean estaTodoBien() {
        boolean bandera = true;

        Object[][] campos = {
            {cajaNombre.getText(), "Digite el nombre de la ancheta"},
            {lblCantProductos.getText(), "Agregue productos a la canasta"},
            {lblValorCanasta.getText(), "Agregue productos a la canasta"},
            {cajaUtilidad.getText(), "Digite el valor de la utilidad"},};

        for (Object[] campo : campos) {
            if (campo[0] == null || campo[0].equals("") || campo[0].equals(0) || campo[0].equals("0")) {
                bandera = false;
                JOptionPane.showMessageDialog(panelCuerpo, campo[1], "Advertencia", JOptionPane.WARNING_MESSAGE);

                // Si es un JTextField, coloca el foco en él
                if (campo[0] instanceof JTextField jTextField) {
                    jTextField.requestFocus();
                }
                return bandera;  // Terminar la validación si encuentra un campo vacío o con un valor no válido
            }
        }
        return bandera;
    }

    private void borrarDatos() {
        cajaNombre.setText("");
        lblCantProductos.setText("0");
        lblValorCanasta.setText("0");
        cajaPublicidad.setText("");
        cajaOtros.setText("");
        cajaDomicilio.setText("");
        lblSubtotal.setText("0");
        cajaUtilidad.setText("");
        lblTotal.setText("0");
        cajaNombre.requestFocus();
    }

    public static void insertarDatosEnTablaDeRompimiento(Object[] rowData) {
        // Aquí iría tu lógica para insertar los datos en la tabla de rompimiento
        // Puedes utilizar la misma lógica que tenías en tu código original
        // Por ejemplo:
        String nombre = rowData[0].toString();
        
        System.out.println("nom: " + nombre);

        DaoProducto dao = new DaoProducto();
        List<Producto> arrayProduct = dao.buscarDato(nombre, "nombre_producto");

        Producto codigoProducto = arrayProduct.get(0);
        Integer cod = codigoProducto.getCodProducto();

        System.out.println("cod: " + cod);
        Integer cantProduct = (Integer) rowData[1];
        Integer total = (Integer) rowData[2];
        
//        DaoAncheta
        
        
//        ProductoAncheta objProdAncheta = new ProductoAncheta(codAncheta, codigoProducto, cantProduct, total);
        // Resto de los datos...
        // Realiza la inserción en la tabla de rompimiento...
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        panelContenedor = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        chkPersonalizado = new javax.swing.JCheckBox();
        cmbAnchetas = new javax.swing.JComboBox<>();
        cajaBuscarProduct = new javax.swing.JTextField();
        cajaNombre = new javax.swing.JTextField();
        panelDescrip = new javax.swing.JPanel();
        lblTituloDescr = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbl = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lblCantProductos = new javax.swing.JLabel();
        lblValorCanasta = new javax.swing.JLabel();
        cajaPublicidad = new javax.swing.JTextField();
        cajaOtros = new javax.swing.JTextField();
        cajaDomicilio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        cajaUtilidad = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lbl7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        panelProductos = new javax.swing.JPanel();
        lblTituloProd = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        panelProductos1 = new javax.swing.JPanel();
        lblTituloProd1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCanasta = new javax.swing.JTable();
        lblTituloProd2 = new javax.swing.JLabel();
        lblTituloProd3 = new javax.swing.JLabel();

        panelCuerpo.setBackground(new java.awt.Color(203, 201, 214));

        panelContenedor.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Fredoka Medium", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(79, 61, 162));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Anchetas");

        chkPersonalizado.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        chkPersonalizado.setText("Personalizada");
        chkPersonalizado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));
        chkPersonalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPersonalizadoActionPerformed(evt);
            }
        });

        cmbAnchetas.setBackground(new java.awt.Color(231, 231, 234));
        cmbAnchetas.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cmbAnchetas.setForeground(new java.awt.Color(65, 46, 152));
        cmbAnchetas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));

        cajaBuscarProduct.setBackground(new java.awt.Color(231, 231, 234));
        cajaBuscarProduct.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaBuscarProduct.setForeground(new java.awt.Color(65, 46, 152));
        cajaBuscarProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));
        cajaBuscarProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaBuscarProductKeyReleased(evt);
            }
        });

        cajaNombre.setBackground(new java.awt.Color(231, 231, 234));
        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaNombre.setForeground(new java.awt.Color(65, 46, 152));
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));

        panelDescrip.setBackground(new java.awt.Color(231, 231, 234));
        panelDescrip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));

        lblTituloDescr.setFont(new java.awt.Font("Fredoka Medium", 0, 22)); // NOI18N
        lblTituloDescr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloDescr.setText("Descripción de la ancheta");

        jSeparator3.setBackground(new java.awt.Color(65, 46, 152));
        jSeparator3.setForeground(new java.awt.Color(65, 46, 152));

        lbl.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl.setText("Cant Productos:");

        lbl1.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl1.setText("Valor Canasta:");

        lbl2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl2.setText("Publicidad:");

        lbl3.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl3.setText("Otros:");

        lbl4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl4.setText("Domicilio:");

        lblCantProductos.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lblCantProductos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantProductos.setText("0");

        lblValorCanasta.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lblValorCanasta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValorCanasta.setText("0");

        cajaPublicidad.setBackground(new java.awt.Color(231, 231, 234));
        cajaPublicidad.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaPublicidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cajaPublicidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        cajaPublicidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPublicidadActionPerformed(evt);
            }
        });
        cajaPublicidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaPublicidadKeyReleased(evt);
            }
        });

        cajaOtros.setBackground(new java.awt.Color(231, 231, 234));
        cajaOtros.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaOtros.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cajaOtros.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        cajaOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaOtrosActionPerformed(evt);
            }
        });
        cajaOtros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaOtrosKeyReleased(evt);
            }
        });

        cajaDomicilio.setBackground(new java.awt.Color(231, 231, 234));
        cajaDomicilio.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaDomicilio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cajaDomicilio.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        cajaDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaDomicilioActionPerformed(evt);
            }
        });
        cajaDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaDomicilioKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(65, 46, 152));
        jSeparator1.setForeground(new java.awt.Color(65, 46, 152));

        lbl5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl5.setText("Subtotal:");

        lbl6.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl6.setText("Utilidad:");

        lblSubtotal.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText("0");

        cajaUtilidad.setBackground(new java.awt.Color(231, 231, 234));
        cajaUtilidad.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaUtilidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cajaUtilidad.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        cajaUtilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaUtilidadKeyReleased(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(65, 46, 152));
        jSeparator2.setForeground(new java.awt.Color(65, 46, 152));

        lbl7.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl7.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0");

        javax.swing.GroupLayout panelDescripLayout = new javax.swing.GroupLayout(panelDescrip);
        panelDescrip.setLayout(panelDescripLayout);
        panelDescripLayout.setHorizontalGroup(
            panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescripLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDescripLayout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDescripLayout.createSequentialGroup()
                                    .addComponent(lbl5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelDescripLayout.createSequentialGroup()
                                    .addComponent(lbl1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblValorCanasta, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDescripLayout.createSequentialGroup()
                                    .addComponent(lbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCantProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelDescripLayout.createSequentialGroup()
                                    .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl2)
                                        .addComponent(lbl3)
                                        .addComponent(lbl4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cajaDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                        .addComponent(cajaOtros)
                                        .addComponent(cajaPublicidad))))
                            .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDescripLayout.createSequentialGroup()
                                    .addComponent(lbl6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cajaUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDescripLayout.createSequentialGroup()
                                    .addComponent(lbl7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addComponent(lblTituloDescr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelDescripLayout.setVerticalGroup(
            panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescripLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTituloDescr)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDescripLayout.createSequentialGroup()
                        .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl)
                            .addComponent(lblCantProductos))
                        .addGap(18, 18, 18)
                        .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl1)
                            .addComponent(lblValorCanasta))
                        .addGap(18, 18, 18)
                        .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2)
                            .addComponent(cajaPublicidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl3))
                    .addComponent(cajaOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl4)
                    .addComponent(cajaDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl5)
                    .addComponent(lblSubtotal))
                .addGap(18, 18, 18)
                .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl6)
                    .addComponent(cajaUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDescripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl7)
                    .addComponent(lblTotal))
                .addGap(78, 78, 78))
        );

        btnCrear.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panelProductos.setBackground(new java.awt.Color(255, 255, 255));
        panelProductos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));

        lblTituloProd.setFont(new java.awt.Font("Fredoka Medium", 0, 22)); // NOI18N
        lblTituloProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloProd.setText("Productos en Stock");

        jSeparator4.setBackground(new java.awt.Color(65, 46, 152));
        jSeparator4.setForeground(new java.awt.Color(65, 46, 152));

        tablaProductos.setFont(new java.awt.Font("Fredoka", 0, 12)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addGroup(panelProductosLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(jSeparator4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTituloProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelProductos1.setBackground(new java.awt.Color(255, 255, 255));
        panelProductos1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(65, 46, 152), 3, true));

        lblTituloProd1.setFont(new java.awt.Font("Fredoka Medium", 0, 22)); // NOI18N
        lblTituloProd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloProd1.setText("En Canasta");

        jSeparator5.setBackground(new java.awt.Color(65, 46, 152));
        jSeparator5.setForeground(new java.awt.Color(65, 46, 152));

        tablaCanasta.setFont(new java.awt.Font("Fredoka", 0, 12)); // NOI18N
        tablaCanasta.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCanasta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaCanasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCanastaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCanasta);

        javax.swing.GroupLayout panelProductos1Layout = new javax.swing.GroupLayout(panelProductos1);
        panelProductos1.setLayout(panelProductos1Layout);
        panelProductos1Layout.setHorizontalGroup(
            panelProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductos1Layout.createSequentialGroup()
                .addGroup(panelProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloProd1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addGroup(panelProductos1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(jSeparator5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelProductos1Layout.setVerticalGroup(
            panelProductos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductos1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTituloProd1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTituloProd2.setFont(new java.awt.Font("Fredoka Medium", 0, 22)); // NOI18N
        lblTituloProd2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloProd2.setText("Productos:");

        lblTituloProd3.setFont(new java.awt.Font("Fredoka Medium", 0, 22)); // NOI18N
        lblTituloProd3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloProd3.setText("Nombre:");

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(lblTituloProd3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(chkPersonalizado)
                .addGap(18, 18, 18)
                .addComponent(cmbAnchetas, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(panelProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblTituloProd2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cajaBuscarProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblTitulo))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkPersonalizado)
                            .addComponent(cmbAnchetas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTituloProd3))))
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(panelDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cajaBuscarProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTituloProd2))
                        .addGap(44, 44, 44)
                        .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelProductos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaPublicidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPublicidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaPublicidadActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        columnaSeleccionada = tablaProductos.getSelectedColumn();
        if (columnaSeleccionada == 4) {
            agregarCarrito();
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void tablaCanastaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCanastaMouseClicked
        columnaSeleccionada = tablaCanasta.getSelectedColumn();
        if (columnaSeleccionada == 3) {
            eliminarCanasta();
        }
    }//GEN-LAST:event_tablaCanastaMouseClicked

    private void cajaBuscarProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaBuscarProductKeyReleased

        buscarDato("%" + cajaBuscarProduct.getText().toUpperCase() + "%", "nombre_producto");
    }//GEN-LAST:event_cajaBuscarProductKeyReleased

    private void cajaDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaDomicilioActionPerformed

    private void cajaOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaOtrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaOtrosActionPerformed

    private void cajaPublicidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPublicidadKeyReleased
        descripcionCargar();
    }//GEN-LAST:event_cajaPublicidadKeyReleased

    private void cajaOtrosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaOtrosKeyReleased
        descripcionCargar();
    }//GEN-LAST:event_cajaOtrosKeyReleased

    private void cajaDomicilioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDomicilioKeyReleased
        descripcionCargar();
    }//GEN-LAST:event_cajaDomicilioKeyReleased

    private void cajaUtilidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaUtilidadKeyReleased
        descripcionTotal();
    }//GEN-LAST:event_cajaUtilidadKeyReleased

    private void chkPersonalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPersonalizadoActionPerformed
        if (chkPersonalizado.isSelected()) {
            cmbAnchetas.setEnabled(true);
        } else {
            anchetaPersonalizada();
        }
    }//GEN-LAST:event_chkPersonalizadoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (estaTodoBien()) {

            String nombre = cajaNombre.getText().toUpperCase();

            asignarValorDefaultSiEstaVacio(cajaPublicidad);
            asignarValorDefaultSiEstaVacio(cajaDomicilio);
            asignarValorDefaultSiEstaVacio(cajaOtros);

            Integer cantProduct = Integer.valueOf(Funciones.formatoNatural(lblCantProductos.getText()));
            Integer valorCanasta = Integer.valueOf(Funciones.formatoNatural(lblValorCanasta.getText()));
            Integer domicilio = Integer.valueOf(Funciones.formatoNatural(cajaDomicilio.getText()));
            Integer otros = Integer.valueOf(Funciones.formatoNatural(cajaOtros.getText()));
            Integer publicidad = Integer.valueOf(Funciones.formatoNatural(cajaPublicidad.getText()));
            Integer subtotal = Integer.valueOf(Funciones.formatoNatural(lblSubtotal.getText()));
            Integer utilidad = Integer.valueOf(Funciones.formatoNatural(cajaUtilidad.getText()));
            Integer total = Integer.valueOf(Funciones.formatoNatural(lblTotal.getText()));

            String tipo = "cliente";

            if (!chkPersonalizado.isSelected()) {
                tipo = "Nueva";
            }

            DaoAncheta daoAncheta = new DaoAncheta();
            Ancheta objAncheta = new Ancheta(0, nombre, tipo, cantProduct, valorCanasta, publicidad, otros, domicilio, utilidad, total, subtotal);

            DefaultTableModel modelCanasta = (DefaultTableModel) tablaCanasta.getModel();

            // Obtener el número de filas y columnas en la tabla
            int numRows = modelCanasta.getRowCount();
            int numCols = modelCanasta.getColumnCount();

            // Iterar sobre todas las filas
            for (int row = 0; row < numRows; row++) {
                // Crear un arreglo para almacenar los valores de cada fila
                Object[] rowData = new Object[numCols];
                // Iterar sobre todas las columnas de la fila actual
                for (int col = 0; col < numCols; col++) {
                    // Obtener el valor de la celda en la fila y columna actual
                    rowData[col] = modelCanasta.getValueAt(row, col);
                }
                // Aquí tienes los valores de la fila actual en el arreglo rowData
                // Ahora puedes procesar estos valores según tu lógica
                // Por ejemplo, insertarlos en tu tabla de rompimiento
                // Inserta los valores en tu tabla de rompimiento utilizando la lógica que ya tienes implementada
                insertarDatosEnTablaDeRompimiento(rowData);
            }

//            if (!verificarNombre(nombre)) {
//                System.out.println("existe: " + verificarNombre(nombre));
//            if (daoAncheta.registrar(objAncheta)) {
//                
//
//                JOptionPane.showMessageDialog(panelCuerpo, "Registro Exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
//                borrarDatos();
//
//            } else {
//                JOptionPane.showMessageDialog(panelCuerpo, "No se pudo registrar", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//            } else {
//                JOptionPane.showMessageDialog(panelCuerpo, "El proveedor ya ha sido registrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
//            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JTextField cajaBuscarProduct;
    private javax.swing.JTextField cajaDomicilio;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaOtros;
    private javax.swing.JTextField cajaPublicidad;
    private javax.swing.JTextField cajaUtilidad;
    private javax.swing.JCheckBox chkPersonalizado;
    private javax.swing.JComboBox<String> cmbAnchetas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lblCantProductos;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloDescr;
    private javax.swing.JLabel lblTituloProd;
    private javax.swing.JLabel lblTituloProd1;
    private javax.swing.JLabel lblTituloProd2;
    private javax.swing.JLabel lblTituloProd3;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValorCanasta;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelDescrip;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JPanel panelProductos1;
    private javax.swing.JTable tablaCanasta;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
