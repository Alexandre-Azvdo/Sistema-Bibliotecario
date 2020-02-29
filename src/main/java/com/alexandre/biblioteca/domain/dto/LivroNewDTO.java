package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

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
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String identificador;
	
	private Boolean qr_code;
	
	@NotNull(message = "O campo Data de Aquisição NÃO pode ser nulo")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_aquisicao;
	
	@NotNull(message = "O campo Preço unitário NÃO pode ser nulo")
	private Double preco_unitario;
	
	private Integer status;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String edicao;
	
	public LivroNewDTO() {
		
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Boolean getQr_code() {
		return qr_code;
	}

	public void setQr_code(Boolean qr_code) {
		this.qr_code = qr_code;
	}

	public Date getData_aquisicao() {
		return data_aquisicao;
	}

	public void setData_aquisicao(Date data_aquisicao) {
		this.data_aquisicao = data_aquisicao;
	}

	public Double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
		
}
