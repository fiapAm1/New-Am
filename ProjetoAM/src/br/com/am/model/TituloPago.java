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
public class TituloPago implements Serializable{

	private static final long serialVersionUID = 267539667925279026L;
	
	private Titulo titulo = new Titulo();
	private Date dataPagamento;
	private double valorPago;
	
	public TituloPago() {}

	/**
	 * @param titulo
	 * @param dataPagamento
	 * @param valorPago
	 */
	public TituloPago(Titulo titulo, Date dataPagamento, double valorPago) {
		this.titulo = titulo;
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
	}

	/**
	 * @return the titulo
	 */
	public Titulo getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	/**
	 * @return the valorPago
	 */
	public double getValorPago() {
		return valorPago;
	}

	/**
	 * @param valorPago the valorPago to set
	 */
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
}
