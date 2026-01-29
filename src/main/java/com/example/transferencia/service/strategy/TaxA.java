package com.example.transferencia.service.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxA  implements TaxStrategy{

    @Override
    public boolean aplica(BigDecimal valor, long dias) {
        return valor.compareTo(BigDecimal.valueOf(1000)) <= 0 && dias == 0;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor, long dias) {
        return valor.multiply(BigDecimal.valueOf(0.03))
                .add(BigDecimal.valueOf(3));
    }
}
