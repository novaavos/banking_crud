package com.example.transferencia.service.strategy;

import java.math.BigDecimal;

public interface TaxStrategy {

    boolean aplica(BigDecimal valor, long dias);

    BigDecimal calcular(BigDecimal valor, long dias);
}
