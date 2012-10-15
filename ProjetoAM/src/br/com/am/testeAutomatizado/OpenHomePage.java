package br.com.am.testeAutomatizado;


import com.thoughtworks.selenium.Selenium;

public class OpenHomePage {
	
	Selenium selenium;
	
	public OpenHomePage (Selenium selenium) {
		this.selenium = selenium;
	}

	public void openHomePage(String url) {
		selenium.open(url);
		selenium.waitForPageToLoad("10000");
		selenium.windowMaximize();
	}
}

