package br.com.am.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.ProcessoBO;
import br.com.am.model.Advogado;
import br.com.am.model.AdvogadoProcesso;
import br.com.am.model.Cliente;
import br.com.am.model.Forum;
import br.com.am.model.Processo;
import br.com.am.model.TipoCausa;
import br.com.am.model.TipoCobranca;


/**
 * Class Action CadastrarProcesso
 * @author Ricardo
 * @since 18/09/2012
 */
public class CadastrarProcessoAction extends GenericAction{
	
	private static final long serialVersionUID = 7470359708896232812L;
	
	private List<Advogado> advogados = new ArrayList<Advogado>();
	private List<AdvogadoProcesso> advogadosVinculados = new ArrayList<AdvogadoProcesso>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Forum> foruns = new ArrayList<Forum>();
	private List<Integer> dias = new ArrayList<Integer>();
	private List<Processo> processos = new ArrayList<Processo>();
	private List<TipoCausa> tiposCausas  = new ArrayList<TipoCausa>();
	private List<TipoCobranca> tiposCobrancas = new ArrayList<TipoCobranca>();
	
	private AdvogadoProcesso advogadoProcesso = new AdvogadoProcesso();
	private Processo processo = new Processo();
	
	/**
	 * Action que direciona para as p�ginas da funcionalidade de cadastro de processo.
	 * @author Ricardo
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="forwardCadastrarProcesso", results={
			@Result(location="/pages/processo/alterarProcesso.jsp", name="alterar"),
			@Result(location="/pages/processo/cadastroProcesso.jsp", name="cadastrar"),
			@Result(location="/pages/processo/listarProcessos.jsp", name="listar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardCadastrarProcesso(){
		if(PaginaEnum.ALTERAR_PROCESSO.getDescricao().equals(getPaginaDirecionar())){
			carregarListas();
			processo = carregarProcesso();
			return PaginaEnum.ALTERAR_PROCESSO.getDescricao();
		} else if(PaginaEnum.CADASTRAR_PROCESSO.getDescricao().equals(getPaginaDirecionar())){
			carregarListas();
			return PaginaEnum.CADASTRAR_PROCESSO.getDescricao();
		} else if(PaginaEnum.LISTAR_PROCESSO.getDescricao().equals(getPaginaDirecionar())){
			//carregarListas();
			//processos = carregarProcessos();
			return PaginaEnum.LISTAR_PROCESSO.getDescricao();
		}else {
			return String.valueOf(PaginaEnum.ERRO.getDescricao());
		}
	}
	
	/**
	 * Action para cadastrar processo
	 * @author Ricardo
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="cadastrarProcesso", results={
			@Result(location="/pages/processo/listarProcessos.jsp", name="listar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String cadastrarProcesso(){
		//TODO implementar
		System.out.println("Cadastrar");
		carregarListas();
		processos = carregarProcessos();
		return PaginaEnum.LISTAR_PROCESSO.getDescricao();
	}
	
	/**
	 * Action para alterar processo
	 * @author Ricardo
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="alterarProcesso", results={
			@Result(location="/pages/processo/listarProcessos.jsp", name="listar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String alterarProcesso(){
		//TODO implementar
		System.out.println("Alterar");
		carregarListas();
		processos = carregarProcessos();
		return PaginaEnum.LISTAR_PROCESSO.getDescricao();
	}
	
	/**
	 * Action para exibir processo
	 * @author Ricardo
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="exibirProcesso", results={
			@Result(location="/pages/processo/exibirProcesso.jsp", name="exibir"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String exibirProcesso(){
		carregarListas();
		processo = carregarProcesso();
		return String.valueOf(PaginaEnum.EXIBIR_PROCESSO.getDescricao());
	}
	
	/**
	 * Action para adicionar advogados ao processo
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="adicionarAdvogado", results={
			@Result(name="cadastrar", type="json", params={
					"advogadosVinculados", "advogados, clientes,"+ 
					"foruns, dias, processos, tiposCausas, "+ 
					"tiposCobrancas, advogadoProcesso, processo"
			})
	})
	public String adicionarAdvogados(){
		try {
			advogadoProcesso.setAdvogado(ProcessoBO.consultarAdvogado(advogadoProcesso.getAdvogado().getCodigoPessoa()));
			advogadosVinculados.add(advogadoProcesso);
			advogadoProcesso = new AdvogadoProcesso();
			setMensagem("Advogado vinculado com sucesso!");
			setResultado("sucesso");
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
		}
		session.put("mensagem", getMensagem());
		session.put("resultado", getResultado());
		return PaginaEnum.CADASTRAR_PROCESSO.getDescricao();
	}
	
	/**
	 * M�todo para guardar valores na session
	 * @author Ricardo
	 * @since 23/09/2012
	 */
	private void guardarValoresSession(){
		//TODO guarda objetos na sess�o.
	}
	
	/**
	 * M�todo para carregar listas
	 * @author JDGR�
	 * @since 26/09/2012
	 */
	private void carregarListas(){
		advogados = carregarAdvogados();
		advogadosVinculados = carregarAdvogadosVinculados();
		clientes = carregarClientes();
		dias = carregarDias();
		foruns = carregarForuns();
		tiposCausas = carregarTiposCausas();
		tiposCobrancas = carregarTiposCobrancas();
	}
	
	/**
	 * M�todo para carregar adovogados
	 * @author JDGR�
	 * @return List<Advogado>
	 * @since 18/09/2012
	 */
	private List<Advogado> carregarAdvogados(){
		return ProcessoBO.consultarAdvogados();
	}
	
	/**
	 * M�todo para carregar adovogados vinculados ao processo
	 * @author JDGR�
	 * @return List<AdvogadoProcesso>
	 * @since 18/09/2012
	 */
	private List<AdvogadoProcesso> carregarAdvogadosVinculados(){
		List<AdvogadoProcesso> list = new ArrayList<AdvogadoProcesso>();
		if(processo.getNumeroProcesso() != null && processo.getNumeroProcesso().intValue() >0){
			 list = ProcessoBO.carregarAdvogadosVinculados(processo.getNumeroProcesso().intValue());
		}
		return list;
	}
	
	/**
	 * M�todo para carregar clientes
	 * @author JDGR�
	 * @return List<Cliente>
	 * @since 18/09/2012
	 */
	private List<Cliente> carregarClientes(){
		return ProcessoBO.consultarClientes();
	}
	
	/**
	 * M�todo para carregar foruns
	 * @author JDGR�
	 * @return List<Forum>
	 * @since 18/09/2012
	 */
	private List<Forum> carregarForuns(){
		return ProcessoBO.consultarForuns();
	}
	
	/**
	 * M�todo para carregar tipos de causas
	 * @author JDGR�
	 * @return List<TipoCausa>
	 * @since 18/09/2012
	 */
	private List<TipoCausa> carregarTiposCausas(){
		return ProcessoBO.consultarTiposCausas();
	}
	
	/**
	 * M�todo para carregar tipos de cobran�as
	 * @author JDGR�
	 * @return List<TipoCobranca>
	 * @since 18/09/2012
	 */
	private List<TipoCobranca> carregarTiposCobrancas(){
		return ProcessoBO.consultarTiposCobrancas();
	}
	
	/**
	 * M�todo para carregar processo selecionado
	 * @author JDGR�
	 * @return Processo
	 * @since 18/09/2012
	 */
	private Processo carregarProcesso(){
		return ProcessoBO.consultarProcesso(processo.getNumeroProcesso());
	}
	
	/**
	 * M�todo para carregar processos
	 * @author JDGR�
	 * @return List<Processo>
	 * @since 18/09/2012
	 */
	private List<Processo> carregarProcessos(){
		return ProcessoBO.consultarProcessosEmAndamento();
	}
	
	/**
	 * M�todo para carregar dias de pagamento
	 * @author JDGR�
	 * @return List<Integer>
	 * @since 18/09/2012
	 */
	private List<Integer> carregarDias(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=31;i++){
			list.add(i);
		}
		return list;
	}

	public List<Advogado> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(List<Advogado> advogados) {
		this.advogados = advogados;
	}

	public List<AdvogadoProcesso> getAdvogadosVinculados() {
		return advogadosVinculados;
	}

	public void setAdvogadosVinculados(List<AdvogadoProcesso> advogadosVinculados) {
		this.advogadosVinculados = advogadosVinculados;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Forum> getForuns() {
		return foruns;
	}

	public void setForuns(List<Forum> foruns) {
		this.foruns = foruns;
	}

	public List<Integer> getDias() {
		return dias;
	}

	public void setDias(List<Integer> dias) {
		this.dias = dias;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public List<TipoCausa> getTiposCausas() {
		return tiposCausas;
	}

	public void setTiposCausas(List<TipoCausa> tiposCausas) {
		this.tiposCausas = tiposCausas;
	}

	public List<TipoCobranca> getTiposCobrancas() {
		return tiposCobrancas;
	}

	public void setTiposCobrancas(List<TipoCobranca> tiposCobrancas) {
		this.tiposCobrancas = tiposCobrancas;
	}

	public AdvogadoProcesso getAdvogadoProcesso() {
		return advogadoProcesso;
	}

	public void setAdvogadoProcesso(AdvogadoProcesso advogadoProcesso) {
		this.advogadoProcesso = advogadoProcesso;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
}