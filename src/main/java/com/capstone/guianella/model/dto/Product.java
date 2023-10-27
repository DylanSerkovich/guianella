package com.capstone.guianella.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String modelo;
    private int cantidad;
    private float precioU;
}
