package pages;

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


    /*FormularioCalculoDoDescontoParaProduto*/
    String ID_SELECT_TIPOCLIENTE = "tipoCliente";
    String ID_QUANTIDADEPRODUTO = "quantidade";
		String XPATH_SELECIONARPRODUTO = "//tr[1]//td[4]//a[1]//span[1]";

}
