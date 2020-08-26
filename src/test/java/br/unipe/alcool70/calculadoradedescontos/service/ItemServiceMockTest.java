package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Item;
import br.unipe.alcool70.calculadoradedescontos.repository.ItemRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import static br.unipe.alcool70.calculadoradedescontos.service.ItemRepositoryStub.generateItems;
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
        Mockito.when(this.mock.getAll()).thenReturn(
                generateItems(this.totalDeItens, new Random().nextInt(3000), "")
        );
        //Procedimento
        Collection<Item> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(this.totalDeItens, resultados.size());
        resultados.forEach(System.out::println);
    }

    @Test
    @DisplayName("Quando não tenho itens então nenhum iten é carregado")
    public void testFindAllQuandoNenhumItemEntao0ItemsSaoCarregados() {
        Mockito.when(this.mock.getAll()).thenReturn(generateItems(0, 0, ""));
        //Procedimento
        Collection<Item> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
    }

    @Test
    @DisplayName("Quando um item não existe então nenhum item é encontrado")
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
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, new Random().nextInt(3000), "")
                        .iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }
}