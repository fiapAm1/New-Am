package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Forum;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public interface ForumDAOInterface {
	
	/**
	 * Busca todos os foruns existentes na tabela AM_FORUM
	 * @return List<Forum>
	 */
	public List<Forum> consultarForuns();
	
	/**
	 * Busca um forum específico através do código do forum fornecido
	 * @param codigoForum
	 * @return Forum
	 */
	public Forum consultarForum(int codigoForum);
	
}
