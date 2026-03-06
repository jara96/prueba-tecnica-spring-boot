package com.jara.supermercado.controller;


import com.jara.supermercado.dto.venta.VentaRequestDTO;
import com.jara.supermercado.entity.Venta;
import com.jara.supermercado.service.VentaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public Venta crearVenta(@RequestBody VentaRequestDTO dto) {
        return ventaService.crearVenta(dto);
    }

    @PatchMapping("/{id}/anular")
    public void anularVenta(@PathVariable Long id) {
        ventaService.anularVenta(id);
    }


    @GetMapping("/todas")
    public List<Venta> obtenerTodasLasVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    @GetMapping
    public List<Venta> obtenerVentasPorSucursalYFecha(
            @RequestParam Long sucursalId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        return ventaService.obtenerVentasPorSucursalYFecha(sucursalId, fecha);
    }
}