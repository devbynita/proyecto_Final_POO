package org.example.usuario;


import org.example.carrito.Carrito;
import org.example.compra.MetodoPago;

public class Cliente extends Usuario {
    private String direccionEnvio;
    private String telefono;
    private boolean pagoRealizado;
    private Carrito carrito;


    public Cliente(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
        this.direccionEnvio = "No especificado";
        this.telefono = "Sin telefono";
        this.pagoRealizado = false;
        this.carrito = new Carrito(id);

    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isPagoRealizado() {
        return pagoRealizado;
    }

    public boolean realizarPago(MetodoPago metodoPago) {
        double total = carrito.calcularTotal();

        if (total <= 0) {
            System.out.println("No hay productos en el carrito para pagar");
            return false;
        }
        if (metodoPago == null || !metodoPago.verificarMetodo()) {
            System.out.println( "Método de pago inválido.");
            return false;
        }
        pagoRealizado = true;
        System.out.println(" El cliente " + getNombre() +
                " ha pagado " + total + " usando " + metodoPago.getTipo() + ".");
        return true;
    }

    public void cancelarPago() {
        if (pagoRealizado) {
            pagoRealizado = false;
            System.out.println("El pago ha sido cancelado ");
        }else {
            System.out.println("No se ha realizado un pago anteriormente.");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "direccionEnvio='" + direccionEnvio + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pagoRealizado=" + pagoRealizado +
                '}';
    }
}
