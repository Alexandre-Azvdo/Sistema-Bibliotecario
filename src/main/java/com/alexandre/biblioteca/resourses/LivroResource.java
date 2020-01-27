package com.alexandre.biblioteca.resourses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.biblioteca.domain.Livro;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar() {
		Livro l1 = new Livro(1, "Reinações de Narizinho", "Sinopse", "978-8554062613", "2019", "Companhia das Letrinhas", "Literatura Infantil", "Português");
		Livro l2 = new Livro(2, "O saci", "Sinopse", "978-8525062130", "2016", "Biblioteca Azul", "Literatura Juvenil", "Português");
		Livro l3= new Livro(3, "Dom Casmurro", "Sinopse", "857-2322647", "2010", "Martin Claret", "Romance Impressionista", "Português");
		
		List<Livro> livros = new ArrayList<>();
		livros.addAll(Arrays.asList(l1, l2, l3));
		return livros;
	}
}
