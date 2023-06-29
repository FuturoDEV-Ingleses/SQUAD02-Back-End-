package com.senai.devinadoption.controller;

import com.senai.devinadoption.dto.DashboardDTO;
import com.senai.devinadoption.repository.EstoqueRepository;
import com.senai.devinadoption.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private final EstoqueService estoqueService;
    private final EstoqueRepository estoqueRepository;

    public DashboardController(EstoqueService estoqueService, EstoqueRepository estoqueRepository) {
        this.estoqueService = estoqueService;
        this.estoqueRepository = estoqueRepository;
    }

    @GetMapping("/relatorio")
    public ResponseEntity<Map<String, Map<String, Object>>> gerarRelatorioEstoque() throws Exception {
        List<DashboardDTO> estoque = estoqueService.listarRelatorioEstoque();

        Map<String, Map<String, Object>> resultado = new LinkedHashMap<>();

        for (DashboardDTO item : estoque) {
            String animal = item.getAnimal();
            String categoria = item.getCategoria();

            if (!resultado.containsKey(animal)) {
                resultado.put(animal, new LinkedHashMap<>());
            }

            Map<String, Object> animalMap = resultado.get(animal);

            if (!animalMap.containsKey(categoria)) {
                animalMap.put(categoria, new LinkedHashMap<>());
            }

            Map<String, Object> categoriaMap = (Map<String, Object>) animalMap.get(categoria);

            // Atualize os valores dos atributos para cada categoria
            if (!categoriaMap.containsKey("racao")) {
                categoriaMap.put("racao", item.getSomaRacao() + " kg");
            }

            if (!categoriaMap.containsKey("antiparasitario")) {
                categoriaMap.put("antiparasitario", item.getQuantidade());
            } else {
                long antiparasitario = (long) categoriaMap.get("antiparasitario") + item.getQuantidade();
                categoriaMap.put("antiparasitario", antiparasitario);
            }

            if (!categoriaMap.containsKey("antipulgas")) {
                categoriaMap.put("antipulgas", item.getQuantidade());
            } else {
                long antipulgas = (long) categoriaMap.get("antipulgas") + item.getQuantidade();
                categoriaMap.put("antipulgas", antipulgas);
            }

            animalMap.put(categoria, categoriaMap);
            resultado.put(animal, animalMap);
        }

        // Criar uma cópia do mapa resultado
        Map<String, Map<String, Object>> resultadoCopy = new LinkedHashMap<>(resultado);

        // Atualizar a soma do número de animais por categoria
        for (Map.Entry<String, Map<String, Object>> entry : resultadoCopy.entrySet()) {
            String animal = entry.getKey();
            Map<String, Object> animalMap = entry.getValue();
            int totalAnimais = 0;

            for (String categoria : animalMap.keySet()) {
                if (!categoria.equals(animal)) {
                    totalAnimais += 1;
                }
            }

            String totalAnimaisKey = animal + "s";
            if (!resultado.containsKey(totalAnimaisKey)) {
                resultado.put(totalAnimaisKey, new LinkedHashMap<>());
            }

            resultado.get(totalAnimaisKey).put("total", totalAnimais);
        }

        return ResponseEntity.ok(resultado);
    }
}
