package com.benefitseller.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import jakarta.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityScan
@Table(name="card")
public class Card {

    @Id
    private Long id;
    private String cardNumber;
    private Double balance;
    @ManyToOne
    private CardHolder user;

}
