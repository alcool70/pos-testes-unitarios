package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormularioCalculoDoDescontoParaProdutoPage extends MyPageObject{

	@FindBy(id = Locators.ID_BTNCALCULARDESCONTO)
	WebElement botaoCalcularDesconto;
	@FindBy(xpath = Locators.XPATH_TOASTMSG)
	WebElement toastMsg;
	@FindBy(css = Locators.ID_SELECT_TIPOCLIENTE)
	WebElement tipoCliente;
	@FindBy(id = Locators.ID_QUANTIDADEPRODUTO)
	WebElement quantidadeProduto;
	@FindBy(id = Locators.XPATH_SELECIONARPRODUTO)
	WebElement selecionarProduto;


    public void solicitarTipoCliente(String Cliente) {
	    verificarPresenca(tipoCliente);
	    selecionarNoCombobox(tipoCliente, Cliente);
    }

    public void solicitarQuantidadeProduto(String quantidade) {
	    verificarPresenca(quantidadeProduto);
	    preencher(quantidadeProduto,quantidade);

    }

    public void submeta_calcular_desconto() {
	    submeterFormularioDesconto(botaoCalcularDesconto);
    }
    public void selecionarProduto(){
    	clicar(selecionarProduto);
    }

    public Object getToastMsg() {
        return toastMsg.getText();
    }


}
