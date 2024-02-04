package com.vainilla.daos;

import com.vainilla.configuracion.Conexion;
import com.vainilla.entidades.CategoriaProducto;
import com.vainilla.entidades.Producto;
import com.vainilla.entidades.Proveedor;
import com.vainilla.interfaces.Funcionalidad;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProducto extends Conexion implements Funcionalidad<Producto> {

    @Override
    public boolean registrar(Producto elObjeto) {
        try {
            cadenaSql = "INSERT INTO productos (nombre_producto, num_cajas, num_unidad_cajas, "
                    + "precio_caja, precio_unidad, precio_total_compra, envio, precio_final, fecha_compra, fecha_vencimiento, stock, "
                    + "tamanno, precioMetro, precio_unidad_con_envio, cod_proveedor, cod_categoria, ud_adq_envio) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            consulta = objConexion.prepareStatement(cadenaSql);

            consulta.setString(1, elObjeto.getNombreProducto());
            consulta.setInt(2, elObjeto.getNumeroCajas());
            consulta.setInt(3, elObjeto.getUnidadPorCaja());
            consulta.setInt(4, elObjeto.getPrecioCaja());
            consulta.setInt(5, elObjeto.getPrecioUnidad());
            consulta.setInt(6, elObjeto.getPrecioTotalCompra());
            consulta.setInt(7, elObjeto.getEnvio());
            consulta.setInt(8, elObjeto.getPrecioFinal());

            long milisegundos = elObjeto.getFechaCompra().getTime();
            Date fechaCompra = new Date(milisegundos);
            consulta.setDate(9, fechaCompra);

            long milisegundo = elObjeto.getFechaVencimiento().getTime();
            Date fechaVencimiento = new Date(milisegundo);
            consulta.setDate(10, fechaVencimiento);

            consulta.setInt(11, elObjeto.getStock());
            consulta.setDouble(12, elObjeto.getTamanno());
            consulta.setInt(13, elObjeto.getPrecioMetro());
            consulta.setInt(14, elObjeto.getPrecioUnidadEnvio());
            consulta.setInt(15, elObjeto.getCodProveedor().getCodProveedor());
            consulta.setInt(16, elObjeto.getCodCategoriaProducto().getCodCategoria());
            consulta.setInt(16, elObjeto.getUdAdquiridasEnvio());
            cantidad = consulta.executeUpdate();

            objConexion.close();

            return cantidad > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Producto> consultar(String orden) {
        try {
            if (orden.isEmpty()) {
                orden = "p.cod_producto";
            }
            cadenaSql = "SELECT cod_producto, nombre_producto, num_cajas, num_unidad_cajas, precio_caja, "
                    + "precio_unidad, precio_total_compra, envio, precio_final, fecha_compra, fecha_vencimiento, stock, tamanno, "
                    + "precioMetro, precio_unidad_con_envio, ud_adq_envio, c.cod_categoria, c.nombre_categoria, s.cod_proveedor, s.nombre_proveedor FROM productos p INNER JOIN proveedores s "
                    + "ON p.cod_proveedor = s.cod_proveedor "
                    + "INNER JOIN categoria_productos c "
                    + "ON p.cod_categoria = c.cod_categoria "
                    + "ORDER BY " + orden;

            consulta = objConexion.prepareStatement(cadenaSql);

            registros = consulta.executeQuery();

            List<Producto> arrayProducto = new ArrayList<>();

            while (registros.next()) {
                Integer codProducto = registros.getInt(1);
                String nombre = registros.getString(2);
                Integer numCajas = registros.getInt(3);
                Integer numUniCajas = registros.getInt(4);
                Integer precioCaja = registros.getInt(5);
                Integer precioUnidad = registros.getInt(6);
                Integer precioTotalCompra = registros.getInt(7);
                Integer envio = registros.getInt(8);
                Integer precioFinal = registros.getInt(9);
                Date fCompra = registros.getDate(10);
                Date fVencimiento = registros.getDate(11);
                Integer stock = registros.getInt(12);
                Double tamanno = registros.getDouble(13);
                Integer precioMetro = registros.getInt(14);
                Integer precioUnidadConEnvio = registros.getInt(15);
                Integer udAdquiridasEnvio = registros.getInt(16);
                Integer codCat = registros.getInt(17);
                String nomCat = registros.getString(18);
                Integer codProveedor = registros.getInt(19);
                String nomProveedor = registros.getString(20);

                Proveedor objProveedor = new Proveedor(codProveedor, nomProveedor, "", "", 0);
                CategoriaProducto objCat = new CategoriaProducto(codCat, nomCat, 0);

                Producto objProducto = new Producto(codProducto, nombre, numCajas, numUniCajas, precioCaja,
                        precioUnidad, precioTotalCompra, envio, precioFinal, fCompra, fVencimiento, stock,
                        tamanno, precioMetro, precioUnidadConEnvio, objCat, objProveedor, udAdquiridasEnvio);
                arrayProducto.add(objProducto);
            }
            objConexion.close();
            return arrayProducto;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Producto buscar(Integer llavePrimaria) {
        try {
            cadenaSql = "SELECT cod_producto, nombre_producto, num_cajas, num_unidad_cajas, precio_caja, "
                    + "precio_unidad, precio_total_compra, envio, precio_final, fecha_compra, fecha_vencimiento, stock, tamanno, "
                    + "precioMetro, precio_unidad_con_envio,ud_adq_envio, c.cod_categoria, c.nombre_categoria, s.cod_proveedor, s.nombre_proveedor FROM productos p INNER JOIN proveedores s "
                    + "ON p.cod_proveedor = s.cod_proveedor "
                    + "INNER JOIN categoria_productos c "
                    + "ON p.cod_categoria = c.cod_categoria WHERE p.cod_producto = ? ";

            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setInt(1, llavePrimaria);
            registros = consulta.executeQuery();

            Producto objProducto = null;

            if (registros.next()) {
               Integer codProducto = registros.getInt(1);
                String nombre = registros.getString(2);
                Integer numCajas = registros.getInt(3);
                Integer numUniCajas = registros.getInt(4);
                Integer precioCaja = registros.getInt(5);
                Integer precioUnidad = registros.getInt(6);
                Integer precioTotalCompra = registros.getInt(7);
                Integer envio = registros.getInt(8);
                Integer precioFinal = registros.getInt(9);
                Date fCompra = registros.getDate(10);
                Date fVencimiento = registros.getDate(11);
                Integer stock = registros.getInt(12);
                Double tamanno = registros.getDouble(13);
                Integer precioMetro = registros.getInt(14);
                Integer precioUnidadConEnvio = registros.getInt(15);
                Integer udAdquiridasEnvio = registros.getInt(16);
                Integer codCat = registros.getInt(17);
                String nomCat = registros.getString(18);
                Integer codProveedor = registros.getInt(19);
                String nomProveedor = registros.getString(20);

                Proveedor objProveedor = new Proveedor(codProveedor, nomProveedor, "", "", 0);
                CategoriaProducto objCat = new CategoriaProducto(codCat, nomCat, 0);

                objProducto = new Producto(codProducto, nombre, numCajas, numUniCajas, precioCaja, precioUnidad, precioTotalCompra, envio,
                        precioFinal, fCompra, fVencimiento, stock, tamanno, precioMetro, precioUnidadConEnvio, objCat, objProveedor, udAdquiridasEnvio);

            }

            objConexion.close();
            return objProducto;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        try {
            cadenaSql = "DELETE FROM productos WHERE cod_producto = ?";
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
    public Boolean actualizar(Producto elObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer totalRegistros() {
        try {
            cadenaSql = "SELECT COUNT(cod_producto) FROM productos";
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
    public List<Producto> buscarDato(String dato, String campo) {
        try {

            cadenaSql = "SELECT cod_producto, nombre_producto, num_cajas, num_unidad_cajas, precio_caja, "
                    + "precio_unidad, precio_total_compra, envio, precio_final, fecha_compra, fecha_vencimiento, stock, tamanno, "
                    + "precioMetro, precio_unidad_con_envio, ud_adq_envio,c.cod_categoria, c.nombre_categoria, s.cod_proveedor, s.nombre_proveedor FROM productos p INNER JOIN proveedores s "
                    + "ON p.cod_proveedor = s.cod_proveedor "
                    + "INNER JOIN categoria_productos c "
                    + "ON p.cod_categoria = c.cod_categoria WHERE " + campo + " LIKE ? ";

            consulta = objConexion.prepareStatement(cadenaSql);
            consulta.setString(1, dato);
            registros = consulta.executeQuery();

            List<Producto> arrayProducto = new ArrayList<>();

            while (registros.next()) {
                Integer codProducto = registros.getInt(1);
                String nombre = registros.getString(2);
                Integer numCajas = registros.getInt(3);
                Integer numUniCajas = registros.getInt(4);
                Integer precioCaja = registros.getInt(5);
                Integer precioUnidad = registros.getInt(6);
                Integer precioTotalCompra = registros.getInt(7);
                Integer envio = registros.getInt(8);
                Integer precioFinal = registros.getInt(9);
                Date fCompra = registros.getDate(10);
                Date fVencimiento = registros.getDate(11);
                Integer stock = registros.getInt(12);
                Double tamanno = registros.getDouble(13);
                Integer precioMetro = registros.getInt(14);
                Integer precioUnidadConEnvio = registros.getInt(15);
                Integer udAdquiridasEnvio = registros.getInt(16);
                Integer codCat = registros.getInt(17);
                String nomCat = registros.getString(18);
                Integer codProveedor = registros.getInt(19);
                String nomProveedor = registros.getString(20);

                Proveedor objProveedor = new Proveedor(codProveedor, nomProveedor, "", "", 0);
                CategoriaProducto objCat = new CategoriaProducto(codCat, nomCat, 0);

                Producto objProducto = new Producto(codProducto, nombre, numCajas, numUniCajas, precioCaja, precioUnidad, precioTotalCompra, envio,
                        precioFinal, fCompra, fVencimiento, stock, tamanno, precioMetro, precioUnidadConEnvio, objCat, objProveedor, udAdquiridasEnvio);
                arrayProducto.add(objProducto);

            }
            objConexion.close();
            return arrayProducto;

        } catch (SQLException ex) {
            Logger.getLogger(DaoProveedor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
