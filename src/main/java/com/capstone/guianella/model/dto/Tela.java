package com.capstone.guianella.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tela {
    private String tipo;
    private String color;
    private float rendimiento;
    private float cantidad;
    private float costo;
}
