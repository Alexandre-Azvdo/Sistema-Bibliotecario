package com.alexandre.biblioteca.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.repositories.LeitorRepository;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class LeitorService {

	@Autowired
	private LeitorRepository repo;

	public Leitor findById(Integer id) {
		Optional<Leitor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Leitor.class.getName()));
	}

}
