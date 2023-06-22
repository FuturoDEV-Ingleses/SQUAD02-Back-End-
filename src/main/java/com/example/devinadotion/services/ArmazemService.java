package com.example.devinadotion.services;

import com.example.devinadotion.models.ArmazemModel;
import com.example.devinadotion.repository.ArmazemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArmazemService {

    final ArmazemRepository armazemRepository;

    public ArmazemService(ArmazemRepository armazemRepository) {
        this.armazemRepository = armazemRepository;
    }

    @Transactional
    public Object save(ArmazemModel armazemModel) {
        return armazemRepository.save(armazemModel);
    }

    public boolean existsByNomeArmazem(String armazemNome){
        return armazemRepository.existsByArmazemNome(armazemNome);
    }

    public List<ArmazemModel> findAll() {
        return armazemRepository.findAll();
    }

    public Optional<ArmazemModel> findById(UUID id) {
        return armazemRepository.findById(id);
    }

    @Transactional
    public void delete(ArmazemModel armazemModel) {
        armazemRepository.delete(armazemModel);
    }
}
