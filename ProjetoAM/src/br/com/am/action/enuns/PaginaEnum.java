package br.com.am.action.enuns;

/**
 * Enum para direcionar páginas
 * @author Ricardo
 * @since 18/09/2012
 */
public enum PaginaEnum {
	
	ALTERAR_PROCESSO("alterar"),
	CADASTRAR_PROCESSO("cadastrar"),
	EMITIR_RELATORIO_AUDIENCIA("emitirAudiencia"),
	EMITIR_RELATORIO_HONORARIO("emitirHonorario"),
	ERRO("erro"),
	EXIBIR_PROCESSO("exibir"),
	HOME("home"),
	LANCAR_DESPESA("lancar"),
	LISTAR_PROCESSO("listar"),
	REGISTRAR_PAGAMENTO("registrarPagamento");
	
	
	private String descricao;
	
	private PaginaEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
