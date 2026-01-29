package com.example.transferencia.service;

import com.example.transferencia.exceptions.RegraNegocioException;
import com.example.transferencia.service.strategy.TaxStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TaxCalculatorService {

    private final List<TaxStrategy> strategies;

    public TaxCalculatorService(List<TaxStrategy> strategies) {
        this.strategies = strategies;
    }

    public BigDecimal calcular(BigDecimal valor, LocalDate dataAgendamento) {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), dataAgendamento);

        return strategies.stream()
                .filter(strategy -> strategy.aplica(valor, dias))
                .findFirst()
                .map(strategy -> strategy.calcular(valor, dias))
                .orElseThrow(() ->
                        new RegraNegocioException("No tax applied to the appointment made"));
    }
}