package com.microservice.factura.service;

import com.microservice.factura.entities.Factura;
import com.microservice.factura.entities.detalle_Factura;
import com.microservice.factura.persistence.detalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class detalleFacturaImpl implements IdetalleFacturaService{

    @Autowired
    private detalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<detalle_Factura> findALL() {
        return (List<detalle_Factura>) detalleFacturaRepository.findAll();
    }

    @Override
    public void save(detalle_Factura detallefactura) {
        detalleFacturaRepository.save(detallefactura);
    }

    @Override
    public boolean existsById(Long id) {
        return detalleFacturaRepository.existsById(id);
    }

    @Override
    public Optional<Long> findByFacturaId(Long detalleFacturaId) {
        Optional<detalle_Factura> detalleFactura = detalleFacturaRepository.findById(detalleFacturaId);
        return detalleFactura.map(df -> df.getFactura().getId());
    }
}
