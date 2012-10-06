package br.com.am.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.ProcessoBO;
import br.com.am.model.Processo;

public class ListarProcessoAction extends GenericAction{

	private static final long serialVersionUID = -8032621170923607709L;
	
	private int numeroProcesso;
	private String nomeCliente;
	private int numeroCausa;
	
	private List<Processo> processos;
	
	
	/**
	 * Action para listar processo
	 * @author Ricardo
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="listarProcesso", results={
			@Result(location="/pages/processo/listarProcessos.jsp", name="listar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String listarProcesso(){
		carregarProcessos();
		return String.valueOf(PaginaEnum.LISTAR_PROCESSO.getDescricao());
	}
	
	/**
	 * Método para carregar processo selecionado
	 * @author Rodrigo Joubert
	 * @since 18/09/2012
	 */
	private void carregarProcessos(){
		Processo processo = ProcessoBO.consultarProcesso(numeroProcesso);
		
		processos.add(processo);
	}
	
	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getNumeroCausa() {
		return numeroCausa;
	}
	public void setNumeroCausa(int numeroCausa) {
		this.numeroCausa = numeroCausa;
	}

}
