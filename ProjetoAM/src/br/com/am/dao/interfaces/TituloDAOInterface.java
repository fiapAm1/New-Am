package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Titulo;


/**
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public interface TituloDAOInterface {
	
	public Titulo consultarTitulo(int numeroTitulo);
	
	public List<Titulo> consultarTitulos(int numeroProcesso);
	
	public List<Titulo> consultarTitulosPendentes(int numeroProcesso);

}
