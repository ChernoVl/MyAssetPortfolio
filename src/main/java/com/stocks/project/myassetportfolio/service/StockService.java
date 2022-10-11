package com.stocks.project.myassetportfolio.service;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import com.stocks.project.myassetportfolio.model.entity.StockWrapper;

import java.util.List;
import java.util.Optional;

public interface StockService {

    List<StockWrapper> findAll();

    Optional<StockWrapper> findById(Long id);

    StockWrapper save(StockDto stockDto);

    Optional<StockWrapper> update(Long id, StockDto stockDto);

    void deleteById(Long id);

}
