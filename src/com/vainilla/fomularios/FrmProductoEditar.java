package com.vainilla.fomularios;

import com.vainilla.daos.DaoCategoriaProducto;
import com.vainilla.daos.DaoProducto;
import com.vainilla.daos.DaoProveedor;
import com.vainilla.entidades.CategoriaProducto;
import com.vainilla.entidades.Producto;
import com.vainilla.entidades.Proveedor;
import com.vainilla.funciones.Funciones;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrmProductoEditar extends javax.swing.JDialog {

    private final Producto objActualizar;

    private final Map<Integer, Integer> losCodigosProv = new HashMap<>();
    private final Map<Integer, Integer> losCodigosCat = new HashMap<>();
    private final DefaultComboBoxModel modeloComboProv = new DefaultComboBoxModel();
    private final DefaultComboBoxModel modeloComboCat = new DefaultComboBoxModel();
    private Integer indiceProv;
    private Integer indiceCat;

    public FrmProductoEditar(java.awt.Frame parent, boolean modal, Producto objExterno) {
        super(parent, modal);
        initComponents();
        cmbProveedor.setModel(modeloComboProv);
        cmbCat.setModel(modeloComboCat);
        objActualizar = objExterno;
        cargarProveedor();
        cargarCat();
        cargarDatos();
        cargarImg();
        formatoCajas();
    }

    private void cargarImg() {
        try {
            URL imgU = new URL("https://cdn-icons-png.flaticon.com/128/738/738884.png");
            Image boxesImg = new ImageIcon(imgU).getImage().getScaledInstance(25, 25, 0);
            ImageIcon iconoBox = new ImageIcon(boxesImg);
            lblErrorImg.setIcon(iconoBox);
            lblErrorImg.setVisible(false);

        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void formatoCajas() {
        Funciones.formatoMondeaCajas(cajaPrecioTotal);
        Funciones.formatoMondeaCajas(cajaPrecioTotalCaja);
        Funciones.formatoMondeaCajas(cajaEnvio);
    }

    private void cargarCategoria(String orden) {
        modeloComboCat.removeAllElements();
        List<CategoriaProducto> arrayCat;
        Integer indice = 0;

        DaoCategoriaProducto dao = new DaoCategoriaProducto();
        arrayCat = dao.consultar(orden);
        losCodigosCat.put(0, 0);
        modeloComboCat.addElement("SELECCIONE LA CATEGORIA");

        for (CategoriaProducto categoria : arrayCat) {
            indice++;

            losCodigosCat.put(indice, categoria.getCodCategoria());
            modeloComboCat.addElement(categoria.getNombreCategoria());
        }

    }

    private void cargarProveedor() {

        List<Proveedor> arrProveedor;
        int indice = -1;

        DaoProveedor miDao = new DaoProveedor();
        arrProveedor = miDao.consultar("nombre_proveedor");
        for (Proveedor miProv : arrProveedor) {
            indice++;
            losCodigosProv.put(indice, miProv.getCodProveedor());
            modeloComboProv.addElement(miProv.getNombreProveedor());

            if (Objects.equals(objActualizar.getCodProveedor().getCodProveedor(), miProv.getCodProveedor())) {
                indiceProv = indice;
            }

        }
        cmbProveedor.setSelectedIndex(indiceProv);
    }

    private void cargarCat() {

        List<CategoriaProducto> arrCat;
        int indice = 0;

        DaoCategoriaProducto miDao = new DaoCategoriaProducto();
        arrCat = miDao.consultar("nombre_categoria");

        for (CategoriaProducto miCat : arrCat) {
            losCodigosCat.put(indice, miCat.getCodCategoria());
            modeloComboCat.addElement(miCat.getNombreCategoria());

            if (Objects.equals(objActualizar.getCodCategoriaProducto().getCodCategoria(), miCat.getCodCategoria())) {
                indiceCat = indice;
                System.out.println("cat: " + miCat.getNombreCategoria());
            }
            indice++;

        }
        cmbCat.setSelectedIndex(indiceCat);
    }

    private void cargarDatos() {
        cajaNombre.setText(objActualizar.getNombreProducto());
        fCompra.setDate(objActualizar.getFechaCompra());
        fVencimiento.setDate(objActualizar.getFechaVencimiento());
        cajaEnvio.setText(objActualizar.getEnvio().toString());
        cajaTotalProductosEnvio.setText(objActualizar.getUdAdquiridasEnvio().toString());
        lblPrecioAcumulado.setText(Funciones.formatoNumero(objActualizar.getPrecioUnidad()));
        lblPrecioConEnvioUnidad.setText(Funciones.formatoNumero(objActualizar.getPrecioUnidadEnvio()));
        lblPrecioFinal.setText(Funciones.formatoNumero(objActualizar.getPrecioFinal()));
        Integer precioMetr = Integer.valueOf(Funciones.formatoNatural(objActualizar.getPrecioMetro().toString()));
        Integer envio = objActualizar.getEnvio();
        Integer unidadesCompradas = objActualizar.getUdAdquiridasEnvio();
        Integer costoEnvioUnidadCaja = envio / unidadesCompradas;
        lblCostoEnvioUnidad.setText(Funciones.formatoNumero(costoEnvioUnidadCaja) + "");

        Integer numCaja = objActualizar.getNumeroCajas();

        //SI HAY NUMEROS DIFERENTES DE 0 EL CHECK BOX ESTA HABILITADO
        if (numCaja != 0) {
            chBoxCaja.setSelected(true);
            stockDisabled();
            cajaNumCajas.setText(objActualizar.getNumeroCajas().toString());
            lblTotalUnidades.setText(objActualizar.getStock().toString());
            lblPrecioDeUnidad.setText(Funciones.formatoNumero(objActualizar.getPrecioUnidad()));
            cajaPrecioTotalCaja.setText(objActualizar.getPrecioCaja().toString());
            lblPrecioUnidPaquetes.setText(Funciones.formatoNumero(objActualizar.getPrecioCaja()));
            cajaUnidCajas.setText(objActualizar.getUnidadPorCaja().toString());

        } else {
            chBoxCaja.setSelected(false);
            cajaDisabled();
            cajaTamanno.setText(objActualizar.getTamanno().toString());
            cajaStock.setText(objActualizar.getStock().toString());
            lblPrecioUnidad.setText(Funciones.formatoNumero(objActualizar.getPrecioUnidad()));
            cajaPrecioTotal.setText(objActualizar.getPrecioTotalCompra().toString());
            lblPrecioMetro.setText(Funciones.formatoNumero(objActualizar.getPrecioMetro()));
            Integer precioMetroEnvio = costoEnvioUnidadCaja + precioMetr;
            lblTamEnvio.setText(Funciones.formatoNumero(precioMetroEnvio) + "");

        }
        cajaNombre.requestFocus();
    }

    private boolean estaTodoBien() {
        boolean bandera = true;
        boolean seleccionado = chBoxCaja.isSelected();

        // Definir los campos y sus respectivos nombres para los mensajes de advertencia
        Object[][] campos = {
            {cajaNombre.getText(), "Digite el nombre del producto"},
            {fCompra.getDate(), "Seleccione una fecha de compra"},
            {fVencimiento.getDate(), "Seleccione una fecha de vencimiento"},};

        for (Object[] campo : campos) {
            if (campo[0] == null || campo[0].equals("") || campo[0].equals(0) || campo[0].equals("-")) {
                bandera = false;
                JOptionPane.showMessageDialog(panelCuerpo, campo[1], "Advertencia", JOptionPane.WARNING_MESSAGE);

                // Si es un JTextField, coloca el foco en él
                if (campo[0] instanceof JTextField jTextField) {
                    jTextField.requestFocus();
                }
                return bandera;  // Terminar la validación si encuentra un campo vacío o con un valor no válido
            }
        }

        if (!seleccionado) {
            Object[][] camposNoCheck = {
                {cajaStock.getText(), "Ingrese la cantidad de stock"},
                {cajaPrecioTotal.getText(), "Ingrese el precio total del producto"},
                {lblPrecioMetro.getText(), "Mensaje correspondiente para lblPrecioMetro"},
                {lblPrecioUnidad.getText(), "Mensaje correspondiente para lblPrecioUnidad"}
            };

            for (Object[] campo : camposNoCheck) {
                if (campo[0] == null || campo[0].equals("") || campo[0].equals(0) || campo[0].equals("-")) {
                    bandera = false;
                    JOptionPane.showMessageDialog(panelCuerpo, campo[1], "Advertencia", JOptionPane.WARNING_MESSAGE);

                    if (campo[0] instanceof JTextField jTextField) {
                        jTextField.requestFocus();
                    }
                    return bandera;
                }
            }
        } else {
            Object[][] camposCheck = {
                {cajaNumCajas.getText(), "Ingrese el número de cajas"},
                {cajaUnidCajas.getText(), "Ingrese la cantidad de unidades por caja"},
                {cajaPrecioTotalCaja.getText(), "Ingrese el precio total de la caja"},
                {lblPrecioUnidPaquetes.getText(), "Mensaje correspondiente para lblPrecioUnidPaquetes"},
                {lblTotalUnidades.getText(), "Mensaje correspondiente para lblTotalUnidades"},
                {lblPrecioDeUnidad.getText(), "Mensaje correspondiente para lblPrecioDeUnidad"},};

            for (Object[] campo : camposCheck) {
                if (campo[0] == null || campo[0].equals("") || campo[0].equals(0) || campo[0].equals("-")) {
                    bandera = false;
                    JOptionPane.showMessageDialog(panelCuerpo, campo[1], "Advertencia", JOptionPane.WARNING_MESSAGE);

                    if (campo[0] instanceof JTextField jTextField) {
                        jTextField.requestFocus();
                    }
                    return bandera;
                }
            }
        }

        Object[][] camposEnvio = {
            {cajaEnvio.getText(), "Ingrese el costo del envío"},
            {cajaTotalProductosEnvio.getText(), "Ingrese las unidades adquiridas en el envío"},
            {lblPrecioAcumulado.getText(), "Mensaje correspondiente para lblPrecioAcumulado"},
            {lblCostoEnvioUnidad.getText(), "Mensaje correspondiente para lblCostoEnvioUnidad"},
            {lblPrecioConEnvioUnidad.getText(), "Mensaje correspondiente para lblPrecioConEnvioUnidad"},
            {lblPrecioFinal.getText(), "Mensaje correspondiente para lblPrecioFinal"},};

        for (Object[] campo : camposEnvio) {
            if (campo[0] == null || campo[0].equals("") || campo[0].equals(0) || campo[0].equals("-")) {
                bandera = false;
                JOptionPane.showMessageDialog(panelCuerpo, campo[1], "Advertencia", JOptionPane.WARNING_MESSAGE);

                if (campo[0] instanceof JTextField jTextField) {
                    jTextField.requestFocus();
                }
                return bandera;
            }
        }

        return bandera;
    }

    private boolean verificarNombre(String nombre) {
        boolean existencia = true;
        int codigoExistente = objActualizar.getCodProducto();
        List<Producto> arrayProd;
        DaoProducto dao = new DaoProducto();
        arrayProd = dao.buscarDato(nombre, "nombre_producto");
        System.out.println("datos: " + arrayProd);

        if (!arrayProd.isEmpty()) {
            Producto primerProducto = arrayProd.get(0); // Obtiene el primer producto del array
            if (codigoExistente == primerProducto.getCodProducto()) {
                existencia = false;
            }
        } else {
            existencia = false;
        }
        System.out.println("existencia: " + existencia);
        return existencia;
    }

    private void stockCargar() {
        try {
            Integer stock = Integer.valueOf(cajaStock.getText());
            Integer precioFull = Integer.valueOf(cajaPrecioTotal.getText());
            Integer precioXunidad = precioFull / stock;
            lblPrecioUnidad.setText(Funciones.formatoNumero(precioXunidad) + "");
            lblPrecioAcumulado.setText(Funciones.formatoNumero(precioXunidad) + "");

            String tama = cajaTamanno.getText();

            if (tama.equals("") || tama.equals("0")) {
                lblPrecioMetro.setText("0");
                cajaTamanno.setText("");
            } else {
                Integer tam = Integer.valueOf(cajaTamanno.getText());
                Integer precioMetro = precioXunidad / tam;

                lblPrecioMetro.setText(Funciones.formatoNumero(precioMetro) + "");

            }
            cargarCostos();
        } catch (NumberFormatException e) {
        }

    }

    private void paqueteCargar() {

        try {
            Integer numCajas = Integer.valueOf(cajaNumCajas.getText());
            Integer precioTotalCaja = Integer.valueOf(cajaPrecioTotalCaja.getText());
            Integer precioUnitarioCajas = precioTotalCaja / numCajas;
            lblPrecioUnidPaquetes.setText(Funciones.formatoNumero(precioUnitarioCajas) + "");

            Integer unidades = Integer.valueOf(cajaUnidCajas.getText());
            Integer totalUnidad = unidades * numCajas;
            lblTotalUnidades.setText(totalUnidad + "");

            Integer costoUnidad = precioUnitarioCajas / unidades;
            lblPrecioDeUnidad.setText(Funciones.formatoNumero(costoUnidad) + "");
            Integer precioUnidad = Integer.valueOf(Funciones.formatoNatural(lblPrecioDeUnidad.getText()));
            lblPrecioAcumulado.setText(Funciones.formatoNumero(precioUnidad) + "");
            cargarCostos();
        } catch (NumberFormatException e) {
        }
    }

    private void cargarCostos() {
        try {

            Integer envio = Integer.valueOf(cajaEnvio.getText());
            Integer unidadesCompradas = Integer.valueOf(cajaTotalProductosEnvio.getText());
            Integer costoEnvioUnidadCaja = envio / unidadesCompradas;
            lblCostoEnvioUnidad.setText(Funciones.formatoNumero(costoEnvioUnidadCaja) + "");

            if (chBoxCaja.isSelected()) {

                //COSTOS CAJA
                Integer totalUnid = Integer.valueOf(Funciones.formatoNatural(lblTotalUnidades.getText()));

                //EL NUM DE UNIDADES INGRESADAS DEBE SER >= A LAS ENVIADAS
                if (unidadesCompradas < totalUnid) {
                    lblCostoEnvioUnidad.setForeground(Color.red);
                    lblPrecioConEnvioUnidad.setForeground(Color.red);
                    lblErrorImg.setVisible(true);
                } else {
                    lblCostoEnvioUnidad.setForeground(Color.black);
                    lblPrecioConEnvioUnidad.setForeground(new Color(47, 186, 75));
                    lblErrorImg.setVisible(false);
                }

                Integer precioUnidad = Integer.valueOf(Funciones.formatoNatural(lblPrecioDeUnidad.getText()));
                Integer precioConEnvioUnidad = precioUnidad + costoEnvioUnidadCaja;

                lblPrecioConEnvioUnidad.setText(Funciones.formatoNumero(precioConEnvioUnidad));

                Integer precioFinal = totalUnid * precioConEnvioUnidad;
                lblPrecioFinal.setText(Funciones.formatoNumero(precioFinal));

            } else {
                //COSTOS STOCK
                Integer precioUnidad = Integer.valueOf(Funciones.formatoNatural(lblPrecioAcumulado.getText()));

                //EL NUM DE UNIDADES INGRESADAS DEBE SER >= A LAS ENVIADAS
                Integer stock = Integer.valueOf(cajaStock.getText());

                if (unidadesCompradas < stock) {
                    lblCostoEnvioUnidad.setForeground(Color.red);
                    lblPrecioConEnvioUnidad.setForeground(Color.red);
                    lblErrorImg.setVisible(true);
                } else {
                    lblCostoEnvioUnidad.setForeground(Color.black);
                    lblPrecioConEnvioUnidad.setForeground(new Color(47, 186, 75));
                    lblErrorImg.setVisible(false);
                }
                System.out.println("llegue");
                Integer precioConEnvioUnidad = precioUnidad + costoEnvioUnidadCaja;
                lblPrecioConEnvioUnidad.setText(Funciones.formatoNumero(precioConEnvioUnidad) + "");

                Integer precioFinal = stock * precioConEnvioUnidad;
                lblPrecioFinal.setText(Funciones.formatoNumero(precioFinal) + "");

                Integer precioMetr = Integer.valueOf(Funciones.formatoNatural(lblPrecioMetro.getText()));
                if (precioMetr != 0) {

                    Integer precioMetroEnvio = costoEnvioUnidadCaja + precioMetr;
                    lblTamEnvio.setText(Funciones.formatoNumero(precioMetroEnvio) + "");
                }

            }
        } catch (NumberFormatException e) {
        }

    }

    private void asignarValorDefaultSiEstaVacio(JTextField textField) {
        // Verificar si el TextField está vacío y asignar 0 si es el caso
        if (textField.getText().isEmpty()) {
            textField.setText("0");
        }
    }

    private void asignarValorDefaultSiEstaVacioLabel(JLabel label) {
        // Verificar si el TextField está vacío y asignar 0 si es el caso

        if (label.getText().equals("-")) {
            label.setText("0");
        }

    }

    private void stockDisabled() {
        cajaStock.setEnabled(false);
        cajaTamanno.setEnabled(false);
        cajaPrecioTotal.setEnabled(false);
        panelStock.setBackground(Color.WHITE);

        panelCaja.setBackground(new Color(255, 251, 227));
        cajaNumCajas.setEnabled(true);
        cajaPrecioTotalCaja.setEnabled(true);
        cajaUnidCajas.setEnabled(true);
    }

    private void cajaDisabled() {
        cajaNumCajas.setEnabled(false);
        cajaPrecioTotalCaja.setEnabled(false);
        cajaUnidCajas.setEnabled(false);
        panelCaja.setBackground(Color.WHITE);

        panelStock.setBackground(new Color(255, 251, 227));
        cajaStock.setEnabled(true);
        cajaTamanno.setEnabled(true);
        cajaPrecioTotal.setEnabled(true);

    }

    private void borrarCostos() {

        cajaEnvio.setText("");
        cajaStock.setText("");
        cajaNumCajas.setText("");
        cajaUnidCajas.setText("");
        cajaTamanno.setText("");
        cajaPrecioTotalCaja.setText("");
        cajaTotalProductosEnvio.setText("");
        cajaPrecioTotal.setText("");
        lblPrecioUnidPaquetes.setText("-");
        lblPrecioAcumulado.setText("-");
        lblCostoEnvioUnidad.setText("-");
        lblPrecioConEnvioUnidad.setText("-");
        lblPrecioFinal.setText("-");
        lblTotalUnidades.setText("-");
        lblPrecioDeUnidad.setText("-");
        lblPrecioUnidad.setText("-");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelStock = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cajaStock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cajaTamanno = new javax.swing.JTextField();
        cajaPrecioTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblPrecioUnidad = new javax.swing.JLabel();
        lblPrecioMetro = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelCaja = new javax.swing.JPanel();
        cajaNumCajas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cajaUnidCajas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cajaPrecioTotalCaja = new javax.swing.JTextField();
        lblPrecioDeUnidad = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblTotalUnidades = new javax.swing.JLabel();
        lblPrecioUnidPaquetes = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panelBasico = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbCat = new javax.swing.JComboBox<>();
        cmbProveedor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fCompra = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        fVencimiento = new com.toedter.calendar.JDateChooser();
        btnCategoria = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        chBoxCaja = new javax.swing.JCheckBox();
        cajaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelEnvio = new javax.swing.JPanel();
        cajaEnvio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cajaTotalProductosEnvio = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblPrecioAcumulado = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblPrecioFinal = new javax.swing.JLabel();
        lblPrecioConEnvioUnidad = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblCostoEnvioUnidad = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblTamEnvio = new javax.swing.JLabel();
        lblErrorImg = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bntCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Fredoka Medium", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(248, 217, 8));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Productos");

        panelStock.setBackground(new java.awt.Color(238, 238, 238));

        jLabel10.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Stock:");

        cajaStock.setBackground(new java.awt.Color(255, 249, 204));
        cajaStock.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaStock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cajaStockKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaStockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaStockKeyTyped(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Precio por unidad:");

        jLabel12.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Tamaño en cm/m:");

        cajaTamanno.setBackground(new java.awt.Color(255, 249, 204));
        cajaTamanno.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaTamanno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaTamanno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaTamannoKeyReleased(evt);
            }
        });

        cajaPrecioTotal.setBackground(new java.awt.Color(255, 249, 204));
        cajaPrecioTotal.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaPrecioTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaPrecioTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPrecioTotalActionPerformed(evt);
            }
        });
        cajaPrecioTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaPrecioTotalKeyReleased(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Precio total compra:");

        lblPrecioUnidad.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblPrecioUnidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioUnidad.setText("-");
        lblPrecioUnidad.setAlignmentY(0.0F);
        lblPrecioUnidad.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblPrecioMetro.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblPrecioMetro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioMetro.setText("-");
        lblPrecioMetro.setAlignmentY(0.0F);
        lblPrecioMetro.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Precio por metro:");

        javax.swing.GroupLayout panelStockLayout = new javax.swing.GroupLayout(panelStock);
        panelStock.setLayout(panelStockLayout);
        panelStockLayout.setHorizontalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStockLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaTamanno, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioMetro, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        panelStockLayout.setVerticalGroup(
            panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStockLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(7, 7, 7)
                        .addComponent(cajaStock))
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(7, 7, 7)
                        .addComponent(lblPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(7, 7, 7)
                .addComponent(cajaPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(7, 7, 7)
                        .addComponent(cajaTamanno, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelStockLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(7, 7, 7)
                        .addComponent(lblPrecioMetro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        panelCaja.setBackground(new java.awt.Color(255, 251, 227));

        cajaNumCajas.setBackground(new java.awt.Color(255, 249, 204));
        cajaNumCajas.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaNumCajas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaNumCajas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaNumCajasKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Cantidad de paquetes:");

        cajaUnidCajas.setBackground(new java.awt.Color(255, 249, 204));
        cajaUnidCajas.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaUnidCajas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaUnidCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaUnidCajasActionPerformed(evt);
            }
        });
        cajaUnidCajas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaUnidCajasKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Unidades por paquete:");

        jLabel20.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Valor por unidad:");

        jLabel19.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Valor de la compra:");

        cajaPrecioTotalCaja.setBackground(new java.awt.Color(255, 249, 204));
        cajaPrecioTotalCaja.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cajaPrecioTotalCaja.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaPrecioTotalCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaPrecioTotalCajaKeyReleased(evt);
            }
        });

        lblPrecioDeUnidad.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblPrecioDeUnidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioDeUnidad.setText("-");
        lblPrecioDeUnidad.setAlignmentY(0.0F);
        lblPrecioDeUnidad.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel26.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Total unidades:");

        lblTotalUnidades.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblTotalUnidades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalUnidades.setText("-");
        lblTotalUnidades.setAlignmentY(0.0F);
        lblTotalUnidades.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblPrecioUnidPaquetes.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblPrecioUnidPaquetes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioUnidPaquetes.setText("-");
        lblPrecioUnidPaquetes.setAlignmentY(0.0F);
        lblPrecioUnidPaquetes.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel25.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Valor Unitario del paquete:");

        javax.swing.GroupLayout panelCajaLayout = new javax.swing.GroupLayout(panelCaja);
        panelCaja.setLayout(panelCajaLayout);
        panelCajaLayout.setHorizontalGroup(
            panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCajaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaUnidCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaPrecioTotalCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaNumCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCajaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioDeUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioUnidPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCajaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCajaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelCajaLayout.setVerticalGroup(
            panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCajaLayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCajaLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(7, 7, 7)
                        .addComponent(cajaNumCajas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCajaLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cajaPrecioTotalCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioUnidPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCajaLayout.createSequentialGroup()
                        .addGroup(panelCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20))
                        .addGap(43, 43, 43))
                    .addComponent(cajaUnidCajas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioDeUnidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        panelBasico.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Categoria:");

        cmbCat.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cmbCat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cmbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatActionPerformed(evt);
            }
        });

        cmbProveedor.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        cmbProveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel6.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Proveedor:");

        jLabel8.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Fecha de Compra:");

        fCompra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel9.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Fecha de Vencimiento:");

        fVencimiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

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

        chBoxCaja.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        chBoxCaja.setText("Producto por paquete");
        chBoxCaja.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        chBoxCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxCajaActionPerformed(evt);
            }
        });

        cajaNombre.setBackground(new java.awt.Color(255, 249, 204));
        cajaNombre.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));

        jLabel4.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre del producto:");

        javax.swing.GroupLayout panelBasicoLayout = new javax.swing.GroupLayout(panelBasico);
        panelBasico.setLayout(panelBasicoLayout);
        panelBasicoLayout.setHorizontalGroup(
            panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBasicoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBasicoLayout.createSequentialGroup()
                        .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCat, 0, 314, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
            .addGroup(panelBasicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chBoxCaja)
                    .addComponent(cajaNombre)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBasicoLayout.setVerticalGroup(
            panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(cajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chBoxCaja)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnAgregar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        btnAgregar.setText("Actualizar");
        btnAgregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 204, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelEnvio.setBackground(new java.awt.Color(255, 255, 255));

        cajaEnvio.setBackground(new java.awt.Color(255, 249, 204));
        cajaEnvio.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaEnvio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaEnvioActionPerformed(evt);
            }
        });
        cajaEnvio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaEnvioKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Valor Consolidado de Envio:");

        cajaTotalProductosEnvio.setBackground(new java.awt.Color(255, 249, 204));
        cajaTotalProductosEnvio.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        cajaTotalProductosEnvio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        cajaTotalProductosEnvio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cajaTotalProductosEnvioKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Unidades Adquiridas en el envio:");

        jLabel21.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Precio por unidad:");

        lblPrecioAcumulado.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblPrecioAcumulado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecioAcumulado.setText("-");

        jLabel22.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Precio Consolidado:");

        lblPrecioFinal.setFont(new java.awt.Font("Fredoka", 0, 22)); // NOI18N
        lblPrecioFinal.setForeground(new java.awt.Color(242, 204, 87));
        lblPrecioFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecioFinal.setText("-");

        lblPrecioConEnvioUnidad.setFont(new java.awt.Font("Fredoka", 0, 28)); // NOI18N
        lblPrecioConEnvioUnidad.setForeground(new java.awt.Color(47, 186, 75));
        lblPrecioConEnvioUnidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecioConEnvioUnidad.setText("-");

        jLabel24.setFont(new java.awt.Font("Fredoka", 0, 20)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Precio unidad + envio:");

        jLabel23.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Precio del envio por producto:");

        lblCostoEnvioUnidad.setFont(new java.awt.Font("Fredoka", 0, 24)); // NOI18N
        lblCostoEnvioUnidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCostoEnvioUnidad.setText("-");

        jLabel27.setFont(new java.awt.Font("Fredoka", 0, 16)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Precio en m + envio:");

        lblTamEnvio.setFont(new java.awt.Font("Fredoka", 0, 28)); // NOI18N
        lblTamEnvio.setForeground(new java.awt.Color(239, 149, 0));
        lblTamEnvio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTamEnvio.setText("-");

        javax.swing.GroupLayout panelEnvioLayout = new javax.swing.GroupLayout(panelEnvio);
        panelEnvio.setLayout(panelEnvioLayout);
        panelEnvioLayout.setHorizontalGroup(
            panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnvioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnvioLayout.createSequentialGroup()
                        .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cajaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEnvioLayout.createSequentialGroup()
                                    .addComponent(cajaTotalProductosEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblErrorImg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnvioLayout.createSequentialGroup()
                        .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEnvioLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrecioConEnvioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEnvioLayout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblTamEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelEnvioLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblPrecioFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelEnvioLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPrecioAcumulado, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(lblCostoEnvioUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(22, 22, 22))))
        );
        panelEnvioLayout.setVerticalGroup(
            panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnvioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorImg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaTotalProductosEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblPrecioAcumulado))
                .addGap(18, 18, 18)
                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblCostoEnvioUnidad))
                .addGap(18, 18, 18)
                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioConEnvioUnidad)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblPrecioFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblTamEnvio))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jSeparator2.setForeground(new java.awt.Color(255, 204, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bntCancelar.setFont(new java.awt.Font("Fredoka", 0, 14)); // NOI18N
        bntCancelar.setText("Cancelar");
        bntCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 223, 91), 3, true));
        bntCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCuerpoLayout = new javax.swing.GroupLayout(panelCuerpo);
        panelCuerpo.setLayout(panelCuerpoLayout);
        panelCuerpoLayout.setHorizontalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBasico, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(panelCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(panelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        panelCuerpoLayout.setVerticalGroup(
            panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
            .addGroup(panelCuerpoLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(lblTitulo)
                .addGap(68, 68, 68)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(panelBasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCuerpoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(panelStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(panelCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCuerpoLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addGap(0, 60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cajaStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaStockKeyPressed
        stockCargar();
    }//GEN-LAST:event_cajaStockKeyPressed

    private void cajaStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaStockKeyReleased
        stockCargar();
    }//GEN-LAST:event_cajaStockKeyReleased

    private void cajaStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaStockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaStockKeyTyped

    private void cajaTamannoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTamannoKeyReleased
        stockCargar();
    }//GEN-LAST:event_cajaTamannoKeyReleased

    private void cajaPrecioTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPrecioTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaPrecioTotalActionPerformed

    private void cajaPrecioTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPrecioTotalKeyReleased
        stockCargar();
    }//GEN-LAST:event_cajaPrecioTotalKeyReleased

    private void cajaNumCajasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNumCajasKeyReleased
        paqueteCargar();
    }//GEN-LAST:event_cajaNumCajasKeyReleased

    private void cajaUnidCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaUnidCajasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaUnidCajasActionPerformed

    private void cajaUnidCajasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaUnidCajasKeyReleased
        paqueteCargar();
    }//GEN-LAST:event_cajaUnidCajasKeyReleased

    private void cajaPrecioTotalCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPrecioTotalCajaKeyReleased
        paqueteCargar();
    }//GEN-LAST:event_cajaPrecioTotalCajaKeyReleased

    private void cmbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCatActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        FrmCategoriaProducto windowCat = new FrmCategoriaProducto(null, true);
        windowCat.setVisible(true);

        windowCat.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                cargarCategoria("nombre_categoria");
            }

        });
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed

    }//GEN-LAST:event_btnProveedorActionPerformed

    private void chBoxCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxCajaActionPerformed
        if (chBoxCaja.isSelected()) {
            stockDisabled();
            borrarCostos();
        } else {
            cajaDisabled();
            borrarCostos();
        }
    }//GEN-LAST:event_chBoxCajaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (estaTodoBien()) {

            String nombre = cajaNombre.getText().toUpperCase();
            Date fechaCompra = fCompra.getDate();
            Date fechaVencimiento = fVencimiento.getDate();

            asignarValorDefaultSiEstaVacio(cajaNumCajas);
            asignarValorDefaultSiEstaVacio(cajaUnidCajas);
            asignarValorDefaultSiEstaVacio(cajaTamanno);
            asignarValorDefaultSiEstaVacio(cajaPrecioTotalCaja);
            asignarValorDefaultSiEstaVacioLabel(lblPrecioMetro);
            asignarValorDefaultSiEstaVacioLabel(lblTotalUnidades);
            asignarValorDefaultSiEstaVacioLabel(lblPrecioUnidPaquetes);
            asignarValorDefaultSiEstaVacioLabel(lblPrecioDeUnidad);
            asignarValorDefaultSiEstaVacioLabel(lblTamEnvio);

            Integer numCajas = Integer.valueOf(cajaNumCajas.getText());
            Integer undCaja = Integer.valueOf(cajaUnidCajas.getText());
            Integer precioCaja = Integer.valueOf(Funciones.formatoNatural(lblPrecioUnidPaquetes.getText()));
            Integer precioFinal = Integer.valueOf(Funciones.formatoNatural(lblPrecioFinal.getText()));
            Integer envio = Integer.valueOf(Funciones.formatoNatural(cajaEnvio.getText()));
            Integer udAdquiridasEnvio = Integer.valueOf(cajaTotalProductosEnvio.getText());
            Double tamanno = Double.valueOf(cajaTamanno.getText());

            Integer precioMetro = Integer.valueOf(Funciones.formatoNatural(lblPrecioMetro.getText()));
            Integer precioConEnvio = Integer.valueOf(Funciones.formatoNatural(lblPrecioConEnvioUnidad.getText()));

            Integer stock, precioUnid, precioTotalCompra;

            if (chBoxCaja.isSelected()) {
                stock = Integer.valueOf(lblTotalUnidades.getText());
                precioUnid = Integer.valueOf(Funciones.formatoNatural(lblPrecioDeUnidad.getText()));
                precioTotalCompra = Integer.valueOf(Funciones.formatoNatural(cajaPrecioTotalCaja.getText()));
                tamanno = 0.;
            } else {
                stock = Integer.valueOf(cajaStock.getText());
                precioUnid = Integer.valueOf(Funciones.formatoNatural(lblPrecioUnidad.getText()));
                precioTotalCompra = Integer.valueOf(Funciones.formatoNatural(cajaPrecioTotal.getText()));

            }

            indiceCat = cmbCat.getSelectedIndex();
            indiceProv = cmbProveedor.getSelectedIndex();
            System.out.println("indice cat: " + indiceCat);
            System.out.println("indice prov: " + indiceProv);

            Integer codSeleccionadoCat = losCodigosCat.get(indiceCat);
            Integer codSeleccionadoProv = losCodigosProv.get(indiceProv);

            System.out.println("indice cod_cat: " + codSeleccionadoCat);
            System.out.println("indice cod_prov: " + codSeleccionadoProv);

            Proveedor objProveedor = new Proveedor(codSeleccionadoProv, "", "", "", 0);
            CategoriaProducto objCategorias = new CategoriaProducto(codSeleccionadoCat, "", 0);

            System.out.println("data cat: " + objCategorias);
            System.out.println("data prov: " + objProveedor);

            DaoProducto daoProducto = new DaoProducto();
            objActualizar.setNumeroCajas(numCajas);
            objActualizar.setUnidadPorCaja(undCaja);
            objActualizar.setPrecioCaja(precioCaja);
            objActualizar.setPrecioUnidad(precioUnid);
            objActualizar.setPrecioTotalCompra(precioTotalCompra);
            objActualizar.setEnvio(envio);
            objActualizar.setPrecioFinal(precioFinal);
            objActualizar.setFechaCompra(fechaCompra);
            objActualizar.setFechaVencimiento(fechaVencimiento);
            objActualizar.setStock(stock);
            objActualizar.setTamanno(tamanno);
            objActualizar.setPrecioMetro(precioMetro);
            objActualizar.setPrecioUnidadEnvio(precioConEnvio);
            objActualizar.setCodCategoriaProducto(objCategorias);
            objActualizar.setCodProveedor(objProveedor);
            objActualizar.setUdAdquiridasEnvio(udAdquiridasEnvio);

            if (!verificarNombre(nombre)) {
                System.out.println("verificar: " + verificarNombre(nombre));
                objActualizar.setNombreProducto(nombre);

                if (daoProducto.actualizar(objActualizar)) {
                    JOptionPane.showMessageDialog(panelCuerpo, "El producto fue actualizado", "Información", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(panelCuerpo, "No se pudo actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(panelCuerpo, "El producto ya ha sido registrado con ese nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cajaEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaEnvioActionPerformed

    private void cajaEnvioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaEnvioKeyReleased
        cargarCostos();
    }//GEN-LAST:event_cajaEnvioKeyReleased

    private void cajaTotalProductosEnvioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTotalProductosEnvioKeyReleased
        cargarCostos();
    }//GEN-LAST:event_cajaTotalProductosEnvioKeyReleased

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_bntCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmProductoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProductoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProductoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProductoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmProductoEditar dialog = new FrmProductoEditar(new javax.swing.JFrame(), true, new Producto());
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
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JTextField cajaEnvio;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaNumCajas;
    private javax.swing.JTextField cajaPrecioTotal;
    private javax.swing.JTextField cajaPrecioTotalCaja;
    private javax.swing.JTextField cajaStock;
    private javax.swing.JTextField cajaTamanno;
    private javax.swing.JTextField cajaTotalProductosEnvio;
    private javax.swing.JTextField cajaUnidCajas;
    private javax.swing.JCheckBox chBoxCaja;
    private javax.swing.JComboBox<String> cmbCat;
    private javax.swing.JComboBox<String> cmbProveedor;
    private com.toedter.calendar.JDateChooser fCompra;
    private com.toedter.calendar.JDateChooser fVencimiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCostoEnvioUnidad;
    private javax.swing.JLabel lblErrorImg;
    private javax.swing.JLabel lblPrecioAcumulado;
    private javax.swing.JLabel lblPrecioConEnvioUnidad;
    private javax.swing.JLabel lblPrecioDeUnidad;
    private javax.swing.JLabel lblPrecioFinal;
    private javax.swing.JLabel lblPrecioMetro;
    private javax.swing.JLabel lblPrecioUnidPaquetes;
    private javax.swing.JLabel lblPrecioUnidad;
    private javax.swing.JLabel lblTamEnvio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalUnidades;
    private javax.swing.JPanel panelBasico;
    private javax.swing.JPanel panelCaja;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelEnvio;
    private javax.swing.JPanel panelStock;
    // End of variables declaration//GEN-END:variables
}
