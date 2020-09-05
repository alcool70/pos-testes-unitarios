package br.unipe.alcool70.calculadoradedescontos.ui.specs;

import br.unipe.alcool70.calculadoradedescontos.ui.steps.Req001CLIENTBSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Req001CLIENTBSpecs<pubblic> {

	@Steps
	Req001CLIENTBSteps steps;

	@Dado("^seleciono o produto$")
	public void seleciono_o_produto() throws Exception {
		steps.selecionar_produto();
	}

	@Quando("^preencho com dados do cliente$")
	public void preencho_com_dados_do_cliente (DataTable tabela) throws Exception{
		Map<String, String> dados = tabela.asMap(String.class, String.class);
		steps.informar_tipo_cliente(dados.get("cliente"));
		steps.informar_qtd_iten(dados.get("quantidade"));
	}

	@Quando("^calculo o desconto$")
	public void calculo_o_desconto(){
		steps.calcular_o_desconto();
	}

	@Então("^verifico se a mensagem foi eixibida com sucesso$")
	public void verifico_se_a_mensagem_foi_eixibida_com_sucesso () throws Exception{
		steps.verificar_mensagem_sucesso();
	}



}
