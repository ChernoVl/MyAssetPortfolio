package com.stocks.project.myassetportfolio.model.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal brutto;
    private BigDecimal stockPurchasePrice;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "stock_wrapper_id")
    private StockWrapper stockWrapper;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "diller_id")
    private Diller diller;

}
