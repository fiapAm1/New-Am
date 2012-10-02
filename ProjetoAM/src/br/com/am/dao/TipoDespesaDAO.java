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

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.TipoDespesaDAOInterface;
import br.com.am.model.TipoDespesa;


/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class TipoDespesaDAO implements TipoDespesaDAOInterface{

	@Override
	public List<TipoDespesa> consultarTipoDespesas() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT * FROM AM_TIPO_DESPESA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoDespesa tipoDespesa = null;
		List<TipoDespesa> tipoDespesas = new ArrayList<TipoDespesa>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tipoDespesa = new TipoDespesa();
				
				tipoDespesa.setCodigoDespesa(rs.getInt("CD_DESPESA"));
				tipoDespesa.setDespesa(rs.getString("DS_DESPESA"));
				
				tipoDespesas.add(tipoDespesa);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return tipoDespesas;
	}

	@Override
	public TipoDespesa consultarTipoDespesa(int codigoDespesa) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT * FROM AM_TIPO_DESPESA WHERE CD_DESPESA = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoDespesa tipoDespesa = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoDespesa);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				tipoDespesa = new TipoDespesa();
				
				tipoDespesa.setCodigoDespesa(rs.getInt("CD_DESPESA"));
				tipoDespesa.setDespesa(rs.getString("DS_DESPESA"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return tipoDespesa;
	}

}
