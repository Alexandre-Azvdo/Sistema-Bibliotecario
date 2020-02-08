package com.alexandre.biblioteca.domain.enums;

public enum StatusEmprestimo {
	
	EM_ANDAMENTO(1, "Em Andamento"),
	CONCLUIDO(2, "Concluído"),	
	FORA_DO_PRAZO(3, "Fora do prazo");

	private int cod;
	private String descricao;

	private StatusEmprestimo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
	return descricao;
	}

	public static StatusEmprestimo toEnum(Integer cod){
		if(cod == null) {
			return null;
		}
	
		for( StatusEmprestimo x : StatusEmprestimo.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
	
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}

}
