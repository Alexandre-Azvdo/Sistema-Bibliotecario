package com.alexandre.biblioteca.domain.enums;

public enum StatusLeitor {
	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo"),
	PENDENTE(3, "Pendente");
	
	private int cod;
	private String descricao;
	
	private StatusLeitor(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusLeitor toEnum(Integer cod){
		if(cod == null) {
			return null;
		}
		
		for( StatusLeitor x : StatusLeitor.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}

