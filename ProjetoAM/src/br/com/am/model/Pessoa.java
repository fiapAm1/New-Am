package br.com.am.model;

import java.io.Serializable;


/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -6483031180651201880L;
	
	private int codigoPessoa;
	private String nomePessoa;
	
	/**
	 * 
	 * Default constructor
	 */
	public Pessoa() {}

	/**
	 * @param codigoPessoa
	 * @param nomePessoa
	 */
	public Pessoa(int codigoPessoa, String nomePessoa) {
		this.codigoPessoa = codigoPessoa;
		this.nomePessoa = nomePessoa;
	}

	/**
	 * @return the codigoPessoa
	 */
	public int getCodigoPessoa() {
		return codigoPessoa;
	}

	/**
	 * @param codigoPessoa the codigoPessoa to set
	 */
	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	/**
	 * @return the nomePessoa
	 */
	public String getNomePessoa() {
		return nomePessoa;
	}

	/**
	 * @param nomePessoa the nomePessoa to set
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

}
