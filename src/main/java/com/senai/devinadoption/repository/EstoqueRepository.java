package com.senai.devinadoption.repository;

import com.senai.devinadoption.dto.DashboardDTO;
import com.senai.devinadoption.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Estoque e WHERE e.armazem.id = :armazemId")
    boolean existsByArmazemId(@Param("armazemId") Long armazemId);
    @Query(value = "SELECT categoria, produto, animal, SUM(quantidade) AS quantidade " +
            "FROM estoque " +
            "GROUP BY categoria, produto, animal", nativeQuery = true)
    List<DashboardDTO> gerarRelatorioEstoque();


}


