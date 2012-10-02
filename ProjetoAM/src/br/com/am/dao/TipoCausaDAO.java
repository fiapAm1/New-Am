package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.TipoCausaDAOInterface;
import br.com.am.model.TipoCausa;


/**
 * TipoCausaDAO mapeia os dados da tabela AM_TIPO_CAUSA da base de dados.
 * 
 * @author Rodrigo Joubert<br>
 * Turma:   1TDSR<br>
 * Ano:    2012<br>	
 */
public class TipoCausaDAO implements TipoCausaDAOInterface {

	@Override
	public List<TipoCausa> consultarTipoCausas() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_CAUSA, DS_CAUSA FROM AM_TIPO_CAUSA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoCausa tipoCausa = null;
		List<TipoCausa> tipoCausas = new ArrayList<TipoCausa>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tipoCausa = new TipoCausa();
				tipoCausa.setCodigoCausa(rs.getInt("CD_CAUSA"));
				tipoCausa.setCausa(rs.getString("DS_CAUSA"));
				
				tipoCausas.add(tipoCausa);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return tipoCausas;
	}

	@Override
	public TipoCausa consultarTipoCausa(int codigoCausa) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_CAUSA, DS_CAUSA FROM AM_TIPO_CAUSA WHERE CD_CAUSA = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoCausa tipoCausa = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoCausa);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				tipoCausa = new TipoCausa();
				tipoCausa.setCodigoCausa(rs.getInt("CD_CAUSA"));
				tipoCausa.setCausa(rs.getString("DS_CAUSA"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return tipoCausa;
	}

}
