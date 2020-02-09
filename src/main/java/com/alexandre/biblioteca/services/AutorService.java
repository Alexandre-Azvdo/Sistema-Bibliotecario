package com.alexandre.biblioteca.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.biblioteca.domain.Autor;
import com.alexandre.biblioteca.repositories.AutorRepository;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repo;
	
	public Autor findById(Integer id) {
		Optional<Autor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Autor.class.getName()));
	}
	
	public Autor insert(Autor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Autor update(Autor obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
}
