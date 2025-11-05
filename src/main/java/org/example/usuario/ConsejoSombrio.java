package org.example.usuario;

public class ConsejoSombrio {
    private int id;
    private String nombreClave;
    public ConsejoSombrio(int id, String nombreClave) {
        this.id = id;
        this.nombreClave = nombreClave;

    }
    public int getId() {
        return id;
    }
    public String getNombreClave() {
        return nombreClave;
    }
    public void setnombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }
    public void consultarModulo (){
        System.out.println("El Consejo Sombrio "+nombreClave+ " está consultando el modulo confidencial");
    }

    @Override
    public String toString() {
        return "ConsejoSombrio{" +
                "id=" + id +
                ", nombreClave='" + nombreClave + '\'' +
                '}';
    }
}
