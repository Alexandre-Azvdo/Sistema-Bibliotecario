package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.alexandre.biblioteca.domain.Leitor;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LeitorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
	private String nome;	
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 11, max = 14, message = "O tamanho deve ser exatamente 11 caracteres númericos")
	private String cpf;
	
	private Integer status;
	
	public LeitorDTO(Leitor leitor) {
		super();
		this.id = leitor.getId();
		this.nome = leitor.getNome();
		this.dataNascimento = leitor.getDataNascimento();
		this.cpf = leitor.getCpf();
		this.status = leitor.getStatus().getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
