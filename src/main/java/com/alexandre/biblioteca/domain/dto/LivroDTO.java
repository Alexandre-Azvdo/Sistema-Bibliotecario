package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.alexandre.biblioteca.domain.Livro;

public class LivroDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;	
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
	private String titulo;	
	
	private String sinopse;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 17, max = 17, message = "O tamanho deve ser de 17 caracteres no formato XXX-XX-XXXX-XXX-X")
	private String isbn;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String editora;
	
	private String genero;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String idioma;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String numPaginas;
	
	public LivroDTO() {
		
	}

	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.sinopse = livro.getSinopse();
		this.isbn = livro.getIsbn();
		this.editora = livro.getEditora();
		this.genero = livro.getGenero();
		this.idioma = livro.getIdioma();
		this.numPaginas = livro.getNumPaginas();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}
		
}
