package br.com.am.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.action.enuns.ResultadoEnum;
import br.com.am.action.enuns.TipoCausaEnum;
import br.com.am.bo.ProcessoBO;

public class HomeAction extends GenericAction{

	private static final long serialVersionUID = 3392559602784798553L;
	
	private Map<String, Integer> contagemPorCausa = new HashMap<String, Integer>();
	private Map<String, Integer> contagemPorProcessoStatus = new HashMap<String, Integer>();
	
	private int contagemTributaria;
	private int contagemComercial;
	private int contagemTrabalhista;
	
	private int contagemProcessoAndamento;
	private int contagemProcessoPerdido;
	private int contagemProcessoGanho;
	
	
	/**
	 * Action para listar processo
	 * @author JDGR²
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="carregarHome", results={
			@Result(name="home", type="json", params={"json", "contagemPorCausa"})
	})
	public String carregarHome(){
		
		carregarContagemPorCausa();
		carregarContagemPorProcessoStatus();
		
		return String.valueOf(PaginaEnum.HOME.getDescricao());
	}
	
	private void carregarContagemPorProcessoStatus() {
		
		contagemPorProcessoStatus.putAll(ProcessoBO.contagemProcessosPorResultado());
		
		contagemProcessoAndamento = contagemPorProcessoStatus.get(ResultadoEnum.ANDAMENTO.getDescricao()).intValue();
		contagemProcessoGanho = contagemPorProcessoStatus.get(ResultadoEnum.GANHA.getDescricao()).intValue();
		contagemProcessoPerdido = contagemPorProcessoStatus.get(ResultadoEnum.PERDIDA.getDescricao()).intValue();
		
	}
	
	private void carregarContagemPorCausa() {
		
		contagemPorCausa.putAll(ProcessoBO.contagemProcessosPorCausa());	
		
		contagemTrabalhista = contagemPorCausa.get(TipoCausaEnum.TRABALHISTA.getDescricao()).intValue();
		contagemComercial = contagemPorCausa.get(TipoCausaEnum.COMERCIAL.getDescricao()).intValue();
		contagemTributaria = contagemPorCausa.get(TipoCausaEnum.TRIBUTARIA.getDescricao()).intValue();
		
	}
	
	/**
	 * @return the contagemPorCausa
	 */
	public Map<String, Integer> getContagemPorCausa() {
		return contagemPorCausa;
	}
	/**
	 * @param contagemPorCausa the contagemPorCausa to set
	 */
	public void setContagemPorCausa(Map<String, Integer> contagemPorCausa) {
		this.contagemPorCausa = contagemPorCausa;
	}
	/**
	 * @return the contagemTributaria
	 */
	public int getContagemTributaria() {
		return contagemTributaria;
	}
	/**
	 * @param contagemTributaria the contagemTributaria to set
	 */
	public void setContagemTributaria(int contagemTributaria) {
		this.contagemTributaria = contagemTributaria;
	}
	/**
	 * @return the contagemComercial
	 */
	public int getContagemComercial() {
		return contagemComercial;
	}
	/**
	 * @param contagemComercial the contagemComercial to set
	 */
	public void setContagemComercial(int contagemComercial) {
		this.contagemComercial = contagemComercial;
	}
	/**
	 * @return the contagemTrabalhista
	 */
	public int getContagemTrabalhista() {
		return contagemTrabalhista;
	}
	/**
	 * @param contagemTrabalhista the contagemTrabalhista to set
	 */
	public void setContagemTrabalhista(int contagemTrabalhista) {
		this.contagemTrabalhista = contagemTrabalhista;
	}

	/**
	 * @return the contagemPorProcessoStatus
	 */
	public Map<String, Integer> getContagemPorProcessoStatus() {
		return contagemPorProcessoStatus;
	}

	/**
	 * @param contagemPorProcessoStatus the contagemPorProcessoStatus to set
	 */
	public void setContagemPorProcessoStatus(
			Map<String, Integer> contagemPorProcessoStatus) {
		this.contagemPorProcessoStatus = contagemPorProcessoStatus;
	}

	/**
	 * @return the contagemProcessoAndamento
	 */
	public int getContagemProcessoAndamento() {
		return contagemProcessoAndamento;
	}

	/**
	 * @param contagemProcessoAndamento the contagemProcessoAndamento to set
	 */
	public void setContagemProcessoAndamento(int contagemProcessoAndamento) {
		this.contagemProcessoAndamento = contagemProcessoAndamento;
	}

	/**
	 * @return the contagemProcessoPerdido
	 */
	public int getContagemProcessoPerdido() {
		return contagemProcessoPerdido;
	}

	/**
	 * @param contagemProcessoPerdido the contagemProcessoPerdido to set
	 */
	public void setContagemProcessoPerdido(int contagemProcessoPerdido) {
		this.contagemProcessoPerdido = contagemProcessoPerdido;
	}

	/**
	 * @return the contagemProcessoGanho
	 */
	public int getContagemProcessoGanho() {
		return contagemProcessoGanho;
	}

	/**
	 * @param contagemProcessoGanho the contagemProcessoGanho to set
	 */
	public void setContagemProcessoGanho(int contagemProcessoGanho) {
		this.contagemProcessoGanho = contagemProcessoGanho;
	}
	
}