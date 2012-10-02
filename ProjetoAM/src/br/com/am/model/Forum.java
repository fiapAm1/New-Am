package br.com.am.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class Forum extends Pessoa implements Serializable{

	private static final long serialVersionUID = 8582526742669365546L;
	
	private String descricaoForum;
	
	/**
	 * 
	 * Default constructor
	 */
	public Forum() {}


	/**
	 * @param codigoForum
	 * @param forum
	 */
	public Forum(int codigoForum, String nomeForum, String descricaoForum) {
		super(codigoForum, nomeForum);
		this.descricaoForum = descricaoForum;
	}

	/**
	 * @return the forum
	 */
	public String getDescricaoForum() {
		return descricaoForum;
	}


	/**
	 * @param descricaoForum the descricaoForum to set
	 */
	public void setDescricaoForum(String descricaoForum) {
		this.descricaoForum = descricaoForum;
	}

}
