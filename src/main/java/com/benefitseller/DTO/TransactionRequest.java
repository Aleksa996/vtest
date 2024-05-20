package com.benefitseller.DTO;

import lombok.Data;

@Data
public class TransactionRequest {
    private String cardNumber;
    private Double amount;
    private Long merchantId;
}
