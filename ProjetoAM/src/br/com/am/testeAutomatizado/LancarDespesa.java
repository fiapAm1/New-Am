package br.com.am.testeAutomatizado;

import com.thoughtworks.selenium.Selenium;

public class LancarDespesa {

	Selenium selenium;
	
	public LancarDespesa (Selenium selenium){
		this.selenium = selenium;
	}
	
	public void lancamento(String processo) throws Exception {
		selenium.click("link=Lançar Despesas por Processo");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textfield_Codigo", processo);
		selenium.click("id=submit_Pesquisar");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=select_TipoDespesa", "label=XEROX");
		selenium.type("id=textfield_Valor", "12");
		selenium.type("id=textarea_Observacao", "teste automatizado");
		selenium.click("id=submit_Incluir");
		selenium.waitForPageToLoad("30000");
	}
}
