# language: pt

# tags de exemplo
@all @req003 @falha @fb @regressivo

Funcionalidade: REQ-003 - Formulário de Contato
		Cenario: Enviar formulário sem preencher os dados

 		# Pré condições iniciais
		Dado    que estou na página inicial do sistema
		E       acesso o menu para o formulário de contato

		# Procedimento
			# Nenhum dado é inserido no formulário
		Quando submeto o formulário
		Então verifico que a mensagem de erro foi exibida
