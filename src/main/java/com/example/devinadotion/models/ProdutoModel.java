package com.example.devinadotion.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name= "TB_PRODUTO")
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = false, length = 3)
    private Integer idArmazem;
    //rever esse tópico, não entendi muito bem
    @Column(nullable = false,unique = false)
    private String tipoProduto;
    //só pode ser um entre 3 opções: Ração, antipulga, antiparasitario
    @Column(nullable = false,unique = false, length = 3)
    private Integer quantidadeProduto;
    @Column(nullable = false, unique = false)
    private String tipoAnimalProduto;
    //um entre duas opções, cachorro ou gato
    @Column(nullable = false, unique = true)
    private String tipoCategoriaProduto;
    //um entre duas opções, filhote e adulto


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Integer idArmazem) {
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