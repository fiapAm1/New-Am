package br.com.am.action.enuns;

public enum ResultadoEnum {
	
	ANDAMENTO("ANDAMENTO"),
	PERDIDA("PERDIDA"),
	GANHA("GANHA");
	
	String descricao;
	
	private ResultadoEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
