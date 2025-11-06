package org.example.carrito;

import org.example.producto.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int id;
    private LocalDate fechaCreacion;
    private final List<LineaCarrito> lineas=new ArrayList<>();

    public Carrito(int id) {
        this.id = id;
        this.fechaCreacion = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public List<LineaCarrito> getLineas() {
        return lineas;
    }

    public void agregarLinea(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) return ;
        for (LineaCarrito linea: lineas) {
            if (linea.getProducto().getId() == producto.getId()) {
                linea.setCantidad(linea.getCantidad() + cantidad);
                return;
            }
        }
        lineas.add(new LineaCarrito(cantidad, producto.getPrecio() * cantidad, producto));
        }
        public void quitarProducto(Producto producto) {
        if (producto == null) return ;

        for (int i = 0; i < lineas.size(); i++) {
                if (lineas.get(i).getProducto().getId() == producto.getId()) {
                    lineas.remove(i);
                    break;
                }
            }
        }
        public double calcularTotal() {
        double total=0;
        for (LineaCarrito linea: lineas) {
            total+=linea.getSubtotal();
        }
        return total;

        }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", fechaCreacion=" + fechaCreacion +
                ", lineas=" + lineas +
                '}';
    }
}

