package br.com.am.model;

import java.io.Serializable;

/**
 * 
 * @author Ricardo
 * @since 24/09/2012
 */
public class AdvogadoProcesso implements Serializable{

	private static final long serialVersionUID = -5438225687142186467L;
	
	private Advogado advogado = new Advogado();
	private Processo processo = new Processo();
	private String dataInicioStr;
	
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
	public String getDataInicioStr() {
		return dataInicioStr;
	}
	public void setDataInicioStr(String dataInicioStr) {
		this.dataInicioStr = dataInicioStr;
	}
}