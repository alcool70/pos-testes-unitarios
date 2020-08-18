package br.unipe.alcool70.calculadoradedescontos.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TipoClienteTest {
    /*Inicializacao do Teste*/
    TipoCliente driver;
    Integer qtdInferiorA100;
    Integer qtdInferiorA1000;
    Integer qtdIAPartirDe1000;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Iniciando Testes");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("Fim dos Testes");
    }

    @BeforeEach
    void setUp() {
        this.qtdInferiorA100 = 99;
        this.qtdInferiorA1000 = 999;
        this.qtdIAPartirDe1000 = 1000;
    }

    @AfterEach
    void tearDown() {
        this.driver = null;
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteA")})
    @DisplayName("Fator Desconto será 0.9 quando Cliente for tipo A e Quantidade < 100")
    public void testGetFatorDescontoQuandoClienteAQuantidadeIferiorA100EntaoFatorDescontoSera09() {
        this.driver = TipoCliente.A;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdInferiorA100);
        //Verificacao
        assertEquals(0.90, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteA")})
    @DisplayName("Fator Desconto será 0.95 quando Cliente for tipo A e Quantidade < 1000")
    public void testGetFatorDescontoQuandoClienteAQuantidadeIferiorA1000EntaoFatorDescontoSera095() {
        this.driver = TipoCliente.A;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdInferiorA1000);
        //Verificacao
        assertEquals(0.95, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteA")})
    @DisplayName("Fator Desconto será 1.0 quando Cliente for tipo A e Quantidade >= 1000")
    public void testGetFatorDescontoQuandoClienteAQuantidadeAPartirDe1000EntaoFatorDescontoSera100() {
        this.driver = TipoCliente.A;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdIAPartirDe1000);
        //Verificacao
        assertEquals(1.00, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteB")})
    @DisplayName("Fator Desconto será 0.85 quando Cliente for tipo B e Quantidade < 100")
    public void testGetFatorDescontoQuandoClienteBQuantidadeIferiorA100EntaoFatorDescontoSera085() {
        this.driver = TipoCliente.B;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdInferiorA100);
        //Verificacao
        assertEquals(0.85, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteB")})
    @DisplayName("Fator Desconto será 0.9 quando Cliente for tipo B e Quantidade < 1000")
    public void testGetFatorDescontoQuandoClienteBQuantidadeIferiorA1000EntaoFatorDescontoSera090() {
        this.driver = TipoCliente.B;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdInferiorA1000);
        //Verificacao
        assertEquals(0.90, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteB")})
    @DisplayName("Fator Desconto será 0.95 quando Cliente for tipo B e Quantidade >= 1000")
    public void testGetFatorDescontoQuandoClienteBQuantidadeAPartirDe1000EntaoFatorDescontoSera095() {
        this.driver = TipoCliente.B;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdIAPartirDe1000);
        //Verificacao
        assertEquals(0.95, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteC")})
    @DisplayName("Fator Desconto será 0.80 quando Cliente for tipo C e Quantidade < 100")
    public void testGetFatorDescontoQuandoClienteCQuantidadeIferiorA100EntaoFatorDescontoSera080() {
        this.driver = TipoCliente.C;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdInferiorA100);
        //Verificacao
        assertEquals(0.80, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteC")})
    @DisplayName("Fator Desconto será 0.85 quando Cliente for tipo C e Quantidade < 1000")
    public void testGetFatorDescontoQuandoClienteCQuantidadeIferiorA1000EntaoFatorDescontoSera085() {
        this.driver = TipoCliente.C;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdInferiorA1000);
        //Verificacao
        assertEquals(0.85, resultado);
    }

    @Test
    @Tags({@Tag("All"), @Tag("ClienteC")})
    @DisplayName("Fator Desconto será 0.90 quando Cliente é tipo C e Quantidade >= 1000")
    public void testGetFatorDescontoQuandoClienteCQuantidadeAPartirDe1000EntaoFatorDescontoSera090() {
        this.driver = TipoCliente.C;
        //Teste Procedure
        double resultado = this.driver.getFatorDesconto(this.qtdIAPartirDe1000);
        //Verificacao
        assertEquals(0.90, resultado);
    }
}