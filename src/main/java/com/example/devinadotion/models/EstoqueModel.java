package com.example.devinadotion.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EstoqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

// RELAÇÃO DAS TABELAS NO SQL, NÃO FIZ ESSA PARTE>>> por isso deixarei comentado
    //    @ManyToOne
    //    @JoinColumn(name = "armazem_id", nullable = false)
    //    private Armazem armazem;

    @Column(length = 20, nullable = false)
    private String produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(length = 20, nullable = false)
    private String animal;


    @Column(length = 10, nullable = false)
    private String categoria;


}
