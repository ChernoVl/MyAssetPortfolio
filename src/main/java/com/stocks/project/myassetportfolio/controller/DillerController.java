package com.stocks.project.myassetportfolio.controller;

import com.stocks.project.myassetportfolio.dataprovider.dto.DillerDto;
import com.stocks.project.myassetportfolio.service.DillerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diller")
public class DillerController {

    private final DillerService dillerService;
    private final ModelMapper modelMapper;

    @GetMapping
    List<DillerDto> getAll(){
        return dillerService.getAll().stream()
                .map(diller -> modelMapper.map(diller, DillerDto.class))
                .toList();
    }

    @GetMapping("/{id:[\\d]+}")
    ResponseEntity<DillerDto> getById(@PathVariable Long id){
        return dillerService.getById(id)
                .map(diller ->
                        ResponseEntity.ok(modelMapper.map(diller, DillerDto.class)))
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @PostMapping
    DillerDto create(@Valid @RequestBody DillerDto dillerDto){
        return modelMapper.map(dillerService.create(dillerDto), DillerDto.class);
    }

    @PutMapping("/{id:[\\d]+}")
    ResponseEntity<DillerDto> update(@PathVariable Long id, @Valid @RequestBody DillerDto dillerDto){
        return dillerService.update(id, dillerDto)
                .map(diller ->
                        ResponseEntity.ok(modelMapper.map(diller, DillerDto.class)))
                .orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    @DeleteMapping("/{id:[\\d]+}")
    ResponseEntity<DillerDto> delete(@PathVariable Long id){
        dillerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
