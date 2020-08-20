package br.unipe.alcool70.calculadoradedescontos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Produto {
    private Long id;
    private String nome;
    private Double valor;
}
