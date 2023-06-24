package com.example.devinadotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devinadotion.models.UsuarioModel;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    boolean existsByEmail(String email);
    Optional<UsuarioModel> findByEmail(String email);

}
