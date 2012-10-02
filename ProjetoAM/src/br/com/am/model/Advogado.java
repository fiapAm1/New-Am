package br.com.am.model;

import java.io.Serializable;

/**
 * @author JDGR2<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class Advogado extends Pessoa implements Serializable{

	private static final long serialVersionUID = 4446309154175198787L;
	
	private int registroOAB;
	private long cpf;
	private String rg;
	private String email;
	private String password;
	
	
	/**
	 * 
	 * Default constructor
	 */
	public Advogado() {}
	
	
	/**
	 * @param registroOAB
	 * @param cpf
	 * @param rg
	 * @param email
	 * @param password
	 */
	public Advogado(int codigoAdvogado, String nomeAdvogado, int registroOAB, long cpf, String rg, String email, String password) {
		super(codigoAdvogado, nomeAdvogado);
		this.registroOAB = registroOAB;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.password = password;
	}


	/**
	 * @return the registroOAB
	 */
	public int getRegistroOAB() {
		return registroOAB;
	}


	/**
	 * @param registroOAB the registroOAB to set
	 */
	public void setRegistroOAB(int registroOAB) {
		this.registroOAB = registroOAB;
	}


	/**
	 * @return the cpf
	 */
	public long getCpf() {
		return cpf;
	}


	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}


	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}


	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
