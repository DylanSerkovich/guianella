package com.capstone.guianella.model.dto;

import java.math.BigDecimal;
import java.time.Month;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GananciaMes {
    private  Month mes;
    private BigDecimal ganancia;
}
