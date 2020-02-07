package com.alexandre.biblioteca;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.biblioteca.domain.Autor;
import com.alexandre.biblioteca.domain.Emprestimo;
import com.alexandre.biblioteca.domain.Endereco;
import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.Livro;
import com.alexandre.biblioteca.domain.enums.StatusLeitor;
import com.alexandre.biblioteca.domain.enums.StatusLivro;
import com.alexandre.biblioteca.repositories.AutorRepository;
import com.alexandre.biblioteca.repositories.CidadeRepository;
import com.alexandre.biblioteca.repositories.ContatoRepository;
import com.alexandre.biblioteca.repositories.EmprestimoRepository;
import com.alexandre.biblioteca.repositories.EnderecoRepository;
import com.alexandre.biblioteca.repositories.EstadoRepository;
import com.alexandre.biblioteca.repositories.ExemplarRepository;
import com.alexandre.biblioteca.repositories.LeitorRepository;
import com.alexandre.biblioteca.repositories.LivroRepository;
import com.alexandre.biblioteca.domain.Cidade;
import com.alexandre.biblioteca.domain.Contato;
import com.alexandre.biblioteca.domain.Estado;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private LeitorRepository leitorRepository;
	@Autowired
	private ExemplarRepository exemplarRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ContatoRepository contatoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					
		Livro livro1 = new Livro(null, "Reinações de Narizinho", "Sinopse",	"978-8538090311", "Ciranda Cultural", 
				"Literatura Infantil", "Português", "288");		
		Exemplar exemplar0 = new Exemplar(null, "LIVRO-2019-05-21231", true, sdf.parse("08/07/2019 01:00"), 72.50, StatusLivro.DISPONIVEL, "2019", livro1);
		Exemplar exemplar1 = new Exemplar(null, "LIVRO-2020-01-12345", true, sdf.parse("01/01/2020 01:00"), 80.50, StatusLivro.DISPONIVEL, "2020", livro1);
		Exemplar exemplar2 = new Exemplar(null, "LIVRO-2020-01-12346", true, sdf.parse("01/01/2020 01:01"), 80.50, StatusLivro.DISPONIVEL, "2020", livro1);
		Exemplar exemplar3 = new Exemplar(null, "LIVRO-2020-01-12347", true, sdf.parse("01/01/2020 01:02"), 80.50, StatusLivro.DISPONIVEL, "2020", livro1);
		
		livro1.getExemplares().addAll(Arrays.asList(exemplar0, exemplar1, exemplar2, exemplar3));		

		Livro livro2 = new Livro(null, "O saci", "Sinopse", "978-8525062130", "Biblioteca Azul", 
				"Literatura Juvenil", "Português", "208");
		Exemplar exemplar10 = new Exemplar(null, "LIVRO-2019-08-23100", true, sdf.parse("08/07/2019 14:00"), 44.75, StatusLivro.INDISPONIVEL, "2018", livro2);
		Exemplar exemplar11 = new Exemplar(null, "LIVRO-2019-08-23101", true, sdf.parse("08/07/2019 14:03"), 44.75, StatusLivro.INDISPONIVEL, "2018", livro2);
		Exemplar exemplar12 = new Exemplar(null, "LIVRO-2020-01-12334", true, sdf.parse("02/01/2020 02:00"), 41.75, StatusLivro.INDISPONIVEL, "2019", livro2);
		Exemplar exemplar13 = new Exemplar(null, "LIVRO-2020-01-12335", true, sdf.parse("02/01/2020 02:02"), 41.75, StatusLivro.INDISPONIVEL, "2019", livro2); 
				
		Livro livro3 = new Livro(null, "Dom Casmurro", "Sinopse", "857-2322647", "Martin Claret",
				"Romance Impressionista", "Português", "210");
		Exemplar exemplar20 = new Exemplar(null, "LIVRO-2020-01-14432", true, sdf.parse("03/01/2020 15:02"), 39.45, StatusLivro.RESERVADO, "2020", livro3);
		Exemplar exemplar21 = new Exemplar(null, "LIVRO-2020-01-14433", true, sdf.parse("03/01/2020 15:03"), 39.45, StatusLivro.RESERVADO, "2020", livro3);
		Exemplar exemplar22 = new Exemplar(null, "LIVRO-2020-01-14434", true, sdf.parse("03/01/2020 15:04"), 39.45, StatusLivro.RESERVADO, "2020", livro3);
				 		
		Autor a1 = new Autor(null,"Monteiro Lobato");
		Autor a2 = new Autor(null,"Machado de Assis");		
		
		livro1.getAutores().addAll(Arrays.asList(a1));
		livro2.getAutores().addAll(Arrays.asList(a1));
		livro3.getAutores().addAll(Arrays.asList(a2));
		
		a1.getLivros().addAll(Arrays.asList(livro1, livro2));
		a2.getLivros().addAll(Arrays.asList(livro3));
		
		autorRepository.saveAll(Arrays.asList(a1, a2));
		livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3));
		exemplarRepository.saveAll(
				Arrays.asList(
						exemplar0, exemplar1, exemplar2, exemplar3,
						exemplar10, exemplar11,exemplar12, exemplar13, 
						exemplar20, exemplar21, exemplar22
					)
				);
				
		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Pernambuco");
		
		Cidade c1 = new Cidade(null, "Sumé", est1);
		Cidade c2 = new Cidade(null, "Campina Grande", est1);
		Cidade c3 = new Cidade(null, "São José do Egito", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Contato contato1 = new Contato(null);
		Contato contato2 = new Contato(null);
		
		contato1.getTelefones().addAll(Arrays.asList("(83)99654-7901"));
		contato1.getEmails().addAll(Arrays.asList("azvdo.ads@gmail.com", "azvedo_xandy@hotmail.com"));
		contato2.getTelefones().addAll(Arrays.asList("(83)98875-2134", "(83)99632-1127"));
		contato2.getEmails().addAll(Arrays.asList("gustavo@gmail.com"));
					
		Leitor leitor1 = new Leitor(null, "Alexandre Azevedo", sdf.parse("21/05/1985 00:00"), "054.630.324-24", StatusLeitor.ATIVO, contato1);
		Leitor leitor2 = new Leitor(null, "Gustavo Rafael", sdf.parse("26/03/2019 07:00"), "021.310.665-98", StatusLeitor.ATIVO, contato2);
				
		Endereco endereco1 = new Endereco(null, "Rua Pedro Francisco Maciel", "904", "Santa Rosa", "Residencial", "58540-000", c1, leitor1);
		Endereco endereco2 = new Endereco(null, "Rua Praça da Bandeira", "s/n", "Centro", "Orgão Público", "63210-000", c3, leitor1);
		Endereco endereco3 = new Endereco(null, "Av. Floriano Peixoto", "21", "Centro", "Apt. 300", "75440-000", c2, leitor2);
		
		leitor1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		leitor2.getEnderecos().addAll(Arrays.asList(endereco3));		
		
		leitorRepository.saveAll(Arrays.asList(leitor1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));		
		contatoRepository.saveAll(Arrays.asList(contato1, contato2));
		
		Emprestimo emp1 = new Emprestimo(null, sdf.parse("04/02/2020 10:12"), sdf.parse("14/02/2020 08:00"), leitor1, exemplar1);
		Emprestimo emp2 = new Emprestimo(null, sdf.parse("05/02/2020 09:30"), sdf.parse("28/02/2020 08:00"), leitor2, exemplar1);
				
		leitor1.getEmprestimos().addAll(Arrays.asList(emp1));
		leitor2.getEmprestimos().addAll(Arrays.asList(emp2));
		
		exemplar1.getEmprestimos().addAll(Arrays.asList(emp1, emp2));
				
		emprestimoRepository.saveAll(Arrays.asList(emp1, emp2));
		
	}
}
