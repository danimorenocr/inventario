package com.vainilla.configuracion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Credenciales {

    // Actualización de las credenciales para acceder a la base 
    private Properties propiedades;

    private String nombreBase;
    private String clave;
    private String usuario;
    private String rutaArchivo = System.getProperty("user.dir") + "/config.properties";

    public Credenciales() {
        propiedades = new Properties();
        System.out.println("dir: " + rutaArchivo);
        cargarConfiguracion();
    }

    private void cargarConfiguracion() {
        try (FileInputStream archivoInput = new FileInputStream("config.properties")) {
            propiedades.load(archivoInput);
            nombreBase = propiedades.getProperty("nombreBase", "nombreBase");
            clave = propiedades.getProperty("clave", "clave");
            usuario = propiedades.getProperty("usuario", "usuario");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void guardarConfiguracion() {
        try (FileOutputStream archivoOutput = new FileOutputStream("config.properties")) {
            propiedades.setProperty("nombreBase", nombreBase);
            propiedades.setProperty("clave", clave);
            propiedades.setProperty("usuario", usuario);
            propiedades.store(archivoOutput, null);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Error al guardar las propiedades: " + ex.getMessage());
        }
    }

    public String getNombreBase() {
        return nombreBase;
    }

    public void setNombreBase(String nombreBase) {
        this.nombreBase = nombreBase;
        guardarConfiguracion();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
        guardarConfiguracion();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        guardarConfiguracion();
    }

}
