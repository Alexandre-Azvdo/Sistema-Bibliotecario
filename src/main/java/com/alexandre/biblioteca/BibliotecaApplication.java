package com.alexandre.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.biblioteca.domain.Autor;
import com.alexandre.biblioteca.domain.Livro;
import com.alexandre.biblioteca.repositories.AutorRepository;
import com.alexandre.biblioteca.repositories.LivroRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Livro l1 = new Livro(null, "Reinações de Narizinho", "Sinopse",
		 "978-8538090311", "2019", "Ciranda Cultural", "Literatura Infantil",
		 "Português", "288"); 
		Livro l2 = new Livro(null, "O saci", "Sinopse",
		 "978-8525062130", "2016", "Biblioteca Azul", "Literatura Juvenil",
		 "Português", "208"); 
		Livro l3 = new Livro(null, "Dom Casmurro", "Sinopse",
		 "857-2322647", "2010", "Martin Claret", "Romance Impressionista",
		 "Português", "210");		
		
		Autor a1 = new Autor(null,"Monteiro Lobato");
		Autor a2 = new Autor(null,"Machado de Assis");
		
		l1.getAutores().addAll(Arrays.asList(a1));
		l2.getAutores().addAll(Arrays.asList(a1));
		l3.getAutores().addAll(Arrays.asList(a2));
		
		a1.getLivros().addAll(Arrays.asList(l1, l2));
		a2.getLivros().addAll(Arrays.asList(l3));
		
		autorRepository.saveAll(Arrays.asList(a1, a2));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3));
		
				
	}
}
