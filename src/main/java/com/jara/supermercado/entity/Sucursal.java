package com.jara.supermercado.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Venta> ventas = new ArrayList<>();

}