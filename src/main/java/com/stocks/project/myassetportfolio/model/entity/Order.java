package com.stocks.project.myassetportfolio.model.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Instant buyingDate;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "price_id")
    private Price price;

}
