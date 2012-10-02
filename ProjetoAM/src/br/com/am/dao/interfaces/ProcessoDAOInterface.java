package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Processo;

/**
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public interface ProcessoDAOInterface {
	
	/**
	 * Busca todos os processos em andamento na tabela AM_PROCESSO
	 * @return List<Forum>
	 */
	public List<Processo> consultarProcessosEmAndamento();
	
	/**
	 * Busca um processo específico através do número do processo fornecido
	 * @param numeroProcesso
	 * @return Processo
	 */
	public Processo consultarProcesso(int numeroProcesso);
	
	/**
	 * Insere um novo processo na tabela AM_PROCESSO
	 * @param processo
	 */
	public void cadastrarProcesso(Processo processo);

}
