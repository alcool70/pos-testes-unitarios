package pages;

import br.unipe.alcool70.calculadoradedescontos.ux.passos.compartilhados.CompartilhadosSteps;

public class FormularioCalculoDoDescontoParaProdutoPage {
    public CompartilhadosSteps page;

    public void solicitarTipoCliente(String tipoCliente) {
    }

    public void solicitarQuantidadeProduto(String quantidadeProduto) {
    }

    public void submeta() {
    }

    public Object getToastMsg() {
        return null;
    }

    public void solicitarIdProdudo() {//calculando pelo produto de ID01 - @author Victor*/
        page.acesse_pagina_CalcularDesconto_Id01();
    }
}
