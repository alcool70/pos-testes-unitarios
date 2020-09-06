# language: pt

# tags de exemplo
@all @req001 @sucesso @fb @regressivo @clientec

Funcionalidade: REQ-001 - Calcular desconto

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


		Exemplos:
			| cliente| quantidade |fatoresperado						    	  | msg														 |
			| C      | 99       	|	 0.8  (ou seja,20% de desconto) |	Operação realizada com sucesso!|
			| C  		 | 100 				|	 0,85 (ou seja,15% de desconto) |	Operação realizada com sucesso!|
			| C  		 | 999    		|	 0,85 (ou seja,15% de desconto) |	Operação realizada com sucesso!|
			| C  		 | 1000    		|	 0,9  (ou seja,10% de desconto) |	Operação realizada com sucesso!|
			| C  		 | 2000    		|	 0,9  (ou seja,10% de desconto) |	Operação realizada com sucesso!|
