package br.unipe.alcool70.calculadoradedescontos.ux.passos.req001;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class Req001GWT {

    @Steps
    Req001Steps steps;
    @Quando("") /*(DUVIDA)Ler Comentarios_Victor*/
    @Quando("^$")
    public void preencho_com_dados_validos_o_formulario_de_calculo_do_desconto_para_o_produto(DataTable tabela) throws Exception {
        Map<String, String> dados = tabela.asMap(String.class, String.class);/*Essa parte nao entendi Victor*/

        //steps.selecionar_Produto();//SELECIONANDO PELO ID 1
        steps.informar_tipoCliente(dados.get("nome"));
        steps.informar_quantidadeProduto(dados.get("quantidadeProduto"));

    }

    @Quando("^submeto o formulário$")
    public void submeto_o_formulário() throws Exception {
        steps.submeta_formulario_Calcular_Desconto();
    }

    @Então("verificar o desconto")
    public void verifica_fator_de_desconto() throws Exception {
        //"Ainda nao entendi isso aqui" /*"Duvida" @author Victor*/
        steps.verifica_fator_desconto();
    }
    @Então("^verifico que a mensagem de sucesso foi exibida$")
    public void verifico_que_a_mensagem_de_sucesso_foi_exibida() throws Exception {
        steps.verificar_mensagem_sucesso();
    }

}
