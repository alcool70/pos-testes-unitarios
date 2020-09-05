# language: pt

@all @req001 @FormularioDesconto @Cliente_C @sucesso @fb

Funcionalidade: REQ001 - Calcular desconto de produto

  Esquema do Cenario: Enviar Formulário de informações complementares para Cálculo do Desconto para o Produto com sucesso
  (fluxo básico)

      # Pré condições iniciais
    Dado    que estou na página inicial do sistema
    E       seleciono um produto da lista de produtos

      # Procedimento
    Quando  preencho com dados válidos o Formulário
      | tipo        | <tipo>        |
      | quant       | <quant>       |
    E       submeto o formulário

      #Verificação
    Então   verifico que a mensagem de sucesso foi exibida
		E 			verificar o desconto

    Exemplos:
     | tipo | quant |
     | C    | 87  |
     | C    | 50  |
     | C    | 1  |
     | C    | 0  |
     | C    | 100  |
     | C    | 500  |
     | C    | 999  |
     | C    | 1000  |
     | C    | 2000  |
     | C    | 3000  |

