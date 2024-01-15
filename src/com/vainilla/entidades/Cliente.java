package com.vainilla.entidades;

public class Cliente {

    private Integer codCliente;
    private String nombreCliente;
    private String telefonoCliente;

    public Cliente() {
    }

    public Cliente(Integer codCliente, String nombreCliente, String telefonoCliente) {
        this.codCliente = codCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nombreCliente=" + nombreCliente + ", telefonoCliente=" + telefonoCliente + '}';
    }

}
