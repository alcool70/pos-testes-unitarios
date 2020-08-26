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
    double tolerance = 0.01;

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
                generateItems(this.totalDeItens, new Random().nextInt(3000), -1, "")
        );
        //Procedimento
        Collection<Item> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(this.totalDeItens, resultados.size());
        resultados.forEach(System.out::println);
    }

    @Test
    @DisplayName("Quando não tenho itens então nenhum item é carregado")
    public void testFindAllQuandoNenhumItemEntao0ItemsSaoCarregados() {
        Mockito.when(this.mock.getAll()).thenReturn(generateItems(0, 0, -1,""));
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
                generateItems(1, new Random().nextInt(3000), -1,"")
                        .iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente A, qtde 1 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 111.10±0.01")
    public void testClienteAQtd1VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 1, 123.45,"A").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(111.1, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente B, qtde 1 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 104.93±0.01")
    public void testClienteBQtd1VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 1, 123.45,"B").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(104.93, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente C, qtde 1 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 98.76±0.01")
    public void testClienteCQtd1VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 1, 123.45,"C").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(98.76, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente A, qtde 100 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 117.27±0.01")
    public void testClienteAQtd100VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 100, 123.45,"A").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(117.27, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente B, qtde 100 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 111.10±0.01")
    public void testClienteBQtd100VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 100, 123.45,"B").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(111.1, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente C, qtde 100 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 104.93±0.01")
    public void testClienteCQtd100VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 100, 123.45,"C").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(104.93, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente A, qtde 100 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 123.45±0.01")
    public void testClienteAQtd1000VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 1000, 123.45,"A").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(123.45, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente B, qtde 1000 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 117.27±0.01")
    public void testClienteBQtd1000VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 1000, 123.45,"B").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(117.27, resultado.get().getValorComDesconto(), tolerance);
    }

    @Test
    @DisplayName("Para 1 item válido com Cliente C, qtde 1000 e valor do produto 123.45 "+
            "então 1 item é encontrado com Valor com desconto 111.10±0.01")
    public void testClienteCQtd1000VlrThen1ItemVlr() {
        Mockito.when(this.mock.get(1L)).thenReturn(Optional.of(
                generateItems(1, 1000, 123.45,"C").iterator().next()
        ));
        //Procedimento
        Optional<Item> resultado = this.driver.findById(this.idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
        assertEquals(111.11, resultado.get().getValorComDesconto(), tolerance);
    }
}