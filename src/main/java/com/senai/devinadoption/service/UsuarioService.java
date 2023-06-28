package com.senai.devinadoption.service;

import com.senai.devinadoption.exeptions.EmailJaCadastradoException;
import com.senai.devinadoption.dto.UsuarioDTO;
import com.senai.devinadoption.model.Usuario;

public interface UsuarioService {
    Usuario cadastrar(UsuarioDTO usuarioDTO) throws EmailJaCadastradoException;
    Usuario login(String email, String senha) throws Exception;

}


