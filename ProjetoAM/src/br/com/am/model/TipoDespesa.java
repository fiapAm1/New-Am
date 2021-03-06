package br.com.am.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class TipoDespesa implements Serializable {
	
	private static final long serialVersionUID = -4343325866387980100L;
	private Integer codigoDespesa;
	private String despesa;
	
	/**
	 * Default constructor
	 */
	public TipoDespesa() {}
	
	/**
	 * @param codigoDespesa
	 * @param despesa
	 */
	public TipoDespesa(Integer codigoDespesa, String despesa) {
		this.codigoDespesa = codigoDespesa;
		this.despesa = despesa;
	}

	/**
	 * @return the codigoDespesa
	 */
	public Integer getCodigoDespesa() {
		return codigoDespesa;
	}

	/**
	 * @param codigoDespesa the codigoDespesa to set
	 */
	public void setCodigoDespesa(Integer codigoDespesa) {
		this.codigoDespesa = codigoDespesa;
	}

	/**
	 * @return the despesa
	 */
	public String getDespesa() {
		return despesa;
	}

	/**
	 * @param despesa the despesa to set
	 */
	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

}
