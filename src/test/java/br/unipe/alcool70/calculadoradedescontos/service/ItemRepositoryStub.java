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
    private static Faker faker = new Faker(new Locale("pt_BR"));

    @Override
    public Collection<Item> getAll() {
        return this.items;
    }

    @Override
    public Optional<Item> get(Long id) {
        if (id == 1L)
            return Optional.of(
                    generateItems(1, new Random().nextInt(3000), -1,"")
                            .iterator().next()
            );
        else return Optional.empty();
    }

    public static Collection<Item> generateItems(int qtdItems, int qtd, double vlr, String tipoCliente) {
        String clientType = tipoCliente.isBlank()
                ? Arrays.asList("A", "B", "C").get(new Random().nextInt(2))
                : tipoCliente;
        Collection<Item> items = new ArrayList<>();
        long i = 1;
        while (items.size() < qtdItems) {
            items.add(
                    Item.builder()
                            .id(i++)
                            .tipoCliente(TipoCliente.valueOf(clientType))
                            .produto(Produto.builder()
                                    .valor(
                                            vlr < 0
                                                ? faker.number().randomDouble(2, 200, 2000)
                                                : vlr
                                    )
                                    .nome(faker.commerce().productName())
                                    .id(faker.random().nextLong())
                                    .build()
                            )
                            .qtd(qtd)
                            .build()
            );
        }
        return items;
    }
}
