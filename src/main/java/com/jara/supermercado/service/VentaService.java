package com.jara.supermercado.service;

import com.jara.supermercado.dto.venta.VentaRequestDTO;

import com.jara.supermercado.entity.Venta;

import java.time.LocalDate;
import java.util.List;

public interface VentaService {

    Venta crearVenta(VentaRequestDTO dto);
    List<Venta> obtenerVentasPorSucursalYFecha(Long sucursalId, LocalDate fecha);
    void anularVenta(Long id);
    List<Venta> obtenerTodasLasVentas();
}