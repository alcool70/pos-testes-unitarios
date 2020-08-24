package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Item;
import br.unipe.alcool70.calculadoradedescontos.repository.ItemRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    @Setter
    ItemRepository itemRepository;

    public Collection<Item> findAll() {
        return this.itemRepository.getAll();
    }

    public Optional<Item> findById(Long id) {
        return this.itemRepository.get(id);
    }

    public Optional<Double> getValorComDesconto(Long id) {
        if (itemRepository.get(id).isPresent()) {
            Item item = itemRepository.get(id).get();
            return Optional.of(item.getValorComDesconto());
        } else
            return Optional.empty();
    }
}
