## Proyecto Final POO – Sistema de Tienda Virtual

## Descripción General

Este proyecto es una simulación de una tienda virtual desarrollada en Java. Su propósito es aplicar los principios de la Programación Orientada a Objetos (POO) (herencia, encapsulamiento, polimorfismo y composición)
a través de la interacción entre diferentes tipos de usuarios y módulos.

El sistema permite crear clientes, administradores y productos, realizar compras, procesar pagos y administrar información, todo mediante un *menú interactivo en consola*.  
Cada clase representa un componente del sistema (usuarios, productos, carrito, compras, pagos, etc.), y sus relaciones reflejan un modelo real de negocio.

## Funcionamiento del Menú

El sistema se ejecuta desde la clase *Main.java, que contiene un **menú interactivo por consola*.  
Este menú guía al usuario a través de las diferentes opciones del sistema.

### Menú Principal:
1. *Crear cliente:* registra un nuevo usuario del tipo Cliente.  
2. *Crear producto:* permite ingresar productos al catálogo.  
3. *Módulo Cliente / Tienda:* permite al cliente ver productos, agregar al carrito, crear y pagar compras.  
4. *Módulo Administración:* acceso para administradores de usuario y contenido.  
5. *Módulo Dueña / Esclavos (simulado):* funcionalidades simbólicas según el diagrama UML.  
6. *Salir:* termina la ejecución del programa.

### Módulo Cliente / Tienda:
- Ver catálogo de productos.  
- Agregar productos al carrito.  
- Crear una compra a partir del carrito.  
- Realizar el pago usando un método (tarjeta, efectivo, transferencia).  

Cada acción modifica los objetos en memoria (por ejemplo, se actualiza el carrito o el estado de la compra).

### Módulo Administración:
- Listar usuarios creados.  
- Suspender o reactivar usuarios (AdminUsuario).  
- Crear o eliminar productos (AdminContenido).

## En resumen:  
El programa ejecuta una simulación completa de una tienda virtual,  
donde se combinan *herencia, **composición, **asociaciones entre clases*  
y un *menú modular* que permite interactuar con todas las entidades del sistema desde la consola.
El programa ejecuta una simulación completa de una tienda virtual,  
donde se combinan *herencia, **composición, **asociaciones entre clases*  
y un *menú modular* que permite interactuar con todas las entidades del sistema desde la consola

eso es todo :) <3
