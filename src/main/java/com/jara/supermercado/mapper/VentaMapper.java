package com.jara.supermercado.mapper;



import com.jara.supermercado.dto.venta.DetalleVentaResponseDTO;
import com.jara.supermercado.dto.venta.VentaResponseDTO;
import com.jara.supermercado.entity.DetalleVenta;
import com.jara.supermercado.entity.Venta;

import java.util.List;
import java.util.stream.Collectors;

public class VentaMapper {

    public static VentaResponseDTO toDTO(Venta venta) {

        VentaResponseDTO dto = new VentaResponseDTO();

        dto.setId(venta.getId());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());
        dto.setAnulada(venta.isAnulada());
        dto.setNombreSucursal(venta.getSucursal().getNombre());

        List<DetalleVentaResponseDTO> detalles = venta.getDetalles()
                .stream()
                .map(VentaMapper::detalleToDTO)
                .collect(Collectors.toList());

        dto.setDetalle(detalles);

        return dto;
    }

    private static DetalleVentaResponseDTO detalleToDTO(DetalleVenta detalle) {

        DetalleVentaResponseDTO dto = new DetalleVentaResponseDTO();

        dto.setProductoId(detalle.getProducto().getId());
        dto.setNombreProducto(detalle.getProducto().getNombre());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());

        return dto;
    }
}