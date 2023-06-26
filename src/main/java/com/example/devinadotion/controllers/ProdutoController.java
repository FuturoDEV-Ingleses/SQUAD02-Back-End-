package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.ProdutoDTO;
import com.example.devinadotion.models.ProdutoModel;
import com.example.devinadotion.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "produto", produces = APPLICATION_JSON_VALUE)
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoModel> get() throws Exception {
        return produtoService.buscarTodos();
    }

    @PostMapping("cadastrar")
    private ResponseEntity cadastrarProduto(@RequestBody ProdutoDTO produtoDTO){
        try {
            ProdutoModel produto = this.produtoService.cadastrarProduto(produtoDTO);
            return ResponseEntity.ok(produto);
        }catch (Exception e) {
            return ResponseEntity.status(400).body("");
        }
    }



    @GetMapping("/pesquisar")
    public ResponseEntity<Optional<ProdutoModel>> pesquisarProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            Optional<ProdutoModel> produtos = produtoService.pesquisarProduto(produtoDTO);
            return ResponseEntity.ok(produtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

