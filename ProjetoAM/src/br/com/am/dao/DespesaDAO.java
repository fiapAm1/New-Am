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
import br.com.am.dao.interfaces.DespesaDAOInterface;
import br.com.am.model.Despesa;
import br.com.am.model.Processo;
import br.com.am.model.TipoDespesa;


/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class DespesaDAO implements DespesaDAOInterface{

	@Override
	public List<Despesa> consultarDespesas() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_LANCAMENTO,  CD_DESPESA,  NR_PROCESSO,  DT_DESPESA,  VL_DESPESA,  DS_OBSERVACAO FROM AM_DESPESA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Despesa despesa = null;
		List<Despesa> despesas = new ArrayList<Despesa>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				despesa = new Despesa();
				
				despesa.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
				
				TipoDespesa tipoDespesa = ProcessoBO.consultarTipoDespesa(rs.getInt("CD_DESPESA"));
				despesa.setTipoDespesa(tipoDespesa);
				
				Processo processo = ProcessoBO.consultarProcesso(rs.getInt("NR_PROCESSO"));
				despesa.setProcesso(processo);
				
				despesa.setDataDespesa(rs.getDate("DT_DESPESA"));
				despesa.setValorDespesa(rs.getDouble("VL_DESPESA"));
				despesa.setObservacao(rs.getString("DS_OBSERVACAO"));
				
				despesas.add(despesa);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return despesas;
	}

	@Override
	public List<Despesa> consultarDespesasPorProcesso(int numeroProcesso) {
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_LANCAMENTO,  CD_DESPESA,  NR_PROCESSO,  DT_DESPESA,  VL_DESPESA,  DS_OBSERVACAO FROM AM_DESPESA " +
					 "WHERE NR_PROCESSO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Despesa despesa = null;
		List<Despesa> despesas = new ArrayList<Despesa>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroProcesso);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				despesa = new Despesa();
				
				despesa.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
				
				Processo processo = ProcessoBO.consultarProcesso(rs.getInt("NR_PROCESSO"));
				despesa.setProcesso(processo);
				
				TipoDespesa tipoDespesa = ProcessoBO.consultarTipoDespesa(rs.getInt("CD_DESPESA"));
				despesa.setTipoDespesa(tipoDespesa);
				
				despesa.setDataDespesa(rs.getDate("DT_DESPESA"));
				
				despesa.setValorDespesa(rs.getDouble("VL_DESPESA"));
				
				despesa.setObservacao(rs.getString("DS_OBSERVACAO"));
				
				despesas.add(despesa);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return despesas;
	}	
	
	
	@Override
	public Despesa consultarDespesa(int codigoLancamento) {

		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_LANCAMENTO,  CD_DESPESA,  NR_PROCESSO,  DT_DESPESA,  VL_DESPESA,  DS_OBSERVACAO " +
				     "FROM AM_DESPESA WHERE CD_LANCAMENTO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Despesa despesa = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoLancamento);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				despesa = new Despesa();
				
				despesa.setCodigoLancamento(rs.getInt("CD_LANCAMENTO"));
				
				TipoDespesa tipoDespesa = ProcessoBO.consultarTipoDespesa(rs.getInt("CD_DESPESA"));
				despesa.setTipoDespesa(tipoDespesa);
				
				Processo processo = ProcessoBO.consultarProcesso(rs.getInt("NR_PROCESSO"));
				despesa.setProcesso(processo);
				
				despesa.setDataDespesa(rs.getDate("DT_DESPESA"));
				despesa.setValorDespesa(rs.getDouble("VL_DESPESA"));
				despesa.setObservacao(rs.getString("DS_OBSERVACAO"));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return despesa;
	}

	@Override
	public void lancarDespesa(Despesa despesa) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "INSERT INTO AM_DESPESA(CD_DESPESA, NR_PROCESSO, DT_DESPESA, VL_DESPESA, DS_OBSERVACAO) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, despesa.getTipoDespesa().getCodigoDespesa());
			ps.setInt(2, despesa.getProcesso().getNumeroProcesso());
			ps.setDate(3, new java.sql.Date(despesa.getDataDespesa().getTime()));
			ps.setDouble(4, despesa.getValorDespesa());
			ps.setString(5, despesa.getObservacao());
			
			ps.executeQuery();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps);
		}
		
	}

	@Override
	public double somarDespesaPorProcesso (int codigoProcesso) {
				
				//Conexão
				Connection conn = ConnectionFactory.getConnectionOracle();
				
				//Comunicação
				String sql = "SELECT sum(VL_DESPESA) " +
							 "FROM AM_DESPESA WHERE NR_PROCESSO = ? " +
							 "GROUP BY NR_PROCESSO";
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				Double soma = null;
				
				try {
					
					ps = conn.prepareStatement(sql);
					ps.setInt(1, codigoProcesso);
					
					rs = ps.executeQuery();
					
					if(rs.next()) {
						
						 soma = rs.getDouble(1);
						
					}
					
				} catch(SQLException e) {
					e.printStackTrace();
				} finally {
					ConnectionFactory.close(conn, ps, rs);
				}
				
				return soma;
	} 
	
	@Override
	public void atualizarDespesa (Despesa despesa)  {
				
				//Conexão
				Connection conn = ConnectionFactory.getConnectionOracle();
				
				//Comunicação
				String sql = "UPDATE AM_DESPESA SET VL_DESPESA = ?, DS_OBSERVACAO = ? WHERE CD_LANCAMENTO = ? ";
				
				PreparedStatement ps = null;
				
				try {
					
					ps = conn.prepareStatement(sql);
					ps.setDouble(1, despesa.getValorDespesa());
					ps.setString(2, despesa.getObservacao());
					ps.setInt(3, despesa.getCodigoLancamento());
					
					ps.executeQuery();
					
						
					
				} catch(SQLException e) {
					e.printStackTrace();
				} finally {
					ConnectionFactory.close(conn, ps);
				}
				
	} 
	
	public void deletarDespesa (int codigoDespesa) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();

		String sql = "DELETE FROM AM_DESPESA WHERE CD_LANCAMENTO = ? ";
		PreparedStatement ps = null;
		
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoDespesa);
			
			ps.executeQuery();
		
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps);
		}
	}
	
}
