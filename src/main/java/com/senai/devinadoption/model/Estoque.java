package com.senai.devinadoption.model;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.enums.Categoria;
import com.senai.devinadoption.enums.Produto;
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

    @Enumerated(EnumType.STRING)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    private Animal animal;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

}
