package com.example.transferencia.service.strategy;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class TaxATest {


    private final TaxA strategy = new TaxA();

    @Test
    void deveAplicarTaxaAQuandoValorAte1000EMesmoDia() {
        boolean aplica = strategy.aplica(BigDecimal.valueOf(1000), 0);
        assertTrue(aplica);
    }

    @Test
    void deveCalcularTaxaAComPercentualMaisValorFixo() {
        BigDecimal taxa = strategy.calcular(BigDecimal.valueOf(1000), 0);
        assertEquals(0, taxa.compareTo(BigDecimal.valueOf(33)));
    }

    @Test
    void naoDeveAplicarTaxaAQuandoDiasDiferentesDeZero() {
        boolean aplica = strategy.aplica(BigDecimal.valueOf(500), 1);
        assertFalse(aplica);
    }

}
