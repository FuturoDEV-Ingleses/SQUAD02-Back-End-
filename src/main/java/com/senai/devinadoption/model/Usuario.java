package com.senai.devinadoption.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

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