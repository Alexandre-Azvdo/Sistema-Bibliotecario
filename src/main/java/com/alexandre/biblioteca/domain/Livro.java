package com.alexandre.biblioteca.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String snopse;
	private String isbn;
	private String edicao;
	private String editora;
	private String genero;
	
	private List<Autor> autores = new ArrayList<>();
	
	public Livro() {
		
	}
	
	public Livro(Integer id, String titulo, String snopse, String isbn, String edicao, String editora, String genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.snopse = snopse;
		this.isbn = isbn;
		this.edicao = edicao;
		this.editora = editora;
		this.genero = genero;
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

	public String getSnopse() {
		return snopse;
	}

	public void setSnopse(String snopse) {
		this.snopse = snopse;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
