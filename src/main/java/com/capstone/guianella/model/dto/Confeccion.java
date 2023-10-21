package com.capstone.guianella.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Confeccion {
    private double servicePolo;

    private double serviceCortacinta;

    private double serviceBoton;

    private double costBoton;
}
