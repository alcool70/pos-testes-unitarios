package br.unipe.alcool70.calculadoradedescontos.ui.pages;

public interface Locators {
	/*Página inicial*/
	String ID_BTNCALCULARDESCONTO = "welcome.button.calculardesconto";
	String ID_BTNAJUDA = "welcome.button.ajuda";
	String ID_BTNCONTATO = "welcome.button.contato";

	/*Formulário de contato*/
	String NAME_NOME = "nome";
	String ID_EMAIL = "email";
	String ID_MENSAGEM = "mensagem";
	String CSS_SELECT_FAIXAIDADE = "#idade";
	String ID_BTNSUBMETERCONTATO = "contato.button.enviarMensagem";
	String XPATH_TOASTMSG = "//strong";
	String NAME_TIPOMENSAGEM = "tipoMsg";
	/*listagem de produto*/
	String CLASS_PRODUTO = "btn-primary";

	/*Calcular desconto*/
	String ID_CLIENTE    = "tipoCliente";
	String ID_QUANTIDADE = "quantidade";
	String ID_BTCALCULAR = "calculardesconto.button.calcular";
	String XPATH_FATOR = "//strong";


}
