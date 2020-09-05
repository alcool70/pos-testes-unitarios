package br.unipe.alcool70.calculadoradedescontos.ux.passos.req001;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matcher;
import pages.FormularioCalculoDoDescontoParaProdutoPage;

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
    public void verificar_mensagem_sucesso() {"Ainda nao entendi isso aqui" /*"Duvida" @author Victor*/
        assertThat(
                page.getToastMsg(),
                is("Mensagem enviada com sucesso!"));
    }

    private void assertThat(Object toastMsg, Matcher<String> stringMatcher) {
        "Ainda nao entendi isso aqui" /*"Duvida" @author Victor*/
    }

    public void verifica_fator_desconto() {
    }
}
