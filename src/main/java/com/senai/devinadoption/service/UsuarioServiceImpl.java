package com.senai.devinadoption.service;

import com.senai.devinadoption.exeptions.EmailJaCadastradoException;
import com.senai.devinadoption.dto.UsuarioDTO;
import com.senai.devinadoption.model.Usuario;
import com.senai.devinadoption.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario cadastrar(UsuarioDTO usuarioDTO) throws EmailJaCadastradoException {
        String nome = usuarioDTO.getNome();
        String email = usuarioDTO.getEmail();
        String senha = usuarioDTO.getSenha();

        if (usuarioRepository.existsByEmail(email)) {
            throw new EmailJaCadastradoException();
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        return usuarioRepository.save(usuario);
    }
    @Override
    public Usuario login(String email, String senha) throws Exception {
        if (email.isEmpty() || senha.isEmpty()) {
            throw new Exception("E-mail e senha são obrigatórios para efetuar o login.");
        }

        Optional<Usuario> usuarioResponse = usuarioRepository.findByEmail(email);
        if (usuarioResponse.isEmpty()) {
            throw new Exception("E-mail ou senha incorretos.");
        }

        Usuario usuario = usuarioResponse.get();

        if (!usuario.getSenha().equals(senha)) {
            throw new Exception("E-mail ou senha incorretos.");
        }

        return usuario;
    }
}

