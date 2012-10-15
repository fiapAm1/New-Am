package br.com.am.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.am.bo.ProcessoBO;
import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.ProcessoDAOInterface;
import br.com.am.model.Cliente;
import br.com.am.model.Forum;
import br.com.am.model.Processo;
import br.com.am.model.TipoCausa;
import br.com.am.model.TipoCobranca;
import br.com.am.util.UtilDate;


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
				processo.setDataAberturaStr(UtilDate.convertDateToString(rs.getDate("DT_ABERTURA")));
				if(rs.getDate("DT_FECHAMENTO") != null){
					processo.setDataFechamentoStr(UtilDate.convertDateToString(rs.getDate("DT_FECHAMENTO")));
				}
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				if(rs.getDate("CD_RESULTADO") != null){
					processo.setResultado(rs.getInt("CD_RESULTADO"));
				}
				if(rs.getString("DS_OBSERVACAO") != null){
					processo.setObservacao(rs.getString("DS_OBSERVACAO"));
				}
				
				processos.add(processo);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e){
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
				     " DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO " +
				     "FROM AM_PROCESSO WHERE NR_PROCESSO = ?";
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
				processo.setDataAberturaStr(UtilDate.convertDateToString(rs.getDate("DT_ABERTURA")));
				if(rs.getDate("DT_FECHAMENTO") != null){
					processo.setDataFechamentoStr(UtilDate.convertDateToString(rs.getDate("DT_FECHAMENTO")));
				}
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				if(((Integer)rs.getInt("CD_RESULTADO")) != null){
					processo.setResultado(rs.getInt("CD_RESULTADO"));
				}
				if(rs.getString("DS_OBSERVACAO") != null){
					processo.setObservacao(rs.getString("DS_OBSERVACAO"));
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return processo;
	}

	@Override
	public Integer cadastrarProcesso(Processo processo) {

		Connection conn = ConnectionFactory.getConnectionOracle();
		
		StringBuffer query = new StringBuffer();
		query.append("BEGIN ");
		query.append("INSERT INTO AM_PROCESSO ");
		query.append("(CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, "); 
		query.append(" CD_COBRANCA, DS_PROCESSO, DT_ABERTURA, "); 
        query.append(" DT_FECHAMENTO, DD_DIA_VENCIMENTO, CD_RESULTADO, ");
        query.append(" DS_OBSERVACAO) ");
        query.append("VALUES (?,?,?,?,?,?,?,?,?,?) "); 
        query.append("RETURNING NR_PROCESSO INTO ?; "); 
        query.append("END;");
        CallableStatement ctmt = null;
        Integer codigoProcesso = 0;
		
		try{
			ctmt = conn.prepareCall(query.toString());
			
			ctmt.setInt(1, processo.getForum().getCodigoPessoa());
			ctmt.setInt(2, processo.getCliente().getCodigoPessoa());
			ctmt.setInt(3, processo.getCausa().getCodigoCausa());
			ctmt.setInt(4, processo.getCobranca().getCodigoCobranca());
			ctmt.setString(5, processo.getProcesso());
			ctmt.setDate(6, new Date(UtilDate.convertStringToDate(processo.getDataAberturaStr()).getTime()));
			if(!"".equals(processo.getDataFechamentoStr()) && processo.getDataFechamentoStr() != null){
				ctmt.setDate(7, new Date(UtilDate.convertStringToDate(processo.getDataFechamentoStr()).getTime()));
			} else {
				ctmt.setNull(7, Types.DATE);
			}
			ctmt.setInt(8, processo.getDiaVencimento());
			if(processo.getResultado() != null){
				ctmt.setInt(9, processo.getResultado().intValue());
			} else {
				ctmt.setNull(9, Types.INTEGER);
			}
			if(processo.getObservacao() != null){
				ctmt.setString(10, processo.getObservacao().toString());
			} else {
				ctmt.setNull(10, Types.VARCHAR);
			}
			ctmt.registerOutParameter(11, Types.INTEGER);
			
			ctmt.executeUpdate();
			
			codigoProcesso = ctmt.getInt(11);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ctmt);
		}
		return codigoProcesso;
	}

	@Override
	public List<Processo> consultarProcessos(String nomeCliente, int codigoCausa) {
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT NR_PROCESSO,  CD_PESSOA_FORUM,  p.CD_PESSOA_CLIENTE,  CD_CAUSA,  CD_COBRANCA,  DS_PROCESSO,  DT_ABERTURA, " +
					 "DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO " +
					 "FROM AM_PROCESSO p " +
				     "LEFT JOIN AM_CLIENTE cli ON cli.CD_PESSOA_CLIENTE = p.CD_PESSOA_CLIENTE " +
				     "LEFT JOIN AM_PESSOA pes ON pes.CD_PESSOA = cli.CD_PESSOA_CLIENTE " +
				     "WHERE NM_PESSOA LIKE ? " +
				     "AND CD_CAUSA = ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Processo processo = null;
		List<Processo> processos = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + nomeCliente.toUpperCase() + "%");
			ps.setInt(2, codigoCausa);
			
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
				processo.setDataAberturaStr(UtilDate.convertDateToString(rs.getDate("DT_ABERTURA")));
				if(rs.getDate("DT_FECHAMENTO") != null){
					processo.setDataFechamentoStr(UtilDate.convertDateToString(rs.getDate("DT_FECHAMENTO")));
				}
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				if(((Integer)rs.getInt("CD_RESULTADO")) != null){
					processo.setResultado(rs.getInt("CD_RESULTADO"));
				}
				if(rs.getString("DS_OBSERVACAO") != null){
					processo.setObservacao(rs.getString("DS_OBSERVACAO"));
				}
				
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
	public List<Processo> consultarProcessos(String nomeCliente) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT NR_PROCESSO,  CD_PESSOA_FORUM,  p.CD_PESSOA_CLIENTE,  CD_CAUSA,  CD_COBRANCA,  DS_PROCESSO,  DT_ABERTURA, " +
					 "DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO " +
					 "FROM AM_PROCESSO p " +	
				     "LEFT JOIN AM_CLIENTE cli ON cli.CD_PESSOA_CLIENTE = p.CD_PESSOA_CLIENTE " +
				     "LEFT JOIN AM_PESSOA pes ON pes.CD_PESSOA = cli.CD_PESSOA_CLIENTE " +
				     "WHERE NM_PESSOA LIKE ? ";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Processo processo = null;
		List<Processo> processos = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + nomeCliente.toUpperCase() + "%");
			
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
				processo.setDataAberturaStr(UtilDate.convertDateToString(rs.getDate("DT_ABERTURA")));
				if(rs.getDate("DT_FECHAMENTO") != null){
					processo.setDataFechamentoStr(UtilDate.convertDateToString(rs.getDate("DT_FECHAMENTO")));
				}
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				if(((Integer)rs.getInt("CD_RESULTADO")) != null){
					processo.setResultado(rs.getInt("CD_RESULTADO"));
				}
				if(rs.getString("DS_OBSERVACAO") != null){
					processo.setObservacao(rs.getString("DS_OBSERVACAO"));
				}
				
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
	public List<Processo> consultarProcessos(int codigoCausa) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT NR_PROCESSO,  CD_PESSOA_FORUM,  p.CD_PESSOA_CLIENTE,  CD_CAUSA,  CD_COBRANCA,  DS_PROCESSO,  DT_ABERTURA, " +
					 " DT_FECHAMENTO,  DD_DIA_VENCIMENTO,  CD_RESULTADO,  DS_OBSERVACAO " +
					 "FROM AM_PROCESSO p " +
				     "LEFT JOIN AM_CLIENTE cli ON cli.CD_PESSOA_CLIENTE = p.CD_PESSOA_CLIENTE " +
				     "LEFT JOIN AM_PESSOA pes ON pes.CD_PESSOA = cli.CD_PESSOA_CLIENTE " +
				     "WHERE CD_CAUSA = ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Processo processo = null;
		List<Processo> processos = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoCausa);
			
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
				processo.setDataAberturaStr(UtilDate.convertDateToString(rs.getDate("DT_ABERTURA")));
				if(rs.getDate("DT_FECHAMENTO") != null){
					processo.setDataFechamentoStr(UtilDate.convertDateToString(rs.getDate("DT_FECHAMENTO")));
				}
				processo.setDiaVencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				if(((Integer)rs.getInt("CD_RESULTADO")) != null){
					processo.setResultado(rs.getInt("CD_RESULTADO"));
				}
				if(rs.getString("DS_OBSERVACAO") != null){
					processo.setObservacao(rs.getString("DS_OBSERVACAO"));
				}
				
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
	public void alterarProcesso(Processo processo) {
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		StringBuffer query = new StringBuffer();
		query.append("UPDATE AM_PROCESSO ");
		query.append("SET DS_PROCESSO = ?,  DT_FECHAMENTO = ?, "); 
        query.append(" CD_RESULTADO = ?, DS_OBSERVACAO = ? ");
        query.append(" WHERE  NR_PROCESSO = ?");
        PreparedStatement psmt = null;
		
		try{
			psmt = conn.prepareCall(query.toString());
			
			psmt.setString(1, processo.getProcesso());
			if(!"".equals(processo.getDataFechamentoStr()) && processo.getDataFechamentoStr() != null){
				psmt.setDate(2, new Date(UtilDate.convertStringToDate(processo.getDataFechamentoStr()).getTime()));
			} else {
				psmt.setNull(2, Types.DATE);
			}
			if(processo.getResultado() != null &&  0 != processo.getResultado().intValue()){
				psmt.setInt(3, processo.getResultado().intValue());
			} else {
				psmt.setNull(3, Types.INTEGER);
			}
			if(processo.getObservacao() != null){
				psmt.setString(4, processo.getObservacao().toString());
			} else {
				psmt.setNull(4, Types.VARCHAR);
			}
			psmt.setInt(5, processo.getNumeroProcesso());
			
			psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, psmt);
		}
	}

	@Override
	public Map<String, Integer> ContagemProcessosPorCausa() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT COUNT(*) AS CONTAGEM, DS_CAUSA " +
					 "FROM AM_PROCESSO p " +
				     "LEFT JOIN AM_TIPO_CAUSA tc ON TC.CD_CAUSA = P.CD_CAUSA " +
				     "GROUP BY DS_CAUSA " +
				     "ORDER BY 1 DESC ";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Integer> contagemPorCausa = new HashMap<String, Integer>();
		
		try{
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String causa = rs.getString("DS_CAUSA");
				Integer contagem = rs.getInt("CONTAGEM");
				
				contagemPorCausa.put(causa, contagem);	
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return contagemPorCausa;
	}

	@Override
	public Map<String, Integer> ContagemProcessosPorResultado()  {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT COUNT(*) AS CONTAGEM, CD_RESULTADO " +
					 "FROM AM_PROCESSO p " +
				     "GROUP BY CD_RESULTADO ";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Integer> contagemPorResultado = new HashMap<String, Integer>();
		
		try{
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int resultado = rs.getInt("CD_RESULTADO");
				String resultadoStr = "";
				
				if(resultado == 0)
					resultadoStr = "ANDAMENTO";
				else if(resultado == 1)
					resultadoStr = "PERDIDA";
				else if(resultado == 2)
					resultadoStr = "GANHA";
					
				Integer contagem = rs.getInt("CONTAGEM");
				
				contagemPorResultado.put(resultadoStr, contagem);	
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		return contagemPorResultado;
	}
}