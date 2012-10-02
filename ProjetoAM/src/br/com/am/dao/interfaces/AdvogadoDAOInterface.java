/**
 * 
 */
package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Advogado;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public interface AdvogadoDAOInterface {
	
	/**
	 * Busca todos os advogados existentes na tabela AM_ADVOGADO
	 * @return List<Advogado>
	 */
	public List<Advogado> consultarAdvogados();
	
	/**
	 * Busca um advogado específico através do código do advogado fornecido
	 * @param codigoAdvogado
	 * @return Advogado
	 */
	public Advogado consultarAdvogado(int codigoAdvogado);	

}
