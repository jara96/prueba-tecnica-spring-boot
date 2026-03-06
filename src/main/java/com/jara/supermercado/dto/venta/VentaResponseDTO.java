package com.jara.supermercado.dto.venta;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class VentaResponseDTO {

    private Long id;
    private LocalDateTime fecha;
    private String nombreSucursal;
    private BigDecimal total;
    private boolean anulada;
    private List<DetalleVentaResponseDTO> detalle;

}