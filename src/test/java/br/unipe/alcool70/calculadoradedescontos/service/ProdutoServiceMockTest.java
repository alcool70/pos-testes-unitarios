package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Produto;
import br.unipe.alcool70.calculadoradedescontos.repository.ProdutoRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@Nested
@DisplayName("TESTE MOCKITO")
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)

public class ProdutoServiceMockTest {
    @Mock
    ProdutoRepository mock;
    @InjectMocks
    ProdutoService driver;
    private Faker faker = new Faker(new Locale("pt_BR"));
    Integer totalDeProdutos = 10;
    Long idProdutoValido = 1l;

    @BeforeEach
    void setUp() {
        this.driver = new ProdutoService();
    }

    @AfterEach
    void tearDown() {
        this.driver = null;
    }

    @Test
    void findAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {

        Mockito.when(this.mock.getAll())
                .thenReturn(criarProdutos(10));
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
        resultados.stream().forEach(
                p -> System.out.println(p.toString())
        );
    }

    @Test
    void testFindAllQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(this.totalDeProdutos, resultados.size());
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

    private Collection<Produto> criarProdutos(Integer qtd) {
        Collection<Produto> produtos = new ArrayList<Produto>();
        Faker faker = new Faker(new Locale("pt_BR"));
        for (int i = 0; i > qtd; i++) {
            produtos.add(new Produto(
                    i + 1l,
                    faker.commerce().productName(),
                    faker.number().randomDouble(2, 100, 2000)
            ));
        }
        return produtos;
    }
}