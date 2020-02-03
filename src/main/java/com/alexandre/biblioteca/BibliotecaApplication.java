package com.alexandre.biblioteca;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.biblioteca.domain.Autor;
import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.Livro;
import com.alexandre.biblioteca.domain.enums.StatusLivro;
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Livro l1 = new Exemplar(null, "Reinações de Narizinho", "Sinopse",
		 "978-8538090311", "2019", "Ciranda Cultural", "Literatura Infantil", "Português", "288", 
		 "LIVRO-2020-01-12345", true, sdf.parse("02/01/2020 00:00"), 80.50, StatusLivro.DISPONIVEL); 
		
		Livro l2 = new Exemplar(null, "O saci", "Sinopse", "978-8525062130", "2016",
		 "Biblioteca Azul", "Literatura Juvenil", "Português", "208",
		 "LIVRO-2020-01-12334", true, sdf.parse("02/01/2020 00:00"), 32.75, StatusLivro.INDISPONIVEL); 
		
		Livro l3 = new Exemplar(null, "Dom Casmurro", "Sinopse", "857-2322647", "2010",
		 "Martin Claret", "Romance Impressionista", "Português", "210",
		 "LIVRO-2020-01-14432", true, sdf.parse("02/01/2020 00:00"), 39.45, StatusLivro.RESERVADO);
		 
		
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
