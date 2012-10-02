package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.RelatorioDAOInterface;
import br.com.am.model.RelatorioHonorario;

/**
 * Bussines Object Honor�rio. Cont�m os m�todos que v�o ser usados, apenas para a funcionalidade de Emitir Rel�torio de Honor�rios por Processo.
 * @author Ricardo
 * @since 26/09/2012
 */
public class HonorarioBO extends GenericBO{
	
	/**
	 * M�todo que retorna uma lista de honorarios por processo, a partir do n�mero do processo e do codigo de uma tarefa passados como parametro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroProcesso
	 * @return List<RelatorioHonorario>
	 */
	public static List<RelatorioHonorario> consultarRelatorioHonorario(int numeroProcesso, int codigoTarefa) {
		RelatorioDAOInterface relatorioDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getRelatorioDAO();
		return relatorioDAO.relatorioHonorario(numeroProcesso, codigoTarefa);
	}
}