package com.microservice.category.http.response;

import com.microservice.category.controller.sto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductByCategoryResponse {

    private String name;
    private String descripcion;
    private List<ProductDTO> productDTOList;

}
