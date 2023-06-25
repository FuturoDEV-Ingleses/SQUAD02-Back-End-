package com.example.devinadotion.dtos;

import com.example.devinadotion.enums.Animal;
import com.example.devinadotion.enums.Categoria;
import com.example.devinadotion.enums.TipoProduto;
import lombok.Data;

@Data
public class CadastrarProdutoDTO {
    // Cachorro ou Gato
    private Animal animal;

    // Filhote ou Adulto
    private Categoria categoria;

    // Racao, Antiparasitario, Antipulgas
    private TipoProduto tipo;
}
