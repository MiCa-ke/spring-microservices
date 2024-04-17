package com.microservice.factura.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalle_Factura")
public class detalle_Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @JoinColumn(name = "product_id", nullable = false)
    private Long productId;

    public detalle_Factura(Integer cantidad, Double precio, Factura factura, Long productId){
        this.cantidad = cantidad;
        this.precio = precio;
        this.factura = factura;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public long getProducto() {
        return productId;
    }

    public void setProducto(long productId) {
        this.productId = productId;
    }
}
