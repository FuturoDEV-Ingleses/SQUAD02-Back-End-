package com.example.devinadotion.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="estoque")
public class EstoqueModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(insertable = false, updatable = false, name = "armazem_id")
        private Long armazemId;

        @ManyToOne
        @JoinColumn(name = "armazem_id", nullable = false)
        private ArmazemModel armazem;

        @ManyToOne
        @JoinColumn(name = "produto_id", nullable = false)
        private ProdutoModel produto;

        @Column(nullable = false)
        private Integer quantidade;
    }