package org.example;


import org.example.carrito.LineaCarrito;
import org.example.compra.Compra;
import org.example.compra.MetodoPago;
import org.example.esclavos.RegistroEsclavos;
import org.example.producto.Categoria;
import org.example.producto.Producto;
import org.example.usuario.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Main {

    private static int leerEntero(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println(" Entrada inválida. Ingresa un número entero:");
            }
        }
    }

    private static double leerDouble(Scanner sc) {
        while (true) {
            String s = sc.nextLine();
            try {
                return Double.parseDouble(s);
            } catch (Exception e) {
                System.out.println("Entrada inválida. Ingresa un número decimal:");
            }
        }
    }

    private static Producto buscarProducto(List<Producto> lista, int id) {
        for (Producto p : lista) if (p.getId() == id) return p;
        return null;
    }

    private static Usuario buscarUsuario(List<Usuario> lista, int id) {
        for (Usuario u : lista) if (u.getId() == id) return u;
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Producto> catalogo = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        Cliente cliente = null;
        Compra compraActual = null;
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("---- MENÚ PRINCIPAL ----");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear producto");
            System.out.println("3. Módulo Cliente / Tienda");
            System.out.println("4. Módulo Administración");
            System.out.println("5. Módulo Dueña / Esclavos (simulado)");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);
            switch (opcion) {
                case 1: {
                    System.out.println("Ingresa el ID del cliente: ");
                    int id = leerEntero(sc);
                    sc.nextLine();
                    System.out.println("Ingresa el nombre del cliente: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingresa el correo ");
                    String correo = sc.nextLine();
                    System.out.println("Ingresa la contraseña: ");
                    String clave = sc.nextLine();
                    Cliente c = new Cliente(id, nombre, correo, clave);
                    usuarios.add(c);
                    System.out.println("Cliente creado");
                    break;
                }

                case 2: {
                    System.out.println("Ingresa el ID del producto: ");
                    int idProducto = leerEntero(sc);
                    System.out.println("Ingresa el nombre del producto: ");
                    String nombreProducto = sc.nextLine();
                    System.out.println("Ingresa descripcion del producto: ");
                    String descripcionProducto = sc.nextLine();
                    System.out.println("Ingresa el precio del producto: ");
                    double precioProducto = leerDouble(sc);
                    System.out.println("Ingresa el stock del producto: ");
                    int stockProducto = leerEntero(sc);
                    System.out.println("Ingrese ID categoria del producto: ");
                    int idCategoria = leerEntero(sc);
                    System.out.println("Ingresa el nombre del producto: ");
                    String nombreCategoria = sc.nextLine();
                    Categoria categoria = new Categoria(idCategoria, nombreCategoria, "Creada por Usuario");
                    Producto producto = new Producto(idProducto, nombreProducto, descripcionProducto, precioProducto, stockProducto, new Date(), categoria);
                    catalogo.add(producto);
                    System.out.println("Producto creado");
                    break;
                }
                case 3: {
                    if (cliente == null) {
                        System.out.println("Primero crea el cliente");
                        break;
                    }
                    if (catalogo.isEmpty()) {
                        System.out.println("Primero crea un producto");
                        break;
                    }
                    compraActual = menuCliente(sc, cliente, catalogo, compraActual);
                    break;


                }
                case 4: {
                    menuAdmin(sc, usuarios, catalogo);
                    break;
                }
                case 5: {
                    menuEsclavos(sc);
                    break;

                }
                case 6: {
                    System.out.println("Saliendo");
                }
                default: {
                    System.out.println("Opcion Invalida");
                }
            }
        }
        sc.close();
    }

    private static Compra menuCliente(Scanner sc, Cliente cliente, List<Producto> catalogo, Compra compraActual) {
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("----MENU CLIENTE / TIENDA ----");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Crear compra");
            System.out.println("5. Pagar compra");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);
        switch (opcion) {
            case 1: {
                for (Producto p : catalogo) System.out.println(p);
                break;
            }
            case 2: {
                System.out.println("ID del producto: ");
                int id = leerEntero(sc);
                Producto producto = buscarProducto(catalogo, id);
                if (producto == null) {
                    System.out.println("El producto no existe");
                    break;
                }
                System.out.println("Cantidad del producto: ");
                int cantidad = leerEntero(sc);
                if (cantidad <= 0 || cantidad > producto.getStock()) {
                    System.out.println("Cantidad insuficiente");
                    break;
                }
                cliente.getCarrito().agregarLinea(producto,cantidad);
                System.out.println("Agregado al carrito");

                break;
            }
            case 3: {
            if (cliente.getCarrito().getLineas().isEmpty())
                System.out.println("El carrito esta vacio");
            else
                for (LineaCarrito linea : cliente.getCarrito().getLineas())
                    System.out.println(linea);
                    break;

            }
            case 4: {
                if (cliente.getCarrito().getLineas().isEmpty()) {
                    System.out.println("El carrito esta vacio");
                    break;
                }
                System.out.println("ID de la compra: ");
                int idC = leerEntero(sc);
                compraActual = new Compra(idC);
                for (LineaCarrito linea : cliente.getCarrito().getLineas()) {
                    compraActual.agregarLineaCompra(linea.getProducto(), linea.getCantidad(), linea.getProducto().getPrecio());
                }
                System.out.println("Compra creada " + compraActual);
                break;
            }
            case 5: {
                if (compraActual == null) {
                    System.out.println("La compra no existe ");
                    break;
                }
                System.out.println("ID metodo de pago: ");
                int idP = leerEntero(sc);
                System.out.println("Tipo de pago: ");
                String tipoPago = sc.nextLine();
                String titular = cliente.getNombre();
                System.out.println("Numero enmascarado: ");
                String numeroEnmascarado = sc.nextLine();
                MetodoPago metodoPago = new MetodoPago(idP, tipoPago, titular, numeroEnmascarado);
                compraActual.pagar(metodoPago);
                break;
            }
            case 6: {
                break;
            }
            default: {
                System.out.println("Opcion Invalida");
                break;
            }
            }

        }
        return compraActual;

        }
        private static void menuAdmin(Scanner sc,List <Usuario> usuarios, List<Producto> catalogo) {
            System.out.println("ID Administrador Usuario: ");
            int idAdmin = leerEntero(sc);
            AdminUsuario adminU = new AdminUsuario(idAdmin, "Admin", "admin@mail.com", "admin",
                    NivelAcceso.SUPERADMINISTRADOR);
            System.out.println("ID Administrador contenido: ");
            int idAdminC = leerEntero(sc);
            AdminContenido adminC = new AdminContenido(idAdminC, "Content", "content@mail.com", "1234");
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("--- MÓDULO ADMINISTRACIÓN ---");
            System.out.println("1. Listar usuarios");
            System.out.println("2. Suspender usuario por ID");
            System.out.println("3. Reactivar usuario por ID");
            System.out.println("4. Crear producto");
            System.out.println("5. Eliminar producto por ID");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);
            switch (opcion) {
                case 1: {
                    if(usuarios.isEmpty()) System.out.println("No hay usuarios");
                    else for (Usuario usuario : usuarios)
                        System.out.println("ID: " + usuario.getId()+ " Nombre: " + usuario.getNombre()+ " Activo: " + usuario.isActivo());
                    break;
                }
                case 2: {
                    System.out.println("ID  a suspender: ");
                    int idSusp = leerEntero(sc);
                    adminU.suspenderUsuario(buscarUsuario(usuarios, idSusp));
                    break;
                }
                case 3: {
                    System.out.println("ID  a reactivar : ");
                    int idReactivar = leerEntero(sc);
                    adminU.reactivarUsuario(buscarUsuario(usuarios, idReactivar));
                }
                case 4: {
                    System.out.println("ID producto: ");
                    int idProducto = leerEntero(sc);
                    System.out.println("Nombre producto: ");
                    String nombreProducto = sc.nextLine();
                    System.out.println("Precio producto: ");
                    double precioProducto = leerDouble(sc);
                    System.out.println("Cantidad producto: ");
                    int cantidadProducto = leerEntero(sc);
                    System.out.println("ID categoria: ");
                    int idCategoria = leerEntero(sc);
                    System.out.println("nombre categoria: ");
                    String nombreCategoria = sc.nextLine();
                    Categoria cat = new Categoria(idCategoria,nombreCategoria,"creado por admin");
                    Producto producto = new Producto(idProducto,nombreProducto,"Nuevo",precioProducto,cantidadProducto,new Date(),cat);
                    catalogo.add(producto);
                    adminC.publicarProducto(nombreProducto);
                    break;
                }
                case 5: {
                    System.out.println("ID producto a eliminar: ");
                    int idProducto = leerEntero(sc);
                    Producto producto = buscarProducto(catalogo,idProducto);
                    if (producto != null) {
                        catalogo.remove(producto);
                        adminC.eliminarProducto(producto.getNombre());
                    }else System.out.println("El producto no existe");
                    break;
                    }
                case 6: {
                    break;
                }
                default: {
                    System.out.println("Opcion Invalida");
                }
            }

        }

        }
        private static void menuEsclavos(Scanner sc) {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("--- DUEÑA / ESCLAVOS ---");
            System.out.println("1. Examinar caso");
            System.out.println("2. Editar registro");
            System.out.println("3. Registrar entrada");
            System.out.println("4. Volver");
            System.out.print("Opción: ");
            opcion = leerEntero(sc);
            ConsejoSombrio consejoSombrio = new ConsejoSombrio(1, "dueña");
            RegistroEsclavos registroEsclavos = new RegistroEsclavos(1,"se Registra la entrada");
            switch (opcion) {
                case 1: {
                    consejoSombrio.consultarModulo();
                    break;
                }
                case 2: {
                    registroEsclavos.editarEntrada(registroEsclavos.getId(), registroEsclavos.getObservaciones());
                    break;

                }
                case 3: {
                    registroEsclavos.agregarEntrada(registroEsclavos.getObservaciones());
                    break;
                }
                case 4: {
                    System.out.println("Volviendo");
                    break;
                }
                default: {
                    System.out.println("Opcion Invalida");
                }
            }
        }
        }

    }









