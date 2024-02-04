package com.vainilla.entidades;

import java.util.Date;

public class Producto {

    private Integer codProducto;
    private String nombreProducto;
    private Integer numeroCajas;
    private Integer unidadPorCaja;
    private Integer precioCaja;
    private Integer precioUnidad;
    private Integer precioTotalCompra;
    private Integer envio;
    private Integer precioFinal;
    private Date fechaCompra;
    private Date fechaVencimiento;
    private Integer stock;
    private Double tamanno;
    private Integer precioMetro;
    private Integer precioUnidadEnvio;
    private CategoriaProducto codCategoriaProducto;
    private Proveedor codProveedor;
    private Integer udAdquiridasEnvio;

    public Producto() {
    }

    public Producto(Integer codProducto, String nombreProducto, Integer numeroCajas, Integer unidadPorCaja, Integer precioCaja, Integer precioUnidad, Integer precioTotalCompra, Integer envio, Integer precioFinal, Date fechaCompra, Date fechaVencimiento, Integer stock, Double tamanno, Integer precioMetro, Integer precioUnidadEnvio, CategoriaProducto codCategoriaProducto, Proveedor codProveedor, Integer udAdquiridasEnvio) {
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.numeroCajas = numeroCajas;
        this.unidadPorCaja = unidadPorCaja;
        this.precioCaja = precioCaja;
        this.precioUnidad = precioUnidad;
        this.precioTotalCompra = precioTotalCompra;
        this.envio = envio;
        this.precioFinal = precioFinal;
        this.fechaCompra = fechaCompra;
        this.fechaVencimiento = fechaVencimiento;
        this.stock = stock;
        this.tamanno = tamanno;
        this.precioMetro = precioMetro;
        this.precioUnidadEnvio = precioUnidadEnvio;
        this.codCategoriaProducto = codCategoriaProducto;
        this.codProveedor = codProveedor;
        this.udAdquiridasEnvio = udAdquiridasEnvio;
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

    public Integer getPrecioTotalCompra() {
        return precioTotalCompra;
    }

    public void setPrecioTotalCompra(Integer precioTotalCompra) {
        this.precioTotalCompra = precioTotalCompra;
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

    public Integer getPrecioMetro() {
        return precioMetro;
    }

    public void setPrecioMetro(Integer precioMetro) {
        this.precioMetro = precioMetro;
    }

    public Integer getPrecioUnidadEnvio() {
        return precioUnidadEnvio;
    }

    public void setPrecioUnidadEnvio(Integer precioUnidadEnvio) {
        this.precioUnidadEnvio = precioUnidadEnvio;
    }

    public CategoriaProducto getCodCategoriaProducto() {
        return codCategoriaProducto;
    }

    public void setCodCategoriaProducto(CategoriaProducto codCategoriaProducto) {
        this.codCategoriaProducto = codCategoriaProducto;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Integer getUdAdquiridasEnvio() {
        return udAdquiridasEnvio;
    }

    public void setUdAdquiridasEnvio(Integer udAdquiridasEnvio) {
        this.udAdquiridasEnvio = udAdquiridasEnvio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", nombreProducto=" + nombreProducto + ", numeroCajas=" + numeroCajas + ", unidadPorCaja=" + unidadPorCaja + ", precioCaja=" + precioCaja + ", precioUnidad=" + precioUnidad + ", precioTotalCompra=" + precioTotalCompra + ", envio=" + envio + ", precioFinal=" + precioFinal + ", fechaCompra=" + fechaCompra + ", fechaVencimiento=" + fechaVencimiento + ", stock=" + stock + ", tamanno=" + tamanno + ", precioMetro=" + precioMetro + ", precioUnidadEnvio=" + precioUnidadEnvio + ", codCategoriaProducto=" + codCategoriaProducto + ", codProveedor=" + codProveedor + ", udAdquiridasEnvio=" + udAdquiridasEnvio + '}';
    }
    

    

}
