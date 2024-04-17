package com.microservice.factura.persistence;

import com.microservice.factura.entities.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
