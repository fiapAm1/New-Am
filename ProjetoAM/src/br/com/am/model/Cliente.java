package br.com.am.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = 6108696599446439467L;
	
	private String razaoSocial;
	private long cnpj;
	private long inscEstadual;
	private String email;
	private String password;
	
	/**
	 * 
	 * Default constructor
	 */
	public Cliente () {}

	

	/**
	 * @param codigoCliente
	 * @param nomeCliente
	 * @param razaoSocial
	 * @param cnpj
	 * @param inscEstadual
	 * @param email
	 * @param password
	 */
	public Cliente(int codigoCliente, String nomeCliente, String razaoSocial, long cnpj, long inscEstadual, String email, String password) {
		super(codigoCliente, nomeCliente);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscEstadual = inscEstadual;
		this.email = email;
		this.password = password;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the cnpj
	 */
	public long getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the inscEstadual
	 */
	public long getInscEstadual() {
		return inscEstadual;
	}

	/**
	 * @param inscEstadual the inscEstadual to set
	 */
	public void setInscEstadual(long inscEstadual) {
		this.inscEstadual = inscEstadual;
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
