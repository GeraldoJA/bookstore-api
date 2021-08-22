package com.Geraldo.bookstore.resouces;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Geraldo.bookstore.domain.Categoria;
import com.Geraldo.bookstore.dtos.CategoriaDTO;
import com.Geraldo.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class categoriaResource {

	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {	
		Categoria obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity< List<CategoriaDTO> > findAll() {
		
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map( obj -> new CategoriaDTO(obj) ).collect( Collectors.toList() );
		
		return ResponseEntity.ok().body(listDTO);
	}
	
}

// localhost:8080/categorias/1
