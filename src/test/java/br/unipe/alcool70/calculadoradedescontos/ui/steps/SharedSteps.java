package br.unipe.alcool70.calculadoradedescontos.ui.steps;

import br.unipe.alcool70.calculadoradedescontos.ui.pages.InicialPage;
import net.thucydides.core.annotations.Step;

public class SharedSteps {
	// Comunica com o PageObject
	InicialPage page;

	@Step
	public void acesse_pagina_inicial() {
		page.get("https://calculadora.diegoquirino.net/");
	}

	@Step
	public void acesse_pagina_contato() {
		page.acessePaginaContato();
	}

	@Step
	public void acesse_pagina_desconto() {
		page.acessarCalculoDesconto();
	}



}
