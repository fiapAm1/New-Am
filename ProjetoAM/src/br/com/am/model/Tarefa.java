/**
 * 
 */
package br.com.am.model;

import java.io.Serializable;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 2981696023878699140L;
	
	private int codigo;
	private String tarefa;
	
	/**
	 * Construtor padrão
	 */
	public Tarefa() {}

	/**
	 * @param codigo
	 * @param tarefa
	 */
	public Tarefa(int codigo, String tarefa) {
		this.codigo = codigo;
		this.tarefa = tarefa;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the tarefa
	 */
	public String getTarefa() {
		return tarefa;
	}

	/**
	 * @param tarefa the tarefa to set
	 */
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}

}
