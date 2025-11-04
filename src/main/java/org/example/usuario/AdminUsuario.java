package org.example.usuario;

public class AdminUsuario extends Usuario {
    private NivelAcceso acceso;
    public AdminUsuario(int id, String nombre, String email, String password, NivelAcceso acceso) {
        super(id, nombre, email, password);
        this.acceso = acceso;
    }

    public NivelAcceso getAcceso() {
        return acceso;
    }

    public void setAcceso(NivelAcceso acceso) {
        this.acceso = acceso;
    }
    public void gestionarUsuario(Usuario u) {
        if (acceso == NivelAcceso.ADMINISTRADOR || acceso == NivelAcceso.SUPERADMINISTRADOR) {
            System.out.println(" " + getNombre() + " gestionó al usuario " + u.getNombre());
        } else {
            System.out.println(" No tiene permisos para esta acción.");
        }
    }
    public void reactivarUsuario(Usuario u) {
        if(!u.isActivo()){
            u.setActivo(false);
            System.out.println("Se ha suspendido el usuario " + u.getNombre());
        } else {
            System.out.println("El usuario "+ u.getNombre() +" ha suspendido el usuario " + u.getNombre()+ " ya estaba activo");

        }
    }
    public void suspenderUsuario(Usuario u) {
        if(u.isActivo()){
            u.setActivo(true);
            System.out.println("Se ha suspendido el usuario " + u.getNombre());
            }else {
            System.out.println("El usuario "+u.getNombre()+" ya estaba activo");
        }
    }
    @Override
    public String toString() {
        return super.toString() +
                "acceso= " + acceso +
                '}';
    }
}
