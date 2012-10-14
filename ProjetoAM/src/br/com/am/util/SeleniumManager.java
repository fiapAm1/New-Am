package br.com.am.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

/**
 * @author dpoblete
 *
 */
public class SeleniumManager {

	SeleniumServer seleniumServer = null;
	static Selenium selenium = null;

	private String host;
	private String port;
	private String browser;
	private String url;
	
	public Selenium getSelenium() {
		return selenium;
	}
	
	public String getBrowser() {
		return browser;
	}
	
	public String getURL(){
		return url;
	}
	
	/**
	 * Abre,lê e seta as variaveis setadas no 
	 * arquivo selenium.properties
	 * @author dpoblete
	 */
	private void readProperties() {
		Properties props;
		props = new Properties();

		String filePath = "selenium.properties";

		try {
			props.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out
					.println("Nao foi possivel achar nenhum arquivo selenium.properties");
			e.printStackTrace();
		} catch (IOException e) {
			System.out
					.println("Erro ao carregar o arquivo selenium.properties");
			e.printStackTrace();
		}

		this.url = props.getProperty("url");
		this.browser = props.getProperty("browser", "*firefox");
		System.out.println("SETTING BROWSER as " + this.browser
				+ " during property file processing");
		this.host = props.getProperty("host", "localhost");
		this.port = props.getProperty("port", "4444");
	}

	private static final String SELENIUM_PORT = "selenium.port";
	private static final String SELENIUM_HOST = "selenium.host";
	private static final String SELENIUM_BROWSER = "selenium.browser";

	public void readSystemProperties() {
		Properties systemProperties = System.getProperties();

		if (systemProperties.containsKey(SELENIUM_BROWSER)) {
			this.browser = systemProperties.getProperty(SELENIUM_BROWSER);
			System.out.println("SETTING BROWSER as " + this.browser
					+ " during system property file processing");
		}

		if (systemProperties.containsKey(SELENIUM_HOST))
			this.host = systemProperties.getProperty(SELENIUM_HOST);

		if (systemProperties.containsKey(SELENIUM_PORT))
			this.port = systemProperties.getProperty(SELENIUM_PORT);
	}
	
	/**
	 * Inicia o servidor selenium
	 * @author dpoblete
	 */
	public void start() throws IOException {

		readProperties(); // pega as propriedades do arquivo
		readSystemProperties(); // allow system properties to override the
								// properties file
		
		//String para fechar o servidor selenium via broswer
		String shutdownCommand = "http://%s:%s/selenium-server/driver/?cmd=shutDownSeleniumServer";
		String stopSeleniumCommand = String.format(shutdownCommand, host, port);

		try {
			seleniumServer = new SeleniumServer();
			seleniumServer.start();
		} catch (java.net.BindException bE) {
	
			System.out.println("Não pode iniciar - fechando e continuando");
			
			if (runHTTPCommand(stopSeleniumCommand)) {
				try {
					seleniumServer = new SeleniumServer();
					seleniumServer.start();
				} catch (Exception e) {
					throw new IllegalStateException(
							"Servidor não pode ser parado, porta bloqueada "
									+ port, e);
				}
			}
		} catch (Exception e) {
			// Qualquer outra exception finaliza e start o servidor
			throw new IllegalStateException("Servidor Selenium nao pode ser Iniciado", e);
		}

		selenium = new DefaultSelenium(host, new Integer(port), browser,
				"http://");
		selenium.start();
	}

	private boolean runHTTPCommand(String theCommand) throws IOException {
		URL url = new URL(theCommand);

		URLConnection seleniumConnection = url.openConnection();
		seleniumConnection.connect();

		InputStream inputStream = seleniumConnection.getInputStream();
		ByteArrayOutputStream outputSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int streamLength;
		while ((streamLength = inputStream.read(buffer)) != -1) {
			outputSteam.write(buffer, 0, streamLength);
		}
		inputStream.close();

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String stringifiedOutput = outputSteam.toString();

		if (stringifiedOutput.startsWith("OK"))
			return true;

		return false;
	}

	/**
	 * Fecha o servidor Selenium 
	 * para finalizar a execução dos casos de teste 
	 * @author dpoblete
	 */
	public void stopServer() {

		if (selenium != null) {
			selenium.close();
			selenium.stop();
		}

		if (seleniumServer != null) {
			seleniumServer.stop();
		}
	}

}// END CLASS
