package br.com.am.action;

import java.util.ArrayList;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.DespesaBO;
import br.com.am.model.Despesa;
import br.com.am.model.Processo;
import br.com.am.model.TipoDespesa;

/**
 * Class Action LancarDespesas
 * @author JDGR�
 * @since 18/09/2012
 */
public class LancarDespesasAction extends GenericAction{
	
	private static final long serialVersionUID = 6688816828187072391L;
	
	private List<Processo> processos = new ArrayList<Processo>();
	private Double valorTotalDespesas;
	private Integer numeroProcesso;
	private Integer codigoLancamento;
	
	private List<Despesa> despesas = new ArrayList<Despesa>();
	private List<TipoDespesa> tiposDespesas = new ArrayList<TipoDespesa>();
	private Despesa despesa = new Despesa();
	
	private String jSonTipoDespesa;
	private String jSonValorDespesa;
	private String jSonObservacaoDespesa;
	
	
	/**
	 * Action que direciona para as p�ginas da funcionalidade de lan�ar despesas.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="forwardLancarDespesa", results={
			@Result(location="/pages/despesa/lancarDespesa.jsp", name="lancar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardLancarDespesa(){
		if(PaginaEnum.LANCAR_DESPESA.getDescricao().equals(getPaginaDirecionar())){
			tiposDespesas = DespesaBO.consultarTiposDespesas();
			return PaginaEnum.LANCAR_DESPESA.getDescricao();
		} else {
			return String.valueOf(PaginaEnum.ERRO.getDescricao());
		}
	}
	
	/**
	 * Action que cadastra despesas.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="cadastrarDespesa", results={
			@Result(location="/pages/despesa/lancarDespesa.jsp", name="lancar")
	})
	public String cadastrarDespesa(){
		try {
			numeroProcesso = (Integer) session.get("numeroProcesso");
			if(validarCampos()){
				despesa.getProcesso().setNumeroProcesso(numeroProcesso);
				DespesaBO.lancarDespesa(despesa);
				
				limparCampos();
				setMensagem("Despesa lan�ada com sucesso!");
				setResultado("sucesso");
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
			e.printStackTrace();
		}
		session.put("mensagem", getMensagem());
		session.put("resultado", getResultado());
		pesquisarProcessosAux();
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	/**
	 * Action que altera despesa.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="alterarDespesa", results={
			@Result(location="/pages/despesa/lancarDespesa.jsp", name="lancar")
	})
	public String alterarDespesa(){
		try {
			despesa.getTipoDespesa().setCodigoDespesa((Integer)session.get("codigoTipoDespesa")); 
			despesa.setCodigoLancamento((Integer)session.get("codigoLancamento"));
			if(despesa.getCodigoLancamento() != null){
				if(validarCampos()){
					DespesaBO.atualizarDespesa(despesa);
					
					limparCampos();
					
					setMensagem("Despesa alterada com sucesso!");
					setResultado("sucesso");
				}
			} else {
				setMensagem("Selecione uma despesa!");
				setResultado("erro");
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
			e.printStackTrace();
			return PaginaEnum.ERRO.getDescricao();
		}
		session.put("mensagem", getMensagem());
		session.put("resultado", getResultado());
		pesquisarProcessosAux();
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	/**
	 * Action que excluir despesas.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="excluirDespesa", results={
			@Result(location="/pages/despesa/lancarDespesa.jsp", name="lancar")
	})
	public String excluirDespesa(){
		try {
			despesa.setCodigoLancamento((Integer)session.get("codigoLancamento"));
			if(despesa.getCodigoLancamento() != null){
				DespesaBO.deletarDespesa(despesa.getCodigoLancamento());
				
				limparCampos();
				
				setMensagem("Despesa exclu�da com sucesso!");
				setResultado("sucesso");
			} else {
				setMensagem("Selecione uma despesa!");
				setResultado("erro");
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
			e.printStackTrace();
		}
		session.put("mensagem", getMensagem());
		session.put("resultado", getResultado());
		pesquisarProcessosAux();
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	/**
	 * Action que pesquisa o processo.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="pesquisarProcessoDespesas", results={
			@Result(location="/pages/despesa/lancarDespesa.jsp", name="lancar")
	})
	public String pesquisarProcessoDespesas(){
		try {
			if(numeroProcesso != null){
				pesquisarProcessosAux();
				limparMensagem();
				if(processos.size() <=0){
					setMensagem("Nenhum processo encontrado!");
					setResultado("info");
				}
			} else {
				setMensagem("Informe o n�mero do processo!");
				setResultado("erro");
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			setResultado("erro");
			e.printStackTrace();
		}
		session.put("mensagem", getMensagem());
		session.put("resultado", getResultado());
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	/**
	 * M�todo auxiliar de pesquisa de processos
	 * @JDGR�
	 * @since 05/10/2012
	 * @param processo
	 */
	private void pesquisarProcessosAux(){
		Processo processo = DespesaBO.consultarProcesso(numeroProcesso);
		if(processo != null){
			processos = new ArrayList<Processo>();
			processos.add(processo);
			despesas = new ArrayList<Despesa>();
			despesas = DespesaBO.consultarDespesasPorProcesso(numeroProcesso);
			valorTotalDespesas = DespesaBO.somarDespesaPorProcesso(numeroProcesso);
			tiposDespesas = DespesaBO.consultarTiposDespesas();
			session.put("numeroProcesso", numeroProcesso);
			session.put("despesas", despesas);
		}
	}
	
	/**
	 * M�todo que localizar despesa selecionada.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="localizarDespesa", results={
			@Result(name="lancar", type="json", params={
					"despesaLocalizada", "processos, " +
					"valorTotalDespesas, numeroProcesso, despesas, " +
					"tiposDespesas, despesa, codigoLancamento"
			}),
			@Result(location="/erro.jsp", name="erro")
	})
	public String localizarDespesa(){
		despesas = (List<Despesa>) session.get("despesas");
		for(Despesa d: despesas){
			if(d.getCodigoLancamento() == codigoLancamento){
				despesa = d;
				session.put("codigoTipoDespesa", d.getTipoDespesa().getCodigoDespesa());
				session.put("codigoLancamento", codigoLancamento);
				break;
			}
		}
		jSonTipoDespesa = String.valueOf(despesa.getTipoDespesa().getCodigoDespesa());
		jSonValorDespesa = String.valueOf(despesa.getValorDespesa());
		jSonObservacaoDespesa = despesa.getObservacao();
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	/**
	 * M�todo para reinicializar atributos da tela.
	 * @author JDGR�
	 * @since 30/09/2012
	 */
	private void limparCampos(){
		tiposDespesas = DespesaBO.consultarTiposDespesas();
		codigoLancamento = null;
		despesa = new Despesa();
		jSonTipoDespesa = "";
		jSonValorDespesa = null;
		jSonObservacaoDespesa = null;
		session.put("mensagem", "");
		session.put("resultado", "");
	}
	
	/**
	 * M�todo para validar campos obrigat�rios.
	 * @author JDGR�
	 * @since 30/09/2012
	 * @return boolean
	 */
	private boolean validarCampos(){
		if(numeroProcesso == null || numeroProcesso.intValue() <= 0){
			setMensagem("Informe o n�mero do processo!");
			setResultado("erro");
			return false;
		} else if((despesa.getTipoDespesa().getCodigoDespesa() == null 
					|| despesa.getTipoDespesa().getCodigoDespesa().intValue() <= 0 )) {
			setMensagem("Informe o tipo de despesa!");
			setResultado("erro");
			return false;
		}
//		} else if(despesa.getValorDespesa() == null){
//			setMensagem("Informe o valor da despesa!");
//			setResultado("erro");
//			return false;
//		}
		return true;
	}
	
	public Despesa getDespesa() {
		return despesa;
	}
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public List<TipoDespesa> getTiposDespesas() {
		return tiposDespesas;
	}

	public void setTiposDespesas(List<TipoDespesa> tiposDespesas) {
		this.tiposDespesas = tiposDespesas;
	}

	public Integer getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(Integer numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Double getValorTotalDespesas() {
		return valorTotalDespesas;
	}

	public void setValorTotalDespesas(Double valorTotalDespesas) {
		this.valorTotalDespesas = valorTotalDespesas;
	}

	public String getjSonTipoDespesa() {
		return jSonTipoDespesa;
	}

	public void setjSonTipoDespesa(String jSonTipoDespesa) {
		this.jSonTipoDespesa = jSonTipoDespesa;
	}

	public String getjSonValorDespesa() {
		return jSonValorDespesa;
	}

	public void setjSonValorDespesa(String jSonValorDespesa) {
		this.jSonValorDespesa = jSonValorDespesa;
	}

	public String getjSonObservacaoDespesa() {
		return jSonObservacaoDespesa;
	}

	public void setjSonObservacaoDespesa(String jSonObservacaoDespesa) {
		this.jSonObservacaoDespesa = jSonObservacaoDespesa;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public Integer getCodigoLancamento() {
		return codigoLancamento;
	}

	public void setCodigoLancamento(Integer codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}
	
}