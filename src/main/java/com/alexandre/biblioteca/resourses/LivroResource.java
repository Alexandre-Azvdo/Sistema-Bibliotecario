package com.alexandre.biblioteca.resourses;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest está funcionando para livro!";
	}
}
