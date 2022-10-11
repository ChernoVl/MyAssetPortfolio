package com.stocks.project.myassetportfolio.controller;

import com.stocks.project.myassetportfolio.model.entity.StockWrapper;
import com.stocks.project.myassetportfolio.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockRepository stockRepository;

    @GetMapping
    public ResponseEntity<List<StockWrapper>> getAll(){
        return ResponseEntity.ok(stockRepository.findAll());
    }
}
