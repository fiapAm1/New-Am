package br.com.am.teste;

import java.util.HashMap;
import java.util.Map;

import br.com.am.action.enuns.ResultadoEnum;
import br.com.am.bo.ProcessoBO;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String, Integer> contagemPorProcessoStatus = new HashMap<String, Integer>();
		
		int contagemProcessoAndamento;
		int contagemProcessoPerdido;
		int contagemProcessoGanho;
		
		contagemPorProcessoStatus.putAll(ProcessoBO.contagemProcessosPorResultado());
		
		contagemProcessoAndamento = contagemPorProcessoStatus.get(ResultadoEnum.ANDAMENTO.getDescricao()).intValue();
		contagemProcessoGanho = contagemPorProcessoStatus.get(ResultadoEnum.GANHA.getDescricao()).intValue();
		contagemProcessoPerdido = contagemPorProcessoStatus.get(ResultadoEnum.PERDIDA.getDescricao()).intValue();
		
		System.out.println(contagemProcessoAndamento);
		System.out.println(contagemProcessoGanho);
		System.out.println(contagemProcessoPerdido);
		
	}

}
