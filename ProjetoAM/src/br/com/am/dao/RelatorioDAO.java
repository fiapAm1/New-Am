package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.RelatorioDAOInterface;
import br.com.am.model.RelatorioAudiencia;
import br.com.am.model.RelatorioHonorario;


public class RelatorioDAO implements RelatorioDAOInterface{

	@Override
	public List<RelatorioAudiencia> relatorioAudiencia(int numeroProcesso) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT agenda.DT_HORA_AGENDA AS DATA, pessoa_forum.NM_PESSOA AS FORUM, endereco.NM_LOGRADOURO AS ENDERECO_FORUM, " +
					 "pe_endereco.NR_ENDERECO AS NUMERO_FORUM, agenda.SL_FORUM AS SALA, pessoa.NM_PESSOA AS ADVOGADO " +
					 "FROM AM_AGENDA_AUDIENCIA agenda " +
					 "LEFT JOIN AM_PESSOA pessoa ON pessoa.CD_PESSOA = agenda.CD_PESSOA_ADV " +
					 "LEFT JOIN AM_PROCESSO processo ON processo.NR_PROCESSO = agenda.NR_PROCESSO " +
					 "LEFT JOIN AM_PESSOA pessoa_forum ON pessoa_forum.CD_PESSOA = processo.CD_PESSOA_FORUM " +
					 "LEFT JOIN AM_PESSOA_ENDERECO pe_endereco ON pe_endereco.CD_PESSOA = pessoa_forum.CD_PESSOA " +
					 "LEFT JOIN AM_ENDERECO endereco ON endereco.CD_ENDERECO = pe_endereco.CD_ENDERECO " +
					 "WHERE processo.NR_PROCESSO = ? " +
					 "ORDER BY agenda.DT_HORA_AGENDA DESC ";
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		RelatorioAudiencia relatorio = null;
		List<RelatorioAudiencia> relatorios = new ArrayList<RelatorioAudiencia>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroProcesso);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				relatorio = new RelatorioAudiencia();
				
				relatorio.setDataAudiencia(rs.getDate("DATA"));
				relatorio.setForum(rs.getString("FORUM"));
				relatorio.setSala(rs.getInt("SALA"));
				relatorio.setLogradouro(rs.getString("ENDERECO_FORUM"));
				relatorio.setNumeroEndereco(rs.getInt("NUMERO_FORUM"));
				relatorio.setNomeAdvogado(rs.getString("ADVOGADO"));
				
				relatorios.add(relatorio);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return relatorios;
		
		
	}

	@Override
	public List<RelatorioHonorario> relatorioHonorario(int numeroProcesso, int codigoTarefa) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT adv_honorario.DT_HONORARIO AS DATA, pessoa.NM_PESSOA AS ADVOGADO, " +
					 "SUM(adv_hora.VL_HORA * adv_honorario.QT_HORAS) AS VALOR_TAREFA " +
				     "FROM AM_ADVOGADO_HONORARIO adv_honorario " +
					 "LEFT JOIN AM_PESSOA pessoa ON pessoa.CD_PESSOA = adv_honorario.CD_PESSOA_ADV " +
				     "LEFT JOIN AM_HORA_ADVOGADO adv_hora ON adv_hora.CD_PESSOA_ADV = adv_honorario.CD_PESSOA_ADV " +
					 "LEFT JOIN AM_ADVOGADO_PROCESSO adv_processo ON adv_processo.CD_PESSOA_ADV = adv_honorario.CD_PESSOA_ADV " +
				     "LEFT JOIN AM_PROCESSO processo ON processo.NR_PROCESSO = adv_processo.NR_PROCESSO " +
					 "LEFT JOIN AM_TAREFA tarefa ON tarefa.CD_TAREFA = adv_honorario.CD_TAREFA " +
				     "WHERE processo.NR_PROCESSO = ? " +
					 "AND tarefa.CD_TAREFA = ? " +
				     "GROUP BY adv_honorario.DT_HONORARIO, pessoa.NM_PESSOA " +
				     "ORDER BY 1 DESC ";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		RelatorioHonorario relatorio = null;
		List<RelatorioHonorario> relatorios = new ArrayList<RelatorioHonorario>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroProcesso);
			ps.setInt(2, codigoTarefa);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				relatorio = new RelatorioHonorario();
				
				relatorio.setDataHonorario(rs.getDate("DATA"));
				relatorio.setNomeAdvogado(rs.getString("ADVOGADO"));
				relatorio.setValorTarefa(rs.getDouble("VALOR_TAREFA"));
				
				relatorios.add(relatorio);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return relatorios;
	}

}
