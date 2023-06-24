package com.example.devinadotion.services;

import com.example.devinadotion.Exceptions.EmailJaCadastradoException;
import com.example.devinadotion.Exceptions.EmailOuSenhaIncoretosException;
import com.example.devinadotion.dtos.UsuarioDTO;
import com.example.devinadotion.models.UsuarioModel;
import com.example.devinadotion.repository.UsuarioRepository;
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
    public UsuarioModel cadastrarUsuario(UsuarioDTO usuarioDTO) throws EmailJaCadastradoException {
        String nome = usuarioDTO.getNome();
        String email = usuarioDTO.getEmail();
        String senha = usuarioDTO.getSenha();

        if (usuarioRepository.existsByEmail(email)) {
            throw new EmailJaCadastradoException();
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        return usuarioRepository.save(usuario);
    }
    @Override
    public UsuarioModel loginUsuario(String email, String senha) throws EmailOuSenhaIncoretosException {
        if (email.isEmpty() || senha.isEmpty()) {
            throw new EmailOuSenhaIncoretosException();
        }

        Optional<UsuarioModel> usuarioResponse = usuarioRepository.findByEmail(email);
        if (usuarioResponse.isEmpty()) {
            throw new EmailOuSenhaIncoretosException();
        }

        UsuarioModel usuario = usuarioResponse.get();

        if(!usuario.getSenha().equals(senha)) {
            throw new EmailOuSenhaIncoretosException();
        }

        return usuario;
    }

}


