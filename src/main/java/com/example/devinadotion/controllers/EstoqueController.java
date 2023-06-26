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

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
    public ResponseEntity<EstoqueModel> editar(@PathVariable Long id, @RequestBody EstoqueDTO estoqueDTO) {
        try {
            EstoqueModel estoque = estoqueService.editar(id, estoqueDTO);
            return (ResponseEntity<EstoqueModel>) ResponseEntity.ok();
        } catch (Exception e) {
            return (ResponseEntity<EstoqueModel>) ResponseEntity.status(NOT_FOUND);
        }
    }

    @DeleteMapping("/remover")
    public ResponseEntity<EstoqueModel> remover(@PathVariable Long id) {
        try {
            estoqueService.remover(id);
            return (ResponseEntity<EstoqueModel>) ResponseEntity.ok();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
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