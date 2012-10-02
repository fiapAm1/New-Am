package br.com.am.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class TipoCausa implements Serializable {

	private static final long serialVersionUID = -6524211805046334281L;
	
	private int codigoCausa;
	private String causa;
	
	/**
	 * Default constructor
	 * 
	 */
	public TipoCausa () {}

	/**
	 * @param codigoCausa
	 * @param causa
	 */
	public TipoCausa(int codigoCausa, String causa) {
		this.codigoCausa = codigoCausa;
		this.causa = causa;
	}

	/**
	 * @return the codigoCausa
	 */
	public int getCodigoCausa() {
		return codigoCausa;
	}

	/**
	 * @param codigoCausa the codigoCausa to set
	 */
	public void setCodigoCausa(int codigoCausa) {
		this.codigoCausa = codigoCausa;
	}

	/**
	 * @return the causa
	 */
	public String getCausa() {
		return causa;
	}

	/**
	 * @param causa the causa to set
	 */
	public void setCausa(String causa) {
		this.causa = causa;
	}


}
