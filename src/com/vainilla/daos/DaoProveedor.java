package com.vainilla.daos;

import com.vainilla.configuracion.Conexion;
import com.vainilla.entidades.Proveedor;
import com.vainilla.interfaces.Funcionalidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProveedor extends Conexion implements Funcionalidad<Proveedor> {

    @Override
    public boolean registrar(Proveedor elObjeto) {
        try {
            cadenaSql = "INSERT INTO proveedores "
                    + "(nombre_proveedor, ciudad, telefono) "
                    + "VALUES (?,?,?);";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setString(1, elObjeto.getNombreProveedor());

            consulta.setString(2, elObjeto.getCiudadProveedor());
            consulta.setString(3, elObjeto.getTelefonoProveedor());

            cantidad = consulta.executeUpdate();

            objConexion.close();

            return cantidad > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Proveedor> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "p.cod_proveedor";
            }
            cadenaSql = "SELECT cod_proveedor, nombre_proveedor, ciudad, telefono, "
                    + "(SELECT COUNT(cod_proveedor) FROM productos WHERE cod_proveedor = p.cod_proveedor) AS cantProductos "
                    + "FROM proveedores p ORDER BY " + orden;

            consulta = objConexion.prepareStatement(cadenaSql);

            registros = consulta.executeQuery();

            List<Proveedor> arrayProveedor = new ArrayList<>();

            while (registros.next()) {
                int codProveed = registros.getInt(1);
                String nombre = registros.getString(2);
                String ciudad = registros.getString(3);
                String telefono = registros.getString(4);
                Integer cantProd = registros.getInt(5);

                Proveedor objProveedor = new Proveedor(codProveed, nombre, ciudad, telefono, cantProd);
                arrayProveedor.add(objProveedor);

            }
            objConexion.close();
            return arrayProveedor;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Proveedor buscar(Integer llavePrimaria) {
        try {
            cadenaSql = "SELECT cod_proveedor, nombre_proveedor, ciudad, telefono, "
                    + "(SELECT COUNT(cod_proveedor) FROM productos WHERE cod_proveedor = p.cod_proveedor) AS cantProductos "
                    + "FROM proveedores p WHERE p.cod_proveedor = ? ";

            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setInt(1, llavePrimaria);
            registros = consulta.executeQuery();

            Proveedor objProveedor = null;

            if (registros.next()) {
                int codProveed = registros.getInt(1);
                String nombre = registros.getString(2);
                String ciudad = registros.getString(3);
                String telefono = registros.getString(4);
                Integer cantProd = registros.getInt(5);
                objProveedor = new Proveedor(codProveed, nombre, ciudad, telefono, cantProd);

            }

            objConexion.close();
            return objProveedor;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        try {
            cadenaSql = "DELETE FROM proveedores WHERE cod_proveedor = ?";
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
    public Boolean actualizar(Proveedor elObjeto) {
        try {
            cadenaSql = "UPDATE proveedores SET nombre_proveedor = ?,"
                    + "ciudad = ?, telefono = ? "
                    + "WHERE cod_proveedor = ?";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setString(1, elObjeto.getNombreProveedor());
            consulta.setString(2, elObjeto.getCiudadProveedor());
            consulta.setString(3, elObjeto.getTelefonoProveedor());
            consulta.setInt(4, elObjeto.getCodProveedor());

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
            cadenaSql = "SELECT COUNT(cod_proveedor) FROM proveedores";
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
    public List<Proveedor> buscarDato(String dato, String campo) {
        try {

            cadenaSql = "SELECT cod_proveedor, nombre_proveedor, ciudad, telefono, "
                    + "(SELECT COUNT(cod_proveedor) FROM productos WHERE cod_proveedor = p.cod_proveedor) AS cantProductos "
                    + "FROM proveedores p WHERE " + campo + " LIKE ? ";
            System.out.println("cadena: " + cadenaSql);
            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setString(1, dato);
            registros = consulta.executeQuery();

            List<Proveedor> arrayProveedor = new ArrayList<>();

            while (registros.next()) {
                int codProveed = registros.getInt(1);
                String nombre = registros.getString(2);
                String ciudad = registros.getString(3);
                String telefono = registros.getString(4);
                int cantProduct = registros.getInt(5);

                Proveedor objProveedor = new Proveedor(codProveed, nombre, ciudad, telefono, cantProduct);
                arrayProveedor.add(objProveedor);

            }
            objConexion.close();
            return arrayProveedor;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
