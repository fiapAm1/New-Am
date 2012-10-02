package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Cliente;

/**
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public interface ClienteDAOInterface {
	
	/**
	 * Busca todos os clientes existentes na tabela AM_CLIENTE
	 * @return List<Cliente>
	 */
	public List<Cliente> consultarClientes();
	
	/**
	 * Busca um cliente específico através do código do cliente fornecido
	 * @param codigoCliente
	 * @return Cliente
	 */
	public Cliente consultarCliente(int codigoCliente);

}
