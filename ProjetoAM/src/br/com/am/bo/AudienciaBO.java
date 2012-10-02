package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.RelatorioDAOInterface;
import br.com.am.model.RelatorioAudiencia;

/**
 * Bussines Object Audiência. Contém os métodos que vão ser usados, apenas para a funcionalidade de Emitir Relátorio de Audiências por Processo.
 * @author JDGR2
 * @since 26/09/2012
 */
public class AudienciaBO extends GenericBO{
	
	/**
	 * Método que retorna uma lista de audiências por processo, a partir do número do processo passado como parametro.
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