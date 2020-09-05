package br.unipe.alcool70.calculadoradedescontos.ui.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.Normalizer;
import java.time.Duration;

import static org.awaitility.Awaitility.await;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyPageObject extends PageObject {

	private int tempoDeEspera = 10;

	public String extrairTextoDaPagina(WebElement element) {
		verificarPresenca(element);
		return element.getText();
	}

	public void submeterFormulario(WebElement element) {
		verificarPresenca(element);
		element.submit();
	}

	public void clicar(WebElement element) {
		verificarPresenca(element);
		element.click();
	}

	public void preencher(WebElement element, String nomeCompleto) {
		element.clear();
		element.sendKeys(nomeCompleto);
	}


	public void selecionarNoCombobox(WebElement select, String label) {
		Select combobox = new Select(select);
		combobox.selectByVisibleText(label);
	}



	public void verificarPresenca(WebElement element) {
		await()
				 .atMost(Duration.ofSeconds(tempoDeEspera))
				 .until(element::isDisplayed);
	}

	public String normalizar(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		return texto.replaceAll("[^\\p{ASCII}]", "");
	}

}
