package com.microservice.factura.service;

import com.microservice.factura.entities.detalle_Factura;

import java.util.List;
import java.util.Optional;

public interface IdetalleFacturaService {

    List<detalle_Factura> findALL();
    void save(detalle_Factura detallefactura);
    boolean existsById(Long id);
    Optional<Long> findByFacturaId(Long detalleFacturaId);
}
