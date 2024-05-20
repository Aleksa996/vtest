package com.benefitseller.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityScan
@Table(name="customer_merchant")
public class CustomerMerchant {

    @EmbeddedId
    private CustomerMerchantId id;

    @Column(nullable = false)
    private Double discountAmount;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private CustomerCompany customerCompany;

    @ManyToOne
    @MapsId("merchantId")
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;
}
