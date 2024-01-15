package com.vainilla.entidades;

public class CategoriaProducto {

    private Integer codCategoria;
    private String nombreCategoria;
    public Integer cantProductos;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer codCategoria, String nombreCategoria, Integer cantProductos) {
        this.codCategoria = codCategoria;
        this.nombreCategoria = nombreCategoria;
        this.cantProductos = cantProductos;
    }

    public Integer getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(Integer cantProductos) {
        this.cantProductos = cantProductos;
    }

   

    public Integer getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Integer codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" + "codCategoria=" + codCategoria + ", nombreCategoria=" + nombreCategoria + ", cantProductos=" + cantProductos + '}';
    }

   

}
