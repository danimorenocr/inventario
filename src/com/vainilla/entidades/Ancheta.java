package com.vainilla.entidades;
public class Ancheta {
    private Integer codAncheta;
    private String nombreAncheta;
    private Integer cantProductos;
    private Integer precioParcial;
    private Integer utilidad;
    private Integer precioDomicilio;
    private Integer valorAdicional;
    private Integer precioFinal;
    private TipoAncheta codTipoAncheta;

    public Ancheta() {
    }

    public Ancheta(Integer codAncheta, String nombreAncheta, Integer cantProductos, Integer precioParcial, Integer utilidad, Integer precioDomicilio, Integer valorAdicional, Integer precioFinal, TipoAncheta codTipoAncheta) {
        this.codAncheta = codAncheta;
        this.nombreAncheta = nombreAncheta;
        this.cantProductos = cantProductos;
        this.precioParcial = precioParcial;
        this.utilidad = utilidad;
        this.precioDomicilio = precioDomicilio;
        this.valorAdicional = valorAdicional;
        this.precioFinal = precioFinal;
        this.codTipoAncheta = codTipoAncheta;
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

    public Integer getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Integer utilidad) {
        this.utilidad = utilidad;
    }

    public Integer getPrecioDomicilio() {
        return precioDomicilio;
    }

    public void setPrecioDomicilio(Integer precioDomicilio) {
        this.precioDomicilio = precioDomicilio;
    }

    public Integer getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Integer valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public Integer getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Integer precioFinal) {
        this.precioFinal = precioFinal;
    }

    public TipoAncheta getCodTipoAncheta() {
        return codTipoAncheta;
    }

    public void setCodTipoAncheta(TipoAncheta codTipoAncheta) {
        this.codTipoAncheta = codTipoAncheta;
    }

    @Override
    public String toString() {
        return "Ancheta{" + "codAncheta=" + codAncheta + ", nombreAncheta=" + nombreAncheta + ", cantProductos=" + cantProductos + ", precioParcial=" + precioParcial + ", utilidad=" + utilidad + ", precioDomicilio=" + precioDomicilio + ", valorAdicional=" + valorAdicional + ", precioFinal=" + precioFinal + ", codTipoAncheta=" + codTipoAncheta + '}';
    }
    
    
    
    
}
