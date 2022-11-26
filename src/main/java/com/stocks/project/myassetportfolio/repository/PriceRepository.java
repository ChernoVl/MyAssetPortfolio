package com.stocks.project.myassetportfolio.repository;

import com.stocks.project.myassetportfolio.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
