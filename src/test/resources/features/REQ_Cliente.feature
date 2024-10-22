# language: pt

# tags de exemplo
@all @cliente
Funcionalidade: Calcular desconto

	@sucesso
	Esquema do Cenario: Calcular desconto com sucesso (fluxo básico)

		# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o calculo do desconto
		E       seleciono o produto

		# Procedimento
		Quando  preencho com dados do cliente
			| cliente       | <cliente>       |
			| quantidade    | <quantidade>    |
			| fatoresperado | <fatoresperado> |
			| msg           | <msg>           |
		E     calculo o desconto

		#Verificação
		Então   verifico se a mensagem foi exibida com sucesso

		Exemplos:
			| cliente | quantidade | fatoresperado                  | msg                             |
			| A       | 99         | 0,9  (10% de desconto)         | Operação realizada com sucesso! |
			| A       | 100        | 0.95 (5% de desconto)          | Operação realizada com sucesso! |
			| A       | 999        | 0.95 (5% de desconto)          | Operação realizada com sucesso! |
			| A       | 1000       | 1,00 (0% de desconto)          | Operação realizada com sucesso! |
			| A       | 2000       | 1,00 (0% de desconto)          | Operação realizada com sucesso! |
			| B       | 100        | 0.9  (ou seja,10% de desconto) | Operação realizada com sucesso! |
			| B       | 99         | 0,85 (ou seja,15% de desconto) | Operação realizada com sucesso! |
			| B       | 1000       | 0,95 (ou seja,5% de desconto)  | Operação realizada com sucesso! |


	@falha
	Esquema do Cenario: Calcular desconto sem sucesso (fluxo alt)

  	# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o calculo do desconto
		E       seleciono o produto

 		# Procedimento
		Quando  preencho com dados do cliente
			| cliente       | <cliente>       |
			| quantidade    | <quantidade>    |
			| fatoresperado | <fatoresperado> |
			| msg           | <msg>           |
		E     calculo o desconto

 		#Verificação
		Então   verifico se a mensagem de erro foi exibida

		Exemplos:
			| cliente | quantidade | fatoresperado         | msg                                                       |
			| A       | 0          | 1,00 (0% de desconto) | A quantidade informada deve ser maior ou igual a 01 (um)! |
			| A       | -1         | 1,00 (0% de desconto) | A quantidade informada deve ser maior ou igual a 01 (um)! |
			| A       | X          | 1,00 (0% de desconto) | A quantidade informada deve ser maior ou igual a 01 (um)! |
			| A       | 0.5        | 1,00 (0% de desconto) | A quantidade informada deve ser maior ou igual a 01 (um)! |
			| A       | Abc123     | 1,00 (0% de desconto) | A quantidade informada deve ser maior ou igual a 01 (um)! |
