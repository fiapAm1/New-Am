package br.com.am.teste;

import java.util.List;

import br.com.am.bo.TituloBO;
import br.com.am.model.Titulo;
import br.com.am.model.TituloPago;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<TituloPago> t = TituloBO.consultarTitulosPagosPorProcesso(1);
		
		for (TituloPago titulo : t) {
			
			System.out.println(titulo.getTitulo().getNumeroTitulo());
			System.out.println(titulo.getDataPagamento());
			System.out.println(titulo.getValorPago());
			System.out.println();
			
		}
		
	}

}
