package com.microservice.factura.controller.sto;

import com.microservice.factura.entities.detalle_Factura;
import jakarta.persistence.*;

import java.util.Date;


public class FacturaDTO {
    private Long id;
    private String name;
    private Integer nit;
    private Date fechaHora;
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
