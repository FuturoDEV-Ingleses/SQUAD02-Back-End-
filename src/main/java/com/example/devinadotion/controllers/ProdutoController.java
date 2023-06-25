package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.CadastrarProdutoDTO;
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

        @PostMapping("/cadastrar")
        public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody CadastrarProdutoDTO cadastrarProduto) {
            try {
                ProdutoModel produto = produtoService.cadastrarProduto(cadastrarProduto);
                return ResponseEntity.ok(produto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
    @PostMapping("/pesquisar")
    public ResponseEntity<Optional<ProdutoModel>> pesquisarProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            Optional<ProdutoModel> produtos = produtoService.pesquisarProduto(produtoDTO);
            return ResponseEntity.ok(produtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        try {
            List<ProdutoModel> produtos = produtoService.listarProdutos();
            return ResponseEntity.ok(produtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
