package com.benefitseller.controllers.Mock;

import com.benefitseller.DTO.TransactionRequest;

public class TransactionRequestMock {
    public TransactionRequest createTransaction(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount(10D);
        transactionRequest.setCategoryId(2L);
        transactionRequest.setCardNumber("cardNumber");
        transactionRequest.setMerchantId(1L);
        return  transactionRequest;
    }
}

