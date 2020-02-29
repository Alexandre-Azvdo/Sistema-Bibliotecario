package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class LeitorNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
	private String nome;	

	@NotNull(message = "O campo Data de de Nascimento NÃO pode ser nulo")
	private Date dataNascimento;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 11, max = 14, message = "O tamanho deve ser exatamente 11 caracteres númericos")
	private String cpf;
	
	private Integer status;

	private Set<String> emails = new HashSet<>();	
	private Set<String> telefones = new HashSet<>();
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String logradouro;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String numero;
	
	private String complemento;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String bairro;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String cep;
	
	@NotNull(message = "Preenchimento obrigatório!")
	private Integer cidadeId;
	
	public LeitorNewDTO() {
		
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
}
