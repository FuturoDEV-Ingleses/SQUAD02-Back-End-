package com.senai.devinadoption.dto;

import org.springframework.beans.factory.annotation.Value;


public interface DashboardDTO {
    @Value(value = "#{target.categoria}")
    String getCategoria();

    @Value(value = "#{target.produto}")
    String getProduto();

    @Value(value = "#{target.animal}")
    String getAnimal();

    @Value(value = "#{target.quantidade}")
    long getQuantidade();
}


