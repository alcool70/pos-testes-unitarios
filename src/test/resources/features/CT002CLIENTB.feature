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
			| cliente  				| <cliente> 	|
			| quantidade 			| <quantidade>|


		E     calculo o desconto

		#Verificação
		Então   verifico se a mensagem foi eixibida com sucesso

		Exemplos:
			| cliente   		| quantidade 			|
			| B             | 100      				|
			| B  						| 99  						|
			| B  						| 1000   					|
