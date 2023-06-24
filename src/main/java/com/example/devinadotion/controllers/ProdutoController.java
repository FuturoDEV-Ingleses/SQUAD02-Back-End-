package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.CadastrarProdutoDTO;
import com.example.devinadotion.models.ProdutoModel;
import com.example.devinadotion.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "produto", produces = APPLICATION_JSON_VALUE)
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("cadastrar")
    private ResponseEntity cadastrarProduto(@RequestBody CadastrarProdutoDTO cadastrarProduto){
        try {
            ProdutoModel produto = this.produtoService.cadastrarProduto(cadastrarProduto);
            return ResponseEntity.ok(produto);
        }catch (Exception e) {
            return ResponseEntity.status(400).body("");
        }
    }
}
