package com.vainilla.fomularios;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        apariencia();

    }

    private void apariencia() {
        cargarImg();

        panelRedondeado2.cambiarRadioEsquinas(150);
        btnRegis.cambiarRadioEsquinas(20);
        btnIniciar.cambiarRadioEsquinas(20);

//        btnRegis.setBackground(new Color(255,182,193));
//        btnRegis.setForeground(Color.WHITE);
    }

    private void cargarImg() {

        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/com/vainilla/iconos/Bg.jpg"));
        ImageIcon iconoEscalado = escalarImagen(iconoOriginal, 1600, 810);
        lblBg.setIcon(iconoEscalado);
        try {
            URL imgU = new URL("   https://cdn-icons-png.flaticon.com/512/4679/4679524.png ");
            Image boxesImg = new ImageIcon(imgU).getImage().getScaledInstance(150, 150, 0);
            ImageIcon iconoBox = new ImageIcon(boxesImg);
            lblIcon.setIcon(iconoBox);

//            //IMAGEN PARA LA BARRA DE TAREAS
//            String rutaIcon = "/com/usta/iconos/library.png";
//            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(rutaIcon)));
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ImageIcon escalarImagen(ImageIcon imagenOriginal, int ancho, int alto) {
        Image imagen = imagenOriginal.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenRedimensionada);
    }

    private void quitarHeader(JInternalFrame ventana) {
        BasicInternalFrameUI interUser = (BasicInternalFrameUI) ventana.getUI();
        interUser.setNorthPane(null);
    }

    private void centrarVentana(JInternalFrame window) {
        Dimension tamannoPanel = panelEscritorio.getSize();

        window.setSize(tamannoPanel);
    }

    public void agregarVentanaPanel(JInternalFrame ventana) {

        if (panelEscritorio.getComponentCount() > 0) {
            panelEscritorio.removeAll();
        }

        ventana.setVisible(true);
        quitarHeader(ventana);
        centrarVentana(ventana);

        panelEscritorio.add(ventana);
        panelEscritorio.revalidate();
        panelEscritorio.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEscritorio = new javax.swing.JDesktopPane();
        panelCuerpo = new javax.swing.JPanel();
        panelRedondeado2 = new com.vainilla.apariencia.PanelRedondeado();
        btnRegis = new com.vainilla.apariencia.BotonRedon();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIniciar = new com.vainilla.apariencia.ButtonOutLine();
        lblIcon = new javax.swing.JLabel();
        lblBg = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        smSalir = new javax.swing.JMenuItem();
        smDashBoard = new javax.swing.JMenuItem();
        smConfig = new javax.swing.JMenuItem();
        mComercio = new javax.swing.JMenu();
        smProveedor = new javax.swing.JMenuItem();
        smCliente = new javax.swing.JMenuItem();
        mSuministros = new javax.swing.JMenu();
        smCatProducto = new javax.swing.JMenuItem();
        smProduct = new javax.swing.JMenuItem();
        smProductList = new javax.swing.JMenuItem();
        smAncheta = new javax.swing.JMenuItem();
        mOrdenes = new javax.swing.JMenu();
        smPedidos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1500, 900));
        getContentPane().setLayout(null);

        panelCuerpo.setBackground(new java.awt.Color(255, 255, 255));
        panelCuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRedondeado2.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado2.setLayout(null);

        btnRegis.setBackground(new java.awt.Color(255, 182, 193));
        btnRegis.setText("Registrarse");
        btnRegis.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });
        panelRedondeado2.add(btnRegis);
        btnRegis.setBounds(140, 460, 290, 50);

        jLabel1.setFont(new java.awt.Font("Fredoka", 0, 36)); // NOI18N
        jLabel1.setText("Bienvenid@");
        panelRedondeado2.add(jLabel1);
        jLabel1.setBounds(190, 230, 187, 48);

        jLabel2.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estamos encantados de tenerte aquí.");
        panelRedondeado2.add(jLabel2);
        jLabel2.setBounds(20, 290, 548, 23);

        jLabel3.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("  ¿Listo para comenzar tu experiencia?");
        panelRedondeado2.add(jLabel3);
        jLabel3.setBounds(10, 320, 550, 23);

        btnIniciar.setBackground(new java.awt.Color(255, 182, 193));
        btnIniciar.setText("Iniciar sesión");
        btnIniciar.setFont(new java.awt.Font("Fredoka", 0, 18)); // NOI18N
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        panelRedondeado2.add(btnIniciar);
        btnIniciar.setBounds(140, 400, 290, 50);

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setMaximumSize(new java.awt.Dimension(40, 16));
        panelRedondeado2.add(lblIcon);
        lblIcon.setBounds(150, 50, 260, 180);

        panelCuerpo.add(panelRedondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 560, 570));

        lblBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vainilla/iconos/Bg.jpg"))); // NOI18N
        panelCuerpo.add(lblBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1550, 860));

        panelEscritorio.setLayer(panelCuerpo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelEscritorioLayout = new javax.swing.GroupLayout(panelEscritorio);
        panelEscritorio.setLayout(panelEscritorioLayout);
        panelEscritorioLayout.setHorizontalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
            .addGroup(panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelEscritorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelEscritorioLayout.setVerticalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelEscritorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(panelEscritorio);
        panelEscritorio.setBounds(0, 0, 1550, 820);

        mArchivo.setText("Archivo");

        smSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        smSalir.setText("Salir");
        smSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smSalirActionPerformed(evt);
            }
        });
        mArchivo.add(smSalir);

        smDashBoard.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        smDashBoard.setText("Dashboard");
        smDashBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smDashBoardActionPerformed(evt);
            }
        });
        mArchivo.add(smDashBoard);

        smConfig.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        smConfig.setText("Configuración");
        smConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smConfigActionPerformed(evt);
            }
        });
        mArchivo.add(smConfig);

        menuBar.add(mArchivo);

        mComercio.setText("Comercio");

        smProveedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        smProveedor.setText("Proveedores");
        smProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smProveedorActionPerformed(evt);
            }
        });
        mComercio.add(smProveedor);

        smCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        smCliente.setText("Clientes");
        mComercio.add(smCliente);

        menuBar.add(mComercio);

        mSuministros.setText("Suministros");

        smCatProducto.setText("Categoria de Productos");
        smCatProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smCatProductoActionPerformed(evt);
            }
        });
        mSuministros.add(smCatProducto);

        smProduct.setText("Productos");
        smProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smProductActionPerformed(evt);
            }
        });
        mSuministros.add(smProduct);

        smProductList.setText("Lista de Productos");
        smProductList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smProductListActionPerformed(evt);
            }
        });
        mSuministros.add(smProductList);

        smAncheta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        smAncheta.setText("Anchetas");
        smAncheta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smAnchetaActionPerformed(evt);
            }
        });
        mSuministros.add(smAncheta);

        menuBar.add(mSuministros);

        mOrdenes.setText("Ordenes");

        smPedidos.setText("Pedidos");
        mOrdenes.add(smPedidos);

        menuBar.add(mOrdenes);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_smSalirActionPerformed

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        FrmRegistarse ventanaRegistarse = new FrmRegistarse();
        agregarVentanaPanel(ventanaRegistarse);
    }//GEN-LAST:event_btnRegisActionPerformed

    private void smDashBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smDashBoardActionPerformed
        FrmDashBoard ventanaDash = new FrmDashBoard();
        agregarVentanaPanel(ventanaDash);
    }//GEN-LAST:event_smDashBoardActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        FrmLogin ventanaLogin = new FrmLogin();
        agregarVentanaPanel(ventanaLogin);
    }//GEN-LAST:event_buttonOutLine1ActionPerformed

    private void smConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smConfigActionPerformed
        FrmConfig windowConfig = new FrmConfig(null, true);
        windowConfig.setVisible(true);
    }//GEN-LAST:event_smConfigActionPerformed

    private void smProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smProveedorActionPerformed
        FrmProveedor ventanaProveedor = new FrmProveedor();
        agregarVentanaPanel(ventanaProveedor);
    }//GEN-LAST:event_smProveedorActionPerformed

    private void smProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smProductActionPerformed
        FrmProducto ventanaProducto = new FrmProducto();
        agregarVentanaPanel(ventanaProducto);
    }//GEN-LAST:event_smProductActionPerformed

    private void smCatProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smCatProductoActionPerformed
        FrmCategoriaProducto windowCat = new FrmCategoriaProducto(null, true);
        windowCat.setVisible(true);
    }//GEN-LAST:event_smCatProductoActionPerformed

    private void smProductListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smProductListActionPerformed
        FrmProductoList ventanaProductoList = new FrmProductoList();
        agregarVentanaPanel(ventanaProductoList);
    }//GEN-LAST:event_smProductListActionPerformed

    private void smAnchetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smAnchetaActionPerformed
        FrmAncheta ventanaAncheta = new FrmAncheta();
        agregarVentanaPanel(ventanaAncheta);
    }//GEN-LAST:event_smAnchetaActionPerformed

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

            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.vainilla.apariencia.ButtonOutLine btnIniciar;
    private com.vainilla.apariencia.BotonRedon btnRegis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblBg;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mComercio;
    private javax.swing.JMenu mOrdenes;
    private javax.swing.JMenu mSuministros;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JDesktopPane panelEscritorio;
    private com.vainilla.apariencia.PanelRedondeado panelRedondeado2;
    private javax.swing.JMenuItem smAncheta;
    private javax.swing.JMenuItem smCatProducto;
    private javax.swing.JMenuItem smCliente;
    private javax.swing.JMenuItem smConfig;
    private javax.swing.JMenuItem smDashBoard;
    private javax.swing.JMenuItem smPedidos;
    private javax.swing.JMenuItem smProduct;
    private javax.swing.JMenuItem smProductList;
    private javax.swing.JMenuItem smProveedor;
    private javax.swing.JMenuItem smSalir;
    // End of variables declaration//GEN-END:variables
}
