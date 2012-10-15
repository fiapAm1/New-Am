package br.com.am.dao.interfaces;

import java.util.List;
import java.util.Map;

import br.com.am.model.Processo;

/**
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
/**
 * @author Rodrigo
 *
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
	 * Busca uma lista de processos através do nome do cliente ou tipo de causa
	 * @param nomeCliente
	 * @param codigoCausa
	 * @return List<Processo>
	 */
	public List<Processo> consultarProcessos(String nomeCliente, int codigoCausa);
	
	/**
	 * Busca uma lista de processos através do nome do cliente
	 * @param nomeCliente
	 * @return List<Processo>
	 */
	public List<Processo> consultarProcessos(String nomeCliente);
	
	/**
	 * Busca uma lista de processos através do tipo de causa
	 * @param codigoCausa
	 * @return Processo
	 */
	public List<Processo> consultarProcessos(int codigoCausa);	
	
	/**
	 * Insere um novo processo na tabela AM_PROCESSO
	 * @param processo
	 */
	public Integer cadastrarProcesso(Processo processo);
	
	/**
	 * Altera um processo na tabela AM_PROCESSO
	 * @param processo
	 */
	public void alterarProcesso(Processo processo);
	

	/**
	 * Exibe a contagem de processos por tipo de causa
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> ContagemProcessosPorCausa();

}
