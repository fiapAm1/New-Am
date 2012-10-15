package br.com.am.dao.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public class ConnectionFactory {

	public static Connection getConnectionOracle() {

		Connection conn = null;

		try {
			//INSTALAÇÃO DO DRIVER
			Class.forName("oracle.jdbc.driver.OracleDriver");


			//CONEXÃO
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AM", "am");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn, PreparedStatement psmt){
		close(conn);
		if(psmt != null){
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn, PreparedStatement psmt, ResultSet rs){
		close(conn, psmt);
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
