package com.jara.supermercado.mapper;



import com.jara.supermercado.dto.sucursal.SucursalRequestDTO;
import com.jara.supermercado.dto.sucursal.SucursalResponseDTO;
import com.jara.supermercado.entity.Sucursal;

public class SucursalMapper {

    public static Sucursal toEntity(SucursalRequestDTO dto) {

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());

        return sucursal;
    }

    public static SucursalResponseDTO toDTO(Sucursal sucursal) {

        SucursalResponseDTO dto = new SucursalResponseDTO();

        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        dto.setDireccion(sucursal.getDireccion());

        return dto;
    }
}