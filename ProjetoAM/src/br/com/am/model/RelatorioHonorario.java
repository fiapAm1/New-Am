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
public class RelatorioHonorario implements Serializable{

	private static final long serialVersionUID = -5862401400198221903L;
	
	private Date dataHonorario;
	private String nomeAdvogado;
	private double valorTarefa;
	
	/**
	 * Construtor padrão
	 */
	public RelatorioHonorario() {}

	/**
	 * @param dataHonorario
	 * @param nomeAdvogado
	 * @param valorTarefa
	 */
	public RelatorioHonorario(Date dataHonorario, String nomeAdvogado, double valorTarefa) {
		this.dataHonorario = dataHonorario;
		this.nomeAdvogado = nomeAdvogado;
		this.valorTarefa = valorTarefa;
	}

	/**
	 * @return the dataHonorario
	 */
	public Date getDataHonorario() {
		return dataHonorario;
	}

	/**
	 * @param dataHonorario the dataHonorario to set
	 */
	public void setDataHonorario(Date dataHonorario) {
		this.dataHonorario = dataHonorario;
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

	/**
	 * @return the valorTarefa
	 */
	public double getValorTarefa() {
		return valorTarefa;
	}

	/**
	 * @param valorTarefa the valorTarefa to set
	 */
	public void setValorTarefa(double valorTarefa) {
		this.valorTarefa = valorTarefa;
	}

}
