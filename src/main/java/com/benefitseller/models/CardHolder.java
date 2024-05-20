package com.benefitseller.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityScan
@Table(name="card_holder")
public class CardHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userType;

    @ManyToOne
    @JoinColumn(name = "customer_company_id")
    private CustomerCompany customerCompany;

    @OneToMany(mappedBy = "cardHolder")
    private Set<Card> cards;
}
