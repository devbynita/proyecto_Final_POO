package org.example.usuario;

import java.util.Date;

public class Duena extends Usuario {
 private String claveMaestra;
 private Date fechaCoronacion;

    public Duena(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
        this.claveMaestra = claveMaestra;
        this.fechaCoronacion = new Date();
    }

    public String getClaveMaestra() {
        return claveMaestra;
    }

    public void setClaveMaestra(String claveMaestra) {
        this.claveMaestra = claveMaestra;
    }

    public Date getFechaCoronacion() {
        return fechaCoronacion;
    }

    public void setFechaCoronacion(Date fechaCoronacion) {
        this.fechaCoronacion = fechaCoronacion;
    }

}
