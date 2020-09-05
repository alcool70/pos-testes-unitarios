# language: pt

# tags de exemplo
@all @reqX @sucesso @fb @regressivo

Funcionalidade: REQ-X - Calcular desconto

	Esquema do Cenario: Calcular desconto com sucesso (fluxo básico)

		# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o calculo do desconto
		E       seleciono o produto

		# Procedimento
		Quando  preencho com dados do cliente
			| cliente  				| <cliente> 			|
			| quantidade 			| <quantidade>		|
			|fatoresperado  	|<fatoresperado>  |
			|msg							|<msg>						|
		E     calculo o desconto

		#Verificação
		Então   verifico se a mensagem foi eixibida com sucesso
		E 			verifico se o fator de desconto foi obitido

		Exemplos:
			| cliente| quantidade |fatoresperado						    	 | msg														 |
			| B      | 100      	|	 0.9  (ou seja,10% de desconto)|	Operação realizada com sucesso!|
			| B  		 | 99  				|	 0,85 (ou seja,15% de desconto)|	Operação realizada com sucesso!|
			| B  		 | 1000   		|	 0,95 (ou seja,5% de desconto) |	Operação realizada com sucesso!|
