package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Despesa;

public interface DespesaDAOInterface {
	
	public List<Despesa> consultarDespesas();
	
	public List<Despesa> consultarDespesasPorProcesso(int numeroProcesso);
	
	public Despesa consultarDespesa(int codigoLancamento);
	
	public void lancarDespesa(Despesa despesa);
	
	public double somarDespesaPorProcesso (int codigoProcesso);
	
	public void atualizarDespesa (Despesa despesa);
	
	public void deletarDespesa (int codigoDespesa);

}
