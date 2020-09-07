package br.unipe.alcool70.calculadoradedescontos.ui.specs;

import br.unipe.alcool70.calculadoradedescontos.ui.steps.Req001ClientASteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class Req001ClienteASpecs<pubblic> {

	@Steps
	Req001ClientASteps steps;

	@Dado("^seleciono um produto$")
	public void selecionoUmProduto() throws Exception {
		steps.selecionarProduto();
	}

	@Quando("^preencho com dados do cliente do tipo A$")
	public void preenchoComDadosClienteA (DataTable tabela) throws Exception {
		Map<String, String> dados = tabela.asMap(String.class, String.class);
		steps.informarTipoCliente(dados.get("cliente"));
		steps.informarQuantidadeItens(dados.get("quantidade"));
	}

	@Quando("^calculo o desconto aplicado$")
	public void calculoDesconto() {
		steps.calcularDesconto();
	}

	@Então("^verifico se a mensagem foi exibida com sucesso$")
	public void verificoMensagemExibidaComSucesso() throws Exception{
		steps.verificarMensagemSucesso();
	}

}
