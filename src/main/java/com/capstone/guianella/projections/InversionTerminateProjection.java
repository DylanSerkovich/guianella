package com.capstone.guianella.projections;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public interface InversionTerminateProjection {
    int getIdInversion();

    String getNameInvestor();

    Date getDateRecord();

    BigDecimal getCostoTela();

    int getLotProduction();

    BigDecimal getServicePole();

    BigDecimal getConfeccionAddCost();

    BigDecimal getIngresos();

    default BigDecimal getCostoTelaConfeccion() {
        BigDecimal costoTela = getCostoTela() != null ? getCostoTela() : BigDecimal.ZERO;
        BigDecimal confeccionCost = getConfeccionAddCost() != null ? getConfeccionAddCost() : BigDecimal.ZERO;

        BigDecimal roundedCostoTela = costoTela.setScale(2, RoundingMode.HALF_UP);
        BigDecimal roundedConfeccionCost = confeccionCost.setScale(2, RoundingMode.HALF_UP);

        BigDecimal serviceTotalPole = getServicePole().multiply(BigDecimal.valueOf(getLotProduction())).setScale(2, RoundingMode.HALF_UP);

        BigDecimal CostTotal = roundedConfeccionCost.add(serviceTotalPole);

        return roundedCostoTela.add(CostTotal);
    }
}
