package com.example.devinadotion.dtos;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

public interface EstoqueDashboardDTO {
    @Value(value = "#{target.categoria}")
    String getCategoria();

    @Value(value = "#{target.tipo}")
    String getTipo();

    @Value(value = "#{target.animal}")
    String getAnimal();

    @Value(value = "#{target.quantidade}")
    long getQuantidade();
}
