package com.jara.supermercado.dto.producto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String categoria;
    private boolean activo;

}