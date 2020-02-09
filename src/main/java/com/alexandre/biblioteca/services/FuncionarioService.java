package com.alexandre.biblioteca.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.biblioteca.domain.Funcionario;
import com.alexandre.biblioteca.repositories.FuncionarioRepository;
import com.alexandre.biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario findById(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}
}
