package com.example.transferencia.service;

import com.example.transferencia.domain.Agendamento;
import com.example.transferencia.dto.AgendamentoRequestDTO;
import com.example.transferencia.exceptions.RegraNegocioException;
import com.example.transferencia.repository.AgendamentoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final TaxCalculatorService taxCalculatorService;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, TaxCalculatorService taxCalculatorService){
        this.repository = agendamentoRepository;
        this.taxCalculatorService  = taxCalculatorService;
    }

    public Agendamento criar(AgendamentoRequestDTO dto){
        validarData(dto.dataAgendamento());

        BigDecimal tax = taxCalculatorService.calcular(dto.valor(), dto.dataAgendamento());

        BigDecimal valorTotal = dto.valor().add(tax);

        Agendamento agendamento = new Agendamento(null, dto.contaOrigem(), dto.contaDestino(), dto.valor(), tax, valorTotal, dto.dataAgendamento(), LocalDateTime.now());

        return repository.save(agendamento);

    }

    public List<Agendamento> listar() {
        return repository.findAll();
    }

    public Agendamento buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Appointment not found"));
    }

    public Agendamento atualizar(String id, AgendamentoRequestDTO dto) {
        validarData(dto.dataAgendamento());

        Agendamento existente = buscarPorId(id);

        BigDecimal taxa = taxCalculatorService.calcular(
                dto.valor(),
                dto.dataAgendamento()
        );

        BigDecimal valorTotal = dto.valor().add(taxa);

        Agendamento atualizado = new Agendamento(
                existente.getId(),
                dto.contaOrigem(),
                dto.contaDestino(),
                dto.valor(),
                taxa,
                valorTotal,
                dto.dataAgendamento(),
                existente.getDataCriacao()
        );

        return repository.save(atualizado);
    }

    public void remover(String id) {
        Agendamento existente = buscarPorId(id);
        repository.delete(existente);
    }

    private void validarData(LocalDate dataAgendamento) {
        if (dataAgendamento.isBefore(LocalDate.now())) {
            throw new RegraNegocioException("Invalid appointment date");
        }
    }

}
