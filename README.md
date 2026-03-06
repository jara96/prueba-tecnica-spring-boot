# Prueba Técnica Spring Boot

API REST para la gestión de ventas en una cadena de supermercados desarrollada con **Java + Spring Boot**.

---

# 🎯 Objetivo

El objetivo de esta prueba es evaluar conocimientos en:

- Java
- Spring Boot
- JPA / Hibernate
- API REST
- DTOs
- Manejo de excepciones
- Lambdas y Streams
- Buenas prácticas de arquitectura

---

# 📘 Descripción

Una cadena de supermercados necesita digitalizar su sistema de control de ventas.

La API permite:

- Registrar productos
- Gestionar sucursales
- Registrar ventas
- Consultar ventas por sucursal
- Calcular estadísticas

---

# 🧱 Entidades del sistema

## Producto
Representa un artículo que puede venderse.

Campos principales:

- id
- nombre
- precio
- categoria

---

## Sucursal

Representa una ubicación física del supermercado.

Campos principales:

- id
- nombre
- direccion

---

## Venta

Representa una venta realizada en una sucursal.

Campos principales:

- id
- fecha
- total
- anulada

---

## DetalleVenta

Representa cada producto vendido dentro de una venta.

Campos principales:

- id
- cantidad
- precioUnitario
- subtotal

---

# 🔗 Relaciones

Las entidades se relacionan de la siguiente forma:

- **Una Sucursal tiene muchas Ventas**  
- **Una Venta tiene muchos DetallesVenta**  
- **Un Producto puede aparecer en muchos DetallesVenta**

---

# 🛠 Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database / MySQL
- Maven
- Postman

---

# 📡 Endpoints

## Productos

### Obtener productos

GET
