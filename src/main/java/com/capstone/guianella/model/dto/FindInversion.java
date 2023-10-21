package com.capstone.guianella.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindInversion {
    private int idInversion;
    private String nameInversor;
    private Date dateRecord;
    private BigDecimal cost;
    private BigDecimal ingresos;
    private BigDecimal ganancias;
}
