package com.jara.supermercado.mapper;

import com.jara.supermercado.dto.producto.ProductoRequestDTO;
import com.jara.supermercado.dto.producto.ProductoResponseDTO;
import com.jara.supermercado.entity.Producto;

public class ProductoMapper {

    public static Producto toEntity(ProductoRequestDTO dto) {

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(dto.getCategoria());

        return producto;
    }

    public static ProductoResponseDTO toDTO(Producto producto) {

        ProductoResponseDTO dto = new ProductoResponseDTO();

        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setCategoria(producto.getCategoria());
        dto.setActivo(producto.isActivo());

        return dto;
    }
}