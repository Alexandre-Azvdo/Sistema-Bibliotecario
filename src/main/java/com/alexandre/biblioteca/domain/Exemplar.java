package com.alexandre.biblioteca.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.alexandre.biblioteca.domain.enums.StatusLivro;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Exemplar implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String identificador;
	private Boolean qr_code;
	private Date data_aquisicao;
	private Double preco_unitario;
	private Integer situacao;
	private String edicao;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "exemplar")
	private List<Emprestimo> emprestimos = new ArrayList<>();
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;
	
	public Exemplar() {
		
	}

	public Exemplar(Integer id, String identificador, Boolean qr_code, Date data_aquisicao, Double preco_unitario,
			StatusLivro situacao, String edicao, Livro livro) {
		super();
		this.id = id;
		this.identificador = identificador;
		this.qr_code = qr_code;
		this.data_aquisicao = data_aquisicao;
		this.preco_unitario = preco_unitario;
		this.situacao = situacao.getCod();
		this.edicao = edicao;
		this.livro = livro;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
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
		Exemplar other = (Exemplar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
