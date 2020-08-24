package br.unipe.alcool70.calculadoradedescontos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Item {
    private Long id;
    private TipoCliente tipoCliente;
    private Produto produto;
    private Integer qtd;

    public Double getValorComDesconto(){
        return this.produto.getValor() * this.tipoCliente.getFatorDesconto(this.qtd);
    }
}
