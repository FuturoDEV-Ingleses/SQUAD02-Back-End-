package com.example.devinadotion.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

//Neli fez ao invés de Entity, usou @Data. Não sei dizer qual melhor opção. Se for usar @Data tem que importar ali em cima
@Entity
@Table(name= "TB_ARMAZEM")
public class ArmazemModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String nomeArmazem;
    @Column(nullable = false)
    private boolean dogOrCat;
    @Column(nullable = false)
    private boolean situacaoArmazem;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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