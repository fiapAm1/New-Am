package br.com.am.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import br.com.am.action.enuns.PaginaEnum;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Class Action Genérica
 * @author Ricardo
 * @since 18/09/2012
 */
@ParentPackage("json-default")
public class GenericAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -3767734831406044587L;
	
	protected Map<String, Object> session = new HashMap<String, Object>();
	
	private String paginaDirecionar;
	private String mensagem;
	
	/**
	 * Action que direciona para página home.
	 * @author JDGR²
	 * @return String
	 * @since 25/09/2012
	 */
	@Action(value="home", results={
			@Result(location="/pages/home.jsp", name="home"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String direcionar(){
		return PaginaEnum.HOME.getDescricao();
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getPaginaDirecionar() {
		return paginaDirecionar;
	}

	public void setPaginaDirecionar(String paginaDirecionar) {
		this.paginaDirecionar = paginaDirecionar;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}