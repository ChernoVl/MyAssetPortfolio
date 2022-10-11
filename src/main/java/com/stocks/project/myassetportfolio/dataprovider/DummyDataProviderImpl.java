package com.stocks.project.myassetportfolio.dataprovider;

import com.stocks.project.myassetportfolio.dataprovider.dto.StockDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class DummyDataProviderImpl implements DataProvider {
    @Override
    public Stream<StockDto> loadData() {
        return IntStream
                .rangeClosed(1, 100)
                .mapToObj(this::buildDto);
    }

    private StockDto buildDto(int i) {
        return StockDto.builder()
                .fullName("stock number " + i)
                .ticker("ticker: " + i * 2)
                .currPrice(BigDecimal.valueOf((i * 100. - 54.) / 100.))
                .updatedDate(Instant.now())
                .build();
    }
}
