package com.alexandre.biblioteca.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.alexandre.biblioteca.domain.enums.StatusLivro;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Exemplar extends Livro {
	private static final long serialVersionUID = 1L;

	private String identificador;
	private Boolean qr_code;
	private Date data_aquisicao;
	private Double preco_unitario;
	private Integer situacao;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "exemplar")
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
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

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	// Não aplementatar HashCode() & Equals(), ficão na classe Livro(Classe pai)
}
