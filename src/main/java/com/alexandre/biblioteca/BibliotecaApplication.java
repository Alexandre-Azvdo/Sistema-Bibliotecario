package com.alexandre.biblioteca;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.biblioteca.domain.Autor;
import com.alexandre.biblioteca.domain.Emprestimo;
import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.enums.StatusLeitor;
import com.alexandre.biblioteca.domain.enums.StatusLivro;
import com.alexandre.biblioteca.repositories.AutorRepository;
import com.alexandre.biblioteca.repositories.EmprestimoRepository;
import com.alexandre.biblioteca.repositories.LivroRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;	
	@Autowired
	private EmprestimoRepository emprestimoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					
		Exemplar livro1 = new Exemplar(null, "Reinações de Narizinho", "Sinopse",
		 "978-8538090311", "2019", "Ciranda Cultural", "Literatura Infantil", "Português", "288", 
		 "LIVRO-2020-01-12345", true, sdf.parse("01/01/2020 01:00"), 80.50, StatusLivro.DISPONIVEL); 
				
		Exemplar livro2 = new Exemplar(null, "O saci", "Sinopse", "978-8525062130", "2016",
		 "Biblioteca Azul", "Literatura Juvenil", "Português", "208",
		 "LIVRO-2020-01-12334", true, sdf.parse("02/01/2020 02:00"), 32.75, StatusLivro.INDISPONIVEL);
				
		Exemplar livro3 = new Exemplar(null, "Dom Casmurro", "Sinopse", "857-2322647", "2010",
		 "Martin Claret", "Romance Impressionista", "Português", "210",
		 "LIVRO-2020-01-14432", true, sdf.parse("03/01/2020 03:00"), 39.45, StatusLivro.RESERVADO);
				 		
		Autor a1 = new Autor(null,"Monteiro Lobato");
		Autor a2 = new Autor(null,"Machado de Assis");
		
		livro1.getAutores().addAll(Arrays.asList(a1));
		livro2.getAutores().addAll(Arrays.asList(a1));
		livro3.getAutores().addAll(Arrays.asList(a2));
		
		a1.getLivros().addAll(Arrays.asList(livro1, livro2));
		a2.getLivros().addAll(Arrays.asList(livro3));
		
		autorRepository.saveAll(Arrays.asList(a1, a2));
		livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3));
		
		Leitor leitor1 = new Leitor(null, "Alexandre Azevedo", sdf.parse("21/05/1985 00:00"), "054.630.324-24", StatusLeitor.ATIVO);
		// Leitor leitor2 = new Leitor(null, "Gustavo Rafael", sdf.parse("26/03/2019 07:00"), "021.310.665-98", true);
		
		Emprestimo emp1 = new Emprestimo(null, sdf.parse("04/02/2020 10:12"), sdf.parse("14/02/2020 08:00"), leitor1, livro1);
		
		leitor1.getEmprestimos().addAll(Arrays.asList(emp1));
		livro1.getEmprestimos().addAll(Arrays.asList(emp1));
				
		emprestimoRepository.saveAll(Arrays.asList(emp1));
	}
}
