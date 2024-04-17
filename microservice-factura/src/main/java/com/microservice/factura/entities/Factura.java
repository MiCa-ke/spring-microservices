package com.microservice.factura.entities;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer nit;
    private Date fechahora;
    private Double total;

    @OneToMany(mappedBy = "factura")
    private List<detalle_Factura> detalles;

    public Factura(String name, Integer nit, Date fechahora, Double total, List<detalle_Factura> detalles){
    this.name = name;
    this.nit = 0000;
    this.fechahora = fechahora;
    this.total = total;
    this.detalles = detalles;
    }

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

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public Date getFechaHora() {
        return fechahora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechahora = fechahora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<detalle_Factura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<detalle_Factura> detalles) {
        this.detalles = detalles;
    }
}
