package br.com.am.model;

import java.io.Serializable;

/**
 * Classe com objetivo inicial de guardar objetos selecionaveis.
 * @author JDGR²
 * @since 29/09/2012
 */
public class SelectObject implements Serializable{

	private static final long serialVersionUID = -4255673149725828215L;
	
	private Boolean selected;
	private Object source;
	
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public Object getSource() {
		return source;
	}
	public void setSource(Object source) {
		this.source = source;
	}
}