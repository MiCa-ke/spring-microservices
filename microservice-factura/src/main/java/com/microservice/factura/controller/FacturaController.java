package com.microservice.factura.controller;

import com.microservice.factura.entities.Factura;
import com.microservice.factura.service.IFacturaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFactura(@RequestBody Factura factura){
        facturaService.saveFactura(factura);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findById(){
        return ResponseEntity.ok(facturaService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(facturaService.getFacturaById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFactura(@PathVariable Long id) {
            facturaService.deleteFactura(id);
            return ResponseEntity.ok("Factura eliminada");
    }

}
