package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.TituloDAOInterface;
import br.com.am.dao.interfaces.TituloPagoDAOInterface;
import br.com.am.model.Titulo;
import br.com.am.model.TituloPago;

/**
 * Business Object T�tulo. Cont�m os m�todos que v�o ser usados, apenas para a funcionalidade de Registrar Pagamento.
 * @author Ricardo
 * @since 26/09/2012
 */
public class TituloBO extends GenericBO{

	/**
	 * M�todo que retorna um t�tulo, a partir do n�mero de identifica��o.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroTitulo
	 * @return
	 */
	public static Titulo consultarTitulo(int numeroTitulo) {
		TituloDAOInterface tituloDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTituloDAO();
		return tituloDAO.consultarTitulo(numeroTitulo);
	}
	
	/**
	 * M�todo que retorna uma lista de t�tulos por processo, a partir do n�mero do processo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroProcesso
	 * @return
	 */
	public static List<Titulo> consultarTitulos(int numeroProcesso) {
		TituloDAOInterface tituloDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTituloDAO();
		return tituloDAO.consultarTitulos(numeroProcesso);
	}
	
	/**
	 * M�todo que retorna uma lista de t�tulos pendentes por processo, a partir do n�mero do processo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroProcesso
	 * @return
	 */
	public static List<Titulo> consultarTitulosPendentes(int numeroProcesso) {
		TituloDAOInterface tituloDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTituloDAO();
		return tituloDAO.consultarTitulosPendentes(numeroProcesso);
	}
	
	/**
	 * M�todo que retorna uma lista de t�tulos, a partir do n�mero do processo.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroProcesso
	 * @return
	 */
	public static List<TituloPago> consultarTitulosPagosPorProcesso(int numeroProcesso) {
		TituloPagoDAOInterface tituloPagoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTituloPagoDAO();
		return tituloPagoDAO.consultarTitulosPagosPorProcesso(numeroProcesso);
	}
	
	/**
	 * M�todo que insere um titulo pago na tabela de titulos pagos, a partir de um titulo .
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param titulo
	 * @return
	 */
	public static void registrarTituloPago(Titulo titulo) {
		TituloPagoDAOInterface tituloPagoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTituloPagoDAO();
		tituloPagoDAO.registrarTituloPago(titulo);
	}
}