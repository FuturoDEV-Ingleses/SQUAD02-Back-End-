package com.senai.devinadoption.service;

import com.senai.devinadoption.dto.DashboardDTO;
import com.senai.devinadoption.dto.EstoqueDTO;
import com.senai.devinadoption.enums.Animal;
import com.senai.devinadoption.enums.Categoria;
import com.senai.devinadoption.enums.Produto;
import com.senai.devinadoption.model.Armazem;
import com.senai.devinadoption.model.Estoque;
import com.senai.devinadoption.repository.ArmazemRepository;
import com.senai.devinadoption.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueServiceImpl implements EstoqueService {
    private final EstoqueRepository estoqueRepository;
    private final ArmazemRepository armazemRepository;

    @Autowired
    public EstoqueServiceImpl(EstoqueRepository estoqueRepository, ArmazemRepository armazemRepository) {
        this.estoqueRepository = estoqueRepository;
        this.armazemRepository = armazemRepository;
    }
    @Override
    public List<Estoque> buscarTodos() {
        return estoqueRepository.findAll();
    }
    @Override
    public Estoque cadastrarProdutoEmEstoque(EstoqueDTO estoqueDTO) throws Exception {
        Armazem armazem = armazemRepository.findById(estoqueDTO.getArmazemId())
                .orElseThrow(() -> new Exception("Armazém não encontrado"));

        if (!armazemAceitaProduto(armazem, estoqueDTO.getAnimal())) {
            throw new Exception("O armazém não aceita produtos desse animal");
        }

        Produto produto = Produto.fromValue(estoqueDTO.getProduto().getValue());
        if (produto == null) {
            throw new Exception("Produto inválido");
        }

        Categoria categoria = Categoria.fromValue(estoqueDTO.getCategoria().getValue());
        if (categoria == null) {
            throw new Exception("Categoria inválida");
        }

        Estoque estoque = new Estoque();
        estoque.setArmazem(armazem);
        estoque.setProduto(produto);
        estoque.setQuantidade(estoqueDTO.getQuantidade());
        estoque.setAnimal(estoqueDTO.getAnimal());
        estoque.setCategoria(categoria);

        return estoqueRepository.save(estoque);
    }
    @Override
    public Estoque editar(Long id, EstoqueDTO estoqueDTO) throws Exception {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new Exception("Item do estoque não encontrado"));

        Armazem armazem = estoque.getArmazem();
        Animal animal = estoqueDTO.getAnimal();

        if (!armazemAceitaProduto(armazem, animal)) {
            throw new Exception("O armazém não aceita produtos desse animal");
        }

        estoque.setProduto(estoqueDTO.getProduto());
        estoque.setQuantidade(estoqueDTO.getQuantidade());

        return estoqueRepository.save(estoque);
    }

    private boolean armazemAceitaProduto(Armazem armazem, Animal animal) {
        return armazem.getAnimal().equals(animal);
    }

    @Override
    public List<EstoqueDTO> listarEstoque() {
        List<Estoque> estoqueList = estoqueRepository.findAll();
        List<EstoqueDTO> estoqueDTOList = new ArrayList<>();

        for (Estoque estoque : estoqueList) {
            EstoqueDTO estoqueDTO = new EstoqueDTO();
            estoqueDTO.setId(estoque.getId());
            estoqueDTO.setArmazemId(estoque.getArmazem().getId());
            estoqueDTO.setArmazenado(estoque.getArmazem().getNome());
            estoqueDTO.setProduto(estoque.getProduto());
            estoqueDTO.setQuantidade(estoque.getQuantidade());
            estoqueDTO.setCategoria(estoque.getCategoria());
            estoqueDTO.setAnimal(estoque.getArmazem().getAnimal());

            estoqueDTOList.add(estoqueDTO);
        }

        return estoqueDTOList;
    }
    @Override
    public void removerItem(Long itemId) throws Exception {
        Optional<Estoque> optionalEstoque = estoqueRepository.findById(itemId);
        if (optionalEstoque.isPresent()) {
            Estoque estoque = optionalEstoque.get();
            estoqueRepository.delete(estoque);
        } else {
            throw new Exception("Item de estoque não encontrado");
        }
    }
    @Override
    public List<DashboardDTO> dashboard() throws Exception {
        return estoqueRepository.dashboard();
    }
}
