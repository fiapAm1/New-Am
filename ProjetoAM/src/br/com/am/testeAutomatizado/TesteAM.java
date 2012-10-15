package br.com.am.testeAutomatizado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.am.util.SeleniumManager;

import com.thoughtworks.selenium.Selenium;

public class TesteAM {

	//Instanciando Selenium
	SeleniumManager sm = null;
	Selenium selenium = null;
	String url = null;

	//Abrindo o Selenium RC
	@Before
	public void setUp() throws Exception {
		sm = new SeleniumManager();
		sm.start();
		selenium = sm.getSelenium();
		url = sm.getURL();
	}

	//Stop Selenium Server
	@After
	public void tearDown() throws Exception {
		sm.stopServer();
	}

	
	// Testes automatizados
	@Test
	public void test() throws Exception {
		
		
		OpenHomePage openHome = new OpenHomePage(selenium);
		CadastrarProcesso cadastrar = new CadastrarProcesso(selenium);
		ListarProcesso alterar = new ListarProcesso(selenium);
		//RegistrarPagamento registro = new RegistrarPagamento(selenium);
		LancarDespesa lancar = new LancarDespesa(selenium);
		RelatorioHonorario pesquisarH = new RelatorioHonorario(selenium);
		RelatorioAudiencia pesquisarA = new RelatorioAudiencia(selenium);
		
		// Abrir página
		openHome.openHomePage(url);
		// Realizar cadastro
		cadastrar.cadastrar();
		// Alterar processo
		alterar.alterarProcesso("1");
		//registro.registrar("1");
		// Lançar despesa
		lancar.lancamento("1");
		//Pesquisa Honorário
		pesquisarH.pesquisarH("1");
		
		//Pesquisa Honorário
		pesquisarA.pesquisarA("1");
				
		
	}

	
}
