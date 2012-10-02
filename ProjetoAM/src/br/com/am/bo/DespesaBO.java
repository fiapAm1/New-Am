package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.DespesaDAOInterface;
import br.com.am.model.Despesa;

/**
 * Business Object Despesa. Contém os métodos que vão ser usados, apenas para a funcionalidade de Lançar Despesas por Processo.
 * @author Ricardo
 * @since 26/09/2012
 */
public class DespesaBO extends GenericBO{

	/**
	 * Método que retorna uma lista de despesa.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<Despesa>
	 */
	public static List<Despesa> consultarDespesas() {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		return despesaDAO.consultarDespesas();
	}
	
	/**
	 * Método que retorna uma despesa a partir do código passado como paramentro.
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
	 * Método que realiza lançamento de uma despesa.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param despesa
	 */
	public static void lancarDespesa(Despesa despesa) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		despesaDAO.lancarDespesa(despesa);
	}
	
	
	/**
	 * Método que realiza a consulta de despesa.
	 * @author JGDR2
	 * @since 26/09/2012
	 * @param despesa
	 */
	
	public static List<Despesa> consultarDespesasPorProcesso(int codigoProcesso) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		return despesaDAO.consultarDespesasPorProcesso(codigoProcesso);
	}
	
	/**
	 * Método que realiza a soma da Despesa
	 * @author JGDR2
	 * @since 26/09/2012
	 * @param despesa
	 */
	
	public static double somarDespesaPorProcesso (int codigoProcesso) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		return despesaDAO.somarDespesaPorProcesso(codigoProcesso);
	}
	
	/**
	 * Médoto de atualizar despesa
	 * @author JGDR2
	 * @since 29/09/2012
	 * @param despesa
	 */
	
	public static void atualizarDespesa (Despesa despesa) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		despesaDAO.atualizarDespesa(despesa);
	}
	
	/**
	 * Método para atualizar a despesa
	 * @author JGDR2
	 * @since 29/09/2012
	 * @param codigoDespesa
	 */
	
	public static void deletarDespesa (int codigoDespesa) {
		DespesaDAOInterface despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();
		despesaDAO.deletarDespesa(codigoDespesa);
	}
}