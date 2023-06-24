package com.example.devinadotion.services;

import com.example.devinadotion.dtos.ArmazemDTO;
import com.example.devinadotion.models.ArmazemModel;
import com.example.devinadotion.models.EstoqueModel;
import com.example.devinadotion.repository.ArmazemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazemServiceImpl implements ArmazemService {
    private final ArmazemRepository armazemRepository;
    private final EstoqueService estoqueService;

    @Autowired
    public ArmazemServiceImpl(ArmazemRepository armazemRepository, EstoqueService estoqueService) {
        this.armazemRepository = armazemRepository;
        this.estoqueService = estoqueService;
    }

    @Override
    public ArmazemModel cadastrarArmazem(ArmazemDTO armazemDTO) {
        ArmazemModel armazem = new ArmazemModel();
        armazem.setNome(armazemDTO.getNome());
        armazem.setAnimal(armazemDTO.getAnimal());
        armazem.setAtivo(true);

        return armazemRepository.save(armazem);
    }

    @Override
    public ArmazemModel editarArmazem(Long Id, ArmazemDTO armazemDTO) throws Exception {
        Optional<ArmazemModel> optionalArmazem = armazemRepository.findById(Id);
        if (optionalArmazem.isEmpty()) {
            throw new Exception("Armazém não encontrado");
        }

        ArmazemModel armazem = optionalArmazem.get();
        armazem.setNome(armazemDTO.getNome());
        armazem.setAnimal(armazemDTO.getAnimal());

        return armazemRepository.save(armazem);
    }
    public void desativar(Long id) throws Exception {
        Optional<ArmazemModel> optionalArmazem = armazemRepository.findById(id);
        ArmazemModel armazem = optionalArmazem.orElseThrow(() -> new Exception("Armazém não encontrado."));

        List<EstoqueModel> estoques = this.estoqueService.listarEstoquePorArmazemId(id);
        if (estoques.size() > 0 || !armazem.isAtivo()) {
            throw new Exception("Não é possível excluir o armazém com produtos alocados.");
        }

        armazem.setAtivo(false);

        armazemRepository.save(armazem);
    }
}
