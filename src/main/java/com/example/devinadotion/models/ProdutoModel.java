package com.example.devinadotion.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: Substituir string por enum
    @Column( length = 8,nullable = false)
    private String animal;

    //TODO: Substituir string por enum
    @Column(length = 7 , nullable = false)
    private String categoria;

    //TODO: Substituir string por enum
    @Column(length = 15 , nullable = false)
    private String tipo;
}
