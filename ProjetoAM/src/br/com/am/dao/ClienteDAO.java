package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.ClienteDAOInterface;
import br.com.am.model.Cliente;


/**
 * ClienteDAO mapeia os dados da tabela AM_CLIENTE da base de dados.
 * 
 * @author Rodrigo Joubert<br>
 * Turma:   1TDSR<br>
 * Ano:    2012<br>
 */
public class ClienteDAO implements ClienteDAOInterface {

	@Override
	public List<Cliente> consultarClientes() {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_PESSOA_CLIENTE, NM_RAZAO_SOCIAL, NR_CNPJ, NR_INSC_ESTADUAL, DS_EMAIL, DS_PASSWORD FROM AM_CLIENTE";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				cliente = new Cliente();
				cliente.setCodigoPessoa(rs.getInt("CD_PESSOA_CLIENTE"));
				cliente.setCnpj(rs.getLong("NR_CNPJ"));
				cliente.setRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
				cliente.setEmail(rs.getString("DS_EMAIL"));
				cliente.setPassword(rs.getString("DS_PASSWORD"));
				cliente.setInscEstadual(rs.getLong("NR_INSC_ESTADUAL"));
				
				clientes.add(cliente);
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return clientes;
	}

	@Override
	public Cliente consultarCliente(int codigoCliente) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT CD_PESSOA_CLIENTE, NM_RAZAO_SOCIAL, NR_CNPJ, NR_INSC_ESTADUAL, DS_EMAIL, DS_PASSWORD FROM AM_CLIENTE WHERE CD_PESSOA_CLIENTE = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, codigoCliente);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				cliente = new Cliente();
				cliente.setCodigoPessoa(rs.getInt("CD_PESSOA_CLIENTE"));
				cliente.setCnpj(rs.getLong("NR_CNPJ"));
				cliente.setRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
				cliente.setEmail(rs.getString("DS_EMAIL"));
				cliente.setPassword(rs.getString("DS_PASSWORD"));
				cliente.setInscEstadual(rs.getLong("NR_INSC_ESTADUAL"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return cliente; 
	}

}
