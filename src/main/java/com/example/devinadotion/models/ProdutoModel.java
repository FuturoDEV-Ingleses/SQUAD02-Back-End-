package com.example.devinadotion.models;

import com.example.devinadotion.enums.Categoria;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( length = 8,nullable = false)
    private String animal;

    @Column(length = 7 , nullable = false)
    private String categoria;


    @Column(length = 15 , nullable = false)
    private String tipo;
}
