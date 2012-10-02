package br.com.am.model;

import java.io.Serializable;
import java.util.Date;

import br.com.am.bo.ProcessoBO;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class Processo implements Serializable{

	private static final long serialVersionUID = 6619774559878938692L;
	
	private int numeroProcesso;
	private Forum forum = new Forum();
	private Cliente cliente = new Cliente();
	private TipoCausa causa = new TipoCausa();
	private TipoCobranca cobranca = new TipoCobranca();
	private String processo;
	private Date dataAbertura;
	private Date dataFechamento;
	private int diaVencimento;
	private int resultado;
	private String observacao;
	
	/**
	 * Default constructor
	 * 
	 */
	public Processo () {}

	/**
	 * @param numeroProcesso
	 * @param forum
	 * @param cliente
	 * @param causa
	 * @param cobranca
	 * @param processo
	 * @param dataAbertura
	 * @param dataFechamento
	 * @param dataVencimento
	 * @param resultado
	 * @param observacao
	 */
	public Processo(int numeroProcesso, Forum forum, Cliente cliente,TipoCausa causa, TipoCobranca cobranca, String processo,
			Date dataAbertura, Date dataFechamento, int diaVencimento,int resultado, String observacao) {
		
		this.numeroProcesso = numeroProcesso;
		this.forum = forum;
		this.cliente = cliente;
		this.causa = causa;
		this.cobranca = cobranca;
		this.processo = processo;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.diaVencimento = diaVencimento;
		this.resultado = resultado;
		this.observacao = observacao;
	}

	/**
	 * @return the numeroProcesso
	 */
	public int getNumeroProcesso() {
		return numeroProcesso;
	}

	/**
	 * @param numeroProcesso the numeroProcesso to set
	 */
	public void setNumeroProcesso(int numeroProcesso) {
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
	 * @return the dataAbertura
	 */
	public Date getDataAbertura() {
		return dataAbertura;
	}

	/**
	 * @param dataAbertura the dataAbertura to set
	 */
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	/**
	 * @return the dataFechamento
	 */
	public Date getDataFechamento() {
		return dataFechamento;
	}

	/**
	 * @param dataFechamento the dataFechamento to set
	 */
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	/**
	 * @return the diaVencimento
	 */
	public int getDiaVencimento() {
		return diaVencimento;
	}

	/**
	 * @param diaVencimento the diaVencimento to set
	 */
	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	/**
	 * @return the resultado
	 */
	public int getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(int resultado) {
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

}
