package org.example.usuario;

public class Cliente extends Usuario {
    private String direccionEnvio;
    private String telefono;
    private boolean pagoRealizado;

    public Cliente(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
        this.direccionEnvio = "No especificado";
        this.telefono = "Sin telefono";
        this.pagoRealizado = false;
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

    public void realizarPago(double monto, String metodoPago) {
        if (!pagoRealizado) {
            pagoRealizado = true;
            System.out.println("El cliente " + getNombre() +
                    " ha realizado un pago de $" + monto + " con " + metodoPago + ".");
        } else {
            System.out.println("Ya se ha realizado un pago anteriormente.");
        }
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
