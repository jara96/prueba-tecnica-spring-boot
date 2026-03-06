package com.jara.supermercado.controller;


import com.jara.supermercado.dto.sucursal.SucursalRequestDTO;
import com.jara.supermercado.dto.sucursal.SucursalResponseDTO;
import com.jara.supermercado.service.SucursalService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }


    @GetMapping
    public List<SucursalResponseDTO> listarSucursales() {
        return sucursalService.listarSucursales();
    }

    @GetMapping("/{id}")
    public SucursalResponseDTO obtenerSucursal(@PathVariable Long id) {
        return sucursalService.obtenerSucursal(id);
    }

    @PostMapping
    public SucursalResponseDTO crearSucursal(@RequestBody SucursalRequestDTO dto) {
        return sucursalService.crearSucursal(dto);
    }

    @PutMapping("/{id}")
    public SucursalResponseDTO actualizarSucursal(
            @PathVariable Long id,
            @RequestBody SucursalRequestDTO dto) {

        return sucursalService.actualizarSucursal(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminarSucursal(id);
    }
}