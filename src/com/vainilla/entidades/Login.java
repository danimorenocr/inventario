package com.vainilla.entidades;

public class Login {

    private String nombreUsuario;
    private String contrasennaUsuario;

    public Login() {
    }

    public Login(String nombreUsuario, String contrasennaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasennaUsuario = contrasennaUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasennaUsuario() {
        return contrasennaUsuario;
    }

    public void setContrasennaUsuario(String contrasennaUsuario) {
        this.contrasennaUsuario = contrasennaUsuario;
    }

    @Override
    public String toString() {
        return "Login{" + "nombreUsuario=" + nombreUsuario + ", contrasennaUsuario=" + contrasennaUsuario + '}';
    }
    
    
}
