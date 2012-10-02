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
public class Titulo implements Serializable {

	private static final long serialVersionUID = -2718707057596542917L;
	
	private int numeroTitulo;
	private Processo processo = new Processo();
	private long agenciaCedente;
	private Date dataDocumento;
	private Date dataVencimento;
	private double valorDocumento;
	
	/**
	 * Construtor padrão
	 * 
	 */
	public Titulo() {}

	/**
	 * @param numeroTitulo
	 * @param processo
	 * @param agenciaCedente
	 * @param dataDocumento
	 * @param dataVencimento
	 * @param valorDocumento
	 */
	public Titulo(int numeroTitulo, Processo processo, long agenciaCedente,	Date dataDocumento, Date dataVencimento, 
			      double valorDocumento) {
		this.numeroTitulo = numeroTitulo;
		this.processo = processo;
		this.agenciaCedente = agenciaCedente;
		this.dataDocumento = dataDocumento;
		this.dataVencimento = dataVencimento;
		this.valorDocumento = valorDocumento;
	}

	/**
	 * @return the numeroTitulo
	 */
	public int getNumeroTitulo() {
		return numeroTitulo;
	}

	/**
	 * @param numeroTitulo the numeroTitulo to set
	 */
	public void setNumeroTitulo(int numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
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
	 * @return the agenciaCedente
	 */
	public long getAgenciaCedente() {
		return agenciaCedente;
	}

	/**
	 * @param agenciaCedente the agenciaCedente to set
	 */
	public void setAgenciaCedente(long agenciaCedente) {
		this.agenciaCedente = agenciaCedente;
	}

	/**
	 * @return the dataDocumento
	 */
	public Date getDataDocumento() {
		return dataDocumento;
	}

	/**
	 * @param dataDocumento the dataDocumento to set
	 */
	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	/**
	 * @return the dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * @param dataVencimento the dataVencimento to set
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * @return the valorDocumento
	 */
	public double getValorDocumento() {
		return valorDocumento;
	}

	/**
	 * @param valorDocumento the valorDocumento to set
	 */
	public void setValorDocumento(double valorDocumento) {
		this.valorDocumento = valorDocumento;
	}
	
}
