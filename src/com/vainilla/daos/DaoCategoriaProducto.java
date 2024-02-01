package com.vainilla.daos;

import com.vainilla.configuracion.Conexion;
import com.vainilla.entidades.CategoriaProducto;
import com.vainilla.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCategoriaProducto extends Conexion implements Funcionalidad<CategoriaProducto> {

    @Override
    public boolean registrar(CategoriaProducto elObjeto) {
        try {
            cadenaSql = "INSERT INTO categoria_productos "
                    + "(nombre) "
                    + "VALUES (?);";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setString(1, elObjeto.getNombreCategoria());

            cantidad = consulta.executeUpdate();

            objConexion.close();

            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<CategoriaProducto> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "c.cod_categoria";
            }
            cadenaSql = "SELECT cod_categoria, nombre, "
                    + "(SELECT COUNT(cod_categoria) FROM productos WHERE cod_categoria = c.cod_categoria) AS cantProductos "
                    + "FROM categoria_productos c ORDER BY " + orden;

            consulta = objConexion.prepareStatement(cadenaSql);

            registros = consulta.executeQuery();

            List<CategoriaProducto> arrayCat = new ArrayList<>();

            while (registros.next()) {
                int codProveed = registros.getInt(1);
                String nombre = registros.getString(2);
                int cant = registros.getInt(3);

                CategoriaProducto objCat = new CategoriaProducto(codProveed, nombre, cant);
                arrayCat.add(objCat);

            }
            objConexion.close();
            return arrayCat;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public CategoriaProducto buscar(Integer llavePrimaria) {
        try {
            cadenaSql = "SELECT cod_categoria, nombre, "
                    + "(SELECT COUNT(cod_categoria) FROM productos WHERE cod_categoria = c.cod_categoria) AS cantProductos "
                    + "FROM categoria_productos c WHERE c.cod_categoria = ? ";

            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setInt(1, llavePrimaria);
            registros = consulta.executeQuery();

            CategoriaProducto objCat = null;

            if (registros.next()) {
                int codCat = registros.getInt(1);
                String nombre = registros.getString(2);
                Integer cantProd = registros.getInt(3);
                objCat = new CategoriaProducto(codCat, nombre, cantProd);

            }

            objConexion.close();
            return objCat;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
       try {
            cadenaSql = "DELETE FROM categoria_productos WHERE cod_categoria = ?";
            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setInt(1, llavePrimaria);
            cantidad = consulta.executeUpdate();
            objConexion.close();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Boolean actualizar(CategoriaProducto elObjeto) {
          try {
            cadenaSql = "UPDATE categoria_productos SET nombre = ? "
                
                    + "WHERE cod_categoria = ?";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setString(1, elObjeto.getNombreCategoria());
            consulta.setInt(2, elObjeto.getCodCategoria());

            cantidad = consulta.executeUpdate();
            objConexion.close();
            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Integer totalRegistros() {
        try {
            cadenaSql = "SELECT COUNT(cod_categoria) FROM categoria_productos";
            consulta = objConexion.prepareStatement(cadenaSql);

            registros = consulta.executeQuery();
            while (registros.next()) {
                cantidad = registros.getInt(1);
            }

            objConexion.close();
            return cantidad;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<CategoriaProducto> buscarDato(String dato, String campo) {
        try {

            cadenaSql = "SELECT cod_categoria, nombre, "
                    + "(SELECT COUNT(cod_categoria) FROM productos WHERE cod_categoria = c.cod_categoria) AS cantProductos "
                    + "FROM categoria_productos c WHERE " + campo + " LIKE ? ";
            System.out.println("cadena: " + cadenaSql);
            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setString(1, dato);
            registros = consulta.executeQuery();

            List<CategoriaProducto> arrayCat = new ArrayList<>();

            while (registros.next()) {
                int codProveed = registros.getInt(1);
                String nombre = registros.getString(2);
                int cant = registros.getInt(3);

                CategoriaProducto objCat = new CategoriaProducto(codProveed, nombre, cant);
                arrayCat.add(objCat);

            }
            objConexion.close();
            return arrayCat;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
