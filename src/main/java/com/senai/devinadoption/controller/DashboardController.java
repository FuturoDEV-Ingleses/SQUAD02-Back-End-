package com.senai.devinadoption.controller;

import com.senai.devinadoption.dto.DashboardDTO;
import com.senai.devinadoption.service.EstoqueServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private final EstoqueServiceImpl estoqueService;

    public DashboardController(EstoqueServiceImpl estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    public ResponseEntity<List<DashboardDTO>> dashboard() throws Exception {
        List<DashboardDTO> dashboard = estoqueService.dashboard();
        return ResponseEntity.ok(dashboard);
    }
}

