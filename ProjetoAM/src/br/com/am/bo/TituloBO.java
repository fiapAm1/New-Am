package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.TituloDAOInterface;
import br.com.am.dao.interfaces.TituloPagoDAOInterface;
import br.com.am.model.Titulo;
import br.com.am.model.TituloPago;

/**
 * Business Object Título. Contém os métodos que vão ser usados, apenas para a funcionalidade de Registrar Pagamento.
 * @author Ricardo
 * @since 26/09/2012
 */
public class TituloBO extends GenericBO{

	/**
	 * Método que retorna um título, a partir do número de identificação.
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
	 * Método que retorna uma lista de títulos por processo, a partir do número do processo passado como paramentro.
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
	 * Método que retorna uma lista de títulos pendentes por processo, a partir do número do processo passado como paramentro.
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
	 * Método que retorna uma lista de títulos, a partir do número do processo.
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
	 * Método que insere um titulo pago na tabela de titulos pagos, a partir de um titulo .
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