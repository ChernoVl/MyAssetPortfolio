package com.stocks.project.myassetportfolio.service;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;

public interface ImportService {

    void storeToDatabase(StockDto dto);

}
