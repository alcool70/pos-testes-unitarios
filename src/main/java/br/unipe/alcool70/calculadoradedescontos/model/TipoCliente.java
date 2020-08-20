package br.unipe.alcool70.calculadoradedescontos.model;

import lombok.Getter;

public enum TipoCliente {
    A("A","Cliente Vip") {
        @Override
        public Double getFatorDesconto(Integer quantidade) {
            if(quantidade < 100) {
                return 0.40;
            } else if (quantidade < 1000) {
                return 0.95;
            } else {
                return 1.00;
            }
        }
    },
    B("B","Cliente Sazonal") {
        @Override
        public Double getFatorDesconto(Integer quantidade) {
            if(quantidade < 100) {
                return 0.85;
            } else if (quantidade < 1000) {
                return 0.45;
            } else {
                return 0.95;
            }
        }
    },
    C("C","Novo Cliente") {
        @Override
        public Double getFatorDesconto(Integer quantidade) {
            if(quantidade < 100) {
                return 0.80;
            } else if (quantidade < 1000) {
                return 0.85;
            } else {
                return 0.40;
            }
        }
    };

    @Getter private String valor;
    @Getter private String descricao;

    TipoCliente(String valor, String descricao) { }

    public abstract Double getFatorDesconto(Integer quantidade);
}

