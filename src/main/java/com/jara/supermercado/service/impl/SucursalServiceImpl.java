package com.jara.supermercado.service.impl;


import com.jara.supermercado.dto.sucursal.SucursalRequestDTO;
import com.jara.supermercado.dto.sucursal.SucursalResponseDTO;
import com.jara.supermercado.mapper.SucursalMapper;
import com.jara.supermercado.entity.Sucursal;
import com.jara.supermercado.repository.SucursalRepository;
import com.jara.supermercado.service.SucursalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalServiceImpl(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public SucursalResponseDTO crearSucursal(SucursalRequestDTO dto) {

        Sucursal sucursal = SucursalMapper.toEntity(dto);

        sucursal = sucursalRepository.save(sucursal);

        return SucursalMapper.toDTO(sucursal);
    }

    @Override
    public List<SucursalResponseDTO> listarSucursales() {

        return sucursalRepository.findAll()
                .stream()
                .map(SucursalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SucursalResponseDTO obtenerSucursal(Long id) {

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        return SucursalMapper.toDTO(sucursal);
    }

    @Override
    public SucursalResponseDTO actualizarSucursal(Long id, SucursalRequestDTO dto) {

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());

        sucursal = sucursalRepository.save(sucursal);

        return SucursalMapper.toDTO(sucursal);
    }

    @Override
    public void eliminarSucursal(Long id) {

        if (!sucursalRepository.existsById(id)) {
            throw new RuntimeException("Sucursal no encontrada");
        }

        sucursalRepository.deleteById(id);
    }
}