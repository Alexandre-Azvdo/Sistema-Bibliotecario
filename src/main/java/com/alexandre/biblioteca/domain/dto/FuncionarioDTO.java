package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.alexandre.biblioteca.domain.Funcionario;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
	private String matricula;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
	private String nome;
	
	@Email(message = "Email inválido")
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String email;
	
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
	private Integer enderecoId;
	
	@NotNull(message = "Preenchimento obrigatório!")
	private Integer cidadeId;

	public FuncionarioDTO() {

	}

	public FuncionarioDTO(Funcionario funcionario) {
		super();
		this.id = funcionario.getId();
		this.matricula = funcionario.getMatricula();
		this.nome = funcionario.getNome();
		this.email = funcionario.getEmail();
		this.logradouro = funcionario.getEndereco().getLogradouro();
		this.numero = funcionario.getEndereco().getNumero();
		this.cep = funcionario.getEndereco().getCep();
		this.complemento = funcionario.getEndereco().getComplemento();
		this.bairro = funcionario.getEndereco().getBairro();
		this.cidadeId = funcionario.getEndereco().getCidade().getId();
		this.enderecoId = funcionario.getEndereco().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	public Integer getCidadeId() {
		return cidadeId;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}
		
}
