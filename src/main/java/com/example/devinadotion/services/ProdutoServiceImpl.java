package com.example.devinadotion.services;

import com.example.devinadotion.dtos.CadastrarProdutoDTO;
import com.example.devinadotion.dtos.ProdutoDTO;
import com.example.devinadotion.enums.Animal;
import com.example.devinadotion.enums.Categoria;
import com.example.devinadotion.enums.TipoProduto;
import com.example.devinadotion.models.ProdutoModel;
import com.example.devinadotion.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(final ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoModel cadastrarProduto(CadastrarProdutoDTO cadastrarProduto) throws Exception {

        String tipoStr = String.valueOf(cadastrarProduto.getTipo());
        if (tipoStr == null || !TipoProduto.isValidEnumValue(tipoStr)) {
            throw new Exception("Tipo inválido.");
        }
        TipoProduto tipo = TipoProduto.fromValue(tipoStr);

        String animalStr = String.valueOf(cadastrarProduto.getAnimal());
        if (animalStr == null || !Animal.isValidEnumValue(animalStr)) {
            throw new Exception("Animal inválido.");
        }
        Animal animal = Animal.fromValue(animalStr);

        String categoriaStr = String.valueOf(cadastrarProduto.getCategoria());
        if (categoriaStr == null || !Categoria.isValidEnumValue(categoriaStr)) {
            throw new Exception("Categoria inválida.");
        }
        Categoria categoria = Categoria.fromValue(categoriaStr);


        ProdutoModel produto = new ProdutoModel();
        produto.setTipo(tipo);
        produto.setAnimal(animal);
        produto.setCategoria(categoria);
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<ProdutoModel> pesquisarProduto(ProdutoDTO produtoDTO) {

        ProdutoModel exemplo = new ProdutoModel();
        if (produtoDTO.getTipo() != null) {
            exemplo.setTipo(TipoProduto.fromValue(produtoDTO.getTipo()));
        }
        if (produtoDTO.getAnimal() != null) {
            exemplo.setAnimal(Animal.fromValue(produtoDTO.getAnimal()));
        }
        if (produtoDTO.getCategoria() != null) {
            exemplo.setCategoria(Categoria.fromValue(produtoDTO.getCategoria()));
        }
        
        Example<ProdutoModel> example = Example.of(exemplo);
        
        return produtoRepository.findOne(example);
    }

    @Override
    public List<ProdutoModel> listarProdutos() throws Exception {
        return produtoRepository.findAll();
    }
}