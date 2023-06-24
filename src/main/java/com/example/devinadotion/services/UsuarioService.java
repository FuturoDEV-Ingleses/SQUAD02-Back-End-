package com.example.devinadotion.services;

import com.example.devinadotion.Exceptions.HttpException;
import com.example.devinadotion.dtos.UsuarioDTO;
import com.example.devinadotion.models.UsuarioModel;

public interface UsuarioService {
    UsuarioModel cadastrarUsuario(UsuarioDTO usuarioDTO) throws HttpException;
    UsuarioModel loginUsuario(String email, String senha) throws Exception;

    }



