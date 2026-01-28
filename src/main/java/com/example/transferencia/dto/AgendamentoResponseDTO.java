package com.example.transferencia.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendamentoResponseDTO(
        String id,
        String contaOrigem,
        String contaDestino,
        BigDecimal valor,
        BigDecimal taxa,
        BigDecimal valorTotal,
        LocalDate dataAgendamento,
        LocalDateTime dataCriacao
) {
}