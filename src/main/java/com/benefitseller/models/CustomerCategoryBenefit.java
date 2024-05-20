package com.benefitseller.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_category_benefit")
public class CustomerCategoryBenefit {

    @EmbeddedId
    private CustomerCategoryBenefitId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private CustomerCompany customerCompany;

    @ManyToOne
    @MapsId("merchantId")
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

}
