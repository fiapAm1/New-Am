package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.bo.ProcessoBO;
import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.ProcessoDAOInterface;
import br.com.am.model.Cliente;
import br.com.am.model.Forum;
import br.com.am.model.Processo;
import br.com.am.model.TipoCausa;
import br.com.am.model.TipoCobranca;


public class ProcessoDAO implements ProcessoDAOInterface{

	@Override
	public List<Processo> consultarProcessosEmAndamento() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT NR_PROCESSO,  CD_PESSOA_FORUM,  CD_PESSOA_CLIENTE,  CD_CAUSA,  CD_COBRANCA,  DS_PROCESSO,  DT_ABERTURA, " +
				" DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO FROM AM_PROCESSO WHERE DT_FECHAMENTO IS NULL"; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		Processo processo = null;
		List<Processo> processos = new ArrayList<Processo>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				processo = new Processo();
				processo.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				
				Forum forum = ProcessoBO.consultarForum(rs.getInt("CD_PESSOA_FORUM"));
				processo.setForum(forum);
				
				Cliente cliente = ProcessoBO.consultarCliente(rs.getInt("CD_PESSOA_CLIENTE"));
				processo.setCliente(cliente);
				
				TipoCausa causa = ProcessoBO.consultarTipoCausa(rs.getInt("CD_CAUSA"));
				processo.setCausa(causa);
				
				TipoCobranca cobranca = ProcessoBO.consultarTipoCobranca(rs.getInt("CD_COBRANCA"));
				processo.setCobranca(cobranca);
				
				processo.setProcesso(rs.getString("DS_PROCESSO"));
				processo.setDataAbertura(rs.getDate("DT_ABERTURA"));
				processo.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				processo.setResultado(rs.getInt("CD_RESULTADO"));
				processo.setObservacao(rs.getString("DS_OBSERVACAO"));
				
				processos.add(processo);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return processos;
	}

	@Override
	public Processo consultarProcesso(int numeroProcesso) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT NR_PROCESSO,  CD_PESSOA_FORUM,  CD_PESSOA_CLIENTE,  CD_CAUSA,  CD_COBRANCA,  DS_PROCESSO,  DT_ABERTURA, " +
				     " DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO FROM AM_PROCESSO WHERE NR_PROCESSO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Processo processo = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroProcesso);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				processo = new Processo();
				processo.setNumeroProcesso(rs.getInt("NR_PROCESSO"));
				
				Forum forum = ProcessoBO.consultarForum(rs.getInt("CD_PESSOA_FORUM"));
				processo.setForum(forum);
				
				Cliente cliente = ProcessoBO.consultarCliente(rs.getInt("CD_PESSOA_CLIENTE"));
				processo.setCliente(cliente);
				
				TipoCausa causa = ProcessoBO.consultarTipoCausa(rs.getInt("CD_CAUSA"));
				processo.setCausa(causa);
				
				TipoCobranca cobranca = ProcessoBO.consultarTipoCobranca(rs.getInt("CD_COBRANCA"));
				processo.setCobranca(cobranca);
				
				processo.setProcesso(rs.getString("DS_PROCESSO"));
				processo.setDataAbertura(rs.getDate("DT_ABERTURA"));
				processo.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				processo.setResultado(rs.getInt("CD_RESULTADO"));
				processo.setObservacao(rs.getString("DS_OBSERVACAO"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return processo;
	}

	@Override
	public void cadastrarProcesso(Processo processo) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "INSERT INTO AM_PROCESSO (CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO, " + 
					 "DT_ABERTURA, DD_DIA_VENCIMENTO, DS_OBSERVACAO) VALUES (?,?,?,?,?,?,?,?)";	
		PreparedStatement ps = null;
		
		try{
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, processo.getForum().getCodigoPessoa());
			ps.setInt(2, processo.getCliente().getCodigoPessoa());
			ps.setInt(3, processo.getCausa().getCodigoCausa());
			ps.setInt(4, processo.getCobranca().getCodigoCobranca());
			ps.setString(5, processo.getProcesso());
			ps.setDate(6, new java.sql.Date(processo.getDataAbertura().getTime()));
			ps.setInt(7, processo.getDiaVencimento());
			ps.setString(8, processo.getObservacao());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps);
		}
		
		
	}

}
