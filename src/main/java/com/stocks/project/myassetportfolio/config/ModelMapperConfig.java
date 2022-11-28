package com.stocks.project.myassetportfolio.config;

import com.stocks.project.myassetportfolio.model.entity.StockEntity;
import com.stocks.project.myassetportfolio.model.entity.StockWrapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(StockWrapper.class, StockEntity.class).addMappings(mapper -> {
            mapper.map(src -> src.getStock().getName(), StockEntity::setName);
            mapper.map(src -> src.getStock().getQuote().getPrice(), StockEntity::setCurrPrice);
            mapper.map(src -> src.getStock().getSymbol(), StockEntity::setSymbol);
        });
        return modelMapper;
    }
}
