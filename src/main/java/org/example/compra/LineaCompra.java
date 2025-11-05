package org.example.compra;

import org.example.producto.Producto;

public class LineaCompra {
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private Producto producto;

    public LineaCompra(int cantidad, double precioUnitario, Producto producto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = calcularSubtotal();
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.subtotal = calcularSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public double calcularSubtotal() {
    subtotal= cantidad*precioUnitario;
    return subtotal;
    }

    @Override
    public String toString() {
        return "LineaCompra{" +
                "cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                '}';
    }
}
