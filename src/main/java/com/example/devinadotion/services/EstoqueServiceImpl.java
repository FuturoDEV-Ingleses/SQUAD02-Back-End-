package com.example.devinadotion.services;

import com.example.devinadotion.dtos.EstoqueDTO;
import com.example.devinadotion.dtos.EstoqueDashboardDTO;
import com.example.devinadotion.dtos.ProdutoDTO;
import com.example.devinadotion.models.ArmazemModel;
import com.example.devinadotion.models.EstoqueModel;
import com.example.devinadotion.models.ProdutoModel;
import com.example.devinadotion.repository.ArmazemRepository;
import com.example.devinadotion.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstoqueServiceImpl implements EstoqueService{
    private final EstoqueRepository estoqueRepository;
    private final ArmazemRepository armazemRepository;
    private final ProdutoService produtoService;

    @Autowired
    public EstoqueServiceImpl(EstoqueRepository estoqueRepository, ArmazemRepository armazemRepository, ProdutoService produtoService) {
        this.estoqueRepository = estoqueRepository;
        this.armazemRepository = armazemRepository;
        this.produtoService = produtoService;
    }

    @Override
    public List<EstoqueModel> buscarTodos() {
        return estoqueRepository.findAll();
    }

    @Override
    public EstoqueModel editar(Long id, EstoqueDTO estoqueDTO) throws Exception {
        EstoqueModel estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new Exception("Item do estoque não encontrado"));

       // estoque.setProduto(estoqueDTO.getProduto());
        estoque.setQuantidade(estoqueDTO.getQuantidade());

        return estoqueRepository.save(estoque);
    }
    @Override
    public void remover(Long id) throws Exception {
        Optional<EstoqueModel> optionalEstoque = estoqueRepository.findById(id);
        if (optionalEstoque.isEmpty()) {
            throw new Exception("Item do estoque não encontrado.");
        }
        estoqueRepository.delete(optionalEstoque.get());
    }
    @Override
    public EstoqueModel cadastrarProdutoEmEstoque(EstoqueDTO estoqueDTO) throws Exception {
        Long armazemId = estoqueDTO.getArmazemId();
        ProdutoDTO produtoDTO = estoqueDTO.getProduto();
        int quantidade = estoqueDTO.getQuantidade();

        Optional<ArmazemModel> optionalArmazem = armazemRepository.findById(armazemId);

        if (optionalArmazem.isEmpty()) {
            throw new Exception("O armazém não foi encontrado.");
        }

        ArmazemModel armazem = optionalArmazem.get();

        if (!armazem.isAtivo()) {
            throw new Exception("O armazém não foi encontrado.");
        }

        Optional<ProdutoModel> produtoResponse = this.produtoService.pesquisarProduto(produtoDTO);

        if(produtoResponse.isEmpty()) {
            throw new Exception("Produto nao existe.");
        }

        ProdutoModel produto = produtoResponse.get();

        EstoqueModel estoque = new EstoqueModel();
        estoque.setArmazem(armazem);
        estoque.setProduto(produto);
        estoque.setQuantidade(quantidade);

        return estoqueRepository.save(estoque);
    }

    @Override
    public List<EstoqueModel> listarEstoquePorArmazemId(Long armazemId) throws Exception {
        EstoqueModel teste = new EstoqueModel();
        teste.setArmazemId(armazemId);

        return this.estoqueRepository.findAll(Example.of(teste));
    }

   @Override
     public List<EstoqueDashboardDTO> listarRelatorioEstoque() throws Exception {
       return estoqueRepository.gerarRelatorioEstoque();
    }
}
