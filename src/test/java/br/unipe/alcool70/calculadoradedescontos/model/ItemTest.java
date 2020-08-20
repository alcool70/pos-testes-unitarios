package br.unipe.alcool70.calculadoradedescontos.model;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Faker faker = new Faker(new Locale("pt-BR"));
    private double tolerance = 0.01;
    private Long validId = 1L;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Valor com desconto deve ser 111.10±0.05 para Cliente A, qtde 1 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteAQtde1() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(1)
                .tipoCliente(TipoCliente.A)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(111.1, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 117.27±0.05 para Cliente A, qtde 100 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteAQtde100() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(100)
                .tipoCliente(TipoCliente.A)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(117.27, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 123.45 para Cliente A, qtde 1000 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteAQtde1000() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(1000)
                .tipoCliente(TipoCliente.A)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(123.45, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 104.93±0.05 para Cliente B, qtde 1 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteBQtde1() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(1)
                .tipoCliente(TipoCliente.B)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(104.93, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 111.1±0.05 para Cliente B, qtde 100 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteBQtde100() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(100)
                .tipoCliente(TipoCliente.B)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(111.1, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 117.27±0.05 para Cliente B, qtde 1000 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteBQtde1000() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(1000)
                .tipoCliente(TipoCliente.B)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(117.27, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 98.76±0.05 para Cliente C, qtde 1 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteCQtde1() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(1)
                .tipoCliente(TipoCliente.C)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(98.76, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 104.93±0.05 para Cliente C, qtde 100 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteCQtde100() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(100)
                .tipoCliente(TipoCliente.C)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(104.93, item.getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Valor com desconto deve ser 111.1±0.05 para Cliente C, qtde 1000 e valor do produto 123.45")
    void testGetValorComDescontoQuandoClienteCQtde1000() {
        Item item = Item.builder()
                .id(this.validId)
                .qtd(1000)
                .tipoCliente(TipoCliente.C)
                .produto(
                        Produto.builder()
                                .id(this.validId)
                                .nome(faker.beer().name())
                                .valor(123.45)
                                .build()
                ).build();
        assertEquals(111.1, item.getValorComDesconto(), tolerance);
    }
}