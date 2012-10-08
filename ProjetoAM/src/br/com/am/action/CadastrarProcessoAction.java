package br.com.am.action;

import java.util.ArrayList;
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
import br.com.am.util.UtilDate;

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
	
	private String jSonMensagem;
	private String jSonResultado;
	
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
		} else {
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
			@Result(location="/pages/processo/cadastroProcesso.jsp", name="cadastrar"),
			@Result(location="/pages/processo/listarProcessos.jsp", name="listar")
	})
	public String cadastrarProcesso(){
		try {
			advogadosVinculados = (List<AdvogadoProcesso>)session.get("advogadosVinculados"); 
			if(validarProcesso()){
				Integer codigoProcesso = ProcessoBO.cadastrarProcesso(processo);
				
				for(AdvogadoProcesso ap : advogadosVinculados){
					ProcessoBO.cadastrarAdvogadosVinculados(ap, codigoProcesso);
				}
				
				setMensagem("Processo cadastrado com sucesso!");
				setResultado("sucesso");
			} else {
				carregarListas();
				return PaginaEnum.CADASTRAR_PROCESSO.getDescricao();
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
			e.printStackTrace();
		}
		processos = carregarProcessos();
		session.put("advogadosVinculados", new ArrayList<AdvogadoProcesso>());
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
	 * Action para remover advogados do processo
	 * @author JDGR²
	 * @return String
	 * @since 07/09/2012
	 */
	@Action(value="removerAdvogado", results={
			@Result(name="cadastrar", type="json", params={
					"response", "advogados, clientes,"+ 
					"foruns, dias, processos, tiposCausas, "+ 
					"tiposCobrancas, advogadoProcesso, processo"
			})
	})
	public String removerAdvogados(){
		try {
			advogadosVinculados = (List<AdvogadoProcesso>)session.get("advogadosVinculados");
			boolean resultado = false;
			for(AdvogadoProcesso ap : advogadosVinculados){
				if(ap.getAdvogado().getCodigoPessoa() == advogadoProcesso.getAdvogado().getCodigoPessoa()){
					advogadosVinculados.remove(ap);
					resultado = true;
					break;
				}
			}
			if(resultado){
				setMensagem("Advogado removido com sucesso!");
				setResultado("sucesso");
			} else {
				setMensagem("Ocorreu um erro!");
				setResultado("erro");
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
			e.printStackTrace();
		}
		jSonMensagem = getMensagem();
		jSonResultado = getResultado();
		session.put("advogadosVinculados", advogadosVinculados);
		return PaginaEnum.CADASTRAR_PROCESSO.getDescricao();
	}	
	
	/**
	 * Action para adicionar advogados ao processo
	 * @author JDGR²
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="adicionarAdvogado", results={
			@Result(name="cadastrar", type="json", params={
					"response", "advogados, clientes,"+ 
					"foruns, dias, processos, tiposCausas, "+ 
					"tiposCobrancas, advogadoProcesso, processo"
			})
	})
	public String adicionarAdvogados(){
		try {
			advogadosVinculados = new ArrayList<AdvogadoProcesso>();
			if(session.get("advogadosVinculados") != null){
				advogadosVinculados = (List<AdvogadoProcesso>)session.get("advogadosVinculados");
			}
			if(validarAdvogado()){
				advogadoProcesso.setAdvogado(ProcessoBO.consultarAdvogado(advogadoProcesso.getAdvogado().getCodigoPessoa()));
				advogadosVinculados.add(advogadoProcesso);
				advogadoProcesso = new AdvogadoProcesso();
				setMensagem("Advogado vinculado com sucesso!");
				setResultado("sucesso");
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
			e.printStackTrace();
		}
		jSonMensagem = getMensagem();
		jSonResultado = getResultado();
		session.put("advogadosVinculados", advogadosVinculados);
		return PaginaEnum.CADASTRAR_PROCESSO.getDescricao();
	}
	
	/**
	 * Método para validar advogado que será vincualdo.
	 * @author JDGR²
	 * @since 07/10/2012
	 */
	private boolean validarAdvogado(){
		if(advogadoProcesso.getAdvogado().getCodigoPessoa()<=0){
			setMensagem("Selecione um advogado!");
			setResultado("erro");
			return false;
		} else if(advogadosVinculados != null && advogadosVinculados.size()>0){
			for(AdvogadoProcesso ap : advogadosVinculados){
				if(advogadoProcesso.getAdvogado().getCodigoPessoa() == ap.getAdvogado().getCodigoPessoa()){
					setMensagem("Advogado já está vinculado!");
					setResultado("erro");
					return false;
				}
			}
		} else if(advogadoProcesso.getDataInicio() == null){
			setMensagem("Informe a data de início!");
			setResultado("erro");
			return false;
		}
		return true;
	}
	
	/**
	 * Método para validar processo que será cadastrado.
	 * @author JDGR²
	 * @since 07/10/2012
	 */
	private boolean validarProcesso(){
		if(processo.getCliente() == null || processo.getCliente().getCodigoPessoa() <= 0){
			setMensagem("Selecione um cliente!");
			setResultado("erro");
			return false;
		} else if(processo.getCausa() == null || processo.getCausa().getCodigoCausa() <= 0){
			setMensagem("Selecione uma causa!");
			setResultado("erro");
			return false;
		} else if(processo.getForum() == null || processo.getForum().getCodigoPessoa() <= 0){
			setMensagem("Selecione um forum!");
			setResultado("erro");
			return false;
		} else if(processo.getDataAberturaStr() == null || "".equals(processo.getDataAberturaStr())){
			setMensagem("Informe a data de abertura do processo!");
			setResultado("erro");
			return false;
		} else if(processo.getDataFechamentoStr() != null && !"".equals(processo.getDataFechamentoStr())){
			if(UtilDate.convertStringToDate(
				processo.getDataFechamentoStr()).before(
						UtilDate.convertStringToDate(processo.getDataAberturaStr()))){
				setMensagem("Data de fechamento não pode ser menor que a data de abertura!");
				setResultado("erro");
				return false;
			}
		} else if(processo.getCobranca() == null || processo.getCobranca().getCodigoCobranca() <= 0){
			setMensagem("Selecione o tipo de cobrança!");
			setResultado("erro");
			return false;
		} else if(advogadosVinculados == null || advogadosVinculados.size() <= 0){
			setMensagem("Vincule no minímo um advogado ao processo!");
			setResultado("erro");
			return false;
		} else if(processo.getProcesso() == null || "".equals(processo.getProcesso())){
			setMensagem("Preencha a descrição do processo!");
			setResultado("erro");
			return false;
		}
		return true;
	}
	
	/**
	 * Método para carregar listas
	 * @author JDGR²
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
	 * @author JDGR²
	 * @return List<Advogado>
	 * @since 18/09/2012
	 */
	private List<Advogado> carregarAdvogados(){
		return ProcessoBO.consultarAdvogados();
	}
	
	/**
	 * Método para carregar adovogados vinculados ao processo
	 * @author JDGR²
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
	 * Método para carregar clientes
	 * @author JDGR²
	 * @return List<Cliente>
	 * @since 18/09/2012
	 */
	private List<Cliente> carregarClientes(){
		return ProcessoBO.consultarClientes();
	}
	
	/**
	 * Método para carregar foruns
	 * @author JDGR²
	 * @return List<Forum>
	 * @since 18/09/2012
	 */
	private List<Forum> carregarForuns(){
		return ProcessoBO.consultarForuns();
	}
	
	/**
	 * Método para carregar tipos de causas
	 * @author JDGR²
	 * @return List<TipoCausa>
	 * @since 18/09/2012
	 */
	private List<TipoCausa> carregarTiposCausas(){
		return ProcessoBO.consultarTiposCausas();
	}
	
	/**
	 * Método para carregar tipos de cobranças
	 * @author JDGR²
	 * @return List<TipoCobranca>
	 * @since 18/09/2012
	 */
	private List<TipoCobranca> carregarTiposCobrancas(){
		return ProcessoBO.consultarTiposCobrancas();
	}
	
	/**
	 * Método para carregar processo selecionado
	 * @author JDGR²
	 * @return Processo
	 * @since 18/09/2012
	 */
	private Processo carregarProcesso(){
		return ProcessoBO.consultarProcesso(processo.getNumeroProcesso());
	}
	
	/**
	 * Método para carregar processos
	 * @author JDGR²
	 * @return List<Processo>
	 * @since 18/09/2012
	 */
	private List<Processo> carregarProcessos(){
		return ProcessoBO.consultarProcessosEmAndamento();
	}
	
	/**
	 * Método para carregar dias de pagamento
	 * @author JDGR²
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

	public String getjSonMensagem() {
		return jSonMensagem;
	}

	public void setjSonMensagem(String jSonMensagem) {
		this.jSonMensagem = jSonMensagem;
	}

	public String getjSonResultado() {
		return jSonResultado;
	}

	public void setjSonResultado(String jSonResultado) {
		this.jSonResultado = jSonResultado;
	}
}