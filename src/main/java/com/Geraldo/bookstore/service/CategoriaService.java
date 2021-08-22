package com.Geraldo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Geraldo.bookstore.domain.Categoria;
import com.Geraldo.bookstore.dtos.CategoriaDTO;
import com.Geraldo.bookstore.exceptions.ObjectNotFoundException;
import com.Geraldo.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById( Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
				"Objeto não encontrato! Id: " + id + ", Tipo: " + Categoria.class.getName() ) );
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
}
