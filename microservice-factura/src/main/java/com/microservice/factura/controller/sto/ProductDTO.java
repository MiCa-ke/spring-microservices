package com.microservice.factura.controller.sto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String descripcion;
    private Double precio;
    private Long categoryId;
}
