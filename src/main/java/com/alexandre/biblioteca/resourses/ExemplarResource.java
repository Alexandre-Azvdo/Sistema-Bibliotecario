package com.alexandre.biblioteca.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.services.ExemplarService;

@RestController
@RequestMapping(value = "/exemplares")
public class ExemplarResource {

	@Autowired
	private ExemplarService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Exemplar obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}