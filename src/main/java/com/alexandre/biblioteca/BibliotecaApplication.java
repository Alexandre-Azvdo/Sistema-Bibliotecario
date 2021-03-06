package com.alexandre.biblioteca;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.biblioteca.domain.Autor;
import com.alexandre.biblioteca.domain.Cidade;
import com.alexandre.biblioteca.domain.Emprestimo;
import com.alexandre.biblioteca.domain.Endereco;
import com.alexandre.biblioteca.domain.Estado;
import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.Funcionario;
import com.alexandre.biblioteca.domain.Leitor;
import com.alexandre.biblioteca.domain.Livro;
import com.alexandre.biblioteca.domain.enums.StatusEmprestimo;
import com.alexandre.biblioteca.domain.enums.StatusLeitor;
import com.alexandre.biblioteca.domain.enums.StatusLivro;
import com.alexandre.biblioteca.repositories.AutorRepository;
import com.alexandre.biblioteca.repositories.CidadeRepository;
import com.alexandre.biblioteca.repositories.EmprestimoRepository;
import com.alexandre.biblioteca.repositories.EnderecoRepository;
import com.alexandre.biblioteca.repositories.EstadoRepository;
import com.alexandre.biblioteca.repositories.ExemplarRepository;
import com.alexandre.biblioteca.repositories.FuncionarioRepository;
import com.alexandre.biblioteca.repositories.LeitorRepository;
import com.alexandre.biblioteca.repositories.LivroRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
	
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
	private FuncionarioRepository funcionarioRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					
//		Livro livro1 = new Livro(null, "Reinações de Narizinho", "Sinopse",	"978-85-3809-031-1", "Ciranda Cultural", 
//				"Literatura Infantil", "Português", "288");		
//		Exemplar exemplar11 = new Exemplar(null, "EXEMPLAR-2019-05-21-1315", true, sdf2.parse("08/07/2019 01:00"), 72.50, StatusLivro.DISPONIVEL, "2019", livro1);
//		Exemplar exemplar12 = new Exemplar(null, "EXEMPLAR-2020-01-12-1456", true, sdf2.parse("01/01/2020 01:00"), 80.50, StatusLivro.DISPONIVEL, "2020", livro1);
//		Exemplar exemplar13 = new Exemplar(null, "EXEMPLAR-2020-01-12-1467", true, sdf2.parse("01/01/2020 01:01"), 80.50, StatusLivro.DISPONIVEL, "2020", livro1);
//		Exemplar exemplar14 = new Exemplar(null, "EXEMPLAR-2020-01-12-1478", true, sdf2.parse("01/01/2020 01:02"), 80.50, StatusLivro.DISPONIVEL, "2020", livro1);
//		livro1.getExemplares().addAll(Arrays.asList(exemplar11, exemplar12, exemplar13, exemplar14));		
//
//		Livro livro2 = new Livro(null, "O saci", "Sinopse", "978-85-2506-213-0", "Biblioteca Azul", 
//				"Literatura Juvenil", "Português", "208");
//		Exemplar exemplar21 = new Exemplar(null, "EXEMPLAR-2019-08-23-1000", true, sdf2.parse("08/07/2019 14:00"), 44.75, StatusLivro.INDISPONIVEL, "2018", livro2);
//		Exemplar exemplar22 = new Exemplar(null, "EXEMPLAR-2019-08-23-1014", true, sdf2.parse("08/07/2019 14:03"), 44.75, StatusLivro.INDISPONIVEL, "2018", livro2);
//		Exemplar exemplar23 = new Exemplar(null, "EXEMPLAR-2020-01-12-1345", true, sdf2.parse("02/01/2020 02:00"), 41.75, StatusLivro.INDISPONIVEL, "2019", livro2);
//		Exemplar exemplar24 = new Exemplar(null, "EXEMPLAR-2020-01-12-1354", true, sdf2.parse("02/01/2020 02:02"), 41.75, StatusLivro.INDISPONIVEL, "2019", livro2); 
//		livro2.getExemplares().addAll(Arrays.asList(exemplar21, exemplar22, exemplar23, exemplar24));
//		
//		Livro livro3 = new Livro(null, "Dom Casmurro", "Sinopse", "978-85-7232-264-7", "Martin Claret",
//				"Romance", "Português", "210");
//		Exemplar exemplar31 = new Exemplar(null, "EXEMPLAR-2020-01-14-1320", true, sdf2.parse("03/01/2020 15:02"), 39.45, StatusLivro.RESERVADO, "2020", livro3);
//		Exemplar exemplar32 = new Exemplar(null, "EXEMPLAR-2020-01-14-1330", true, sdf2.parse("03/01/2020 15:03"), 39.45, StatusLivro.RESERVADO, "2020", livro3);
//		Exemplar exemplar33 = new Exemplar(null, "EXEMPLAR-2020-01-14-1340", true, sdf2.parse("03/01/2020 15:04"), 39.45, StatusLivro.RESERVADO, "2020", livro3);
//		livro3.getExemplares().addAll(Arrays.asList(exemplar31, exemplar32, exemplar33));
//		
//		Livro livro4 = new Livro(null, "Memórias Póstumas De Brás Cubas", "Sinopse", "978-85-2092-780-9", "Nova Fronteira",
//				"Romance", "Português", "232");
//		Livro livro5 = new Livro(null, "Quincas Borba", "Sinopse", "978-85-7232-447-X", "Martin Claret",
//				"Romance", "Português", "270");
//		Livro livro6 = new Livro(null, "A Mão e A Luva", "Sinopse", "978-85-3681-534-3", "Dcl Difusão Cultural",
//				"Romance", "Português", "64");		
//		Livro livro7 = new Livro(null, "Esaú e Jacó", "Sinopse", "978-85-2092-735-9", "Nova Fronteira",
//				"Romance", "Português", "256");
//		Livro livro8 = new Livro(null, "O Alienista / Casa Velha", "Sinopse", "978-85-7232-750-3", "Martin Claret",
//				"Romance", "Português", "156");
//		Livro livro9 = new Livro(null, "Ressurreição", "Sinopse", "978-85-7232-957-6", "Martin Claret",
//				"Romance", "Português", "164");
//		Livro livro10 = new Livro(null, "Contos Fluminenses", "Sinopse", "978-85-2092-218-7", "Saraiva De Bolso",
//				"Romance", "Português", "216");
//
//		Autor a1 = new Autor(null,"Monteiro Lobato");
//		Autor a2 = new Autor(null,"Machado de Assis");		
//		
//		livro1.getAutores().addAll(Arrays.asList(a1));
//		livro2.getAutores().addAll(Arrays.asList(a1));
//		livro3.getAutores().addAll(Arrays.asList(a2));
//		livro4.getAutores().addAll(Arrays.asList(a2));
//		livro5.getAutores().addAll(Arrays.asList(a2));
//		livro6.getAutores().addAll(Arrays.asList(a2));
//		livro7.getAutores().addAll(Arrays.asList(a2));
//		livro8.getAutores().addAll(Arrays.asList(a2));
//		livro9.getAutores().addAll(Arrays.asList(a2));
//		livro10.getAutores().addAll(Arrays.asList(a2));
//		
//		a1.getLivros().addAll(Arrays.asList(livro1, livro2));
//		a2.getLivros().addAll(Arrays.asList(livro3, livro4, livro5, livro6, livro7, livro8, livro9, livro10));
//		
//		autorRepository.saveAll(Arrays.asList(a1, a2));
//		livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro3, livro4, livro5, livro6, livro7, livro8, livro9, livro10));
//		exemplarRepository.saveAll(
//				Arrays.asList(
//						exemplar11, exemplar12, exemplar13, exemplar14,
//						exemplar21, exemplar22,exemplar23, exemplar24, 
//						exemplar31, exemplar32, exemplar33
//					)
//				);
				
		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Pernambuco");
		
		Cidade c1 = new Cidade(null, "Sumé", est1);
		Cidade c2 = new Cidade(null, "Campina Grande", est1);
		Cidade c3 = new Cidade(null, "São José do Egito", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));		
					
//		Leitor leitor1 = new Leitor(null, "Alexandre Azevedo", sdf.parse("21/05/1985"), "054.630.324-24", StatusLeitor.ATIVO, "azvdo.ads@gmail.com");
//		leitor1.getTelefones().addAll(Arrays.asList("(83)99654-7901"));
//		
//		Leitor leitor2 = new Leitor(null, "Gustavo Rafael", sdf.parse("26/03/2019"), "021.310.665-98", StatusLeitor.ATIVO, "gustavo@gmail.com");
//		leitor2.getTelefones().addAll(Arrays.asList("(83)98875-2134", "(83)99632-1127"));
//		
//		Endereco endereco1 = new Endereco(null, "Rua Pedro Francisco Maciel", "904", "Santa Rosa", "Residencial", "58540-000", c1);
//		Endereco endereco2 = new Endereco(null, "Rua Praça da Bandeira", "s/n", "Centro", "Orgão Público", "63210-000", c3);
//		Endereco endereco3 = new Endereco(null, "Av. Floriano Peixoto", "21", "Centro", "Apt. 300", "75440-000", c2);
//		Endereco endereco4 = new Endereco(null, "Rua dos Sorrisos", "03", "Largo Alto", "Apt 02", "58540-000", c1);
//		
//		leitor1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
//		leitor2.getEnderecos().addAll(Arrays.asList(endereco3));		
//		
//		leitorRepository.saveAll(Arrays.asList(leitor1, leitor2));
//		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));				
//		
//		Funcionario funcionario1 = new Funcionario(null, "2020332212321", "Maria de Fátma Alves Lira", "435.321.112-98", "maria@gmail.com", endereco4);
//		funcionario1.getTelefones().addAll(Arrays.asList("(83)99543-2211", "(83)98865-0092"));
//				
//		funcionarioRepository.saveAll(Arrays.asList(funcionario1));
//		
//		Emprestimo emp1 = new Emprestimo(null, sdf.parse("04/02/2020 10:12"), sdf.parse("14/02/2020 08:00"), StatusEmprestimo.EM_ANDAMENTO, leitor1, funcionario1, exemplar11);
//		Emprestimo emp2 = new Emprestimo(null, sdf.parse("05/02/2020 09:30"), sdf.parse("28/02/2020 08:00"), StatusEmprestimo.CONCLUIDO, leitor2, funcionario1, exemplar11);
//				
//		leitor1.getEmprestimos().addAll(Arrays.asList(emp1));
//		leitor2.getEmprestimos().addAll(Arrays.asList(emp2));
//		funcionario1.getEmprestimos().addAll(Arrays.asList(emp1, emp2));
//		
//		exemplar11.getEmprestimos().addAll(Arrays.asList(emp1, emp2));
//				
//		emprestimoRepository.saveAll(Arrays.asList(emp1, emp2));
		
	}
}
