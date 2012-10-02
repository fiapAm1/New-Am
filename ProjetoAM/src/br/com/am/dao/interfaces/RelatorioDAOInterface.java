/**
 * 
 */
package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.RelatorioAudiencia;
import br.com.am.model.RelatorioHonorario;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public interface RelatorioDAOInterface {
	
	public List<RelatorioAudiencia> relatorioAudiencia(int numeroProcesso);
	
	public List<RelatorioHonorario> relatorioHonorario(int numeroProcesso, int codigoTarefa);

}
