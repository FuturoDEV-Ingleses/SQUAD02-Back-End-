package com.senai.devinadoption.service;

import com.senai.devinadoption.dto.DashboardDTO;
import com.senai.devinadoption.dto.EstoqueDTO;
import com.senai.devinadoption.model.Estoque;

import java.util.List;

public interface EstoqueService {
    List<Estoque> buscarTodos();

    Estoque editar(Long id, EstoqueDTO estoqueDTO) throws Exception;

    void removerItem(Long itemId) throws Exception;
    Estoque cadastrarProdutoEmEstoque(EstoqueDTO EstoqueDTO) throws Exception;
    List<EstoqueDTO> listarEstoque() throws Exception;
    List<DashboardDTO> listarRelatorioEstoque() throws Exception;

}
