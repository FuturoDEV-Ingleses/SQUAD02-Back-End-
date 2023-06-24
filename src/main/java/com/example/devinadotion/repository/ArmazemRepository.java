package com.example.devinadotion.repository;

import com.example.devinadotion.models.ArmazemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmazemRepository extends JpaRepository<ArmazemModel, Long> {

   boolean existsByArmazemNome(String armazemNome);
}
