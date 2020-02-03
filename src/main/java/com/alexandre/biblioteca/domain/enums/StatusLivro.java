package com.alexandre.biblioteca.domain.enums;

public enum StatusLivro {

	DISPONIVEL(1, "Disponível"),
	INDISPONIVEL(2, "Indisponível"),
	RESERVADO(3, "Reservado");
	
	private int cod;
	private String descricao;
	
	private StatusLivro(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusLivro toEnum(Integer cod){
		if(cod == null) {
			return null;
		}
		
		for( StatusLivro x : StatusLivro.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
