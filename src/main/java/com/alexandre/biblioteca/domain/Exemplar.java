package com.alexandre.biblioteca.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.alexandre.biblioteca.domain.enums.StatusLivro;

@Entity
public class Exemplar extends Livro {
	private static final long serialVersionUID = 1L;

	private String identificador;
	private Boolean qr_code;
	private Date data_aquisicao;
	private Double preco_unitario;
	private Integer situacao;
	
	//private Emprestimo emprestimo;
	
	public Exemplar() {
		
	}

	
	public Exemplar(Integer id, String titulo, String sinopse, String isbn, String edicao, String editora,
			String genero, String idioma, String numPaginas, 
			String identificador, Boolean qr_code, Date data_aquisicao,Double preco_unitario, StatusLivro situacao) {
		super(id, titulo, sinopse, isbn, edicao, editora, genero, idioma, numPaginas);
		this.identificador = identificador;
		this.qr_code = qr_code;
		this.data_aquisicao = data_aquisicao;
		this.preco_unitario = preco_unitario;
		this.situacao = situacao.getCod();
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

	public StatusLivro getSituacao() {
		return StatusLivro.toEnum(situacao);
	}

	public void setSituacao(StatusLivro situacao) {
		this.situacao = situacao.getCod();
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
	
}
