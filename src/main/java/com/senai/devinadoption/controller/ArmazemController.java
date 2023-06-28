package com.senai.devinadoption.controller;


import com.senai.devinadoption.exeptions.NomeArmazemObrigatorioException;
import com.senai.devinadoption.exeptions.NotFoundException;
import com.senai.devinadoption.exeptions.TipoAnimalInvalidoException;
import com.senai.devinadoption.dto.ArmazemDTO;
import com.senai.devinadoption.model.Armazem;
import com.senai.devinadoption.service.ArmazemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/armazem")
public class ArmazemController {
    private final ArmazemService armazemService;

    public ArmazemController(ArmazemService armazemService) {
        this.armazemService = armazemService;
    }
    @GetMapping("/ar")
    public ResponseEntity<List<Armazem>> buscarTodos() {
        List<Armazem> armazens = armazemService.buscarTodos();
        return ResponseEntity.ok(armazens);
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ArmazemDTO armazemDTO) {
        try {
            Armazem armazem = armazemService.cadastrar(armazemDTO);
            return ResponseEntity.ok(armazem);
        } catch (NomeArmazemObrigatorioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (TipoAnimalInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<Armazem> editarArmazem(@PathVariable Long id, @RequestBody ArmazemDTO armazemDTO) {
        try {
            Armazem armazem = armazemService.findById(id).orElse(null);
            if (armazem == null) {
                return ResponseEntity.notFound().build();
            }

            armazem.setNome(armazemDTO.getNome());
            armazem.setAnimal(armazemDTO.getAnimal());

            Armazem armazemEditado = armazemService.save(armazem);
            return ResponseEntity.ok(armazemEditado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }@PutMapping("/desativar/{id}")
    public ResponseEntity<String> desativarArmazem(@PathVariable("id") Long armazemId) {
        try {
            armazemService.desativarArmazem(armazemId);
            return ResponseEntity.ok("Armazém desativado com sucesso.");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}


