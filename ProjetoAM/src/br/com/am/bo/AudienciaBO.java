package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.RelatorioDAOInterface;
import br.com.am.model.RelatorioAudiencia;

/**
 * Bussines Object Audi�ncia. Cont�m os m�todos que v�o ser usados, apenas para a funcionalidade de Emitir Rel�torio de Audi�ncias por Processo.
 * @author JDGR2
 * @since 26/09/2012
 */
public class AudienciaBO extends GenericBO{
	
	/**
	 * M�todo que retorna uma lista de audi�ncias por processo, a partir do n�mero do processo passado como parametro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroProcesso
	 * @return List<RelatorioAudiencia>
	 */
	public static List<RelatorioAudiencia> consultarRelatorioAudiencia(int numeroProcesso) {
		RelatorioDAOInterface relatorioDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getRelatorioDAO();
		return relatorioDAO.relatorioAudiencia(numeroProcesso);
	}	
}