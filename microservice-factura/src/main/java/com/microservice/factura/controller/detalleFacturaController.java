package com.microservice.factura.controller;

import com.microservice.factura.entities.detalle_Factura;
import com.microservice.factura.service.IdetalleFacturaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/detalleFactura")
public class detalleFacturaController {

    @Autowired
    private IdetalleFacturaService detalleFacturaService;

    @GetMapping("/all")
    public ResponseEntity<List<detalle_Factura>> getAllDetalleFactura() {
        List<detalle_Factura> detalleFacturas = detalleFacturaService.findALL();
        return new ResponseEntity<>(detalleFacturas, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearDetalleFactura(@RequestBody detalle_Factura detallefactura) {
        detalleFacturaService.save(detallefactura);
    }

    @GetMapping("search-by-factura/{facturaId}")
    public ResponseEntity<Long> getFacturaIdByDetalleFacturaId(@PathVariable Long detalleFacturaId) {
        Optional<Long> facturaId = detalleFacturaService.findByFacturaId(detalleFacturaId);
        return facturaId.map(id -> new ResponseEntity<>(id, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
