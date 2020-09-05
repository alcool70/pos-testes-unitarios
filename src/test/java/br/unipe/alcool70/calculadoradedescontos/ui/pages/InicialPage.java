package br.unipe.alcool70.calculadoradedescontos.ui.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.firefox.FirefoxDriverLogLevel.FATAL;

public class InicialPage extends MyPageObject {

	@FindBy(id = Locators.ID_BTNCALCULARDESCONTO)
	WebElement botaoCalcularDesconto;
	@FindBy(id = Locators.ID_BTNAJUDA)
	WebElement botaoAjuda;
	@FindBy(id = Locators.ID_BTNCONTATO)
	WebElement botaoContato;

	void acessarCalculoDesconto() {
		clicar(botaoCalcularDesconto);
	}

	void acessarAjuda() {
		clicar(botaoAjuda);
	}

	public void acessePaginaContato() {
		clicar(botaoContato);
	}

	public void get(String url) {
		WebDriverManager.firefoxdriver().setup();

		FirefoxOptions opts = new FirefoxOptions().setLogLevel(FATAL);
		opts.setCapability("marionette", true);

		WebDriver drv = new FirefoxDriver(opts);
		setDriver(drv);
		getDriver().manage().window().maximize();
		getDriver().get(url);
	}
	public void acessePaginaListagemDeProdutos(){clicar(botaoCalcularDesconto);}

}
