package br.unipe.alcool70.calculadoradedescontos.ui.steps;

<<<<<<< HEAD
=======

>>>>>>> REQ001-Victor
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


	public void acesse_pagina_CalcularDesconto_Simulacao_Calcular_Desconto() {
		page.get("https://calculadora.diegoquirino.net/index.php?p=listarProdutos");
	}

	public void getIdProduto() {
		page.get("https://calculadora.diegoquirino.net/index.php?p=calcularDesconto&pid=1");
	}
}
