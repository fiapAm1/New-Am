package br.com.am.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.apache.cxf.binding.corba.wsdl.Array;
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
	 * Action que direciona para as páginas da funcionalidade de cadastro de processo.
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
		carregarListas();
		processos = carregarProcessos();
		return String.valueOf(PaginaEnum.LISTAR_PROCESSO.getDescricao());
	}
	
	/**
	 * Action para adicionar advogados ao processo
	 * @author Ricardo
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="adicionarAdvogado")
	public String adicionarAdvogados(){
		//TODO implementar
		System.out.println("Advogado Adicionado!");
		return null;
	}
	
	/**
	 * Método para guardar valores na session
	 * @author Ricardo
	 * @since 23/09/2012
	 */
	private void guardarValoresSession(){
		//TODO guarda objetos na sessão.
	}
	
	/**
	 * Método para carregar listas
	 * @author Ricardo
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
	 * Método para carregar adovogados
	 * @author Ricardo
	 * @return List<Advogado>
	 * @since 18/09/2012
	 */
	private List<Advogado> carregarAdvogados(){
		return new ArrayList<Advogado>();//ProcessoBO.consultarAdvogados();
	}
	
	/**
	 * Método para carregar adovogados vinculados ao processo
	 * @author Ricardo
	 * @return List<Advogado>
	 * @since 18/09/2012
	 */
	private List<AdvogadoProcesso> carregarAdvogadosVinculados(){
		//TODO implementar
		AdvogadoProcesso a = null;
		List<AdvogadoProcesso> listA = new ArrayList<AdvogadoProcesso>();
		for(int i=1; i<=10; i++){
			a = new AdvogadoProcesso();
			a.getAdvogado().setCodigoPessoa(i);
			a.getAdvogado().setNomePessoa("Teste " + i);
			a.setDataInicio(new Date(System.currentTimeMillis()));
			listA.add(a);
		}
		return new ArrayList<AdvogadoProcesso>();//listA;
	}
	
	/**
	 * Método para carregar clientes
	 * @author Ricardo
	 * @return List<Cliente>
	 * @since 18/09/2012
	 */
	private List<Cliente> carregarClientes(){
		return new ArrayList<Cliente>(); //ProcessoBO.consultarClientes();
	}
	
	/**
	 * Método para carregar foruns
	 * @author Ricardo
	 * @return List<Forum>
	 * @since 18/09/2012
	 */
	private List<Forum> carregarForuns(){
		return new ArrayList<Forum>(); //ProcessoBO.consultarForuns();
	}
	
	/**
	 * Método para carregar tipos de causas
	 * @author Ricardo
	 * @return List<TipoCausa>
	 * @since 18/09/2012
	 */
	private List<TipoCausa> carregarTiposCausas(){
		return new ArrayList<TipoCausa>();//ProcessoBO.consultarTiposCausas();
	}
	
	/**
	 * Método para carregar tipos de cobranças
	 * @author Ricardo
	 * @return List<TipoCobranca>
	 * @since 18/09/2012
	 */
	private List<TipoCobranca> carregarTiposCobrancas(){
		return new ArrayList<TipoCobranca>();//ProcessoBO.consultarTiposCobrancas();
	}
	
	/**
	 * Método para carregar processo selecionado
	 * @author Ricardo
	 * @return Processo
	 * @since 18/09/2012
	 */
	private Processo carregarProcesso(){
		return new Processo();//ProcessoBO.consultarProcesso(processo.getNumeroProcesso());
	}
	
	/**
	 * Método para carregar processos
	 * @author Ricardo
	 * @return List<Forum>
	 * @since 18/09/2012
	 */
	private List<Processo> carregarProcessos(){
//		Processo p = new Processo();
//		List<Processo> ps = new ArrayList<Processo>();
//		for(int i=1;i<=10;i++){
//			p = new Processo();
//			p.setNumeroProcesso(1000+i);
//			p.setProcesso("Processo " + (1000+i));
//			Cliente c = new Cliente();
//			c.setCodigoPessoa(i);
//			c.setNomePessoa("Pessoa " + i);
//			p.setCliente(c);
//			TipoCausa tc = new TipoCausa();
//			tc.setCodigoCausa(i);
//			tc.setCausa("Causa " + i);
//			p.setCausa(tc);
//			p.setDataAbertura(new Date(System.currentTimeMillis()));
//			p.setDataFechamento(new Date(System.currentTimeMillis()));
//			p.setResultado((int)(2*Math.random()));
//			ps.add(p);
//		}
//		return ps;
		return new ArrayList<Processo>();//ProcessoBO.consultarProcessosEmAndamento();
	}
	
	/**
	 * Método para carregar dias de pagamento
	 * @author Ricardo
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