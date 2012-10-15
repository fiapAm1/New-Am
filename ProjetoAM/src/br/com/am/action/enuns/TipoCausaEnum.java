package br.com.am.action.enuns;

public enum TipoCausaEnum {
	
	TRIBUTARIA("TRIBUT�RIA"), 
	TRABALHISTA("TRABALHISTA"), 
	COMERCIAL("COMERCIAL");
	
	private String descricao;
	
	private TipoCausaEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
