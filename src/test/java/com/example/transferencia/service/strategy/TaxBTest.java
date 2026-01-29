package com.example.transferencia.service.strategy;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class TaxBTest {

    private final TaxB strategy = new TaxB();

    @Test
    void deveAplicarTaxaBQuandoValorEntre1001E2000EDataEntre1E10Dias() {
        boolean aplica = strategy.aplica(BigDecimal.valueOf(1500), 5);
        assertTrue(aplica);
    }

    @Test
    void deveCalcularTaxaBComPercentualCorreto() {
        BigDecimal taxa = strategy.calcular(BigDecimal.valueOf(1500), 5);
        assertEquals(0, taxa.compareTo(BigDecimal.valueOf(135)));
    }

    @Test
    void naoDeveAplicarTaxaBQuandoDiasMaiorQue10() {
        boolean aplica = strategy.aplica(BigDecimal.valueOf(1500), 15);
        assertFalse(aplica);
    }
}
