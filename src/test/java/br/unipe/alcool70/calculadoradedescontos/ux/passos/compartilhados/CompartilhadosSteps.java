package br.unipe.alcool70.calculadoradedescontos.ux.passos.compartilhados;

import net.thucydides.core.annotations.Step;
import pages.InicialPage;

public class CompartilhadosSteps {
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
    public void acesse_pagina_listar_produtos(){
    	page.acessePaginaListarProdutos();
    }

		@Step
		public void selecionar_Produto() {
    	page.get("https://calculadora.diegoquirino.net/index.php?p=calcularDesconto&pid=1");
	}

}
