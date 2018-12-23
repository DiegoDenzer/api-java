package com.diegodenzer.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diegodenzer.api.model.Pessoa;
import com.diegodenzer.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoarepository;

	public Pessoa Atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaBusca = buscarPessoa(codigo);
		BeanUtils.copyProperties(pessoa, pessoaBusca, "codigo");
		return pessoarepository.save(pessoaBusca);
	}

	private Pessoa buscarPessoa(Long codigo) {
		Optional<Pessoa> pessoaBusca = pessoarepository.findById(codigo);
		if( pessoaBusca.isPresent()) {
			return pessoaBusca.get();
		}else {
			throw new  EmptyResultDataAccessException(1); 
		}
	}

	public void atualizarAtivo(Long codigo, boolean ativo) {
		Pessoa pessoaAtualizar = buscarPessoa(codigo);
		pessoaAtualizar.setAtivo(ativo);
		pessoarepository.save(pessoaAtualizar);
	}
	
	
}
