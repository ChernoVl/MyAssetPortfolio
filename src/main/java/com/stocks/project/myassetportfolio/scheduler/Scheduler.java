package com.stocks.project.myassetportfolio.scheduler;

import com.stocks.project.myassetportfolio.dataprovider.DataProvider;
import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import com.stocks.project.myassetportfolio.model.entity.StockWrapper;
import com.stocks.project.myassetportfolio.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final DataProvider dummyDataProvider;

    private final StockRepository stockRepository;

    private final ModelMapper modelMapper;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void schedule(){
        log.info("Scheduler started at {}", Instant.now());
        dummyDataProvider.loadData().forEach(dto -> storeToDatabase(dto));
    }

    private void storeToDatabase(StockDto dto) {
        StockWrapper stock = modelMapper.map(dto, StockWrapper.class);
        stockRepository.save(stock);
    }

}
