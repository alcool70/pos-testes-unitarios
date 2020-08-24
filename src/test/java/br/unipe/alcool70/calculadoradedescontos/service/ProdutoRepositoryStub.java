package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Produto;
import br.unipe.alcool70.calculadoradedescontos.repository.ProdutoRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoRepositoryStub implements ProdutoRepository {
    private Collection<Produto> produtos;
    private Faker faker = new Faker(new Locale("pt_BR"));

    @Override
    public Collection<Produto> getAll() {
        return this.produtos;
    }

    @Override
    public Optional<Produto> get(Long id) {
        if (id == 1)
            return Optional.of(new Produto(id, "Caixa de Som", 1000.00));
        else
            return Optional.empty();
    }

    public void criarProdutos(Integer qtd) {
        this.produtos = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            this.produtos.add(new Produto(
                    i + 1L,
                    faker.commerce().productName(),
                    faker.number().randomDouble(2, 100, 2000)
            ));
        }
    }
}
