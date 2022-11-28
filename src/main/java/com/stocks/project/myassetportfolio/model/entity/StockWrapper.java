package com.stocks.project.myassetportfolio.model.entity;

import lombok.*;
import yahoofinance.Stock;

import java.time.LocalDateTime;

@Getter
@With
@Builder
@AllArgsConstructor
public class StockWrapper {
  private final Stock stock;
  private  final LocalDateTime lastAccessed;

  public StockWrapper(final Stock stock) {
    this.stock = stock;
    this.lastAccessed = LocalDateTime.now();
  }
}
