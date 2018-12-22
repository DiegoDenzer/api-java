package com.diegodenzer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegodenzer.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
