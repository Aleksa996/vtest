package com.benefitseller.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TransactionRequest {
    private String cardNumber;
    private Double amount;
    private Long merchantId;
    private Long categoryId;
}
