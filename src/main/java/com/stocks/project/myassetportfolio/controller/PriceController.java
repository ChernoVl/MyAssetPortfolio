package com.stocks.project.myassetportfolio.controller;

import com.stocks.project.myassetportfolio.dataprovider.dto.PriceDto;
import com.stocks.project.myassetportfolio.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<PriceDto> getAll() {
        return priceService.findAll().stream()
                .map(price -> modelMapper.map(price, PriceDto.class))
                .toList();
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<PriceDto> getById(@PathVariable Long id) {
        return priceService.findById(id)
                .map(price ->
                        ResponseEntity.ok(modelMapper.map(price, PriceDto.class)))
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @PostMapping
    public PriceDto create(@Valid @RequestBody PriceDto priceDto) {
        return modelMapper.map(priceService.save(priceDto), PriceDto.class);
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<PriceDto> update(@PathVariable Long id, @Valid @RequestBody PriceDto priceDto) {
        return priceService.update(id, priceDto)
                .map(price -> ResponseEntity.ok(modelMapper.map(price, PriceDto.class)))
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<PriceDto> delete(@PathVariable Long id) {
        priceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
