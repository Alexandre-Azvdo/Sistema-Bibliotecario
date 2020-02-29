package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.alexandre.biblioteca.domain.Leitor;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LeitorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
	private String nome;	
	
	@NotNull(message = "O campo Data de de Nascimento NÃO pode ser nulo")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	private Integer status;
	
	private Set<String> emails = new HashSet<>();	
	private Set<String> telefones = new HashSet<>();
	
	public LeitorDTO() {

	}
	
	public LeitorDTO(Leitor leitor) {
		this.id = leitor.getId();
		this.nome = leitor.getNome();
		this.dataNascimento = leitor.getDataNascimento();
		this.status = leitor.getStatus().getCod();
		this.emails.addAll(leitor.getContato().getEmails());
		this.telefones.addAll(leitor.getContato().getTelefones());
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
