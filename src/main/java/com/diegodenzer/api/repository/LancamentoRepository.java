package com.diegodenzer.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diegodenzer.api.model.Lancamento;
import com.diegodenzer.api.repository.lancamento.LancamentoRepositoryQuery;
import com.diegodenzer.api.repository.projection.ResumoLancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
	
	
	/*@Query("Select new ResumoLancamento(l.codigo as codigo, l.descricao as descricao, "
			+ " l.dataVencimento as dataVencimento, l.dataPagamento as dataPagamento, "
			+ " l.tipo as tipo, l.valor as valor, g.nome, p.nome )" 
			+ " from Lancamento l "
		    + " join l.pessoa p "
		    + " join l.categoria g ")
	Page<ResumoLancamento> consultaResumo(Pageable pageable);*/
		
}
