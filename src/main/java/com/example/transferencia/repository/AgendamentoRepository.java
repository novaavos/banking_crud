package com.example.transferencia.repository;

import com.example.transferencia.domain.Agendamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {
}
