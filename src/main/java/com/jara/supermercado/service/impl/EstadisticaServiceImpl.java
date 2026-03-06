package com.jara.supermercado.service.impl;

import com.jara.supermercado.entity.DetalleVenta;

import com.jara.supermercado.repository.VentaRepository;
import com.jara.supermercado.service.EstadisticaService;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class EstadisticaServiceImpl implements EstadisticaService {

    private final VentaRepository ventaRepository;

    public EstadisticaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public String obtenerProductoMasVendido() {

        return ventaRepository.findAll()
                .stream()

                // obtener todos los detalles
                .flatMap(venta -> venta.getDetalles().stream())

                // agrupar por nombre de producto
                .collect(
                        java.util.stream.Collectors.groupingBy(
                                d -> d.getProducto().getNombre(),
                                java.util.stream.Collectors.summingInt(DetalleVenta::getCantidad)
                        )
                )

                // buscar el mayor
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(e -> e.getValue()))
                .map(e -> e.getKey())
                .orElse("No hay ventas");
    }
}