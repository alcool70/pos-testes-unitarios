# language: pt

# tags de exemplo
@all @req003 @sucesso @fb @regressivo

Funcionalidade: REQ-003 - Formulário de Contato

	Esquema do Cenario: Enviar contato com sucesso (fluxo básico)

		# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o formulário de contato

		# Procedimento
		Quando  preencho com dados válidos o formulário
			| nome  | <nome>  |
			| email | <email> |
			| tipo  | <tipo>  |
			| idade | <idade> |
			| msg   | <msg>   |
		E       submeto o formulário

		#Verificação
		Então   verifico que a mensagem de sucesso foi exibida

		Exemplos:
    			| NOME  	| EMAIL          		| TIPO       | IDADE              | MENSAGEM							|
    			| Maria 	| maria@gmail.com 	| Dúvida     | Menor que 18 anos  | Dúvida de Maria   		|
    			| Carlos	| carlos@gmail.com	| Dúvida     | Entre 18 e 60 anos | Dúvida de Carlos  		|
    			| Alison	| Alison@gmail.com	| Dúvida     | Acima de 60 anos   | Dúvida de Alison 	 		|
    			| Diego 	| diego@gmail.com 	| Sugestão   | Menor que 18 anos  | Sugestão de Diego 		|
    			| José  	| jose@gmail.com  	| Sugestão   | Entre 18 e 60 anos | Sugestão de José  		|
    			| Manoel	| manoel@gmail.com	| Sugestão   | Acima de 60 anos   | Sugestão de Manoel		|
    			| Bianca	| Bianca@gmail.com	| Reclamação | Menor que 18 anos  | Reclamação de Bianca	|
    			| Thiago	| thiago@gmail.com	| Reclamação | Entre 18 e 60 anos | Reclamaçao de Thiago	|
    			| Ana   	| ana@gmail.com   	| Reclamação | Acima de 60 anos   | Reclamação de Ana 		|

