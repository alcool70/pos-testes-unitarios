package br.unipe.alcool70.calculadoradedescontos.ui.steps;

import br.unipe.alcool70.calculadoradedescontos.ui.pages.FormularioContatoPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.is;

public class Req003Steps {

	FormularioContatoPage page;

	@Step
	public void informar_nome(String nome) {
		page.solicitarNomeDoCliente(nome);
	}

	@Step
	public void informar_emais(String email) {
		page.solicitarEmailDoCliente(email);
	}

	@Step
	public void informar_tipo_mensagem(String tipo) {
		page.solicitarTipoMensagem(tipo);
	}

	@Step
	public void informar_faixa_idade(String idade) {
		page.informarFaixaIdade(idade);
	}

	@Step
	public void informar_mensagem(String msg) {
		page.informarConteudoMensagem(msg);
	}

	@Step
	public void submeta() {
		page.submeta();
	}

	@Step
	public void verificar_mensagem_sucesso() {
		assertThat(
				 page.getToastMsg(),
				 containsStringIgnoringCase("Mensagem enviada com sucesso!")
		);
	}




}
