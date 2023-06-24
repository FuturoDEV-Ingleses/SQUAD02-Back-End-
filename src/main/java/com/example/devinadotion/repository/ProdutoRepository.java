package com.example.devinadotion.repository;

import com.example.devinadotion.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {


  //  boolean existsByProdutoNome(String produtoNome);
}

