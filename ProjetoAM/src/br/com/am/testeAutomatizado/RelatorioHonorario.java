package br.com.am.testeAutomatizado;

import com.thoughtworks.selenium.Selenium;

public class RelatorioHonorario {

	Selenium selenium;
	
	public RelatorioHonorario (Selenium selenium){
		this.selenium = selenium;
	}
	
	public void pesquisarH(String processo) throws Exception {
		selenium.click("link=Honor�rio");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=select_Tarefa", "label=AUDI�NCIA");
		selenium.type("id=textfield_Codigo", processo);
		selenium.click("id=submit_Pesquisar");
		selenium.waitForPageToLoad("30000");
	}
}
