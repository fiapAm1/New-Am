package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.TipoCausa;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public interface TipoCausaDAOInterface {
	
	/**
	 * Busca todos os tipos de causa existentes na tabela AM_TIPO_CAUSA
	 * @return List<TipoCausa>
	 */
	public List<TipoCausa> consultarTipoCausas();
	
	/**
	 * Busca um tipo de causa específico através do código da causa fornecido
	 * @param codigoCausa
	 * @return tipoCausa
	 */
	public TipoCausa consultarTipoCausa(int codigoCausa);

}
