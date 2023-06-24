package com.example.devinadotion.services;

import com.example.devinadotion.dtos.CadastrarProdutoDTO;
import com.example.devinadotion.dtos.ProdutoDTO;
import com.example.devinadotion.models.ProdutoModel;
import com.example.devinadotion.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        String[] categorias = new String[]{"adulto", "filhote"};
        String[] animais = new String[] {"cachorro", "gato"};
        String[] tipos = new String[] {"racao", "antiparasitario", "antipulgas", "animal"};

        String tipo = cadastrarProduto.getTipo();

        if(tipo.isEmpty() || !Arrays.asList(tipos).contains(tipo)) {
            throw new Exception("Tipo invalido.");
        }

        String animal = cadastrarProduto.getAnimal();

        if(animal.isEmpty() || !Arrays.asList(animais).contains(animal)) {
            throw new Exception("Animal invalido.");
        }

        String categoria = cadastrarProduto.getCategoria();

        if(categoria.isEmpty() || !Arrays.asList(categorias).contains(categoria)) {
            throw new Exception("Categoria invalido.");
        }

        ProdutoModel produto = new ProdutoModel();
        produto.setTipo(tipo);
        produto.setAnimal(animal);
        produto.setCategoria(categoria);

        return this.produtoRepository.save(produto);
    }

    @Override
    public Optional<ProdutoModel> pesquisarProduto(ProdutoDTO produtoDTO) {
        String categoria = produtoDTO.getCategoria();
        String tipo = produtoDTO.getTipo();
        String animal = produtoDTO.getAnimal();

        ProdutoModel teste = new ProdutoModel();

        if(!categoria.isEmpty()) {
            teste.setCategoria(categoria);
        }

        if(!tipo.isEmpty()) {
            teste.setTipo(tipo);
        }

        if(!animal.isEmpty()) {
            teste.setAnimal(animal);
        }

        Example<ProdutoModel> example = Example.of(teste);

        return this.produtoRepository.findOne(example);
    }

    @Override
    public List<ProdutoModel> listarProdutos() throws Exception {
        return List.of(new ProdutoModel[0]);
    }
}
