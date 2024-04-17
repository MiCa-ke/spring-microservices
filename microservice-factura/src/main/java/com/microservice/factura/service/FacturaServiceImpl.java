package com.microservice.factura.service;

import com.microservice.factura.entities.Factura;
import com.microservice.factura.entities.detalle_Factura;
import com.microservice.factura.persistence.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private detalleFacturaImpl detalleFacturaService;

    @Override
    public List<Factura> findAll() {
        return (List<Factura>) facturaRepository.findAll();
    }

    @Override
    public Factura getFacturaById(Long id) {
        return facturaRepository.findById(id).orElseThrow();
    }

    @Override
    public void saveFactura(Factura factura) {
        // Asigna la factura a cada detalle de factura
        if (factura.getDetalles() != null) {
            for (detalle_Factura detalle : factura.getDetalles()) {
                detalle.setFactura(factura);
                // No guardes los detalles de factura aquí
            }
        }
        // Guarda la factura principal primero
        facturaRepository.save(factura);

        // Ahora guarda los detalles de factura asociados
        if (factura.getDetalles() != null) {
            for (detalle_Factura detalle : factura.getDetalles()) {
                detalleFacturaService.save(detalle);
            }
        }
    }
    @Override
    public boolean existsById(Long id) {
        return facturaRepository.existsById(id);
    }

    @Override
    public void deleteFactura(Long id) {

    }
}
