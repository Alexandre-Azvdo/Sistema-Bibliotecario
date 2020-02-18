package com.alexandre.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alexandre.biblioteca.domain.Autor;
import com.alexandre.biblioteca.repositories.AutorRepository;
import com.alexandre.biblioteca.services.exceptions.DataIntegrityException;
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
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Autor que está associados a um livro!");
		}
	}
	
	public List<Autor> findAll(){
		return repo.findAll();
	}
	
	public Page<Autor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
