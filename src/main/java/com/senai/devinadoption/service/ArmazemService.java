package com.senai.devinadoption.service;

import com.senai.devinadoption.exeptions.NomeArmazemObrigatorioException;
import com.senai.devinadoption.exeptions.TipoAnimalInvalidoException;
import com.senai.devinadoption.dto.ArmazemDTO;
import com.senai.devinadoption.model.Armazem;

import java.util.List;
import java.util.Optional;

public interface ArmazemService {

    List<Armazem> buscarTodos();
     Armazem cadastrar(ArmazemDTO armazemDTO) throws NomeArmazemObrigatorioException, TipoAnimalInvalidoException;
     Armazem editar(Long id, ArmazemDTO armazemDTO) throws Exception;
     void desativarArmazem(Long armazemId) throws Exception;
    public Optional<Armazem> findById(Long id);
    Armazem save(Armazem armazem);
}