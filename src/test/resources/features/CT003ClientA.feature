# language: pt

# tags de exemplo
@all @reqX @sucesso @fb @regressivo

Funcionalidade: REQ-1 - Calcular Desconto

	Esquema do Cenario: Calcular desconto com sucesso

		# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o calculo do desconto
		E       seleciono um produto

		# Procedimento
		Quando  preencho com dados do cliente do tipo A
			| cliente  				| <cliente> 			|
			| quantidade 			| <quantidade>		|
			| fatoresperado  	|<fatoresperado>  |
			| msg							|<msg>						|
		E     calculo o desconto aplicado

		#Verificação
		Então   verifico se a mensagem foi exibida com sucesso


		Exemplos:
			| cliente| quantidade | fatoresperado					 | msg														 |
			| A  		 | 99  				|	 0,9  (10% de desconto)|	Operação realizada com sucesso!|
			| A      | 100      	|	 0.95 (5% de desconto) |	Operação realizada com sucesso!|
			| A      | 999      	|	 0.95 (5% de desconto) |	Operação realizada com sucesso!|
			| A  		 | 1000   		|	 1,00 (0% de desconto) |	Operação realizada com sucesso!|
			| A  		 | 2000   		|	 1,00 (0% de desconto) |	Operação realizada com sucesso!|
