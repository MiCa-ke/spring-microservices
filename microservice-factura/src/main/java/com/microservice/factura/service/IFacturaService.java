package com.microservice.factura.service;

import com.microservice.factura.entities.Factura;

import java.util.List;

public interface IFacturaService {
    List<Factura> findAll();
    Factura getFacturaById(Long id);
    void saveFactura(Factura factura);
    boolean existsById(Long id);
    void deleteFactura(Long id);
}
