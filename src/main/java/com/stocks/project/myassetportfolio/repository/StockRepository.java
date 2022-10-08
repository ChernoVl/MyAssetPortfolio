package com.stocks.project.myassetportfolio.repository;

import com.stocks.project.myassetportfolio.model.entity.StockWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockWrapper, Long> {
}
