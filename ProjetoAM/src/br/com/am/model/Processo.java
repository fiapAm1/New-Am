package br.com.am.model;

import java.io.Serializable;
import java.util.Date;

import br.com.am.bo.ProcessoBO;
import br.com.am.util.UtilDate;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class Processo implements Serializable{

	private static final long serialVersionUID = 6619774559878938692L;
	
	private Integer numeroProcesso;
	private Forum forum = new Forum();
	private Cliente cliente = new Cliente();
	private TipoCausa causa = new TipoCausa();
	private TipoCobranca cobranca = new TipoCobranca();
	private String processo;
	private String dataAberturaStr;
	private String dataFechamentoStr;
	private Integer diaVencimento;
	private Integer resultado;
	private String observacao;
	
	/**
	 * Default constructor
	 * 
	 */
	public Processo () {}

	/**
	 * @return the numeroProcesso
	 */
	public Integer getNumeroProcesso() {
		return numeroProcesso;
	}

	/**
	 * @param numeroProcesso the numeroProcesso to set
	 */
	public void setNumeroProcesso(Integer numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	/**
	 * @return the forum
	 */
	public Forum getForum() {
		return forum;
	}

	/**
	 * @param forum the forum to set
	 */
	public void setForum(Forum forum) {
		this.forum = forum;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		cliente = ProcessoBO.consultarCliente(cliente.getCodigoPessoa());
		this.cliente = cliente;
	}

	/**
	 * @return the causa
	 */
	public TipoCausa getCausa() {
		return causa;
	}

	/**
	 * @param causa the causa to set
	 */
	public void setCausa(TipoCausa causa) {
		causa = ProcessoBO.consultarTipoCausa(causa.getCodigoCausa());
		this.causa = causa;
	}

	/**
	 * @return the cobranca
	 */
	public TipoCobranca getCobranca() {
		return cobranca;
	}

	/**
	 * @param cobranca the cobranca to set
	 */
	public void setCobranca(TipoCobranca cobranca) {
		cobranca = ProcessoBO.consultarTipoCobranca(cobranca.getCodigoCobranca());
		this.cobranca = cobranca;
	}

	/**
	 * @return the processo
	 */
	public String getProcesso() {
		return processo;
	}

	/**
	 * @param processo the processo to set
	 */
	public void setProcesso(String processo) {
		this.processo = processo;
	}

	/**
	 * @return the diaVencimento
	 */
	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	/**
	 * @param diaVencimento the diaVencimento to set
	 */
	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	/**
	 * @return the resultado
	 */
	public Integer getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDataAberturaStr() {
		return dataAberturaStr;
	}

	public void setDataAberturaStr(String dataAberturaStr) {
		this.dataAberturaStr = dataAberturaStr;
	}

	public String getDataFechamentoStr() {
		return dataFechamentoStr;
	}

	public void setDataFechamentoStr(String dataFechamentoStr) {
		this.dataFechamentoStr = dataFechamentoStr;
	}
}