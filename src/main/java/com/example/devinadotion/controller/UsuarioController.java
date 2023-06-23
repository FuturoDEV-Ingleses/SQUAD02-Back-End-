package com.example.devinadotion.controller;

import com.example.devinadotion.dto.UsuarioDTO;
import com.example.devinadotion.model.Usuario;
import com.example.devinadotion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity.BodyBuilder cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioService.cadastrarUsuario(usuarioDTO);
            return ResponseEntity.ok();
        } catch (Exception e) {
            return (ResponseEntity.BodyBuilder) ResponseEntity.status(400).body(e.getMessage());
        }
    }
}


