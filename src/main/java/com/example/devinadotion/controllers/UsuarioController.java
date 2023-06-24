package com.example.devinadotion.controllers;

import com.example.devinadotion.Exceptions.HttpException;
import com.example.devinadotion.dtos.UsuarioDTO;
import com.example.devinadotion.dtos.UsuarioLoginDTO;
import com.example.devinadotion.models.UsuarioModel;
import com.example.devinadotion.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            UsuarioModel usuarioModel = usuarioService.cadastrarUsuario(usuarioDTO);
            return ResponseEntity.ok(usuarioModel);
        } catch (HttpException e) {
            return ResponseEntity
                    .status(e.getStatus())
                    .body(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity loginUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        try {
            UsuarioModel usuario = usuarioService.loginUsuario(usuarioLoginDTO.getEmail(), usuarioLoginDTO.getSenha());
            return ResponseEntity.ok(usuario);
        } catch (HttpException e) {
            return ResponseEntity
                    .status(e.getStatus())
                    .body(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}