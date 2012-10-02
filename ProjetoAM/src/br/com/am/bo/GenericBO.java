package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.AdvogadoDAOInterface;
import br.com.am.dao.interfaces.ClienteDAOInterface;
import br.com.am.dao.interfaces.ForumDAOInterface;
import br.com.am.dao.interfaces.ProcessoDAOInterface;
import br.com.am.dao.interfaces.TarefaDAOInterface;
import br.com.am.dao.interfaces.TipoCausaDAOInterface;
import br.com.am.dao.interfaces.TipoCobrancaDAOInterface;
import br.com.am.dao.interfaces.TipoDespesaDAOInterface;
import br.com.am.model.Advogado;
import br.com.am.model.Cliente;
import br.com.am.model.Forum;
import br.com.am.model.Processo;
import br.com.am.model.Tarefa;
import br.com.am.model.TipoCausa;
import br.com.am.model.TipoCobranca;
import br.com.am.model.TipoDespesa;

/**
 * Business Object gen�rico. Cont�m os m�todos que podem ser usadas em mais de uma funcionalidade.
 * @author Ricardo
 * @since 26/09/2012
 */
public class GenericBO {
	
	/**
	 * M�todo que retorna um forum a partir do c�digo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoForum
	 * @return Forum
	 */
	public static Forum consultarForum(int codigoForum) {
		ForumDAOInterface forumDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getForumDAO();
		return forumDAO.consultarForum(codigoForum);
	}
	
	/**
	 * M�todo que retorna uma lista de foruns.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<Forum>
	 */
	public static List<Forum> consultarForuns() {
		ForumDAOInterface forumDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getForumDAO();
		return forumDAO.consultarForuns();
		
	}
	
	/**
	 * M�todo que retorna um cliente a partir do c�digo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoCliente
	 * @return Cliente
	 */
	public static Cliente consultarCliente(int codigoCliente) {
		ClienteDAOInterface clienteDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getClienteDAO();
		return clienteDAO.consultarCliente(codigoCliente);
		
	}
	
	/**
	 * M�todo para retornar uma lista de clientes.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<Cliente>
	 */
	public static List<Cliente> consultarClientes() {
		ClienteDAOInterface clienteDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getClienteDAO();
		return clienteDAO.consultarClientes();
		
	}
	
	/**
	 * M�todo que retorna um advogado a partir do c�digo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoAdvogado
	 * @return Advogado
	 */
	public static Advogado consultarAdvogado(int codigoAdvogado) {
		AdvogadoDAOInterface advogadoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getAdvogadoDAO();
		return advogadoDAO.consultarAdvogado(codigoAdvogado);
		
	}
	
	/**
	 * M�todo para retornar uma lista de advogados.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<Advogado>
	 */
	public static List<Advogado> consultarAdvogados() {
		AdvogadoDAOInterface advogadoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getAdvogadoDAO();
		return advogadoDAO.consultarAdvogados();
	}
	
	/**
	 * M�todo que retorna um tipo de cobran�a a partir do c�digo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoCobranca
	 * @return TipoCobranca
	 */
	public static TipoCobranca consultarTipoCobranca(int codigoCobranca) {
		TipoCobrancaDAOInterface tipoCobrancaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTipoCobrancaDAO();
		return tipoCobrancaDAO.consultarTipoCobranca(codigoCobranca);
	}
	
	/**
	 * M�todo para retornar uma lista de tipos de cobran�as
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<TipoCobranca>
	 */
	public static List<TipoCobranca> consultarTiposCobrancas() {
		TipoCobrancaDAOInterface tipoCobrancaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTipoCobrancaDAO();
		return tipoCobrancaDAO.consultarTipoCobrancas();
	}
	
	/**
	 * M�todo que retorna um tipo de causa a partir do c�digo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoCausa
	 * @return TipoCausa
	 */
	public static TipoCausa consultarTipoCausa(int codigoCausa) {
		TipoCausaDAOInterface tipoCausaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTipoCausaDAO();
		return tipoCausaDAO.consultarTipoCausa(codigoCausa);
	}
	
	/**
	 * M�todo que retorna uma lista de tipos de causas.
	 * @author Ricardo
	 * @since 26/09/2012
	 * @return TipoCausa
	 */
	public static List<TipoCausa> consultarTiposCausas() {
		TipoCausaDAOInterface tipoCausaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTipoCausaDAO();
		return tipoCausaDAO.consultarTipoCausas();
	}
	
	/**
	 * M�todo que retorna um tipo de despesa a partir do c�digo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param codigoDespesa
	 * @return TipoDespesa
	 */
	public static TipoDespesa consultarTipoDespesa(int codigoDespesa) {
		TipoDespesaDAOInterface tipoDespesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTipoDespesaDAO();
		return tipoDespesaDAO.consultarTipoDespesa(codigoDespesa);
	}
	
	/**
	 * M�todo para retornar uma lista de tipos de despesas
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<TipoDespesa>
	 */
	public static List<TipoDespesa> consultarTiposDespesas() {
		TipoDespesaDAOInterface tipoDespesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTipoDespesaDAO();
		return tipoDespesaDAO.consultarTipoDespesas();
	}
	
	/**
	 * M�todo para retornar uma lista de tarefas
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @return List<Tarefa>
	 */
	public static List<Tarefa> consultarTarefas() {
		TarefaDAOInterface tarefaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTarefaDAO();
		return tarefaDAO.consultarTarefas();
	}
	
	/**
	 * M�todo que retorna um processo a partir do n�mero passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroProcesso
	 * @return Processo
	 */
	public static Processo consultarProcesso(int numeroProcesso) {
		ProcessoDAOInterface processoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getProcessoDAO();
		return processoDAO.consultarProcesso(numeroProcesso);
	}
}