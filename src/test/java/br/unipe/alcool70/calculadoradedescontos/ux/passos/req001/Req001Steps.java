package br.unipe.alcool70.calculadoradedescontos.ux.passos.req001;

import net.thucydides.core.annotations.Step;
import pages.FormularioCalculoDoDescontoParaProdutoPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Req001Steps {
    FormularioCalculoDoDescontoParaProdutoPage page;

    @Step
    public void selecionar_Produto() {
    	page.selecionarProduto();
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
    public void submeta_formulario_Calcular_Desconto() {
        page.submeta_calcular_desconto();
    }

    @Step
    public void verificar_mensagem_sucesso() {
        assertThat(
                page.getToastMsg(),
                is("Mensagem enviada com sucesso!"));
    }

    public void verifica_fator_desconto() {
    }
}
