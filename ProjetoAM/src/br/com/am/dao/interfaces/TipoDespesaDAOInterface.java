/**
 * 
 */
package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.TipoDespesa;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public interface TipoDespesaDAOInterface {
	
	/**
	 * Busca todos os tipos de despesa existentes na tabela AM_TIPO_DESPESA
	 * @return List<TipoDespesa>
	 */
	public List<TipoDespesa> consultarTipoDespesas();
	
	/**
	 * Busca um tipo de despesa específico através do código da despesa fornecido
	 * @param codigoDespesa
	 * @return TipoDespesa
	 */
	public TipoDespesa consultarTipoDespesa(int codigoDespesa);


}
