package com.diegodenzer.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodenzer.api.model.Categoria;
import com.diegodenzer.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoraRepository;
	
	@GetMapping
	public List<Categoria> listar(){
		return categoraRepository.findAll();
	}
	
	
}
