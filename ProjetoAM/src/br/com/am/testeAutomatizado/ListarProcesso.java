package br.com.am.testeAutomatizado;

import com.thoughtworks.selenium.Selenium;

public class ListarProcesso {

	Selenium selenium;
	
	public ListarProcesso (Selenium selenium){
		this.selenium = selenium;
	}
	
	public void alterarProcesso(String processo) throws Exception {
		selenium.click("link=Listar Processos");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textfield_num_processo", processo);
		selenium.click("id=submit_Pesquisar");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img[alt=\"Atualizar este processo\"]");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textarea_Observacao", "teste");
		selenium.click("id=submit_Confirmar");
		selenium.waitForPageToLoad("30000");
		
		for (int second = 0;second < 10; second++) {
			try {
				if (selenium.isElementPresent("id=div_Mensagem")) {
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

	}

}
