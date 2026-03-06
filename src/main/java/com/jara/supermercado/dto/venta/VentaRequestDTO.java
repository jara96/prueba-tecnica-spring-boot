package com.jara.supermercado.dto.venta;



import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class VentaRequestDTO {

    @NotNull(message = "La sucursalId es obligatoria")
    private Long sucursalId;

    @NotEmpty(message = "Debe incluir al menos un producto")
    @Valid
    private List<DetalleVentaRequestDTO> detalle;

}