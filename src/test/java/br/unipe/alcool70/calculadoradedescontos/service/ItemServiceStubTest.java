package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import static br.unipe.alcool70.calculadoradedescontos.service.ItemRepositoryStub.generateItems;
import static org.junit.jupiter.api.Assertions.*;

class ItemServiceStubTest {

    private ItemService driver;
    private ItemRepositoryStub stub; //Stub para o Repository

    @BeforeEach
    void setUp() {
        this.driver = new ItemService();
        this.stub = new ItemRepositoryStub();
        this.driver.setItemRepository(stub);
    }

    @AfterEach
    void tearDown() {
        this.driver = null;
        this.stub = null;
    }

    @Test
    void findAllQuandoTenho10ItemsParaTipoClienteAEntao10ItemsSaoCarregados() {
        int totalDeItems = 10;
        this.stub.setItems(generateItems(totalDeItems, 10, "A"));
        //Procedimento
        Collection<Item> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(10, resultados.size());
        resultados.forEach(System.out::println);
    }

    @Test
    void testFindAllQuandoNenhumItemEntao0ItemsSaoCarregados() {
        //Procedimento
        Collection<Item> resultados = this.driver.findAll();
        //Verificacao
        assertEquals(0, resultados.size());
    }

    @Test
    void testFindByIdQuandoIdItemInexistenteEntaoNenhumItemRetornado() {
        //Procedimento
        Optional<Item> resultado = this.driver.findById(0L);
        //Verificacao
        assertTrue(resultado.isEmpty());
        assertThrows(NoSuchElementException.class, resultado::get);
    }

    @Test
    void testFindByIdQuandoIdItemValidoEntao1ItemRetornado() {
        //Procedimento
        Long idItemValido = 1L;
        Optional<Item> resultado = this.driver.findById(idItemValido);
        //Verificacao
        assertTrue(resultado.isPresent());
        assertNotNull(resultado.get());
    }
}