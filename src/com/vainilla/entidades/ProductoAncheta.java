package com.vainilla.entidades;

public class ProductoAncheta {

    private Ancheta codAncheta;
    private Producto codProducto;
    private Integer cantProductos;
    private Integer precioTotal;

    public ProductoAncheta() {
    }

    public ProductoAncheta(Ancheta codAncheta, Producto codProducto, Integer cantProductos, Integer precioTotal) {
        this.codAncheta = codAncheta;
        this.codProducto = codProducto;
        this.cantProductos = cantProductos;
        this.precioTotal = precioTotal;
    }

    public Ancheta getCodAncheta() {
        return codAncheta;
    }

    public void setCodAncheta(Ancheta codAncheta) {
        this.codAncheta = codAncheta;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public Integer getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(Integer cantProductos) {
        this.cantProductos = cantProductos;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "ProductoAncheta{" + "codAncheta=" + codAncheta + ", codProducto=" + codProducto + ", cantProductos=" + cantProductos + ", precioTotal=" + precioTotal + '}';
    }

}
