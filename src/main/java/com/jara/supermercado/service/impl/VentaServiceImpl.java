package com.jara.supermercado.service.impl;


import com.jara.supermercado.dto.venta.DetalleVentaRequestDTO;
import com.jara.supermercado.dto.venta.VentaRequestDTO;
import com.jara.supermercado.entity.DetalleVenta;
import com.jara.supermercado.entity.Producto;
import com.jara.supermercado.entity.Sucursal;
import com.jara.supermercado.entity.Venta;
import com.jara.supermercado.repository.ProductoRepository;
import com.jara.supermercado.repository.SucursalRepository;
import com.jara.supermercado.repository.VentaRepository;
import com.jara.supermercado.service.VentaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;

    public VentaServiceImpl(
            VentaRepository ventaRepository,
            ProductoRepository productoRepository,
            SucursalRepository sucursalRepository) {

        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public Venta crearVenta(VentaRequestDTO dto) {

        Sucursal sucursal = sucursalRepository.findById(dto.getSucursalId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        Venta venta = new Venta();
        venta.setFecha(LocalDateTime.now());
        venta.setSucursal(sucursal);

        for (DetalleVentaRequestDTO d : dto.getDetalle()) {

            Producto producto = productoRepository.findById(d.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(d.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());

            venta.agregarDetalle(detalle);
        }

        venta.calcularTotal();

        return ventaRepository.save(venta);
    }
    @Override
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }
    @Override
    public List<Venta> obtenerVentasPorSucursalYFecha(Long sucursalId, LocalDate fecha) {

        LocalDateTime inicio = fecha.atStartOfDay();
        LocalDateTime fin = fecha.atTime(23, 59, 59);

        return ventaRepository.findBySucursalIdAndFechaBetween(
                sucursalId,
                inicio,
                fin
        );
    }

    @Override
    public void anularVenta(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        venta.setAnulada(true);

        ventaRepository.save(venta);
    }
}