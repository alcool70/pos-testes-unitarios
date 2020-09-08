# language: pt

# tags de exemplo
@all @contato
Funcionalidade: Formulário de Contato

	@sucesso
	Esquema do Cenario: Enviar contato com sucesso (fluxo básico)

		# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o formulário de contato

		# Procedimento
		Quando  preencho com dados válidos o formulário
			| nome  | <nome>     |
			| email | <email>    |
			| tipo  | <tipo>     |
			| idade | <idade>    |
			| msg   | <mensagem> |
		E       submeto o formulário

		#Verificação
		Então   verifico que a mensagem de sucesso foi exibida

		Exemplos:
			| nome   | email            | tipo       | idade              | mensagem             |
			| Maria  | maria@gmail.com  | Dúvida     | Menor que 18 anos  | Dúvida de Maria      |
			| Carlos | carlos@gmail.com | Dúvida     | Entre 18 e 60 anos | Dúvida de Carlos     |
			| Alison | Alison@gmail.com | Dúvida     | Acima de 60 anos   | Dúvida de Alison     |
			| Diego  | diego@gmail.com  | Sugestão   | Menor que 18 anos  | Sugestão de Diego    |
			| José   | jose@gmail.com   | Sugestão   | Entre 18 e 60 anos | Sugestão de José     |
			| Manoel | manoel@gmail.com | Sugestão   | Acima de 60 anos   | Sugestão de Manoel   |
			| Bianca | Bianca@gmail.com | Reclamação | Menor que 18 anos  | Reclamação de Bianca |
			| Thiago | thiago@gmail.com | Reclamação | Entre 18 e 60 anos | Reclamaçao de Thiago |
			| Ana    | ana@gmail.com    | Reclamação | Acima de 60 anos   | Reclamação de Ana    |

	@falha
	Cenario: Enviar formulário sem preencher os dados

 		# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o formulário de contato

		# Procedimento
			# Nenhum dado é inserido no formulário
		Quando submeto o formulário
		Então verifico que a mensagem de erro foi exibida
