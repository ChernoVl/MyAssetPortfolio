package com.stocks.project.myassetportfolio.dataprovider.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class StockDto {
    private String fullName;
    private String ticker;
    private BigDecimal currPrice;
    private Instant updatedDate;
}
