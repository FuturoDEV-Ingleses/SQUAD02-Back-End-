package com.example.devinadotion.repository;

import com.example.devinadotion.dtos.EstoqueDashboardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.devinadotion.models.EstoqueModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstoqueRepository extends JpaRepository <EstoqueModel, Long> {
     @Query(value = "SELECT tipo, categoria, animal, SUM(quantidade) AS \"quantidade\" FROM \"estoque\" e INNER JOIN produto p ON p.id = e.produto_id GROUP BY tipo, categoria, animal;",
      nativeQuery = true)
      List<EstoqueDashboardDTO> gerarRelatorioEstoque();

}
