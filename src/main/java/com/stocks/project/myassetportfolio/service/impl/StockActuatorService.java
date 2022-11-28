package com.stocks.project.myassetportfolio.service.impl;

import com.stocks.project.myassetportfolio.model.entity.StockWrapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

// This service call YahooAPI to get the latest data about stock
@Service
@RequiredArgsConstructor
@Slf4j
public class StockActuatorService {
  @SneakyThrows
  public StockWrapper findStock(final String ticket) {
    return new StockWrapper(YahooFinance.get(ticket));
  }

}
