package com.stocks.project.myassetportfolio.service.impl;

import com.stocks.project.myassetportfolio.dataprovider.dto.DillerDto;
import com.stocks.project.myassetportfolio.model.entity.Diller;
import com.stocks.project.myassetportfolio.repository.DillerRepository;
import com.stocks.project.myassetportfolio.service.DillerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DillerServiceImpl implements DillerService {

    private final DillerRepository dillerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Diller> getAll() {
        return dillerRepository.findAll();
    }

    @Override
    public Optional<Diller> getById(Long id) {
        return dillerRepository.findById(id);
    }

    @Override
    public Diller create(DillerDto dillerDto) {
        return dillerRepository.save(modelMapper.map(dillerDto, Diller.class));
    }

    @Override
    public Optional<Diller> update(Long id, DillerDto dillerDto) {
        return dillerRepository.findById(id)
                .map(d -> {
                    Diller diller = modelMapper.map(dillerDto, Diller.class);
                    diller.setId(id);
                    return dillerRepository.save(diller);
                });
    }

    @Override
    public void deleteById(Long id) {
        try{
            dillerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception){
            log.info(exception.getMessage(), exception);
        }
    }
}
