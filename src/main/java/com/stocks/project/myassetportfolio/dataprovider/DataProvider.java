package com.stocks.project.myassetportfolio.dataprovider;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;

import java.util.stream.Stream;

public interface DataProvider {

    Stream<StockDto> loadData();

}
