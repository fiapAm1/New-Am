package br.com.am.model;

import java.io.Serializable;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class TipoCobranca implements Serializable{

	private static final long serialVersionUID = 1631652901427763236L;
	
	private int codigoCobranca;
	private String periodoCobranca;
	private double taxaJuros;
	private double moraDiaria;
	
	/**
	 * Default constructor
	 * 
	 */
	public TipoCobranca() {}

	/**
	 * @param codigoCobranca
	 * @param periodoCobranca
	 * @param taxaJuros
	 * @param moraDiaria
	 */
	public TipoCobranca(int codigoCobranca, String periodoCobranca,	double taxaJuros, double moraDiaria) {
		this.codigoCobranca = codigoCobranca;
		this.periodoCobranca = periodoCobranca;
		this.taxaJuros = taxaJuros;
		this.moraDiaria = moraDiaria;
	}

	/**
	 * @return the codigoCobranca
	 */
	public int getCodigoCobranca() {
		return codigoCobranca;
	}

	/**
	 * @param codigoCobranca the codigoCobranca to set
	 */
	public void setCodigoCobranca(int codigoCobranca) {
		this.codigoCobranca = codigoCobranca;
	}

	/**
	 * @return the periodoCobranca
	 */
	public String getPeriodoCobranca() {
		return periodoCobranca;
	}

	/**
	 * @param periodoCobranca the periodoCobranca to set
	 */
	public void setPeriodoCobranca(String periodoCobranca) {
		this.periodoCobranca = periodoCobranca;
	}

	/**
	 * @return the taxaJuros
	 */
	public double getTaxaJuros() {
		return taxaJuros;
	}

	/**
	 * @param taxaJuros the taxaJuros to set
	 */
	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}

	/**
	 * @return the moraDiaria
	 */
	public double getMoraDiaria() {
		return moraDiaria;
	}

	/**
	 * @param moraDiaria the moraDiaria to set
	 */
	public void setMoraDiaria(double moraDiaria) {
		this.moraDiaria = moraDiaria;
	}

}
