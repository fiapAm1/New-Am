package br.com.am.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.AudienciaBO;
import br.com.am.bo.HonorarioBO;
import br.com.am.model.RelatorioAudiencia;
import br.com.am.model.RelatorioHonorario;
import br.com.am.model.Tarefa;


/**
 * Class Action RelatorioProcesso
 * @author Ricardo e Rodrigo Joubert
 * @since 23/09/2012
 */
public class RelatorioProcessoAction extends GenericAction{

	private static final long serialVersionUID = -1540815303890056728L;
	
	private List<RelatorioHonorario> honorarios = new ArrayList<RelatorioHonorario>();
	private List<RelatorioAudiencia> audiencias = new ArrayList<RelatorioAudiencia>();
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	private Integer codigoProcesso;
	private Integer codigoTarefa;
	private Double somaHonorario;
	
	/**
	 * Action que direcina para as p�ginas das funcionlidades de emiss�o de rel�torios.
	 * @author Ricardo
	 * @return String
	 * @since 26/09/2012
	 */
	@Action(value="forwardRelatorio", results={
			@Result(location="/pages/relatorio/emitirRelatorioAudiencia.jsp", name="emitirAudiencia"),
			@Result(location="/pages/relatorio/emitirRelatorioHonorario.jsp", name="emitirHonorario"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardRelatorio(){
		if(PaginaEnum.EMITIR_RELATORIO_AUDIENCIA.getDescricao().equals(getPaginaDirecionar())){
			return PaginaEnum.EMITIR_RELATORIO_AUDIENCIA.getDescricao();
		} else if(PaginaEnum.EMITIR_RELATORIO_HONORARIO.getDescricao().equals(getPaginaDirecionar())){
			carregarTarefas();
			return PaginaEnum.EMITIR_RELATORIO_HONORARIO.getDescricao();
		}else {
			return String.valueOf(PaginaEnum.ERRO.getDescricao());
		}
	}
	
	
	/**
	 * M�todo para realizar pesquisa de honor�rios
	 * @author Ricardo e Rodrigo Joubert
	 * @since 23/02/2012
	 * @return String
	 */
	@Action(value="pesquisarHonorario", results={
			@Result(location="/pages/relatorio/emitirRelatorioHonorario.jsp", name="emitirHonorario"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String pesquisarHonorarios(){
		carregarTarefas();
		carregarHonorarios();
		somarHonorarios();
		return PaginaEnum.EMITIR_RELATORIO_HONORARIO.getDescricao();
	}
	
	/**
	 * M�todo para realizar pesquisa de audi�ncias
	 * @author Ricardo e Rodrigo Joubert
	 * @since 23/02/2012
	 * @return String
	 */
	@Action(value="pesquisarAudiencia", results={
			@Result(location="/pages/relatorio/emitirRelatorioAudiencia.jsp", name="emitirAudiencia"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String pesquisarAudiencias(){
		carregarAudicencias();
		return PaginaEnum.EMITIR_RELATORIO_AUDIENCIA.getDescricao();
	}
	
	/**
	 * M�todo para emiss�o de rel�torio de honor�rios por processo.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="emitirHonorario", results={
			@Result(location="/pages/home.jsp", name="home"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String emitirHonorario(){
		return PaginaEnum.HOME.getDescricao();
	}
	
	/**
	 * M�todo para emiss�o de rel�torio de audi�ncias por processo.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="emitirAudiencia", results={
			@Result(location="/pages/home.jsp", name="home"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String emitirAudiencia(){
		return PaginaEnum.HOME.getDescricao();
	}
	
	/**
	 * M�todo para carregar hon�rarios
	 * @author Ricardo e Rodrigo Joubert
	 * @since 26/09/2012
	 * @return List<RelatorioHonorario>
	 */
	private void carregarHonorarios(){
		honorarios = HonorarioBO.consultarRelatorioHonorario(codigoProcesso, codigoTarefa);
	}
	
	/**
	 * M�todo para carregar audiencias
	 * @author Ricardo e Rodrigo Joubert
	 * @since 26/09/2012
	 */
	private void carregarAudicencias(){
		audiencias = AudienciaBO.consultarRelatorioAudiencia(codigoProcesso);
	}
	
	/**
	 * M�todo para carregar tarefas
	 * @author Ricardo e Rodrigo Joubert
	 * @since 26/09/2012
	 */
	private void carregarTarefas(){
		tarefas =  HonorarioBO.consultarTarefas();
	}
	
	/**
	 * M�todo para somar o tipo de honorario selecionado
	 * @author Ricardo e Rodrigo Joubert
	 * @since 26/09/2012
	 */
	private void somarHonorarios(){
		
		somaHonorario = 0d;
		
		if(honorarios != null && !honorarios.isEmpty()) {
			
			for (RelatorioHonorario honorario : honorarios) {
				somaHonorario = somaHonorario + honorario.getValorTarefa();
			}
		}
		
	}

	public List<RelatorioHonorario> getHonorarios() {
		return honorarios;
	}

	public void setHonorarios(List<RelatorioHonorario> honorarios) {
		this.honorarios = honorarios;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public Integer getCodigoProcesso() {
		return codigoProcesso;
	}

	public void setCodigoProcesso(Integer codigoProcesso) {
		this.codigoProcesso = codigoProcesso;
	}

	public Integer getCodigoTarefa() {
		return codigoTarefa;
	}

	public void setCodigoTarefa(Integer codigoTarefa) {
		this.codigoTarefa = codigoTarefa;
	}
	
	public Double getSomaHonorario() {
		return somaHonorario;
	}


	public void setSomaHonorario(Double somaHonorario) {
		this.somaHonorario = somaHonorario;
	}


	public List<RelatorioAudiencia> getAudiencias() {
		return audiencias;
	}

	public void setAudiencias(List<RelatorioAudiencia> audiencias) {
		this.audiencias = audiencias;
	}
}