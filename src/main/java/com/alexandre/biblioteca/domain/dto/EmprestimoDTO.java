package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.Date;

import com.alexandre.biblioteca.domain.Emprestimo;

public class EmprestimoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date data_inicial;
	private Date data_entrega;	
	private Integer status;
	
	public EmprestimoDTO() {

	}

	public EmprestimoDTO(Emprestimo emprestimo) {
		super();
		this.id = emprestimo.getId();
		this.data_inicial = emprestimo.getData_inicial();
		this.data_entrega = emprestimo.getData_entrega();
		this.status = emprestimo.getStatus().getCod();
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
		
}
