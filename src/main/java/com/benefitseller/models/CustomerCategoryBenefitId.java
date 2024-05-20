package com.benefitseller.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class CustomerCategoryBenefitId implements Serializable {

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "merchant_id")
    private Integer merchantId;

}