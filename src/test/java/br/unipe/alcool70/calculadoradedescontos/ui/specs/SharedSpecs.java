package br.unipe.alcool70.calculadoradedescontos.ui.specs;


import br.unipe.alcool70.calculadoradedescontos.ui.steps.SharedSteps;
import io.cucumber.java.pt.Dado;
import net.thucydides.core.annotations.Steps;

public class SharedSpecs {
	// Comunica com a tela (interface do usuário) Given, When, Then

	@Steps
	SharedSteps steps;

	@Dado("^que estou na página inicial do sistema$")
	public void que_estou_na_página_inicial_do_sistema() throws Exception {
		steps.acesse_pagina_inicial();
	}

	@Dado("^acesso o menu para o formulário de contato$")
	public void acesso_o_menu_para_o_formulário_de_contato() throws Exception {
		steps.acesse_pagina_contato();
	}
	@Dado("^estou na pagina de listar produtos$")
	public void que_estou_na_pagina_de_listar_Produtos() throws Exception{
		steps.acesse_pagina_listar_produtos();
	}
	@Dado("^seleciono ID produto$")
	public void seleciono_Id_produto_SharedSpecs() throws Exception{
		steps.getIdProdutoSteps();
	}

}
