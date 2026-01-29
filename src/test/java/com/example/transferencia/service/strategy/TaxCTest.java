package com.example.transferencia.service.strategy;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class TaxCTest {

    private final TaxC strategy = new TaxC();

    @Test
    void deveAplicarTaxaCQuandoValorMaiorQue2000() {
        boolean aplica = strategy.aplica(BigDecimal.valueOf(3000), 15);
        assertTrue(aplica);
    }

    @Test
    void deveCalcularTaxaCParaPeriodoEntre11E20Dias() {
        BigDecimal taxa = strategy.calcular(BigDecimal.valueOf(3000), 15);
        assertEquals(0, taxa.compareTo(BigDecimal.valueOf(246)));
    }

    @Test
    void deveCalcularTaxaCParaPeriodoEntre21E30Dias() {
        BigDecimal taxa = strategy.calcular(BigDecimal.valueOf(3000), 25);
        assertEquals(0, taxa.compareTo(BigDecimal.valueOf(207)));
    }

    @Test
    void deveCalcularTaxaCParaPeriodoEntre31E40Dias() {
        BigDecimal taxa = strategy.calcular(BigDecimal.valueOf(3000), 35);
        assertEquals(0, taxa.compareTo(BigDecimal.valueOf(141)));
    }

    @Test
    void deveCalcularTaxaCParaPeriodoMaiorQue40Dias() {
        BigDecimal taxa = strategy.calcular(BigDecimal.valueOf(3000), 50);
        assertEquals(0, taxa.compareTo(BigDecimal.valueOf(51)));
    }
}
