package com.stocks.project.myassetportfolio.scheduler;

import com.stocks.project.myassetportfolio.dataprovider.DataProvider;
import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final DataProvider dataProvider;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void schedule(){
        log.info("Scheduler started at {}", Instant.now());
        dataProvider.loadData().forEach(dto -> storeToDatabase(dto));
    }

    private void storeToDatabase(StockDto dto) {

    }

}
