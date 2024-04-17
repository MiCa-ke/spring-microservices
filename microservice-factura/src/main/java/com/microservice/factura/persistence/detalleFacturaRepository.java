package com.microservice.factura.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.microservice.factura.entities.detalle_Factura;

@Repository
public interface detalleFacturaRepository extends CrudRepository<detalle_Factura, Long> {
}
