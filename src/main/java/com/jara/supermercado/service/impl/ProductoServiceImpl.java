package com.jara.supermercado.service.impl;

import com.jara.supermercado.entity.Producto;
import com.jara.supermercado.repository.ProductoRepository;
import com.jara.supermercado.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto productoActualizado) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setCategoria(productoActualizado.getCategoria());

        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}