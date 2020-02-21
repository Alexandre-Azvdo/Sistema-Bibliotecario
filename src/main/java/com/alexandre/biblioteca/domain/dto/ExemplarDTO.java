package com.alexandre.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.alexandre.biblioteca.domain.Exemplar;
import com.alexandre.biblioteca.domain.util.CustomerDateAndTimeDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class ExemplarDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String identificador;
	
	private Boolean qr_code;
	
	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_aquisicao;
	
	private Double preco_unitario;	
	
	private Integer status;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String edicao;
	
	public ExemplarDTO() {

	}
	
	public ExemplarDTO(Exemplar exemplar) {
		super();
		this.id = exemplar.getId();
		this.identificador = exemplar.getIdentificador();
		this.qr_code = exemplar.getQr_code();
		this.data_aquisicao = exemplar.getData_aquisicao();
		this.preco_unitario = exemplar.getPreco_unitario();
		this.status = exemplar.getStatus().getCod();
		this.edicao = exemplar.getEdicao();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
