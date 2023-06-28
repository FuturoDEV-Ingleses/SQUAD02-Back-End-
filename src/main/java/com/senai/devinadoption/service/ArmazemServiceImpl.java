package com.senai.devinadoption.service;

import com.senai.devinadoption.exeptions.NomeArmazemObrigatorioException;
import com.senai.devinadoption.exeptions.NotFoundException;
import com.senai.devinadoption.exeptions.TipoAnimalInvalidoException;
import com.senai.devinadoption.dto.ArmazemDTO;
import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.model.Armazem;
import com.senai.devinadoption.repository.ArmazemRepository;
import com.senai.devinadoption.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArmazemServiceImpl implements ArmazemService {
    private final ArmazemRepository armazemRepository;
    private final EstoqueService estoqueService;
    private final EstoqueRepository estoqueRepository;

    public ArmazemServiceImpl(ArmazemRepository armazemRepository, EstoqueService estoqueService, EstoqueRepository estoqueRepository) {
        this.armazemRepository = armazemRepository;
        this.estoqueService = estoqueService;
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public List<Armazem> buscarTodos() {
        return armazemRepository.findAll();
    }

    @Override
    public Armazem cadastrar(ArmazemDTO armazemDTO) throws NomeArmazemObrigatorioException, TipoAnimalInvalidoException {
        String nome = armazemDTO.getNome();
        Animal animal = armazemDTO.getAnimal();

        if (nome == null || nome.isEmpty()) {
            throw new NomeArmazemObrigatorioException();
        }

        if (!Animal.contains(animal)) {
            throw new TipoAnimalInvalidoException(animal.getValue());
        }

        Armazem armazem = new Armazem();
        armazem.setNome(nome);
        armazem.setAnimal(animal);
        armazem.setAtivo(true);

        return armazemRepository.save(armazem);
    }

    @Override
    public Armazem editar(Long id, ArmazemDTO armazemDTO) throws Exception {
        Optional<Armazem> optionalArmazem = armazemRepository.findById(id);
        if (optionalArmazem.isEmpty()) {
            throw new Exception("Armazém não encontrado");
        }

        Armazem armazem = optionalArmazem.get();
        armazem.setNome(armazemDTO.getNome());
        armazem.setAnimal(armazemDTO.getAnimal());

        return armazemRepository.save(armazem);
    }
    @Override
    public Optional<Armazem> findById(Long id) {
        return armazemRepository.findById(id);
    }
    @Override
    public void desativarArmazem(Long armazemId) throws Exception {
        Armazem armazem = armazemRepository.findById(armazemId)
                .orElseThrow(() -> new NotFoundException("Armazém não encontrado."));

        if (verificarProdutosAlocados(armazemId)) {
            throw new Exception("Não é possível desativar o armazém pois há produtos alocados a ele.");
        }

        armazem.setAtivo(false);
        armazemRepository.save(armazem);
    }
    private boolean verificarProdutosAlocados(Long armazemId) {
        return estoqueRepository.existsByArmazemId(armazemId);
    }
        @Override
        public Armazem save (Armazem armazem){
            return armazemRepository.save(armazem);
        }

    }



