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
	 * Busca todos os tipos de cobrança existentes na tabela AM_TIPO_COBRANCA
	 * @return List<TipoCobranca>
	 */
	public List<TipoCobranca> consultarTipoCobrancas();
	
	/**
	 * Busca um tipo de cobrança específico através do código da cobrança fornecido
	 * @param codigoCobranca
	 * @return TipoCobranca
	 */
	public TipoCobranca consultarTipoCobranca(int codigoCobranca);

}
