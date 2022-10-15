package com.stocks.project.myassetportfolio.service;

import com.stocks.project.myassetportfolio.dataprovider.dto.DillerDto;
import com.stocks.project.myassetportfolio.model.entity.Diller;

import java.util.List;
import java.util.Optional;

public interface DillerService {

    List<Diller> getAll();

    Optional<Diller> getById(Long id);

    Diller create(DillerDto dillerDto);

    Optional<Diller> update(Long id, DillerDto dillerDto);

    void deleteById(Long id);

}
