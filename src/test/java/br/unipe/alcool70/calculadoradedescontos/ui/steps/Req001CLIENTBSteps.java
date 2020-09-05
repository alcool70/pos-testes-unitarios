package br.unipe.alcool70.calculadoradedescontos.ui.steps;

import br.unipe.alcool70.calculadoradedescontos.ui.pages.ProdutoPage;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;

public class Req001CLIENTBSteps {

	ProdutoPage page;

	@Step
	public void selecionar_produto() {
		page.acesseProduto();
	}

	@Step
	public void informar_tipo_cliente(String cliente) {
		page.informarTipoCliente(cliente);
	}

	@Step
	public void informar_qtd_iten(String quantidade){
		page.informarQtdItem(quantidade);
	}

	@Step
	public void calcular_o_desconto(){
		page.calcularDesconto();
	}


	@Step
	public void verificar_mensagem_sucesso() {
		assertThat(
				 page.getmsg(),
				 containsStringIgnoringCase("Operação realizada com sucesso!")

		);
	}
	 @Step
	public String retornar_fator_de_desconto(){
			page.getfator();
		 return page.getfator();
	 }





}
