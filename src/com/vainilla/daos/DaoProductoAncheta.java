package com.vainilla.daos;

import com.vainilla.configuracion.Conexion;
import com.vainilla.entidades.ProductoAncheta;
import com.vainilla.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProductoAncheta extends Conexion implements Funcionalidad<ProductoAncheta> {

    @Override
    public boolean registrar(ProductoAncheta elObjeto) {
        try {
            cadenaSql = "INSERT INTO productos_anchetas (cod_producto, cod_ancheta, cantidad_productos,precio_total_producto) VALUES (?, ?, ?,?)";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setInt(1, elObjeto.getCodProducto().getCodProducto());
            consulta.setInt(2, elObjeto.getCodAncheta().getCodAncheta());
            consulta.setInt(3, elObjeto.getCantProductos());
            consulta.setInt(4, elObjeto.getPrecioTotal());

            cantidad = consulta.executeUpdate();

            objConexion.close();

            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProductoAncheta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<ProductoAncheta> consultar(String orden) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoAncheta buscar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean actualizar(ProductoAncheta elObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer totalRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoAncheta> buscarDato(String dato, String campo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
