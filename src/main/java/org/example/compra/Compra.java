package org.example.compra;

import org.example.producto.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private int id;
    private LocalDate fecha;
    private int total;
    private EstadoCompra estado;
    private List<LineaCompra> compras;
    public  Compra ( int id){
        this.id=id;
        this.fecha=LocalDate.now();
        this.total=0;
        this.estado=EstadoCompra.PENDIENTE;
        this.compras=new ArrayList<>();
    }

    public List<LineaCompra> getCompras() {
        return compras;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public int getTotal() {
        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }
    public void agregarLineaCompra(Producto  producto, int cantidad, double precio) {
        if (producto == null||cantidad<=0 || precio<=0) {
            System.out.println("Datos invalidos para crear una linea");
            return;
        }
        LineaCompra nuevaLinea = new LineaCompra(cantidad,precio,producto);
        compras.add(nuevaLinea);
        calcularTotal();
    }

    private double calcularTotal() {
        total=0;
        for (LineaCompra lineaCompra : compras) {
            total += lineaCompra.getSubtotal();
        }
        return total;
    }
    public boolean pagar( MetodoPago metodoPago ){
        if(metodoPago==null || !metodoPago.verificarMetodo()){
            System.out.println("MetodoPago Invalido");
            return false;
        }
        if (estado==EstadoCompra.PAGADA) {
            System.out.println("La compra ya fue pagada anteriormente");
            return false;
        }
        if (total <= 0){
            System.out.println("No hay productos en la compra");
            return false;
        }
        estado=EstadoCompra.PAGADA;
        System.out.println(" Compra #" + id + " pagada exitosamente por $" + total +
                " con " + metodoPago.getTipo() + ".");
        return true;
    }

    @Override
    public String   toString() {
        return "Compra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + total +
                ", estado=" + estado +
                ", compras=" + compras +
                '}';
    }
}
