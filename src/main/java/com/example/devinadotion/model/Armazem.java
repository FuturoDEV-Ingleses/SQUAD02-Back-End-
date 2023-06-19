package com.example.devinadotion.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( length = 30,nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo_animal;

    @Column(columnDefinition = "boolean default false")
    private boolean ativo;
}
