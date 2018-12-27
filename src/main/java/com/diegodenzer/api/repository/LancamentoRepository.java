package com.diegodenzer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegodenzer.api.model.Lancamento;
import com.diegodenzer.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
