package org.example.usuario;

public class AdminContenido extends Usuario {
    private boolean permisosEdicion;
    public AdminContenido(int id, String nombre, String email, String password) {
        super(id, nombre, email, password);
        this.permisosEdicion = true;
    }

    public boolean tienePermisosEdicion() {
        return permisosEdicion;
    }

    public void setPermisosEdicion(boolean permisosEdicion) {
        this.permisosEdicion = permisosEdicion;
    }
    public void publicarProducto( String nombreProducto){
        if (this.permisosEdicion == true){
            System.out.println("El producto " + nombreProducto + " se ha publicado");
        } else  {
            System.out.println("No tienes permisos para publicar productos");
        }
    }
    public void editarProducto( String nombreProducto){
        if (this.permisosEdicion == true){
            System.out.println("El producto " + nombreProducto + " se ha editado");
        } else   {
            System.out.println("No tienes permisos para editar productos");
        }
    }
    public void eliminarProducto(String nombreProducto){
        if (this.permisosEdicion == true){
            System.out.println("El producto " + nombreProducto + " se ha eliminado");
        }else   {
            System.out.println("No tienes permisos para eliminar productos");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "  Permisos de edición: " + permisosEdicion;
    }
}

