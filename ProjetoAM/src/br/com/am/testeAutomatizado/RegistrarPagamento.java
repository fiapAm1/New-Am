package br.com.am.testeAutomatizado;

import com.thoughtworks.selenium.Selenium;

public class RegistrarPagamento {

	Selenium selenium;
	
	public RegistrarPagamento (Selenium selenium){
		this.selenium = selenium;
	}
	
	public void registrar(String processo) throws Exception {
		selenium.click("link=Registrar Pagamento por Processo");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textfield_Codigo", processo);
		selenium.click("id=submit_Pesquisar");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img[alt=\"Efeturar Pagamento do Título\"]");
		selenium.waitForPageToLoad("30000");
	}
}
