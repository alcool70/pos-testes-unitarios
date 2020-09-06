package br.unipe.alcool70.calculadoradedescontos.ui.pages;

import br.unipe.alcool70.calculadoradedescontos.ui.steps.SharedSteps;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


//@FindBy(id = Locators.QUANTIDADE_PRODUTO_2000)WebElement inputEmail;
//@FindBy(css = Locators.#####) WebElement selectFaixaIdade;
//@FindBy(xpath = Locators.ID_PRODUTO_01) WebElement toastMsg;

public class FormularioCalculoDoDescontoParaProdutoPage extends MyPageObject {
	@FindBy (id = Locators.CSS_TIPO_CLIENTE)
	WebElement selectTipoCliente;
	@FindBy(id = Locators.QUANTIDADE_PRODUTO)
	WebElement quantidadeProduto;
	@FindBy(id = Locators.ID_BTNSUBMETERCALCULODESCONTO)
	WebElement calculardescontoButtonCalcular;
	@FindBy(xpath = Locators.XPATH_TOASTMSG)
	WebElement toastMsg;

    public SharedSteps page;

    public void solicitarTipoCliente(String tipoCliente) {
		    verificarPresenca(selectTipoCliente);
		    selecionarNoCombobox(selectTipoCliente, tipoCliente);

    }

    public void solicitarQuantidadeProduto(String quantidade) {
	    verificarPresenca(quantidadeProduto);
	    preencher(quantidadeProduto, quantidade);
    }

    public void submeta() {
	    submeterFormulario(calculardescontoButtonCalcular);
    }

    public Object getToastMsg() {
	    return toastMsg.getText();
    }

    public void solicitarIdProdudo() {//calculando pelo produto de ID01 -
    	page.acesse_pagina_listar_produtos();
    	page.getIdProdutoSteps();

    }
}
