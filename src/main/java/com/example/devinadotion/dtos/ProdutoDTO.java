package com.example.devinadotion.dtos;

import com.example.devinadotion.models.ProdutoModel;
import lombok.Data;


@Data
public class ProdutoDTO extends ProdutoModel {
    private String animal;
    private String categoria;
    private String tipo;
}

