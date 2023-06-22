package com.example.devinadotion.services;

import com.example.devinadotion.models.ProdutoModel;
import com.example.devinadotion.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Object save(ProdutoModel produtoModel) { return produtoRepository.save(produtoModel);}

    public boolean existsByProduto(String produtoNome){ return produtoRepository.existsByProdutoNome(produtoNome);}

    public List<ProdutoModel> findAll() {return produtoRepository.findAll();}

    public Optional<ProdutoModel> findById(UUID id) {return produtoRepository.findById(id);}

    @Transactional
    public void delete(ProdutoModel produtoModel) {produtoRepository.delete(produtoModel);}
}
