package com.capstone.guianella.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface InversionProjection {
    int getidInversion();

    String getNameInvestor();

    Date getDateRecord();

    BigDecimal getCostoTela();
}
