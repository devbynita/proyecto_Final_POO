package org.example.esclavos;

import java.util.Date;

public class TrabajadorEsclavizado {
    private  int id;
    private String nombre;
    private String paisOrigen;
    private int edad;
    private Date fechaCaptura;
    private String salud;

    public TrabajadorEsclavizado(int id, String nombre, String paisOrigen, int edad, Date fechaCaptura, String salud) {
        this.id = id;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.edad = edad;
        this.fechaCaptura = fechaCaptura;
        this.salud = salud;
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

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }
    public void trabajar(){
        System.out.println("El trabajador " + nombre + " esta trabajando. ");
    }

    @Override
    public String toString() {
        return "TrabajadorEsclavizado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", paisOrigen='" + paisOrigen + '\'' +
                ", edad=" + edad +
                ", fechaCaptura=" + fechaCaptura +
                ", salud='" + salud + '\'' +
                '}';
    }
}
