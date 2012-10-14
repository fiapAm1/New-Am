package br.com.am.testeAutomatizado;

import com.thoughtworks.selenium.Selenium;

public class RelatorioAudiencia {

	Selenium selenium;
	
	public RelatorioAudiencia (Selenium selenium){
		this.selenium = selenium;
	}
	
	public void pesquisarA(String processo) throws Exception {
		selenium.click("link=Audiência");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textfield_Codigo", "1");
		selenium.click("id=submit_Pesquisar");
		selenium.waitForPageToLoad("30000");
	}
}
