package org.example.esclavos;

public class Fabrica {
    private int id;

    private String pais;
    private String ciudad;
    private int capacidad;
    private int nivelAutomatizacion;

    public Fabrica(int id, String pais, String ciudad, int capacidad, int nivelAutomatizacion) {
       this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.nivelAutomatizacion = nivelAutomatizacion;
    }

    public int getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNivelAutomatizacion() {
        return nivelAutomatizacion;
    }

    public void setNivelAutomatizacion(int nivelAutomatizacion) {
        this.nivelAutomatizacion = nivelAutomatizacion;
    }
    public void empezarJornada(){
        System.out.println("La fabrica en " + ciudad+" ,"+pais+" ha comenzado su jornada" );
    }
    public void terminarJornada(){
        System.out.println("La fabrica en "+ciudad+" ,"+pais+" ha terminado su jornada" );
    }

    @Override
    public String toString() {
        return "Fabrica{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", capacidad=" + capacidad +
                ", nivelAutomatizacion=" + nivelAutomatizacion +
                '}';
    }
}
