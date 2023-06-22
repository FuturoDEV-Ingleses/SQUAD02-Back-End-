package com.example.devinadotion.controllers;

import com.example.devinadotion.dtos.ArmazemDto;
import com.example.devinadotion.models.ArmazemModel;
import com.example.devinadotion.services.ArmazemService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/armazem")
public class ArmazemController {
    final ArmazemService armazemService;

    public ArmazemController(ArmazemService armazemService) {
        this.armazemService = armazemService;
    }

    @PostMapping
    public ResponseEntity<Object> saveArmazem(@RequestBody @Valid ArmazemDto armazemDto){

        if(armazemService.existsByNomeArmazem(armazemDto.getNomeArmazem())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Armazem já cadastrado");
        }

        var armazemModel = new ArmazemModel();
        BeanUtils.copyProperties(armazemDto, armazemModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(armazemService.save(armazemModel));
    }

    @GetMapping
    public ResponseEntity<List<ArmazemModel>> getAllArmazem(){
        return ResponseEntity.status(HttpStatus.OK).body(armazemService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArmazem(@PathVariable(value = "id") UUID id){
        Optional<ArmazemModel> armazemModelOptional = armazemService.findById(id);
        if(!armazemModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Armazem não encontrado");
        }
        boolean deletionAllowed = armazemModelOptional.get().isSituacaoArmazem();
        if(deletionAllowed == false ){
            return ResponseEntity.badRequest().body("Não é possível deletar um armazem em uso");
        }else{
            armazemService.delete(armazemModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Armazem Deletado");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArmazem(@PathVariable(value = "id") UUID id, @RequestBody @Valid ArmazemDto armazemDto){
        Optional<ArmazemModel> armazemModelOptional = armazemService.findById(id);
        if(!armazemModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Armazem não encontrado");
        }
        var armazemModel = new ArmazemModel();
        BeanUtils.copyProperties(armazemDto, armazemModel);
        armazemModel.setId(armazemModelOptional.get().getId());
        armazemModel.setSituacaoArmazem(armazemModelOptional.get().isSituacaoArmazem());
        return ResponseEntity.status(HttpStatus.OK).body(armazemService.save(armazemModel));
    }
}
