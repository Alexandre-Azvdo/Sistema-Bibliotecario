package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;

import com.alexandre.biblioteca.domain.Livro;

public class LivroDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String sinopse;
	private String isbn;
	private String editora;
	private String genero;
	private String idioma;
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
