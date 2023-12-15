package com.vainilla.configuracion;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    //Traer informacion de otra clase para cambios de configuracion de la base
    Credenciales datos = new Credenciales();
    private String nombreBase = datos.getNombreBase();
    private String clave = datos.getClave();
    private String usuario = datos.getUsuario();;
    private String driver;
    private String url;

  

    
    protected String cadenaSql;
    protected ResultSet registros;
    protected Connection objConexion;
    protected Integer cantidad;
    protected PreparedStatement consulta;

    public Conexion() {

        
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/" + nombreBase;
        System.out.println("usuario: " + usuario + " Contra: " + clave + " url: " + url);

        conectarse();
    }

    private void conectarse() {
        try {
            Class.forName(driver);
            //Driver: importar -> import java.sql.DriverManager;
            //Añadir clausula y multicatch
            objConexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("usuario: " + usuario + " Contra: " + clave + " url: " + url);
            System.out.println("Conectado a MySql");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
