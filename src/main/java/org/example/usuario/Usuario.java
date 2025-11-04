package org.example.usuario;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private LocalDate fechaRegistro;
    private boolean activo;

    public Usuario(int id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaRegistro = LocalDate.now();
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean iniciarSesion(String emailingresado, String claveIngresada) {
        return this.email.equals(emailingresado) && this.password.equals(claveIngresada);

    }
    public void cerrarSesion() {
        System.out.println("Se ha cerrado la sesion");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", activo=" + activo +
                '}';
    }
}
