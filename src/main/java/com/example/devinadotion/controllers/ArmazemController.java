package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.ArmazemDTO;
import com.example.devinadotion.models.ArmazemModel;
import com.example.devinadotion.services.ArmazemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/armazem", produces = MediaType.APPLICATION_JSON_VALUE)
public class ArmazemController {
    private final ArmazemService armazemService;

    @Autowired
    public ArmazemController(ArmazemService armazemService) {
        this.armazemService = armazemService;
    }
    @PostMapping
    public ResponseEntity<ArmazemModel> cadastrarArmazem(@RequestBody ArmazemDTO armazemDTO) {
        ArmazemModel armazem = armazemService.cadastrarArmazem(armazemDTO);
        return ResponseEntity.ok(armazem);
    }

    @PutMapping("/")
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

