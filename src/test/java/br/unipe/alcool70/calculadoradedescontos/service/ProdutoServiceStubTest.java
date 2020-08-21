package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceStubTest {

    ProdutoService driver;
    //Stub para o Repository
    ProdutoRepositoryStub stub;
    Integer totalDeProdutos = 10;
    Long idProdutoValido = 1L;

    @BeforeEach
    void setUp() {
        this.driver = new ProdutoService();
        this.stub = new ProdutoRepositoryStub();
        this.driver.setProdutoRepository(stub);
    }

    @AfterEach
    void tearDown() {
        this.driver = null;
        this.stub =null;
    }

    @Test
    void findAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {

        this.stub.criarProdutos(this.totalDeProdutos);
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(10, resultados.size());
        resultados.forEach(System.out::println);
    }
    @Test
    void testFindAllQuandoNenhumProdutoEntao0ProdutosSaoCarregados(){
        this.stub.criarProdutos(0);
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
    }
    @Test
    void testFindByIdQuandoIdProdutoInexistenteEntaoNenhumProdutoRetornado() {
        //Procedimento
        Optional<Produto> resultado = this.driver.findById(0L);
        //Verificacao
        assertTrue(resultado.isEmpty());
        assertThrows(NoSuchElementException.class, resultado::get);

    }
    @Test
    void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {
        //Procedimento
        Optional<Produto> resultado = this.driver.findById(1L);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());

    }
}