package com.alexandre.biblioteca.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.services.LeitorService;

@RestController
@RequestMapping(value = "/leitores")
public class LeitorResource {

	@Autowired
	private LeitorService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Leitor obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
