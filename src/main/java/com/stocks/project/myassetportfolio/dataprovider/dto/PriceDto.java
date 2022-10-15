package com.stocks.project.myassetportfolio.dataprovider.dto;

import com.stocks.project.myassetportfolio.model.entity.Diller;
import com.stocks.project.myassetportfolio.model.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceDto {

    private BigDecimal brutto;
    private BigDecimal stockPurchasePrice;
    private StockEntity stock;
    private Diller diller;

}
