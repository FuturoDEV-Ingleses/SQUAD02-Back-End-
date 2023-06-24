package com.example.devinadotion.services;

import com.example.devinadotion.dtos.EstoqueDTO;
import com.example.devinadotion.models.EstoqueModel;

import java.util.List;

public interface EstoqueService {

    List<EstoqueModel> buscarTodos();

    EstoqueModel editar(Long id, EstoqueDTO estoqueDTO) throws Exception;

    void remover(Long id) throws Exception;

    EstoqueModel cadastrarProdutoEmEstoque(EstoqueDTO EstoqueDTO) throws Exception;

    List<EstoqueModel> listarEstoquePorArmazemId(Long armazemId) throws Exception;

   // List<EstoqueDashboardDTO> listarRelatorioEstoque() throws Exception;
}
