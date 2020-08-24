package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Item;
import br.unipe.alcool70.calculadoradedescontos.model.Produto;
import br.unipe.alcool70.calculadoradedescontos.model.TipoCliente;
import br.unipe.alcool70.calculadoradedescontos.repository.ItemRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemRepositoryStub implements ItemRepository {
    private Collection<Item> items = new ArrayList<>();
    private Faker faker = new Faker(new Locale("pt_BR"));

    @Override
    public Collection<Item> getAll() {
        return this.items;
    }

    @Override
    public Optional<Item> get(Long id) {
        if (id == 1L)
            return Optional.of(Item.builder()
                    .id(1L)
                    .tipoCliente(TipoCliente.valueOf(
                            Arrays.asList("A", "B", "C")
                                    .get(new Random().nextInt(2))
                    ))
                    .produto(Produto.builder()
                            .valor(faker.number().randomDouble(2, 200, 2000))
                            .nome(faker.commerce().productName())
                            .id(faker.random().nextLong())
                            .build()
                    )
                    .qtd(new Random().nextInt(3000))
                    .build()
            );
        else return Optional.empty();
    }

    public void generateItems(int qtdItems, int qtd, String tipoCliente) {
        long i = 1;
        do {
            this.items.add(
                    Item.builder()
                            .id(i++)
                            .tipoCliente(TipoCliente.valueOf(tipoCliente))
                            .produto(Produto.builder()
                                    .valor(faker.number().randomDouble(2, 200, 2000))
                                    .nome(faker.commerce().productName())
                                    .id(faker.random().nextLong())
                                    .build()
                            )
                            .qtd(qtd)
                            .build()
            );
        } while (this.items.size() < qtdItems);
    }
}
