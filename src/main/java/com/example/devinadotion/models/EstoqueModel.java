package com.example.devinadotion.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EstoqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 8, nullable = false)
    private String animal;

    @Enumerated(EnumType.STRING)
    @Column(length = 7, nullable = false)
    private String categoria;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private String tipo;
}