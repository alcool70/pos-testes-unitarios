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
    Long idProdutoValido = 1l;

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

        this.stub.criarProdutos(10);
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
        resultados.stream().forEach(
                p -> System.out.println(p.toString())
        );
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
        Optional<Produto> resultado = this.driver.findById(0l);
        //Verificacao
        assertTrue(resultado.isEmpty());
        assertFalse(resultado.isPresent());
        assertThrows(NoSuchElementException.class, () -> {
            resultado.get();
        });

    }
    @Test
    void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {
        //Procedimento
        Optional<Produto> resultado = this.driver.findById(1l);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertFalse(resultado.isEmpty());
        assertNotNull(resultado.get());

    }
}