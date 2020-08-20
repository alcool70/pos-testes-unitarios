package br.unipe.alcool70.calculadoradedescontos.service;

import br.unipe.alcool70.calculadoradedescontos.model.Produto;
import br.unipe.alcool70.calculadoradedescontos.repository.ProdutoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    @Setter
    ProdutoRepository produtoRepository;

    public Collection<Produto> findAll() {
        return this.produtoRepository.getAll();
    }

    public Optional<Produto> findById(Long id) {
        return this.produtoRepository.get(id);
    }

}
