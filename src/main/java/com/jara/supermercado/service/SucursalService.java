package com.jara.supermercado.service;



import com.jara.supermercado.dto.sucursal.SucursalRequestDTO;
import com.jara.supermercado.dto.sucursal.SucursalResponseDTO;

import java.util.List;

public interface SucursalService {

    SucursalResponseDTO crearSucursal(SucursalRequestDTO dto);

    List<SucursalResponseDTO> listarSucursales();

    SucursalResponseDTO obtenerSucursal(Long id);

    SucursalResponseDTO actualizarSucursal(Long id, SucursalRequestDTO dto);

    void eliminarSucursal(Long id);
}