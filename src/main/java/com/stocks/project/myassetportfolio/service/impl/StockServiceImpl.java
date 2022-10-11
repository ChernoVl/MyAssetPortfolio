package com.stocks.project.myassetportfolio.service.impl;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import com.stocks.project.myassetportfolio.model.entity.StockWrapper;
import com.stocks.project.myassetportfolio.repository.StockRepository;
import com.stocks.project.myassetportfolio.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StockWrapper> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<StockWrapper> findById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public StockWrapper save(StockDto stockDto) {
        StockWrapper stock = modelMapper.map(stockDto, StockWrapper.class);
        return stockRepository.save(stock);
    }

    @Override
    public Optional<StockWrapper> update(Long id, StockDto stockDto) {
        return stockRepository.findById(id)
                .map(st -> {
                   StockWrapper stock = modelMapper.map(stockDto, StockWrapper.class);
                   stock.setId(id);
                   return stockRepository.save(stock);
                });
    }

    @Override
    public void deleteById(Long id) {
        try {
            stockRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception){
            log.info(exception.getMessage(), exception);
        }
    }
}
