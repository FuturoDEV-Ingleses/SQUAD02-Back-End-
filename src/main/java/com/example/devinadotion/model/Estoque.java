package com.example.devinadotion.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


       @ManyToOne
       @JoinColumn(name = "armazem_id", nullable = false)
       private Armazem armazem;

    @Column(length = 20, nullable = false)
    private String produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(length = 20, nullable = false)
    private String animal;


    @Column(length = 10, nullable = false)
    private String categoria;


}
