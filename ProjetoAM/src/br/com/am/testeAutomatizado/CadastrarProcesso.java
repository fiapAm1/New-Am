package br.com.am.testeAutomatizado;

import com.thoughtworks.selenium.Selenium;

public class CadastrarProcesso {

	Selenium selenium;
	
	public CadastrarProcesso (Selenium selenium){
		this.selenium = selenium;
	}
	
	public void cadastrar () {
	selenium.click("link=Cadastrar Processo");
	selenium.waitForPageToLoad("30000");
	selenium.type("id=textarea_Descricao", "Teste Automatizado");
	selenium.select("id=select_Cliente", "label=GOOGLE");
	selenium.select("id=select_Advogado", "label=MARIA FLORES");
	selenium.select("id=select_TipoCausa", "label=COMERCIAL");
	selenium.select("id=select_Forum", "label=FORUMSAÚDE");
	selenium.click("id=textfield_DataInclusao");
	selenium.click("link=13");
	selenium.click("id=button_Adicionar");
	selenium.click("id=textfield_DataAbertura");
	selenium.click("link=13");
	selenium.click("id=textfield_DataFechamento");
	selenium.click("id=select_TipoCobranca");
	selenium.select("id=select_TipoCobranca", "label=MENSAL");
	selenium.click("css=option[value=\"22\"]");
	selenium.select("id=select_DiaVencimento", "label=16");
	selenium.type("id=textarea_Observacao", "teste automatizado");
	selenium.click("id=submit_Confirmar");
	selenium.waitForPageToLoad("30000");
	}
}
