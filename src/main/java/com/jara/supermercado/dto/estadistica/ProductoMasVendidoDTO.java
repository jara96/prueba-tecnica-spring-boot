package com.jara.supermercado.dto.estadistica;

import lombok.Getter;

@Getter
public class ProductoMasVendidoDTO {

    private Long productoId;
    private String nombreProducto;
    private Integer cantidadTotalVendida;

    public ProductoMasVendidoDTO(Long productoId, String nombreProducto, Integer cantidadTotalVendida) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidadTotalVendida = cantidadTotalVendida;
    }
}