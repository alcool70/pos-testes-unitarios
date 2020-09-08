package br.unipe.alcool70.calculadoradedescontos.ui.specs;

import br.unipe.alcool70.calculadoradedescontos.ui.steps.ClienteSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class ClienteSpecs {

	@Steps
	ClienteSteps steps;

	@Dado("^seleciono o produto$")
	public void seleciono_o_produto() {
		steps.selecionar_produto();
	}

	@Quando("^preencho com dados do cliente$")
	public void preencho_com_dados_do_cliente(DataTable tabela) {
		Map<String, String> dados = tabela.asMap(String.class, String.class);
		steps.informar_tipo_cliente(dados.get("cliente"));
		steps.informar_qtd_iten(dados.get("quantidade"));
	}

	@Quando("^calculo o desconto$")
	public void calculo_o_desconto() {
		steps.calcular_o_desconto();
	}

	@Então("^verifico se a mensagem foi exibida com sucesso$")
	public void verifico_se_a_mensagem_foi_exibida_com_sucesso() {
		steps.verificar_mensagem_sucesso();
	}

	@Então("^verifico se a mensagem de erro foi exibida$")
	public void verifico_se_a_mensagem_de_erro_foi_exibida() {
		steps.verificar_mensagem_erro();
	}

}
