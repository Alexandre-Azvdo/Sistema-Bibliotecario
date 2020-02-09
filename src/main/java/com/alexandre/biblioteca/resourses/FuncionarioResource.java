package com.alexandre.biblioteca.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.biblioteca.domain.Funcionario;
import com.alexandre.biblioteca.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Funcionario> find(@PathVariable Integer id) {
		Funcionario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
