package com.stocks.project.myassetportfolio.service;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import com.stocks.project.myassetportfolio.model.entity.StockEntity;

import java.util.List;
import java.util.Optional;

public interface StockService {

    List<StockEntity> findAll();

    Optional<StockEntity> findById(Long id);

    StockEntity save(StockDto stockDto);

    Optional<StockEntity> update(Long id, StockDto stockDto);

    void deleteById(Long id);

}
