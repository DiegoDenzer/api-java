package com.diegodenzer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegodenzer.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
