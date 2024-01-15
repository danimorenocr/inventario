package com.vainilla.entidades;

public class TipoAncheta {
    private Integer codAncheta;
    private String nombreAncheta;

    public TipoAncheta() {
    }

    public TipoAncheta(Integer codAncheta, String nombreAncheta) {
        this.codAncheta = codAncheta;
        this.nombreAncheta = nombreAncheta;
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

    @Override
    public String toString() {
        return "TipoAncheta{" + "codAncheta=" + codAncheta + ", nombreAncheta=" + nombreAncheta + '}';
    }
    
    
}
