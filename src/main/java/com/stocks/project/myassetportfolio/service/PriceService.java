package com.stocks.project.myassetportfolio.service;

import com.stocks.project.myassetportfolio.dataprovider.dto.PriceDto;
import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import com.stocks.project.myassetportfolio.model.entity.Price;
import com.stocks.project.myassetportfolio.model.entity.StockEntity;

import java.util.List;
import java.util.Optional;

public interface PriceService {

    List<Price> findAll();

    Optional<Price> findById(Long id);

    Price save(PriceDto priceDto);

    Optional<Price> update(Long id, PriceDto priceDto);

    void deleteById(Long id);

}
