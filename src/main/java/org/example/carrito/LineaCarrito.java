package org.example.carrito;

import org.example.producto.Producto;

public class LineaCarrito {
    private int cantidad;
    private double subtotal;
    private Producto producto;

    public LineaCarrito(int cantidad, double subtotal, Producto producto) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal(producto.getPrecio());
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
    public double calcularSubtotal(double precioUnitario) {
        subtotal = precioUnitario*cantidad;
        return subtotal;

    }

    @Override
    public String toString() {
        return "LineaCarrito{" +
                "cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                ", producto=" + producto +
                '}';
    }
}
