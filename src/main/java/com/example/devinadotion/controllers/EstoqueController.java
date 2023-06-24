package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.EstoqueDTO;
import com.example.devinadotion.dtos.EstoqueDashboardDTO;
import com.example.devinadotion.models.EstoqueModel;
import com.example.devinadotion.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estoque", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstoqueController {

    private final EstoqueService estoqueService;
    @Autowired
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<EstoqueDashboardDTO>> gerarRelatorioEstoque() throws Exception {
        List<EstoqueDashboardDTO> estoque = estoqueService.listarRelatorioEstoque();
        return ResponseEntity.ok(estoque);
    }

    @GetMapping
    public ResponseEntity<List<EstoqueModel>> buscarTodos() {
        List<EstoqueModel> estoque = estoqueService.buscarTodos();
        return ResponseEntity.ok(estoque);
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody EstoqueDTO estoqueDTO) {
        try {
            EstoqueModel estoque = estoqueService.editar(id, estoqueDTO);
            return ResponseEntity.ok(String.valueOf(estoque));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/remover")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        try {
            estoqueService.remover(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarProdutoEmEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        try {
            EstoqueModel estoque = estoqueService.cadastrarProdutoEmEstoque(estoqueDTO);
            return ResponseEntity.ok(estoque);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}