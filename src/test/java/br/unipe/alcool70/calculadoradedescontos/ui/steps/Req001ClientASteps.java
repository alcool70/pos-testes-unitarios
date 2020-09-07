package br.unipe.alcool70.calculadoradedescontos.ui.steps;

import br.unipe.alcool70.calculadoradedescontos.ui.pages.ProdutoPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class Req001ClientASteps {

	ProdutoPage page;

	@Step
	public void selecionarProduto() {
		page.acesseProduto();
	}

	@Step
	public void informarTipoCliente(String cliente) {
		page.informarTipoCliente(cliente);
	}

	@Step
	public void informarQuantidadeItens(String quantidade) {
		page.informarQtdItem(quantidade);
	}

	@Step
	public void calcularDesconto(){
		page.calcularDesconto();
	}

	@Step
	public void verificarMensagemSucesso() {
		assertThat(
				 page.getmsg(),
				 containsStringIgnoringCase("Operação realizada com sucesso!")

		);
	}





}
