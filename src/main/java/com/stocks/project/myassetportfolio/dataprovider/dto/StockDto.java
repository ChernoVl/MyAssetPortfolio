package com.stocks.project.myassetportfolio.dataprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDto {

    private String fullName;
    private String ticker;
    private BigDecimal currPrice;
    private Instant updatedDate;

}
