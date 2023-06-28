package com.senai.devinadoption.controller;

import com.senai.devinadoption.dto.EstoqueDTO;
import com.senai.devinadoption.model.Estoque;
import com.senai.devinadoption.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;
    @Autowired
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }


 @GetMapping("/listar")
 public ResponseEntity<List<EstoqueDTO>> listarEstoque() {
     try {
         List<EstoqueDTO> estoqueDTOList = estoqueService.listarEstoque();
         return ResponseEntity.ok(estoqueDTOList);
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
 }
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProdutoEmEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        try {
            Estoque estoque = estoqueService.cadastrarProdutoEmEstoque(estoqueDTO);
            return ResponseEntity.ok(estoque);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
        @PutMapping("/editar/{id}")
        public ResponseEntity<Estoque> editar(@PathVariable Long id, @RequestBody EstoqueDTO estoqueDTO) {
            try {
                Estoque estoque = estoqueService.editar(id, estoqueDTO);
                return ResponseEntity.ok(estoque);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
    @DeleteMapping("/remover/{itemId}")
    public ResponseEntity<String> removerItem(@PathVariable Long itemId) {
        try {
            estoqueService.removerItem(itemId);
            return ResponseEntity.ok("Item removido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

