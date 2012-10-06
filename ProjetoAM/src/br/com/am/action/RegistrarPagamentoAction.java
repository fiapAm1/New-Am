package br.com.am.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.TituloBO;
import br.com.am.model.Processo;
import br.com.am.model.Titulo;
import br.com.am.model.TituloPago;

/**
 * Class Action RegistrarPagamento
 * @author JDGR²
 * @since 27/09/2012
 */
public class RegistrarPagamentoAction extends GenericAction{

	private static final long serialVersionUID = -1053449491716658470L;
	
	private List<Processo> processos = new ArrayList<Processo>();
	private List<Titulo> titulos = new ArrayList<Titulo>();
	private List<TituloPago> titulosPagos = new ArrayList<TituloPago>();
	
	private Titulo titulo;
	
	/**
	 * Action que direciona para página de registro de pagamento.
	 * @author JDGR²
	 * @return String
	 * @since 27/09/2012
	 */
	@Action(value="forwardRegistrarPagamento", results={
			@Result(location="/pages/pagamento/registrarPagamento.jsp", name="registrarPagamento"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardRegistrarPagamento(){
		if(PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao().equals(getPaginaDirecionar())){
			return PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao();
		} else {
			return PaginaEnum.ERRO.getDescricao();
		}
	}
	
	/**
	 * Action que registra pagamento de um título.
	 * @author JDGR²
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="registrarPagamento", results={
			@Result(location="/pages/pagamento/registrarPagamento.jsp", name="registrarPagamento")
	})
	public String registrarPagamento(){
		limparMensagem();
		try {
			titulo.getProcesso().setNumeroProcesso((Integer)session.get("numeroProcesso"));
			TituloBO.registrarTituloPago(titulo);
			setMensagem("Pagamento efetuado com sucesso!");
			setResultado("sucesso");
			pesquisarProcessos();
		} catch (Exception e) {
			setMensagem(e.getMessage());
			e.printStackTrace();
		}
		session.put("mensagem", getMensagem());
		session.put("resultado", getResultado());
		return PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao();
	}
	
	/**
	 * Action para pesquisar processos
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="pesquisarTitulosProcesso", results={
			@Result(location="/pages/pagamento/registrarPagamento.jsp", name="registrarPagamento")
	})
	public String pesquisarProcessos(){
		try {
			if(validarCampos()){
				Processo processo = TituloBO.consultarProcesso(titulo.getProcesso().getNumeroProcesso());
				if(processo != null){
					processos.add(processo);
					titulos = TituloBO.consultarTitulos(processo.getNumeroProcesso());
					titulosPagos = TituloBO.consultarTitulosPagosPorProcesso(processo.getNumeroProcesso());
					session.put("numeroProcesso", processo.getNumeroProcesso());
				} else {
					setMensagem("Nenhum processo encontrado!");
					setResultado("info");
				}
			}
		} catch (Exception e) {
			setMensagem(e.getMessage());
			e.printStackTrace();
		}
		session.put("mensagem", getMensagem());
		session.put("resultado", getResultado());
		return PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao();
	}
	
	/**
	 * Método para validar campos obrigatórios.
	 * @author JDGR²
	 * @since 30/09/2012
	 * @return boolean
	 */
	private boolean validarCampos(){
		if(titulo.getProcesso().getNumeroProcesso() == null){
			setMensagem("Informe o número do processo!");
			setResultado("erro");
			return false;
		} 
		return true;
	}
	
	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public List<TituloPago> getTitulosPagos() {
		return titulosPagos;
	}

	public void setTitulosPagos(List<TituloPago> titulosPagos) {
		this.titulosPagos = titulosPagos;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}
}