package br.com.am.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.GenericBO;
import br.com.am.bo.ProcessoBO;
import br.com.am.model.Processo;
import br.com.am.model.TipoCausa;

public class ListarProcessoAction extends GenericAction{

	private static final long serialVersionUID = -8032621170923607709L;
	
	private int numeroProcesso;
	private String nomeCliente;
	private Integer codigoCausa;
	
	private List<Processo> processos = new ArrayList<Processo>();
	
	private List<TipoCausa> tiposCausas = new ArrayList<TipoCausa>();
	
	
	/**
	 * Action que direciona para as páginas da funcionalidade de cadastro de processo.
	 * @author Rodrigo Joubert
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="forwardListarProcesso", results={
			@Result(location="/pages/processo/listarProcessos.jsp", name="listar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardCadastrarProcesso(){
		if(PaginaEnum.LISTAR_PROCESSO.getDescricao().equals(getPaginaDirecionar())){
			carregarCausas();
			return PaginaEnum.LISTAR_PROCESSO.getDescricao();
		}else {
			return String.valueOf(PaginaEnum.ERRO.getDescricao());
		}
	}
	
	
	/**
	 * Action para listar processo
	 * @author JDGR²
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="listarProcesso", results={
			@Result(location="/pages/processo/listarProcessos.jsp", name="listar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String listarProcesso(){
		carregarProcessos();
		carregarCausas();
		return String.valueOf(PaginaEnum.LISTAR_PROCESSO.getDescricao());
	}
	
	/**
	 * Método para carregar processos de acordo com o filtro solicitado pelo usuário
	 * @author Rodrigo Joubert
	 * @since 18/09/2012
	 */
	private void carregarProcessos(){
		
		if(numeroProcesso > 0) {
			Processo processo = ProcessoBO.consultarProcesso(numeroProcesso);
			processos.add(processo);
		} else if (nomeCliente != null && codigoCausa > 0) {
			processos = ProcessoBO.consultarProcessos(nomeCliente, codigoCausa);
			
		} else if (nomeCliente != null && codigoCausa == 0) {
			processos = ProcessoBO.consultarProcessos(nomeCliente);
			
		} else if(codigoCausa > 0 && nomeCliente == null) {
			processos = ProcessoBO.consultarProcessos(codigoCausa);
		}
	}
	
	/**
	 * Método para carregar possíveis causas para um processo
	 * @author Rodrigo Joubert
	 * @since 18/09/2012
	 */
	private void carregarCausas(){
			tiposCausas = GenericBO.consultarTiposCausas();
	}	
	
	/**
	 * @return the processos
	 */
	public List<Processo> getProcessos() {
		return processos;
	}

	/**
	 * @param processos the processos to set
	 */
	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	/**
	 * @return the tiposCausas
	 */
	public List<TipoCausa> getTiposCausas() {
		return tiposCausas;
	}

	/**
	 * @param tiposCausas the tiposCausas to set
	 */
	public void setTiposCausas(List<TipoCausa> tiposCausas) {
		this.tiposCausas = tiposCausas;
	}

	/**
	 * @return the numeroProcesso
	 */
	public int getNumeroProcesso() {
		return numeroProcesso;
	}

	/**
	 * @param numeroProcesso the numeroProcesso to set
	 */
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the codigoCausa
	 */
	public Integer getCodigoCausa() {
		return codigoCausa;
	}

	/**
	 * @param codigoCausa the codigoCausa to set
	 */
	public void setCodigoCausa(Integer codigoCausa) {
		this.codigoCausa = codigoCausa;
	}


}
