package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Item;
import br.unipe.alcool70.calculadoradedescontos.model.Produto;
import br.unipe.alcool70.calculadoradedescontos.model.TipoCliente;
import br.unipe.alcool70.calculadoradedescontos.repository.ItemRepository;
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
@DisplayName("Testes de Itens com Mockito")
@ExtendWith(MockitoExtension.class)
public class ItemServiceMockTest {
    @Mock
    private ItemRepository mock;
    @InjectMocks
    private ItemService driver;
    Integer totalDeItens = 10;
    Long idItemValido = 1L;
    Long idItemInvalido = 0L;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    public void tearDown() {
        this.driver = null;
    }

    @Test
    @DisplayName("Quando tenho 10 itens então 10 itens são carregados")
    public void findAllQuandoTenho10ItensEntao10ItensSaoCarregados() {
        Mockito.when(this.mock.getAll()).thenReturn(criarItems(this.totalDeItens));
        //Procedimento
        Collection<Item> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(this.totalDeItens, resultados.size());
        resultados.forEach(System.out::println);
    }

    @Test
    @DisplayName("Quando não tenho itens então nenhum iten é carregado")
    public void testFindAllQuandoNenhumItemEntao0ItemsSaoCarregados() {
        Mockito.when(this.mock.getAll()).thenReturn(criarItems(0));
        //Procedimento
        Collection<Item> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
    }

    @Test
    @DisplayName("Quando um iten não existe então nenhum iten é encontrado")
    public void testFindByIdQuandoIdItemInexistenteEntaoNenhumItemRetornado() {
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemInvalido);
        //Verificacao
        assertTrue(resultado.isEmpty());
        assertThrows(NoSuchElementException.class, resultado::get);
    }

    @Test
    @DisplayName("Quando tenho 1 item válido então 1 item é encontrado")
    public void testFindByIdQuandoIdItemValidoEntao1ItemRetornado() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(Item.builder().id(1L).build()));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }

    private Collection<Item> criarItems(Integer qtd) {
        Collection<Item> itens = new ArrayList<>();
        Faker faker = new Faker(new Locale("pt_BR"));
        for (long i = 0; i < qtd; i++) {
            itens.add(
                    Item.builder()
                            .id(i)
                            .tipoCliente(TipoCliente.A)
                            .produto(Produto.builder()
                                    .valor(faker.number().randomDouble(2, 200, 2000))
                                    .nome(faker.commerce().productName())
                                    .id(faker.random().nextLong())
                                    .build()
                            )
                            .qtd(qtd)
                            .build()
            );
        }
        return itens;
    }
}