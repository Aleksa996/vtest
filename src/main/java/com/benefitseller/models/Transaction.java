package com.benefitseller.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityScan
@Table(name="transaction")
public class Transaction {
    @Id
    private Long id;
    private Timestamp timestamp;
    private Double amount;
    @ManyToOne
    private Card card;
    @ManyToOne
    private Merchant merchant;
    private Boolean success;
}
