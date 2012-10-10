package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.AdvogadoDAOInterface;
import br.com.am.dao.interfaces.ProcessoDAOInterface;
import br.com.am.model.AdvogadoProcesso;
import br.com.am.model.Processo;

/**
 * Business Object Processo. Cont�m os m�todos que v�o ser usados, apenas para a funcionalidade de Cadastro de Processo.  
 * @author Rodrigo Joubert<br>
 * @since 26/09/2012
 * Turma:   1TDSR<br>
 */
public class ProcessoBO extends GenericBO{
	
	/**
	 * M�todo que retorna um processo a partir do n�mero passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param nomeCliente, codigoCausa
	 * @return List<Processo>
	 */
	public static List<Processo> consultarProcessos(String nomeCliente, int codigoCausa) {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();
		return processoDAO.consultarProcessos(nomeCliente, codigoCausa);
	}
	
	/**
	 * M�todo que retorna uma lista de processos a partir do nome do cliente
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param nomeCliente
	 * @return List<Processo>
	 */
	public static List<Processo> consultarProcessos(String nomeCliente) {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();
		return processoDAO.consultarProcessos(nomeCliente);
	}
	
	/**
	 * M�todo que retorna uma lista de processos a partir do tipo de causa
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoCausa
	 * @return List<Processo>
	 */
	public static List<Processo> consultarProcessos(int codigoCausa) {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();
		return processoDAO.consultarProcessos(codigoCausa);
	}
	
	/**
	 * M�todo que retorna uma lista de processos.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<Processo>
	 */
	public static List<Processo> consultarProcessosEmAndamento() {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();
		return processoDAO.consultarProcessosEmAndamento();
	}
	
	/**
	 * M�todo que realiza o cadastro de um processo.
	 * @author JDGR�
	 * @since 26/09/2012
	 * @param processo
	 */
	public static Integer cadastrarProcesso(Processo processo) {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();
		Integer codigoProcesso = 0;
			
		codigoProcesso = processoDAO.cadastrarProcesso(processo);
			
		return codigoProcesso;
	}
	
	/**
	 * M�todo que realiza o altera��o de um processo.
	 * @author JDGR�
	 * @since 26/09/2012
	 * @param processo
	 */
	public static void alterarProcesso(Processo processo) {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();	
		processoDAO.alterarProcesso(processo);
	}
	
	/**
	 * M�todo que retorna advogados vinculados ao um processo.
	 * @author JDGR�
	 * @since 06/10/2012
	 * @param numeroProcesso
	 * @return List<Advogado>
	 */
	public static List<AdvogadoProcesso> carregarAdvogadosVinculados(Integer numeroProcesso){
		AdvogadoDAOInterface dao = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getAdvogadoDAO();
		return dao.carregarAdvogadosVinculados(numeroProcesso);
	}
	
	/**
	 * M�todo que cadastra advogados vinculados a um processo.
	 * @author JDGR�
	 * @since 06/10/2012
	 * @param numeroProcesso
	 * @return List<Advogado>
	 */
	public static void cadastrarAdvogadosVinculados(AdvogadoProcesso advogadoProcesso, Integer numeroProcesso){
		AdvogadoDAOInterface dao = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getAdvogadoDAO();
		dao.cadastrarAdvogadosVinculados(advogadoProcesso, numeroProcesso);
	}
	
	/**
	 * M�todo que remove advogados vinculados a um processo.
	 * @author JDGR�
	 * @since 08/10/2012
	 * @param numeroProcesso
	 * @return List<Advogado>
	 */
	public static void removerAdvogadoVinculado(AdvogadoProcesso advogadoProcesso, Integer numeroProcesso){
		AdvogadoDAOInterface dao = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getAdvogadoDAO();
		dao.removerAdvogadoVinculado(advogadoProcesso, numeroProcesso);
	}
}