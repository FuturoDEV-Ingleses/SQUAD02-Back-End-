package com.example.devinadotion.services;

import com.example.devinadotion.dtos.CadastrarProdutoDTO;
import com.example.devinadotion.dtos.ProdutoDTO;
import com.example.devinadotion.models.ProdutoModel;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

        ProdutoModel cadastrarProduto(CadastrarProdutoDTO cadastrarProdutoDTO) throws Exception;

        Optional<ProdutoModel> pesquisarProduto(ProdutoDTO produtoDTO) throws Exception;

        List<ProdutoModel> listarProdutos() throws Exception;
    }

