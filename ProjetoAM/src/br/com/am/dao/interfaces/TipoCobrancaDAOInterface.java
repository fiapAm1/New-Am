package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.TipoCobranca;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public interface TipoCobrancaDAOInterface {
	
	/**
	 * Busca todos os tipos de cobran�a existentes na tabela AM_TIPO_COBRANCA
	 * @return List<TipoCobranca>
	 */
	public List<TipoCobranca> consultarTipoCobrancas();
	
	/**
	 * Busca um tipo de cobran�a espec�fico atrav�s do c�digo da cobran�a fornecido
	 * @param codigoCobranca
	 * @return TipoCobranca
	 */
	public TipoCobranca consultarTipoCobranca(int codigoCobranca);

}
