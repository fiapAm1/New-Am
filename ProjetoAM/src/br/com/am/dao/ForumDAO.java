package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.ForumDAOInterface;
import br.com.am.model.Forum;


/**
 * ForumDAO mapeia os dados da tabela AM_FORUM da base de dados.
 * 
 * @author Rodrigo Joubert<br>
 * Turma:   1TDSR<br>
 * Ano:    2012<br>
 *
 */
public class ForumDAO implements ForumDAOInterface{
	
	
	/**
	 * 
	 */
	public List<Forum> consultarForuns() {
		
		// CONEXÃO
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//COMUNICAÇÃO
		String sql = "SELECT CD_PESSOA_FORUM, DS_FORUM FROM AM_FORUM";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Forum forum = null;
		List<Forum> foruns = new ArrayList<Forum>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				forum = new Forum();
				forum.setCodigoPessoa(rs.getInt("CD_PESSOA_FORUM"));
				forum.setDescricaoForum(rs.getString("DS_FORUM"));
				
				foruns.add(forum);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return foruns;
	}
	
	/**
	 * 
	 */
	public Forum consultarForum(int codigoForum) {
		
		// CONEXÃO
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//COMUNICAÇÃO
		String sql = "SELECT CD_PESSOA_FORUM, DS_FORUM FROM AM_FORUM WHERE CD_PESSOA_FORUM = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Forum forum = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, codigoForum);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				forum = new Forum();
				forum.setCodigoPessoa(rs.getInt("CD_PESSOA_FORUM"));
				forum.setDescricaoForum(rs.getString("DS_FORUM"));
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return forum;
		
	}

}
