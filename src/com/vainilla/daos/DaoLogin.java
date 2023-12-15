package com.vainilla.daos;

import com.vainilla.configuracion.Conexion;
import com.vainilla.entidades.Login;
import com.vainilla.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoLogin extends Conexion implements Funcionalidad<Login> {

    @Override
    public boolean registrar(Login Usuario) {
        try {
            cadenaSql = "INSERT INTO usuarios "
                    + "(nombre, contrasenna) "
                    + "VALUES (?,?);";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setString(1, Usuario.getNombreUsuario());

            consulta.setString(2, Usuario.getContrasennaUsuario());

            cantidad = consulta.executeUpdate();

            objConexion.close();

            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Login> consultar(String orden) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Login buscar(String usuario) {
    try {
            cadenaSql = "SELECT nombre, contrasenna FROM usuarios WHERE nombre = ? ";

            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setString(1, usuario);
            registros = consulta.executeQuery();

            Login objUsuario = null;

            if (registros.next()) {
                String nombre = registros.getString(1);
                String contra = registros.getString(2);
                objUsuario = new Login(nombre, contra);

            }

            objConexion.close();
            return objUsuario;

        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Login buscar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean actualizar(Login elObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer totalRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
