package com.example.devinadotion.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProdutoDto {

    @NotBlank
    @Size(max=30)
    private String idArmazem;
    @NotBlank
    @Size(max=15)
    private String tipoProduto;
    @NotBlank
    @Size(max=3)
    private Integer quantidadeProduto;
    @NotBlank
    private String tipoAnimalProduto;
    @NotBlank
    private String tipoCategoriaProduto;

    public String getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(String idArmazem) {
        this.idArmazem = idArmazem;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getTipoAnimalProduto() {
        return tipoAnimalProduto;
    }

    public void setTipoAnimalProduto(String tipoAnimalProduto) {
        this.tipoAnimalProduto = tipoAnimalProduto;
    }

    public String getTipoCategoriaProduto() {
        return tipoCategoriaProduto;
    }

    public void setTipoCategoriaProduto(String tipoCategoriaProduto) {
        this.tipoCategoriaProduto = tipoCategoriaProduto;
    }
}