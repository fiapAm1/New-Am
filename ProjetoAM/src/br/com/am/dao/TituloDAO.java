/**
 * 
 */
package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.bo.ProcessoBO;
import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.TituloDAOInterface;
import br.com.am.model.Processo;
import br.com.am.model.Titulo;


/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class TituloDAO implements TituloDAOInterface {
	
	@Override
	public Titulo consultarTitulo(int numeroTitulo) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT NR_TITULO, NR_PROCESSO, NR_AGENCIA_CEDENTE, DT_DOCUMENTO, DT_VENCIMENTO, VL_DOCUMENTO " +
				     "FROM AM_TITULO WHERE NR_TITULO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Titulo titulo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroTitulo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				titulo = new Titulo();
				titulo.setNumeroTitulo(rs.getInt("NR_TITULO"));
				
				Processo processo = ProcessoBO.consultarProcesso(rs.getInt("NR_PROCESSO"));
				titulo.setProcesso(processo);
				
				titulo.setAgenciaCedente(rs.getLong("NR_AGENCIA_CEDENTE"));
				titulo.setDataDocumento(rs.getDate("DT_DOCUMENTO"));
				titulo.setDataVencimento(rs.getDate("DT_VENCIMENTO"));
				titulo.setValorDocumento(rs.getDouble("VL_DOCUMENTO"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return titulo;
	}

	
	@Override
	public List<Titulo> consultarTitulos(int numeroProcesso) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT NR_TITULO, NR_PROCESSO, NR_AGENCIA_CEDENTE, DT_DOCUMENTO, DT_VENCIMENTO, VL_DOCUMENTO " +
				     "FROM AM_TITULO WHERE NR_PROCESSO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Titulo titulo = null;
		List<Titulo> titulos = new ArrayList<Titulo>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroProcesso);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				titulo = new Titulo();
				titulo.setNumeroTitulo(rs.getInt("NR_TITULO"));
				
				Processo processo = ProcessoBO.consultarProcesso(rs.getInt("NR_PROCESSO"));
				titulo.setProcesso(processo);
				
				titulo.setAgenciaCedente(rs.getLong("NR_AGENCIA_CEDENTE"));
				titulo.setDataDocumento(rs.getDate("DT_DOCUMENTO"));
				titulo.setDataVencimento(rs.getDate("DT_VENCIMENTO"));
				titulo.setValorDocumento(rs.getDouble("VL_DOCUMENTO"));
				
				titulos.add(titulo);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return titulos;
	}

	@Override
	public List<Titulo> consultarTitulosPendentes(int numeroProcesso) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT t.NR_TITULO, NR_PROCESSO, NR_AGENCIA_CEDENTE, DT_DOCUMENTO, DT_VENCIMENTO, VL_DOCUMENTO " +
				     "FROM AM_TITULO t " +
				     "LEFT OUTER JOIN AM_TITULO_PAGO tp ON tp.NR_TITULO = t.NR_TITULO " +
				     "WHERE tp.NR_TITULO IS NULL " +
				     "AND NR_PROCESSO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Titulo tituloPendente = null;
		List<Titulo> titulosPendentes = new ArrayList<Titulo>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroProcesso);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tituloPendente = new Titulo();
				tituloPendente.setNumeroTitulo(rs.getInt("NR_TITULO"));
				
				Processo processo = ProcessoBO.consultarProcesso(rs.getInt("NR_PROCESSO"));
				tituloPendente.setProcesso(processo);
				
				tituloPendente.setAgenciaCedente(rs.getLong("NR_AGENCIA_CEDENTE"));
				tituloPendente.setDataDocumento(rs.getDate("DT_DOCUMENTO"));
				tituloPendente.setValorDocumento(rs.getDouble("VL_DOCUMENTO"));
				
				titulosPendentes.add(tituloPendente);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return titulosPendentes;

	}

}
