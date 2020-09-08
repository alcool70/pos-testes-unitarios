package br.unipe.alcool70.calculadoradedescontos.ui.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class InicialPage extends MyPageObject {

	@FindBy(id = Locators.ID_BTNCALCULARDESCONTO)
	WebElement botaoCalcularDesconto;
	@FindBy(id = Locators.ID_BTNAJUDA)
	WebElement botaoAjuda;
	@FindBy(id = Locators.ID_BTNCONTATO)
	WebElement botaoContato;

	public void acessarCalculoDesconto() {
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

		FirefoxOptions opts = new FirefoxOptions();
		opts.setLogLevel(FirefoxDriverLogLevel.FATAL);
		opts.setCapability("marionette", true);

		WebDriver drv = new FirefoxDriver(opts);
		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drv.manage().window().maximize();
		drv.get(url);
		setDriver(drv);
	}

}
