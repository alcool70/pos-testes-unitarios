# language: pt

  @all @req001 @sucesso @fb

  Funcionalidade: REQ001 - Calcular desconto de produto

    Esquema do Cenario: Enviar Formulário de informações complementares para Cálculo do Desconto para o Produto com sucesso (fluxo básico)

      # Pré condições iniciais
      Dado    que estou na página inicial do sistema
      E       acesso o menu para a Listagem de Produtos de Simulação
      E       seleciono um dos produtos listados

      # Procedimento
      Quando  preencho com dados válidos o Formulário de informações complementares
        | tipo  | <tipo>  |
        | quant | <quant> |
      E       submeto o formulário

      #Verificação
      Então   verifico que a mensagem de sucesso foi exibida

      Exemplos:
        | tipo | quant |
        | C    | 2000  |
        | C    | 3000  |

