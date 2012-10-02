/**
 * 
 */
package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Titulo;
import br.com.am.model.TituloPago;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public interface TituloPagoDAOInterface {
	
	public void registrarTituloPago(Titulo titulo);
	
	public List<TituloPago> consultarTitulosPagosPorProcesso(int numeroProcesso);

}
