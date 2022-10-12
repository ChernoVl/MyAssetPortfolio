package com.stocks.project.myassetportfolio.service.impl;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import com.stocks.project.myassetportfolio.service.ImportService;
import com.stocks.project.myassetportfolio.service.StockService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImportServiceImpl implements ImportService {

    private final StockService stockRepository;

    @Override
    public void storeToDatabase(StockDto dto) {
        stockRepository.save(dto);
    }

}
