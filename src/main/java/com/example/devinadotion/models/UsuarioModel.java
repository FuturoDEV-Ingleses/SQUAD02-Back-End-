package com.example.devinadotion.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( length = 100,nullable = false)
    private String nome;

    @Column(length = 100 , nullable = false)
    private String email;

    @Column(length = 30 , nullable = false)
    private String senha;
}
