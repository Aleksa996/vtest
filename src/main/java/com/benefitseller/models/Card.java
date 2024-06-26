package com.benefitseller.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import jakarta.persistence.*;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityScan
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "card_holder_id")
    private CardHolder cardHolder;

    @OneToMany(mappedBy = "card")
    private Set<Transaction> transactions;

}
