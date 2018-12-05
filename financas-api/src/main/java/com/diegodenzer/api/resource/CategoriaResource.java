package com.diegodenzer.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response ) {
		//Salvando a nova categoria recebida pelo requestbody
		Categoria nova = categoraRepository.save(categoria);
		// Criando uma uri para retorno no header no location
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()   
				.path("/{codigo}") //pegando o path atual
				.buildAndExpand(nova.getCodigo()).toUri(); // concatendo com o codigo da nova Categoria
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(nova); //Retornando a categora criada para facilitar 
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Categoria> buscada = categoraRepository.findById(codigo);
		return buscada.isPresent() ? ResponseEntity.ok(buscada.get()) : ResponseEntity.notFound().build();
	}
	
	
}
