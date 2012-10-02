/**
 * 
 */
package br.com.am.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class Despesa implements Serializable{

	private static final long serialVersionUID = 1963584501144760391L;
	
	private int codigoLancamento;
	private TipoDespesa tipoDespesa = new TipoDespesa();
	private Processo processo = new Processo();
	private Date dataDespesa;
	private double valorDespesa;
	private String observacao;
	
	/**
	 * Default constructor
	 */
	public Despesa () {}

	/**
	 * @param codigoLancamento
	 * @param tipoDespesa
	 * @param processo
	 * @param dataDespesa
	 * @param valorDespesa
	 * @param observacao
	 */
	public Despesa(int codigoLancamento, TipoDespesa tipoDespesa, Processo processo, Date dataDespesa, double valorDespesa,
				   String observacao) {
		this.codigoLancamento = codigoLancamento;
		this.tipoDespesa = tipoDespesa;
		this.processo = processo;
		this.dataDespesa = dataDespesa;
		this.valorDespesa = valorDespesa;
		this.observacao = observacao;
	}

	/**
	 * @return the codigoLancamento
	 */
	public int getCodigoLancamento() {
		return codigoLancamento;
	}

	/**
	 * @param codigoLancamento the codigoLancamento to set
	 */
	public void setCodigoLancamento(int codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}

	/**
	 * @return the tipoDespesa
	 */
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	/**
	 * @param tipoDespesa the tipoDespesa to set
	 */
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	/**
	 * @return the processo
	 */
	public Processo getProcesso() {
		return processo;
	}

	/**
	 * @param processo the processo to set
	 */
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	/**
	 * @return the dataDespesa
	 */
	public Date getDataDespesa() {
		return dataDespesa;
	}

	/**
	 * @param dataDespesa the dataDespesa to set
	 */
	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	/**
	 * @return the valorDespesa
	 */
	public double getValorDespesa() {
		return valorDespesa;
	}

	/**
	 * @param valorDespesa the valorDespesa to set
	 */
	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
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
