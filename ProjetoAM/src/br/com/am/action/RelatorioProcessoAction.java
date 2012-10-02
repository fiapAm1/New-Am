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
 * @author Ricardo
 * @since 23/09/2012
 */
public class RelatorioProcessoAction extends GenericAction{

	private static final long serialVersionUID = -1540815303890056728L;
	
	private List<RelatorioHonorario> honorarios = new ArrayList<RelatorioHonorario>();
	private List<RelatorioAudiencia> audiencias = new ArrayList<RelatorioAudiencia>();
	private List<Tarefa> tarefas = new ArrayList<Tarefa>();
	private Integer codigoProcesso;
	private Integer codigoTarefa;
	
	/**
	 * Action que direcina para as páginas das funcionlidades de emissão de relátorios.
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
			tarefas = carregarTarefas();
			return PaginaEnum.EMITIR_RELATORIO_HONORARIO.getDescricao();
		}else {
			return String.valueOf(PaginaEnum.ERRO.getDescricao());
		}
	}
	
	
	/**
	 * Método para realizar pesquisa de honorários
	 * @author Ricardo
	 * @since 23/02/2012
	 * @return String
	 */
	@Action(value="pesquisarHonorario", results={
			@Result(location="/pages/relatorio/emitirRelatorioHonorario.jsp", name="emitirHonorario"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String pesquisarHonorarios(){
		honorarios = carregarHonorarios();
		return PaginaEnum.EMITIR_RELATORIO_HONORARIO.getDescricao();
	}
	
	/**
	 * Método para realizar pesquisa de audiências
	 * @author Ricardo
	 * @since 23/02/2012
	 * @return String
	 */
	@Action(value="pesquisarAudiencia", results={
			@Result(location="/pages/relatorio/emitirRelatorioAudiencia.jsp", name="emitirAudiencia"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String pesquisarAudiencias(){
		audiencias = carregarAudicencias();
		return PaginaEnum.EMITIR_RELATORIO_AUDIENCIA.getDescricao();
	}
	
	/**
	 * Método para emissão de relátorio de honorários por processo.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="emitirHonorario", results={
			@Result(location="/pages/home.jsp", name="home"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String emitirHonorario(){
		//TODO implementar
		return PaginaEnum.HOME.getDescricao();
	}
	
	/**
	 * Método para emissão de relátorio de audiências por processo.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="emitirAudiencia", results={
			@Result(location="/pages/home.jsp", name="home"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String emitirAudiencia(){
		//TODO implementar
		return PaginaEnum.HOME.getDescricao();
	}
	
	/**
	 * Método para carregar honárarios
	 * @author Ricardo
	 * @since 26/09/2012
	 * @return List<RelatorioHonorario>
	 */
	private List<RelatorioHonorario> carregarHonorarios(){
//		RelatorioHonorario relatorioHonorario = null;
//		List<RelatorioHonorario> list = new ArrayList<RelatorioHonorario>();
//		for(int i=1;i<=10;i++){
//			relatorioHonorario = new RelatorioHonorario();
//			relatorioHonorario.setDataHonorario(new Date(System.currentTimeMillis()));
//			relatorioHonorario.setNomeAdvogado("Advogado " + i);
//			relatorioHonorario.setValorTarefa(100.00);
//			list.add(relatorioHonorario);
//		}
//		return list;
		return HonorarioBO.consultarRelatorioHonorario(codigoProcesso, codigoTarefa);
	}
	
	/**
	 * Método para carregar audiencias
	 * @author Ricardo
	 * @since 26/09/2012
	 * @return List<RelatorioAudiencia>
	 */
	private List<RelatorioAudiencia> carregarAudicencias(){
		return AudienciaBO.consultarRelatorioAudiencia(codigoProcesso);
	}
	
	/**
	 * Método para carregar tarefas
	 * @author Ricardo
	 * @since 26/09/2012
	 * @return List<Tarefa>
	 */
	private List<Tarefa> carregarTarefas(){
		return HonorarioBO.consultarTarefas();
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

	public List<RelatorioAudiencia> getAudiencias() {
		return audiencias;
	}

	public void setAudiencias(List<RelatorioAudiencia> audiencias) {
		this.audiencias = audiencias;
	}
}