package com.example.transferencia.service.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxC implements TaxStrategy{

    @Override
    public boolean aplica(BigDecimal valor, long dias) {
        return valor.compareTo(BigDecimal.valueOf(2000)) > 0 && dias >= 11;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor, long dias) {
        if (dias <= 20) {
            return valor.multiply(BigDecimal.valueOf(0.082));
        }
        if (dias <= 30) {
            return valor.multiply(BigDecimal.valueOf(0.069));
        }
        if (dias <= 40) {
            return valor.multiply(BigDecimal.valueOf(0.047));
        }
        return valor.multiply(BigDecimal.valueOf(0.017));
    }
}
