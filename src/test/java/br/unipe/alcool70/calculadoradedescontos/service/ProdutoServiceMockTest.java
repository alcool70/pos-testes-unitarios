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
@DisplayName("Testes de Produto com Mockito")
@ExtendWith(MockitoExtension.class)
public class ProdutoServiceMockTest {
    @Mock
    private ProdutoRepository mock;
    @InjectMocks
    private ProdutoService driver;
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
    @DisplayName("Quando tenho 10 produtos então 10 produtos são carregados")
    public void findAllQuandoTenho10ProdutosEntao10ProdutosSaoCarregados() {
        Mockito.when(this.mock.getAll()).thenReturn(criarProdutos(this.totalDeProdutos));
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(this.totalDeProdutos, resultados.size());
        resultados.forEach(System.out::println);
    }

    @Test
    @DisplayName("Quando não tenho produtos então nenhum produto é carregado")
    public void testFindAllQuandoNenhumProdutoEntao0ProdutosSaoCarregados() {
        Mockito.when(this.mock.getAll()).thenReturn(criarProdutos(0));
        //Procedimento
        Collection<Produto> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
    }

    @Test
    @DisplayName("Quando um produto não existe então nenhum produto é encontrado")
    public void testFindByIdQuandoIdProdutoInexistenteEntaoNenhumProdutoRetornado() {
        //Procedimento
        Optional<Produto> resultado = this.driver.findById(this.idProdutoInvalido);
        //Verificacao
        assertTrue(resultado.isEmpty());
        assertThrows(NoSuchElementException.class, resultado::get);
    }

    @Test
    @DisplayName("Quando tenho 1 produtos válido então 1 produto é encontrado")
    public void testFindByIdQuandoIdProdutoValidoEntao1ProdutoRetornado() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(Produto.builder().id(1L).build()));
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
            produtos.add(
                    Produto.builder()
                            .id(i + 1L)
                            .nome(faker.commerce().productName())
                            .valor(faker.number().randomDouble(2, 100, 2000))
                            .build()
            );
        }
        return produtos;
    }
}