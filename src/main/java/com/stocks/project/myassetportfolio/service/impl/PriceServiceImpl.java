package com.stocks.project.myassetportfolio.service.impl;

import com.stocks.project.myassetportfolio.dataprovider.dto.PriceDto;
import com.stocks.project.myassetportfolio.model.entity.Price;
import com.stocks.project.myassetportfolio.repository.PriceRepository;
import com.stocks.project.myassetportfolio.service.PriceService;
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
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Price> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public Optional<Price> findById(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public Price save(PriceDto priceDto) {
        return priceRepository.save(modelMapper.map(priceDto, Price.class));
    }

    @Override
    public Optional<Price> update(Long id, PriceDto priceDto) {
        return priceRepository.findById(id)
                .map(p -> {
                    Price price = modelMapper.map(priceDto, Price.class);
                    price.setId(id);
                    return priceRepository.save(price);
                });
    }

    @Override
    public void deleteById(Long id) {
        try{
            priceRepository.deleteById(id);
        }catch (EmptyResultDataAccessException exception){
            log.info(exception.getMessage(), exception);
        }
    }

}
