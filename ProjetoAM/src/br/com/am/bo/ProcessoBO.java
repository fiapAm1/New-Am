package br.com.am.bo;

import java.util.List;


import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.ProcessoDAOInterface;
import br.com.am.model.Processo;

/**
 * Business Object Processo. Cont�m os m�todos que v�o ser usados, apenas para a funcionalidade de Cadastro de Processo.  
 * @author Rodrigo Joubert<br>
 * @since 26/09/2012
 * Turma:   1TDSR<br>
 */
public class ProcessoBO extends GenericBO{
	
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
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param processo
	 */
	public static void cadastrarProcesso(Processo processo) {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();
		
		if(processo.getForum() != null && processo.getCliente() != null && processo.getCausa() != null && processo.getCobranca() != null
		   && processo.getDataAbertura() != null && processo.getDiaVencimento() != 0 && processo.getProcesso() != null) {
			
			processoDAO.cadastrarProcesso(processo);
			
		} else {
			System.out.println("Processo n�o pode ser cadastrado. Dados incompletos");
		}
	}
}