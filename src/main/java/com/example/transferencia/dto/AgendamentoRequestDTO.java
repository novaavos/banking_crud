package com.example.transferencia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AgendamentoRequestDTO(

        @NotBlank
        String contaOrigem,

        @NotBlank
        String contaDestino,

        @NotNull
        @Positive
        BigDecimal valor,

        @NotNull
        LocalDate dataAgendamento
) {
}
