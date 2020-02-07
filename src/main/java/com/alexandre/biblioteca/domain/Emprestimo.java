package com.alexandre.biblioteca.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.alexandre.biblioteca.domain.enums.StatusEmprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Emprestimo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_inicial;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_entrega;
	
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "leitor_id")
	private Leitor leitor;
	
	@JsonIgnore	  
	@ManyToOne(cascade = { //Resolvido problema : detached entity passed to persist spring
			CascadeType.MERGE,
            CascadeType.REFRESH}
	)	  
	@JoinColumn(name = "exemplar_id") 
	private Exemplar exemplar;
	
	public Emprestimo() {

	}

	public Emprestimo(Integer id, Date data_inicial, Date data_entrega, StatusEmprestimo status, Leitor leitor, Exemplar exemplar) {
		super();
		this.id = id;
		this.data_inicial = data_inicial;
		this.data_entrega = data_entrega;
		this.status = status.getCod();
		this.leitor = leitor;
		this.exemplar = exemplar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}

	public Date getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}

	public StatusEmprestimo getStatus() {
		return StatusEmprestimo.toEnum(status);
	}

	public void setStatus(StatusEmprestimo status) {
		this.status = status.getCod();
	}

	public Leitor getLeitor() {
		return leitor;
	}

	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
