package br.com.am.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.AdvogadoDAOInterface;
import br.com.am.model.Advogado;
import br.com.am.model.AdvogadoProcesso;
import br.com.am.util.UtilDate;


public class AdvogadoDAO implements AdvogadoDAOInterface{

	@Override
	public List<Advogado> consultarAdvogados() {

		//Conexão
		//xx
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT ADVOGADO.CD_PESSOA_ADV, ADVOGADO.NR_OAB,  ADVOGADO.NR_CPF, ADVOGADO.NR_RG,  ADVOGADO.DS_EMAIL,  ADVOGADO.DS_PASSWORD, PESSOA.NM_PESSOA FROM AM_ADVOGADO ADVOGADO LEFT JOIN AM_PESSOA PESSOA ON ADVOGADO.CD_PESSOA_ADV = PESSOA.CD_PESSOA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Advogado advogado = null;
		List<Advogado> advogados = new ArrayList<Advogado>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				advogado = new Advogado();
				advogado.setCodigoPessoa(rs.getInt("CD_PESSOA_ADV"));
				advogado.setNomePessoa(rs.getString("NM_PESSOA"));
				advogado.setRegistroOAB(rs.getInt("NR_OAB"));
				advogado.setCpf(rs.getLong("NR_CPF"));
				advogado.setRg(rs.getString("NR_RG"));
				advogado.setEmail(rs.getString("DS_EMAIL"));
				advogado.setPassword(rs.getString("DS_PASSWORD"));
				
				advogados.add(advogado);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return advogados;
	}

	@Override
	public Advogado consultarAdvogado(int codigoAdvogado) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT ADVOGADO.CD_PESSOA_ADV, ADVOGADO.NR_OAB,  ADVOGADO.NR_CPF, ADVOGADO.NR_RG,  ADVOGADO.DS_EMAIL,  ADVOGADO.DS_PASSWORD, PESSOA.NM_PESSOA FROM AM_ADVOGADO ADVOGADO LEFT JOIN AM_PESSOA PESSOA ON ADVOGADO.CD_PESSOA_ADV = PESSOA.CD_PESSOA WHERE ADVOGADO.CD_PESSOA_ADV = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Advogado advogado = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoAdvogado);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				advogado = new Advogado();
				advogado.setCodigoPessoa(rs.getInt("CD_PESSOA_ADV"));
				advogado.setNomePessoa(rs.getString("NM_PESSOA"));
				advogado.setRegistroOAB(rs.getInt("NR_OAB"));
				advogado.setCpf(rs.getLong("NR_CPF"));
				advogado.setRg(rs.getString("NR_RG"));
				advogado.setEmail(rs.getString("DS_EMAIL"));
				advogado.setPassword(rs.getString("DS_PASSWORD"));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return advogado;
	}
	
	@Override
	public List<AdvogadoProcesso> carregarAdvogadosVinculados(Integer numeroProcesso) {
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		query.append("		ADVOGADO_PROCESSO.CD_PESSOA_ADV, ");
		query.append("		ADVOGADO_PROCESSO.NR_PROCESSO, ");	
		query.append("		ADVOGADO_PROCESSO.DT_INICIO_PARTICIPACAO, ");
		query.append("		PESSOA.NM_PESSOA ");
		query.append("FROM ");
		query.append("		AM_ADVOGADO_PROCESSO ADVOGADO_PROCESSO ");
		query.append("LEFT JOIN ");
		query.append("		AM_ADVOGADO ADVOGADO ");
		query.append("ON ADVOGADO.CD_PESSOA_ADV = ADVOGADO_PROCESSO.CD_PESSOA_ADV ");
		query.append("LEFT JOIN ");
		query.append("		AM_PESSOA PESSOA ");
		query.append("ON ADVOGADO.CD_PESSOA_ADV = PESSOA.CD_PESSOA ");
		query.append("WHERE ADVOGADO_PROCESSO.NR_PROCESSO = ? ");
		
		List<AdvogadoProcesso> list = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(query.toString());
			psmt.setInt(1, numeroProcesso);
			rs = psmt.executeQuery();
			list = new ArrayList<AdvogadoProcesso>();
			while(rs.next()){
				AdvogadoProcesso ap = new AdvogadoProcesso();
				ap.getAdvogado().setCodigoPessoa(rs.getInt(1));
				ap.getProcesso().setNumeroProcesso(rs.getInt(2));
				ap.setDataInicioStr(UtilDate.convertDateToString(rs.getDate(3)));
				ap.getAdvogado().setNomePessoa(rs.getString(4));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, psmt, rs);
		}
		return list;
	}

	@Override
	public void cadastrarAdvogadosVinculados(AdvogadoProcesso advogadoProcesso, Integer codigoProcesso) {
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO ");
		query.append("		AM_ADVOGADO_PROCESSO ");
		query.append("		(NR_PROCESSO, CD_PESSOA_ADV, DT_INICIO_PARTICIPACAO) ");
		query.append("VALUES(?,?,?)");		
		
		PreparedStatement psmt = null;
		
		try {
			psmt = conn.prepareStatement(query.toString());
			psmt.setInt(1, codigoProcesso.intValue());
			psmt.setInt(2, advogadoProcesso.getAdvogado().getCodigoPessoa());
			psmt.setDate(3, new Date(UtilDate.convertStringToDate(advogadoProcesso.getDataInicioStr()).getTime()));
			
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, psmt);
		}
	}
	
	@Override
	public void removerAdvogadoVinculado(AdvogadoProcesso advogadoProcesso, Integer codigoProcesso) {
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		StringBuffer query = new StringBuffer();
		query.append("DELETE FROM ");
		query.append("	AM_ADVOGADO_PROCESSO ");
		query.append("WHERE ");
		query.append("	NR_PROCESSO = ? ");
		query.append("AND ");
		query.append("	CD_PESSOA_ADV = ?");		
		
		PreparedStatement psmt = null;
		
		try {
			psmt = conn.prepareStatement(query.toString());
			psmt.setInt(1, codigoProcesso.intValue());
			psmt.setInt(2, advogadoProcesso.getAdvogado().getCodigoPessoa());
			
			psmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, psmt);
		}
	}
}