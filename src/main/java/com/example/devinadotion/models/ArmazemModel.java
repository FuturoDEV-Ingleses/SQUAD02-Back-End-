package com.example.devinadotion.models;

import com.example.devinadotion.enums.Animal;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name="armazem")
public class ArmazemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Animal animal;

    @Column(columnDefinition = "boolean default false")
    private boolean ativo;
}
