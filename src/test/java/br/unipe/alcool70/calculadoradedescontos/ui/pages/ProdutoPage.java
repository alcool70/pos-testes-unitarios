package br.unipe.alcool70.calculadoradedescontos.ui.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPage extends MyPageObject {

	@FindBy( className = Locators.CLASS_PRODUTO)
	WebElement btproduto;
	@FindBy (id = Locators.ID_CLIENTE)
	WebElement tipocliente;
	@FindBy (name = Locators.ID_QUANTIDADE)
	WebElement inputItem;
	@FindBy (id = Locators.ID_BTCALCULAR)
	WebElement btcalcular;
	@FindBy (xpath = Locators.XPATH_MSG)
	WebElement descontomsg;
	@FindBy (xpath = Locators.XPATH_FATOR)
	WebElement fatorobtido;

	public void acesseProduto() {
		verificarPresenca(btproduto);
		clicar(btproduto);
	}

	public void informarTipoCliente(String cliente) {
		verificarPresenca(tipocliente);
		selecionarNoCombobox(tipocliente,cliente);

	}
	public void informarQtdItem(String quantidade ){
		verificarPresenca(inputItem);
		preencher(inputItem,quantidade );
	}

	public void calcularDesconto(){
		clicar(btcalcular);
	}
	public String getmsg(){
		return descontomsg.getText();
	}

	public String getfator(){
		return fatorobtido.getText();
	}

}
