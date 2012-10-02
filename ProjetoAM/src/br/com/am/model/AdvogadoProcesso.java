package br.com.am.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Ricardo
 * @since 24/09/2012
 */
public class AdvogadoProcesso implements Serializable{

	private static final long serialVersionUID = -5438225687142186467L;
	
	private Advogado advogado = new Advogado();
	private Processo processo = new Processo();
	private Date dataInicio;
	
	public Advogado getAdvogado() {
		return advogado;
	}
	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
}