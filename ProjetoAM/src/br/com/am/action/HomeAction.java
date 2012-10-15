package br.com.am.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.action.enuns.TipoCausaEnum;
import br.com.am.bo.ProcessoBO;

public class HomeAction extends GenericAction{

	private static final long serialVersionUID = 3392559602784798553L;
	
	private Map<String, Integer> contagemPorCausa = new HashMap<String, Integer>();
	private int contagemTributaria;
	private int contagemComercial;
	private int contagemTrabalhista;
	
	
	/**
	 * Action para listar processo
	 * @author JDGR²
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="carregarHome", results={
			@Result(location="/pages/home.jsp", name="home"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String carregarHome(){
		
		contagemPorCausa = ProcessoBO.contagemProcessosPorCausa();	
		
		contagemTributaria = contagemPorCausa.get(TipoCausaEnum.TRIBUTARIA);
		contagemTrabalhista = contagemPorCausa.get(TipoCausaEnum.TRIBUTARIA);
		contagemComercial = contagemPorCausa.get(TipoCausaEnum.COMERCIAL);
		
		return String.valueOf(PaginaEnum.HOME.getDescricao());
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
	
	

}
