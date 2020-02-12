package com.alexandre.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alexandre.biblioteca.domain.Emprestimo;
import com.alexandre.biblioteca.repositories.EmprestimoRepository;
import com.alexandre.biblioteca.services.exceptions.DataIntegrityException;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repo;
	
	public Emprestimo findById(Integer id) {
		Optional<Emprestimo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Emprestimo.class.getName()));
	}

	public Emprestimo insert(Emprestimo obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Emprestimo update(Emprestimo obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Emprestimo que está associados a um Livros-Leitor-Funcionário!");
		}
	}
	
	public List<Emprestimo> findAll(){
		return repo.findAll();
	}
	
	public Page<Emprestimo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
