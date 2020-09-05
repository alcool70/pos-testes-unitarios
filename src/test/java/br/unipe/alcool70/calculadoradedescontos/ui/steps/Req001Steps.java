package br.unipe.alcool70.calculadoradedescontos.ui.steps;

import br.unipe.alcool70.calculadoradedescontos.ui.pages.FormularioCalculoDoDescontoParaProdutoPage;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.is;

public class Req001Steps {
    FormularioCalculoDoDescontoParaProdutoPage page;

    @Step
    public void informar_idProduto() {
        page.solicitarIdProdudo();
    }

    @Step
    public void informar_tipoCliente(String tipoCliente) {
        page.solicitarTipoCliente(tipoCliente);
    }

    @Step
    public void informar_quantidadeProduto(String quantidadeProduto) {
        page.solicitarQuantidadeProduto(quantidadeProduto);
    }

    @Step
    public void submeta() {
        page.submeta();
    }

    @Step
    public void verificar_mensagem_sucesso() {//"Ainda nao entendi isso aqui" /*"Duvida" @author Victor*/
        assertThat(
                page.getToastMsg(),
                is("Mensagem enviada com sucesso!"));
    }

    public void verifica_fator_desconto() {

    }


}
