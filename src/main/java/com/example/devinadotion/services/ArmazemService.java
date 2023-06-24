package com.example.devinadotion.services;

import com.example.devinadotion.dtos.ArmazemDTO;
import com.example.devinadotion.models.ArmazemModel;

public interface ArmazemService {

    ArmazemModel cadastrarArmazem(ArmazemDTO armazemDTO);

    ArmazemModel editarArmazem(Long id, ArmazemDTO armazemDTO) throws Exception;

    void desativar(Long id) throws Exception;
}
