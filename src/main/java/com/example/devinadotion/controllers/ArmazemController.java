package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.ArmazemDTO;
import com.example.devinadotion.models.ArmazemModel;
import com.example.devinadotion.services.ArmazemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/armazem", produces = APPLICATION_JSON_VALUE)
public class ArmazemController {
    private final ArmazemService armazemService;

    public ArmazemController(ArmazemService armazemService) {
        this.armazemService = armazemService;
    }

   @PostMapping("/")
   public ResponseEntity<ArmazemModel> cadastrarArmazem(@RequestBody ArmazemDTO armazemDTO) {
       ArmazemModel armazemModel = armazemService.cadastrarArmazem(armazemDTO);
       return ResponseEntity.ok(armazemModel);
   }

    @PutMapping("/{id}")
    public ResponseEntity<ArmazemModel> editarArmazem(@PathVariable Long id, @RequestBody ArmazemDTO armazemDTO) {
        try {
            ArmazemModel armazemEditado = armazemService.editarArmazem(id, armazemDTO);
            return ResponseEntity.ok(armazemEditado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            this.armazemService.desativar(id);
            return ResponseEntity.ok("Armazém excluído com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

