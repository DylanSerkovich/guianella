package com.capstone.guianella.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCost {
    private List<Tela> telas;
    private Confeccion confeccion;
    private BigDecimal totalInversion;
    private BigDecimal totalConfeccion;
}
