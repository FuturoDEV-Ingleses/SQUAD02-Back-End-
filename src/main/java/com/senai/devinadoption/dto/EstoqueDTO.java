package com.senai.devinadoption.dto;

import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.enums.Categoria;
import com.senai.devinadoption.enums.Produto;
import lombok.Data;

@Data
public class EstoqueDTO {
    private Long id;
    private Long armazemId;
    private String armazenado;
    private Produto produto;
    private Integer quantidade;
    private Animal animal;
    private Categoria categoria;

    }

