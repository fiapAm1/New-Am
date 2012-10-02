package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.DespesaDAOInterface;
import br.com.am.model.Despesa;

/**
 * Business Object Despesa. Cont�m os m�todos que v�o ser usados, apenas para a funcionalidade de Lan�ar Despesas por Processo.
 * @author Ricardo
 * @since 26/09/2012
 */
public class DespesaBO extends GenericBO{

	/**
	 * M�todo que retorna uma lista de despesa.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<Despesa>
	 */
	public static List<Despesa> consultarDespesas() {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		return despesaDAO.consultarDespesas();
	}
	
	/**
	 * M�todo que retorna uma despesa a partir do c�digo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoLancamento
	 * @return Despesa
	 */
	public static Despesa consultarDespesa(int codigoLancamento) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		return despesaDAO.consultarDespesa(codigoLancamento);
	}
	
	/**
	 * M�todo que realiza lan�amento de uma despesa.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param despesa
	 */
	public static void lancarDespesa(Despesa despesa) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		despesaDAO.lancarDespesa(despesa);
	}
	
	
	/**
	 * M�todo que realiza a consulta de despesa.
	 * @author JGDR2
	 * @since 26/09/2012
	 * @param despesa
	 */
	
	public static List<Despesa> consultarDespesasPorProcesso(int codigoProcesso) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		return despesaDAO.consultarDespesasPorProcesso(codigoProcesso);
	}
	
	/**
	 * M�todo que realiza a soma da Despesa
	 * @author JGDR2
	 * @since 26/09/2012
	 * @param despesa
	 */
	
	public static double somarDespesaPorProcesso (int codigoProcesso) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		return despesaDAO.somarDespesaPorProcesso(codigoProcesso);
	}
	
	/**
	 * M�doto de atualizar despesa
	 * @author JGDR2
	 * @since 29/09/2012
	 * @param despesa
	 */
	
	public static void atualizarDespesa (Despesa despesa) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		despesaDAO.atualizarDespesa(despesa);
	}
	
	/**
	 * M�todo para atualizar a despesa
	 * @author JGDR2
	 * @since 29/09/2012
	 * @param codigoDespesa
	 */
	
	public static void deletarDespesa (int codigoDespesa) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		despesaDAO.deletarDespesa(codigoDespesa);
	}
}