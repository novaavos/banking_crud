package com.example.transferencia.service.strategy;

import java.math.BigDecimal;

public class TaxB implements TaxStrategy{

    @Override
    public boolean aplica(BigDecimal valor, long dias) {
        return valor.compareTo(BigDecimal.valueOf(1000)) > 0
                && valor.compareTo(BigDecimal.valueOf(2000)) <= 0
                && dias >= 1
                && dias <= 10;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor, long dias) {
        return valor.multiply(BigDecimal.valueOf(0.09));
    }
}
