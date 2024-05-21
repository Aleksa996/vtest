package com.benefitseller.controllers;

import com.benefitseller.DTO.TransactionRequest;
import com.benefitseller.models.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benefitseller.services.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping
    public ResponseEntity<Transaction> processTransaction(@RequestBody TransactionRequest request) {
        Transaction transaction = transactionService.processTransaction(request.getCardNumber(), request.getAmount(), request.getMerchantId(), request.getCategoryId());
        return ResponseEntity.ok(transaction);
    }
}
