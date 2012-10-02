package br.com.am.dao.factory;

import br.com.am.dao.AdvogadoDAO;
import br.com.am.dao.ClienteDAO;
import br.com.am.dao.DespesaDAO;
import br.com.am.dao.ForumDAO;
import br.com.am.dao.ProcessoDAO;
import br.com.am.dao.RelatorioDAO;
import br.com.am.dao.TarefaDAO;
import br.com.am.dao.TipoCausaDAO;
import br.com.am.dao.TipoCobrancaDAO;
import br.com.am.dao.TipoDespesaDAO;
import br.com.am.dao.TituloDAO;
import br.com.am.dao.TituloPagoDAO;
import br.com.am.dao.interfaces.AdvogadoDAOInterface;
import br.com.am.dao.interfaces.ClienteDAOInterface;
import br.com.am.dao.interfaces.DespesaDAOInterface;
import br.com.am.dao.interfaces.ForumDAOInterface;
import br.com.am.dao.interfaces.ProcessoDAOInterface;
import br.com.am.dao.interfaces.RelatorioDAOInterface;
import br.com.am.dao.interfaces.TarefaDAOInterface;
import br.com.am.dao.interfaces.TipoCausaDAOInterface;
import br.com.am.dao.interfaces.TipoCobrancaDAOInterface;
import br.com.am.dao.interfaces.TipoDespesaDAOInterface;
import br.com.am.dao.interfaces.TituloDAOInterface;
import br.com.am.dao.interfaces.TituloPagoDAOInterface;


/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class OracleDAOFactory extends DAOFactory{
	
	@Override
	public ForumDAOInterface getForumDAO() {
		return new ForumDAO();
	}

	@Override
	public ClienteDAOInterface getClienteDAO() {
		return new ClienteDAO();
	}

	@Override
	public TipoCausaDAOInterface getTipoCausaDAO() {
		return new TipoCausaDAO();
	}

	@Override
	public TipoCobrancaDAOInterface getTipoCobrancaDAO() {
		return new TipoCobrancaDAO();
	}

	@Override
	public ProcessoDAOInterface getProcessoDAO() {
		return new ProcessoDAO();
	}

	@Override
	public TipoDespesaDAOInterface getTipoDespesaDAO() {
		return new TipoDespesaDAO();
	}

	@Override
	public DespesaDAOInterface getDespesaDAO() {
		return new DespesaDAO();
	}

	@Override
	public AdvogadoDAOInterface getAdvogadoDAO() {
		return new AdvogadoDAO();
	}

	@Override
	public RelatorioDAOInterface getRelatorioDAO() {
		return new RelatorioDAO();
	}

	@Override
	public TarefaDAOInterface getTarefaDAO() {
		return new TarefaDAO();
	}

	@Override
	public TituloDAOInterface getTituloDAO() {
		return new TituloDAO();
	}
	
	@Override
	public TituloPagoDAOInterface getTituloPagoDAO() {
		return new TituloPagoDAO();
	}
	

}
