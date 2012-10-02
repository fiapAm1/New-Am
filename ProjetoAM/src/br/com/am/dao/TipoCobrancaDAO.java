package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.TipoCobrancaDAOInterface;
import br.com.am.model.TipoCobranca;


/**
 * TipoCobrancaDAO mapeia os dados da tabela AM_TIPO_COBRANCA da base de dados.
 * 
 * @author Rodrigo Joubert<br>
 * Turma:   1TDSR<br>
 * Ano:    2012<br>	
 */
public class TipoCobrancaDAO implements TipoCobrancaDAOInterface{

	@Override
	public List<TipoCobranca> consultarTipoCobrancas() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_COBRANCA, DS_COBRANCA, TX_JUROS, VL_MORA_DIARIA FROM AM_TIPO_COBRANCA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoCobranca tipoCobranca = null;
		List<TipoCobranca> tiposCobranca = new ArrayList<TipoCobranca>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tipoCobranca = new TipoCobranca();
				tipoCobranca.setCodigoCobranca(rs.getInt("CD_COBRANCA"));
				tipoCobranca.setPeriodoCobranca(rs.getString("DS_COBRANCA"));
				tipoCobranca.setTaxaJuros(rs.getDouble("TX_JUROS"));
				tipoCobranca.setMoraDiaria(rs.getDouble("VL_MORA_DIARIA"));
				
				tiposCobranca.add(tipoCobranca);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return tiposCobranca;
	}

	@Override
	public TipoCobranca consultarTipoCobranca(int codigoCobranca) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_COBRANCA, DS_COBRANCA, TX_JUROS, VL_MORA_DIARIA FROM AM_TIPO_COBRANCA WHERE CD_COBRANCA = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoCobranca tipoCobranca = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoCobranca);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				tipoCobranca = new TipoCobranca();
				tipoCobranca.setCodigoCobranca(rs.getInt("CD_COBRANCA"));
				tipoCobranca.setPeriodoCobranca(rs.getString("DS_COBRANCA"));
				tipoCobranca.setTaxaJuros(rs.getDouble("TX_JUROS"));
				tipoCobranca.setMoraDiaria(rs.getDouble("VL_MORA_DIARIA"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return tipoCobranca;
	}

}
