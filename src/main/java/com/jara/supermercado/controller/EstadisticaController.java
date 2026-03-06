package com.jara.supermercado.controller;

import com.jara.supermercado.service.EstadisticaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {

    private final EstadisticaService estadisticaService;

    public EstadisticaController(EstadisticaService estadisticaService) {
        this.estadisticaService = estadisticaService;
    }

    @GetMapping("/producto-mas-vendido")
    public String obtenerProductoMasVendido() {

        return estadisticaService.obtenerProductoMasVendido();
    }
}