package com.example.devinadotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devinadotion.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {


    boolean existsByEmail(String email);

}
