package com.example.devinadotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devinadotion.models.EstoqueModel;

public interface EstoqueRepository extends JpaRepository <EstoqueModel, Long> {

}
