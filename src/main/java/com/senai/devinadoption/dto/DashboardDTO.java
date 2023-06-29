package com.senai.devinadoption.dto;

import org.springframework.beans.factory.annotation.Value;


public interface DashboardDTO {
    @Value("#{target.categoria}")
    String getCategoria();

    @Value("#{target.produto}")
    String getProduto();

    @Value("#{target.animal}")
    String getAnimal();

    @Value("#{target.quantidade}")
    long getQuantidade();

    // Métodos adicionais para somar os produtos por categoria, animal e tipo de produto
    @Value("#{target.produto.equals('RACAO') ? target.quantidade : 0}")
    long getSomaRacao();

    @Value("#{target.produto.equals('ANTIPULGAS') ? target.quantidade : 0}")
    long getSomaAntipulgas();

    @Value("#{target.produto.equals('ANTIPARASITARIO') ? target.quantidade : 0}")
    long getSomaAntiparasitario();

    @Value("#{target.produto.equals('Gato') ? target.quantidade : 0}")
    long getSomaGato();

    @Value("#{target.animal.equals('CACHORRO') ? target.quantidade : 0}")
    long getSomaCachorro();
}

