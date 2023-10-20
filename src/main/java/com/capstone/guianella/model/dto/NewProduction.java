package com.capstone.guianella.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class NewProduction {
    private List<Product> products = new ArrayList<>();
    private Confeccion confeccion;
}
