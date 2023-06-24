package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.CadastrarProdutoDTO;
import com.example.devinadotion.models.ProdutoModel;
import com.example.devinadotion.services.ProdutoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("cadastrar")
    private ResponseEntity cadastrarProduto(@RequestBody CadastrarProdutoDTO cadastrarProduto){
        try {
            ProdutoModel produtoModel = this.produtoService.cadastrarProduto(cadastrarProduto);
            return ResponseEntity.ok(produtoModel);
        }catch (Exception e) {
            return ResponseEntity.status(400).body("");
        }
    }
}
