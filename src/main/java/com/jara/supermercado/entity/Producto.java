package com.jara.supermercado.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private boolean activo = true; // soft delete opcional

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalles = new ArrayList<>();

}