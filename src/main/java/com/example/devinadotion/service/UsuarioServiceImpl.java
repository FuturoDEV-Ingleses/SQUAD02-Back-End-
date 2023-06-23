package com.example.devinadotion.service;

import com.example.devinadotion.dto.UsuarioDTO;
import com.example.devinadotion.model.Usuario;
import com.example.devinadotion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        String nome = usuarioDTO.getNome();
        String email = usuarioDTO.getEmail();
        String senha = usuarioDTO.getSenha();

        if (usuarioRepository.existsByEmail(email)) {
            throw new Exception("O email já está cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        return usuarioRepository.save(usuario);
    }
}

