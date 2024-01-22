package com.vainilla.entidades;

import java.util.Date;

public class Producto {

    private Integer codProducto;
    private String nombreProducto;
    private Integer numeroCajas;
    private Integer unidadPorCaja;
    private Integer totalUnidades;
    private Integer precioCaja;
    private Integer precioUnidad;
    private Integer envio;
    private Integer precioFinal;
    private Date fechaCompra;
    private Date fechaVencimiento;
    private Integer stock;
    private Double tamanno;
    private Integer precioMetro;
    private CategoriaProducto categoriaProducto;
    private Proveedor nombreProveedor;

    public Producto() {
    }

    public Producto(Integer codProducto, String nombreProducto, Integer numeroCajas, Integer unidadPorCaja, Integer totalUnidades, Integer precioCaja, Integer precioUnidad, Integer envio, Integer precioFinal, Date fechaCompra, Date fechaVencimiento, Integer stock, Double tamanno, Integer precioMetro, CategoriaProducto categoriaProducto, Proveedor nombreProveedor) {
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.numeroCajas = numeroCajas;
        this.unidadPorCaja = unidadPorCaja;
        this.totalUnidades = totalUnidades;
        this.precioCaja = precioCaja;
        this.precioUnidad = precioUnidad;
        this.envio = envio;
        this.precioFinal = precioFinal;
        this.fechaCompra = fechaCompra;
        this.fechaVencimiento = fechaVencimiento;
        this.stock = stock;
        this.tamanno = tamanno;
        this.precioMetro = precioMetro;
        this.categoriaProducto = categoriaProducto;
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getNumeroCajas() {
        return numeroCajas;
    }

    public void setNumeroCajas(Integer numeroCajas) {
        this.numeroCajas = numeroCajas;
    }

    public Integer getUnidadPorCaja() {
        return unidadPorCaja;
    }

    public void setUnidadPorCaja(Integer unidadPorCaja) {
        this.unidadPorCaja = unidadPorCaja;
    }

    public Integer getTotalUnidades() {
        return totalUnidades;
    }

    public void setTotalUnidades(Integer totalUnidades) {
        this.totalUnidades = totalUnidades;
    }

    public Integer getPrecioCaja() {
        return precioCaja;
    }

    public void setPrecioCaja(Integer precioCaja) {
        this.precioCaja = precioCaja;
    }

    public Integer getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Integer precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Integer getEnvio() {
        return envio;
    }

    public void setEnvio(Integer envio) {
        this.envio = envio;
    }

    public Integer getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Integer precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getTamanno() {
        return tamanno;
    }

    public void setTamanno(Double tamanno) {
        this.tamanno = tamanno;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public Proveedor getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(Proveedor nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getPrecioMetro() {
        return precioMetro;
    }

    public void setPrecioMetro(Integer precioMetro) {
        this.precioMetro = precioMetro;
    }

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", nombreProducto=" + nombreProducto + ", numeroCajas=" + numeroCajas + ", unidadPorCaja=" + unidadPorCaja + ", totalUnidades=" + totalUnidades + ", precioCaja=" + precioCaja + ", precioUnidad=" + precioUnidad + ", envio=" + envio + ", precioFinal=" + precioFinal + ", fechaCompra=" + fechaCompra + ", fechaVencimiento=" + fechaVencimiento + ", stock=" + stock + ", tamanno=" + tamanno + ", precioMetro=" + precioMetro + ", categoriaProducto=" + categoriaProducto + ", nombreProveedor=" + nombreProveedor + '}';
    }

}
