package com.diegodenzer.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodenzer.api.model.Lancamento;
import com.diegodenzer.api.model.Pessoa;
import com.diegodenzer.api.repository.LancamentoRepository;
import com.diegodenzer.api.repository.PessoaRepository;
import com.diegodenzer.api.service.exception.PessoaInexistenteOuInativaExcepetion;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()); 
		if ( !pessoa.isPresent() || !pessoa.get().getAtivo() ) {
			throw new PessoaInexistenteOuInativaExcepetion();
		}
		return lancamentoRepository.save(lancamento);
	}
	
}
