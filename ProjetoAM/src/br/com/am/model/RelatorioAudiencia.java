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
public class RelatorioAudiencia implements Serializable{
	
	private static final long serialVersionUID = 1893946386366741156L;
	
	private Date dataAudiencia;
	private String forum;
	private String logradouro;
	private int numeroEndereco;
	private int sala;
	private String nomeAdvogado;
	
	
	public RelatorioAudiencia() {}
	
	/**
	 * @param dataAudiencia
	 * @param forum
	 * @param logradouro
	 * @param sala
	 * @param nomeAdvogado
	 */
	public RelatorioAudiencia(Date dataAudiencia, String forum,	String logradouro, int sala, String nomeAdvogado) {
		this.dataAudiencia = dataAudiencia;
		this.forum = forum;
		this.logradouro = logradouro;
		this.sala = sala;
		this.nomeAdvogado = nomeAdvogado;
	}

	/**
	 * @return the dataAudiencia
	 */
	public Date getDataAudiencia() {
		return dataAudiencia;
	}

	/**
	 * @param dataAudiencia the dataAudiencia to set
	 */
	public void setDataAudiencia(Date dataAudiencia) {
		this.dataAudiencia = dataAudiencia;
	}

	/**
	 * @return the forum
	 */
	public String getForum() {
		return forum;
	}

	/**
	 * @param forum the forum to set
	 */
	public void setForum(String forum) {
		this.forum = forum;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numeroEndereco
	 */
	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	/**
	 * @param numeroEndereco the numeroEndereco to set
	 */
	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	/**
	 * @return the sala
	 */
	public int getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(int sala) {
		this.sala = sala;
	}

	/**
	 * @return the nomeAdvogado
	 */
	public String getNomeAdvogado() {
		return nomeAdvogado;
	}

	/**
	 * @param nomeAdvogado the nomeAdvogado to set
	 */
	public void setNomeAdvogado(String nomeAdvogado) {
		this.nomeAdvogado = nomeAdvogado;
	}
	
}
