package com.example.devinadotion.models;

import com.example.devinadotion.enums.Animal;
import com.example.devinadotion.enums.Categoria;
import com.example.devinadotion.enums.TipoProduto;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name="produto")
@Data
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Animal animal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProduto tipo;
}
