package com.example.devinadotion.dtos;

import lombok.Data;

@Data
public class EstoqueDTO {
    private Long armazemId;
    private ProdutoDTO produto;
    private int quantidade;
}
