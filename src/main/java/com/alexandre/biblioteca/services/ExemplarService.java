package com.alexandre.biblioteca.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.repositories.ExemplarRepository;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class ExemplarService {
	
	@Autowired
	private ExemplarRepository repo;

	public Exemplar findById(Integer id) {
		Optional<Exemplar> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Exemplar.class.getName()));
	}
}
