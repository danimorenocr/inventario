package com.vainilla.entidades;

public class Ancheta {

    private Integer codAncheta;
    private String nombreAncheta;
    private String tipoAncheta;
    private Integer cantProductos;
    private Integer precioParcial;
    private Integer precioPublicidad;
    private Integer valorAdicional;
    private Integer precioDomicilio;
    private Integer utilidad;
    private Integer precioFinal;

    public Ancheta() {
    }

    public Ancheta(Integer codAncheta, String nombreAncheta, String tipoAncheta, Integer cantProductos, Integer precioParcial, Integer precioPublicidad, Integer valorAdicional, Integer precioDomicilio, Integer utilidad, Integer precioFinal) {
        this.codAncheta = codAncheta;
        this.nombreAncheta = nombreAncheta;
        this.tipoAncheta = tipoAncheta;
        this.cantProductos = cantProductos;
        this.precioParcial = precioParcial;
        this.precioPublicidad = precioPublicidad;
        this.valorAdicional = valorAdicional;
        this.precioDomicilio = precioDomicilio;
        this.utilidad = utilidad;
        this.precioFinal = precioFinal;
    }

    public Integer getCodAncheta() {
        return codAncheta;
    }

    public void setCodAncheta(Integer codAncheta) {
        this.codAncheta = codAncheta;
    }

    public String getNombreAncheta() {
        return nombreAncheta;
    }

    public void setNombreAncheta(String nombreAncheta) {
        this.nombreAncheta = nombreAncheta;
    }

    public String getTipoAncheta() {
        return tipoAncheta;
    }

    public void setTipoAncheta(String tipoAncheta) {
        this.tipoAncheta = tipoAncheta;
    }

    public Integer getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(Integer cantProductos) {
        this.cantProductos = cantProductos;
    }

    public Integer getPrecioParcial() {
        return precioParcial;
    }

    public void setPrecioParcial(Integer precioParcial) {
        this.precioParcial = precioParcial;
    }

    public Integer getPrecioPublicidad() {
        return precioPublicidad;
    }

    public void setPrecioPublicidad(Integer precioPublicidad) {
        this.precioPublicidad = precioPublicidad;
    }

    public Integer getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Integer valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public Integer getPrecioDomicilio() {
        return precioDomicilio;
    }

    public void setPrecioDomicilio(Integer precioDomicilio) {
        this.precioDomicilio = precioDomicilio;
    }

    public Integer getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Integer utilidad) {
        this.utilidad = utilidad;
    }

    public Integer getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Integer precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString() {
        return "Ancheta{" + "codAncheta=" + codAncheta + ", nombreAncheta=" + nombreAncheta + ", tipoAncheta=" + tipoAncheta + ", cantProductos=" + cantProductos + ", precioParcial=" + precioParcial + ", precioPublicidad=" + precioPublicidad + ", valorAdicional=" + valorAdicional + ", precioDomicilio=" + precioDomicilio + ", utilidad=" + utilidad + ", precioFinal=" + precioFinal + '}';
    }

}
