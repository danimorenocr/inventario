package com.vainilla.daos;

import com.vainilla.configuracion.Conexion;
import com.vainilla.entidades.Ancheta;
import com.vainilla.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoAncheta extends Conexion implements Funcionalidad<Ancheta> {

    @Override
    public boolean registrar(Ancheta elObjeto) {
        try {
            cadenaSql = "INSERT INTO anchetas (nombre_ancheta, tipo_ancheta, cant_productos, valor_canasta, "
                    + "utilidad, domicilio, subtotal, otros, precio_final, publicidad) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setString(1, elObjeto.getNombreAncheta());
            consulta.setString(2, elObjeto.getTipoAncheta());
            consulta.setInt(3, elObjeto.getCantProductos());
            consulta.setInt(4, elObjeto.getValorCanasta());
            consulta.setInt(5, elObjeto.getUtilidad());
            consulta.setInt(6, elObjeto.getPrecioDomicilio());
            consulta.setInt(7, elObjeto.getSubTotal());
            consulta.setInt(8, elObjeto.getValorAdicional());
            consulta.setInt(9, elObjeto.getPrecioFinal());
            consulta.setInt(10, elObjeto.getPrecioPublicidad());

            cantidad = consulta.executeUpdate();

            objConexion.close();

            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoAncheta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Ancheta> consultar(String orden) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Ancheta buscar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean actualizar(Ancheta elObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer totalRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ancheta> buscarDato(String dato, String campo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
