package com.stocks.project.myassetportfolio.service.impl;
import com.stocks.project.myassetportfolio.model.entity.StockEntity;
import com.stocks.project.myassetportfolio.model.entity.StockWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class StockActuatorServiceTest {
  @InjectMocks
  private StockActuatorService stockActuatorService;

  private ModelMapper modelMapper;
  private static final String STOCK_TICKER_EXAMPLE = "UU.L";
  private static final String STOCK_TICKER_EXAMPLE_TSLA = "TSLA";
  private static final String STOCK_TICKER_NAME_EXAMPLE_TSLA = "Tesla, Inc.";

  @BeforeEach
  public void setup() {
    this.modelMapper = new ModelMapper();
    this.modelMapper.typeMap(StockWrapper.class, StockEntity.class).addMappings(mapper -> {
      mapper.map(src -> src.getStock().getName(), StockEntity::setName);
      mapper.map(src -> src.getStock().getQuote().getPrice(), StockEntity::setCurrPrice);
      mapper.map(src -> src.getStock().getSymbol(), StockEntity::setSymbol);
    });
  }

  @Test
  void findStock_happyPath() {
    final StockWrapper stockWrapper = stockActuatorService.findStock(STOCK_TICKER_EXAMPLE);

    assertThat(stockWrapper.getStock().getSymbol()).isEqualTo(STOCK_TICKER_EXAMPLE);
  }

  @Test
  void mapToStockEntity_happyPath() {
    final StockEntity expectedStock = StockEntity.builder()
            .name(STOCK_TICKER_NAME_EXAMPLE_TSLA)
            .symbol(STOCK_TICKER_EXAMPLE_TSLA)
            .currPrice(BigDecimal.valueOf(182.86))
            .build();

    final StockWrapper stockWrapper = stockActuatorService.findStock(STOCK_TICKER_EXAMPLE_TSLA);

    final StockEntity mappedStockEntity = this.modelMapper.map(stockWrapper, StockEntity.class);

    assertThat(mappedStockEntity.getSymbol()).isEqualTo(expectedStock.getSymbol());
    assertThat(mappedStockEntity.getName()).isEqualTo(expectedStock.getName());
    assertThat(mappedStockEntity.getCurrPrice()).isEqualTo(BigDecimal.valueOf(182.86));
  }

}