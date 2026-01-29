package com.example.transferencia.controller;


import com.example.transferencia.domain.Agendamento;
import com.example.transferencia.dto.AgendamentoRequestDTO;
import com.example.transferencia.dto.AgendamentoResponseDTO;
import com.example.transferencia.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;


    public AgendamentoController(AgendamentoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponseDTO criar(@RequestBody @Valid AgendamentoRequestDTO dto){
        return map(service.criar(dto));
    }

    @GetMapping
    public List<AgendamentoResponseDTO> listar() {
        return service.listar().stream()
                .map(this::map)
                .toList();
    }

    @GetMapping("/{id}")
    public AgendamentoResponseDTO buscar(@PathVariable String id) {
        return map(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public AgendamentoResponseDTO atualizar(
            @PathVariable String id,
            @RequestBody @Valid AgendamentoRequestDTO dto
    ) {
        return map(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String id) {
        service.remover(id);
    }

    private AgendamentoResponseDTO map(Agendamento agendamento) {
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getContaOrigem(),
                agendamento.getContaDestino(),
                agendamento.getValor(),
                agendamento.getTaxa(),
                agendamento.getValorTotal(),
                agendamento.getDataAgendamento(),
                agendamento.getDataCriacao()
        );
    }

}
