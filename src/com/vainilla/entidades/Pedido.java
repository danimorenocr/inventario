package com.vainilla.entidades;

import com.vainilla.entidades.Ancheta;
import com.vainilla.entidades.Cliente;
import java.util.Date;

public class Pedido {
private Integer codPedido;
private String nombreAncheta;
private String nombreCliente;
private Integer CantAncheta;
private Integer precioTotal;
private Date fechaVenta;
private Date fechaEntrega;
private String nombreDestinatario;
private String mensaje;
private String medioPago;
private String direccionEntrega;
private Ancheta codigoAncheta;
private Cliente codCliente;

    public Pedido() {
    }

    public Pedido(Integer codPedido, String nombreAncheta, String nombreCliente, Integer CantAncheta, Integer precioTotal, Date fechaVenta, Date fechaEntrega, String nombreDestinatario, String mensaje, String medioPago, String direccionEntrega, Ancheta codigoAncheta, Cliente codCliente) {
        this.codPedido = codPedido;
        this.nombreAncheta = nombreAncheta;
        this.nombreCliente = nombreCliente;
        this.CantAncheta = CantAncheta;
        this.precioTotal = precioTotal;
        this.fechaVenta = fechaVenta;
        this.fechaEntrega = fechaEntrega;
        this.nombreDestinatario = nombreDestinatario;
        this.mensaje = mensaje;
        this.medioPago = medioPago;
        this.direccionEntrega = direccionEntrega;
        this.codigoAncheta = codigoAncheta;
        this.codCliente = codCliente;
    }

    public Integer getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Integer codPedido) {
        this.codPedido = codPedido;
    }

    public String getNombreAncheta() {
        return nombreAncheta;
    }

    public void setNombreAncheta(String nombreAncheta) {
        this.nombreAncheta = nombreAncheta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getCantAncheta() {
        return CantAncheta;
    }

    public void setCantAncheta(Integer CantAncheta) {
        this.CantAncheta = CantAncheta;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public void setNombreDestinatario(String nombreDestinatario) {
        this.nombreDestinatario = nombreDestinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public Ancheta getCodigoAncheta() {
        return codigoAncheta;
    }

    public void setCodigoAncheta(Ancheta codigoAncheta) {
        this.codigoAncheta = codigoAncheta;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codPedido=" + codPedido + ", nombreAncheta=" + nombreAncheta + ", nombreCliente=" + nombreCliente + ", CantAncheta=" + CantAncheta + ", precioTotal=" + precioTotal + ", fechaVenta=" + fechaVenta + ", fechaEntrega=" + fechaEntrega + ", nombreDestinatario=" + nombreDestinatario + ", mensaje=" + mensaje + ", medioPago=" + medioPago + ", direccionEntrega=" + direccionEntrega + ", codigoAncheta=" + codigoAncheta + ", codCliente=" + codCliente + '}';
    }


}
