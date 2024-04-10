package com.microservice.category.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categoria")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descripcion;

    public Category(String name, String descripcion) {
        this.name = name;
        this.descripcion = descripcion;
    }

    // Setter para el ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el ID
    public Long getId() {
        return id;
    }

    // Setter para la cate
    public void setName(String name) {
        this.name = name;
    }

    // Getter para la cate
    public String getName() {
        return this.name;
    }

    // Setter para la descripción
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter para la descripción
    public String getDescripcion() {
        return descripcion;
    }
}
