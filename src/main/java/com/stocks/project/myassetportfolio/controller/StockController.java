package com.stocks.project.myassetportfolio.controller;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import com.stocks.project.myassetportfolio.service.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<StockDto>> getAll() {
        return ResponseEntity.ok(
                stockService.findAll().stream()
                        .map(stock -> modelMapper.map(stock, StockDto.class))
                        .toList());
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<StockDto> getById(@PathVariable Long id){
        return stockService.findById(id)
                .map(stock -> ResponseEntity.ok(modelMapper.map(stock, StockDto.class)))
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @PostMapping
    public ResponseEntity<StockDto> create(@Valid @RequestBody StockDto stockDto){
        return ResponseEntity.ok(modelMapper.map(stockService.save(stockDto), StockDto.class));
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<StockDto> update(@PathVariable Long id, @Valid @RequestBody StockDto stockDto){
        return stockService.update(id, stockDto)
                .map(stockWrapper -> ResponseEntity.ok(modelMapper.map(stockWrapper, StockDto.class)))
                .orElseThrow(()->new RuntimeException(String.valueOf(id)));
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<StockDto> delete(@PathVariable Long id){
        stockService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
