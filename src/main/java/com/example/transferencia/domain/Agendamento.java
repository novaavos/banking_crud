package com.example.transferencia.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "agendamentos")
public class Agendamento {

    @Id
    private String id;

    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valor;
    private BigDecimal taxa;
    private BigDecimal valorTotal;
    private LocalDate dataAgendamento;
    private LocalDateTime dataCriacao;

    public Agendamento(
            String id,
            String contaOrigem,
            String contaDestino,
            BigDecimal valor,
            BigDecimal taxa,
            BigDecimal valorTotal,
            LocalDate dataAgendamento,
            LocalDateTime dataCriacao
    ) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.taxa = taxa;
        this.valorTotal = valorTotal;
        this.dataAgendamento = dataAgendamento;
        this.dataCriacao = dataCriacao;
    }

    public String getId() {
        return id;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
