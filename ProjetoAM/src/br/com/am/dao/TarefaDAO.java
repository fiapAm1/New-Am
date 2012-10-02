package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.TarefaDAOInterface;
import br.com.am.model.Tarefa;


public class TarefaDAO implements TarefaDAOInterface{

	@Override
	public List<Tarefa> consultarTarefas() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_TAREFA, DS_TAREFA FROM AM_TAREFA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tarefa tarefa = null;
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tarefa = new Tarefa();
				
				tarefa.setCodigo(rs.getInt("CD_TAREFA"));
				tarefa.setTarefa(rs.getString("DS_TAREFA"));
				
				tarefas.add(tarefa);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return tarefas;
	}

}
