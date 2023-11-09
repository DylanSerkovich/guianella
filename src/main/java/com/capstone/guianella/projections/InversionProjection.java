package com.capstone.guianella.projections;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public interface InversionProjection {
    int getIdInversion();

    String getNameInvestor();

    Date getDateRecord();

    BigDecimal getCostoTela();

    default BigDecimal getCostoTelaRedondeado() {
        return getCostoTela().setScale(2, RoundingMode.HALF_UP);
    }
}
