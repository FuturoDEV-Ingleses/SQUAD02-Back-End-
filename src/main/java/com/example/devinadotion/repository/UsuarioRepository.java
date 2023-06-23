package com.example.devinadotion.repository;

import com.example.devinadotion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    boolean existsByEmail(String email);

}
