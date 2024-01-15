package com.vainilla.entidades;

public class ProductoAncheta {

    private Ancheta codAncheta;
    private Producto codProducto;

    public ProductoAncheta() {
    }

    public ProductoAncheta(Ancheta codAncheta, Producto codProducto) {
        this.codAncheta = codAncheta;
        this.codProducto = codProducto;
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

    @Override
    public String toString() {
        return "ProductoAncheta{" + "codAncheta=" + codAncheta + ", codProducto=" + codProducto + '}';
    }
    
    
    
}
