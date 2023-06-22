package com.example.devinadotion.repository;

import com.example.devinadotion.models.ArmazemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArmazemRepository extends JpaRepository<ArmazemModel, UUID> {

    boolean existsByArmazemNome(String armazemNome);
}
