package org.example.usuario;

import org.example.producto.Producto;

public class DesarrolladorProducto extends Usuario {
    private String especialidad;
    public DesarrolladorProducto(int id, String nombre, String email, String password, String especialidad) {
        super(id, nombre, email, password);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public void desarrollarProducto(Producto p, String faseDesarrollo) {
        System.out.println(" El desarrollador " + getNombre() +
                " está desarrollando el producto: " + p +
                        " | Fase: " + faseDesarrollo +
                        " | Especialidad: " + especialidad);

    }

    @Override
    public String toString() {
        return super.toString() + "  Especialidad: " + especialidad;
    }
}
