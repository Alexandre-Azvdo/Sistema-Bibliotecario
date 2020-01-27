package com.alexandre.biblioteca.resourses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.biblioteca.domain.Autor;

@RestController
@RequestMapping(value = "/autores")
public class AutorResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Autor> listar() {
		Autor a1 = new Autor(1,"Monteiro Lobato");
		Autor a2 = new Autor(2,"Machado de Assis");
		
		List<Autor> autores = new ArrayList<>();
		autores.addAll(Arrays.asList(a1, a2));
		
		return autores;
	}
}
