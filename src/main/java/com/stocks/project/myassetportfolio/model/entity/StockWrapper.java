package com.stocks.project.myassetportfolio.model.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@Table(name="STOCK")
public class StockWrapper {
    @Id
    private Long id;
    private String fullName;
    private String ticker;
    private BigDecimal currPrice;
    private Instant updatedDate;
}
