package org.example.esclavos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroEsclavos {
    private int id;
    private String observaciones;
    private Date fechaApertura;
    private List<String> entradas;

    public RegistroEsclavos(int id, String observaciones) {
        this.id = id;
        this.observaciones = observaciones;
        this.fechaApertura = new Date();
        this.entradas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void agregarEntrada(String texto) {
        this.entradas.add(texto);
        System.out.println("Nueva entrada agregada al reegistro " + texto);
    }
    public void editarEntrada(int indice,String texto) {
        if(indice >= 0 && indice < this.entradas.size()) {
            this.entradas.set(indice, texto);
            System.out.println("Entrada # " +  indice + " editada al registro " + texto);
        } else  {
            System.out.println("Indice fuera de rango");
        }
    }

    @Override
    public String toString() {
        return "RegistroEsclavos{" +
                "id=" + id +
                ", observaciones='" + observaciones + '\'' +
                ", fechaApertura=" + fechaApertura +
                '}';
    }
}
