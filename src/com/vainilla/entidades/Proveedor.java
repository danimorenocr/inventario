package com.vainilla.entidades;

public class Proveedor {

    private Integer codProveedor;
    private String nombreProveedor;
    private String ciudadProveedor;
    private String telefonoProveedor;
    public Integer cantProductos;

    public Proveedor() {
    }

    public Proveedor(Integer codProveedor, String nombreProveedor, String ciudadProveedor, String telefonoProveedor, Integer cantProductos) {
        this.codProveedor = codProveedor;
        this.nombreProveedor = nombreProveedor;
        this.ciudadProveedor = ciudadProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.cantProductos = cantProductos;
    }

    public Integer getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Integer codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCiudadProveedor() {
        return ciudadProveedor;
    }

    public void setCiudadProveedor(String ciudadProveedor) {
        this.ciudadProveedor = ciudadProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public Integer getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(Integer cantProductos) {
        this.cantProductos = cantProductos;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codProveedor=" + codProveedor + ", nombreProveedor=" + nombreProveedor + ", ciudadProveedor=" + ciudadProveedor + ", telefonoProveedor=" + telefonoProveedor + ", cantProductos=" + cantProductos + '}';
    }

}
