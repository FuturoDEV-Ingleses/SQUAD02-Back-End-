package com.example.devinadotion.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ArmazemDto {

    @NotBlank
    @Size(max=30)
    private String nomeArmazem;
    @NotBlank
    private boolean dogOrCat;
    @NotBlank
    private boolean situacaoArmazem;

    public String getNomeArmazem() {
        return nomeArmazem;
    }

    public void setNomeArmazem(String nomeArmazem) {
        this.nomeArmazem = nomeArmazem;
    }

    public boolean isDogOrCat() {
        return dogOrCat;
    }

    public void setDogOrCat(boolean dogOrCat) {
        this.dogOrCat = dogOrCat;
    }

    public boolean isSituacaoArmazem() {
        return situacaoArmazem;
    }

    public void setSituacaoArmazem(boolean situacaoArmazem) {
        this.situacaoArmazem = situacaoArmazem;
    }


}
