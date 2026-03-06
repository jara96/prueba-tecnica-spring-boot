package com.jara.supermercado.service;

import com.jara.supermercado.entity.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();

    Producto crearProducto(Producto producto);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarProducto(Long id);
}