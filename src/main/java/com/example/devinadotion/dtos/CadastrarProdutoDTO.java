package com.example.devinadotion.dtos;

import lombok.Data;

@Data
public class CadastrarProdutoDTO {
    // Cachorro ou Gato
    private String animal;

    // Filhote ou Adulto
    private String categoria;

    // Racao, Antiparasitario, Antipulgas
    private String tipo;
}
