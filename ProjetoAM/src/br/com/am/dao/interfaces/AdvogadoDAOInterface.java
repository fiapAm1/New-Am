/**
 * 
 */
package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Advogado;
import br.com.am.model.AdvogadoProcesso;

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
	 * Busca um advogado espec�fico atrav�s do c�digo do advogado fornecido
	 * @param codigoAdvogado
	 * @return Advogado
	 */
	public Advogado consultarAdvogado(int codigoAdvogado);
	
	/**
	 * Busca advogados vinculados ao processo.
	 * @author JDGR�
	 * @param numeroProcesso
	 * @return List<Advogado>
	 */
	public List<AdvogadoProcesso> carregarAdvogadosVinculados(Integer numeroProcesso);
	
	/**
	 * Cadastrar advogados vinculados a um processo.
	 * @author JDGR�
	 * @param advogadoProcesso
	 * @param numeroProcesso
	 */
	public void cadastrarAdvogadosVinculados(AdvogadoProcesso advogadoProcesso, Integer numeroProcesso);
	
	/**
	 * Remove advogado vinculado de um processo.
	 * @author JDGR�
	 * @param advogadoProcesso
	 * @param numeroProcesso
	 */
	public void removerAdvogadoVinculado(AdvogadoProcesso advogadoProcesso, Integer numeroProcesso);

}