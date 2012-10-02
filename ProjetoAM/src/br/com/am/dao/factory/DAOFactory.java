package br.com.am.dao.factory;

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
public abstract class DAOFactory {
	
	// DISTRIBUICAO DAS FABRICAS
	public static final byte ORACLE = 1;
	
	public static DAOFactory oracleDAOFactory;
	
	public static DAOFactory getDAOFactory(byte factory) {
		
		switch (factory) {
		
		case ORACLE:
			
			if(oracleDAOFactory == null)
				oracleDAOFactory = new OracleDAOFactory();
			
			return oracleDAOFactory;
			
		default:
			return null;
		}
	}
	
	public abstract ForumDAOInterface getForumDAO();
	
	public abstract ClienteDAOInterface getClienteDAO();
	
	public abstract TipoCausaDAOInterface getTipoCausaDAO();
	
	public abstract TipoCobrancaDAOInterface getTipoCobrancaDAO();
	
	public abstract ProcessoDAOInterface getProcessoDAO();
	
	public abstract TipoDespesaDAOInterface getTipoDespesaDAO();
	
	public abstract DespesaDAOInterface getDespesaDAO();
	
	public abstract AdvogadoDAOInterface getAdvogadoDAO();
	
	public abstract RelatorioDAOInterface getRelatorioDAO();
	
	public abstract TarefaDAOInterface getTarefaDAO();
	
	public abstract TituloDAOInterface getTituloDAO();
	
	public abstract TituloPagoDAOInterface getTituloPagoDAO();

}
