package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Produto;
import br.unipe.alcool70.calculadoradedescontos.repository.ProdutoRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("TESTE MOCKITO")
@ExtendWith(MockitoExtension.class)
public class ProdutoServiceMockTest {
    @Mock
    private ProdutoRepository mock;
    @InjectMocks
    private ProdutoService driver;
    private Faker faker = new Faker(new Locale("pt_BR"));
    private Integer totalDeProdutos = 10;
    private Long idProdutoValido = 1L;
    private Long idProdutoInvalido = 0L;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void tearDown() {
        this.driver = null;
    }

    @Test
    public void findAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {

        Mockito.when(this.mock.getAll())
                .thenReturn(criarProdutos(this.totalDeProdutos));
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(this.totalDeProdutos, resultados.size());
        resultados.forEach(System.out::println);
    }

    @Test
    public void testFindAllQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
    }

    @Test
    public void testFindByIdQuandoIdProdutoInexistenteEntaoNenhumProdutoRetornado() {
        //Procedimento
        Optional<Produto> resultado = this.driver.findById(this.idProdutoInvalido);
        //Verificacao
        assertTrue(resultado.isEmpty());
        assertThrows(NoSuchElementException.class, resultado::get);
    }

    @Test
    public void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {
        //Procedimento
        Optional<Produto> resultado = this.driver.findById(this.idProdutoValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }

    private Collection<Produto> criarProdutos(Integer qtd) {
        Collection<Produto> produtos = new ArrayList<>();
        Faker faker = new Faker(new Locale("pt_BR"));
        for (int i = 0; i < qtd; i++) {
            produtos.add(new Produto(
                    i + 1L,
                    faker.commerce().productName(),
                    faker.number().randomDouble(2, 100, 2000)
            ));
        }
        return produtos;
    }
}