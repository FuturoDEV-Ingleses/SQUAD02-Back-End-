package com.senai.devinadoption.controller;

import com.senai.devinadoption.exeptions.HttpException;
import com.senai.devinadoption.dto.UsuarioDTO;
import com.senai.devinadoption.model.Usuario;
import com.senai.devinadoption.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value ="usuario", produces = APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping(value = "/cadastro")
    public ResponseEntity cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioService.cadastrar(usuarioDTO);
            return ResponseEntity.ok("Cadastro criado com sucesso");
        } catch (HttpException e) {
            return ResponseEntity
                    .status(e.getStatus())
                    .body(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UsuarioDTO usuarioLoginDTO)
    {
        try {
            Usuario usuario = usuarioService.login(usuarioLoginDTO.getEmail(), usuarioLoginDTO.getSenha());
            return ResponseEntity.ok("Logado!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}