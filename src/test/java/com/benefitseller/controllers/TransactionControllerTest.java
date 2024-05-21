package com.benefitseller.controllers;

import com.benefitseller.DTO.TransactionRequest;
import com.benefitseller.controllers.Mock.TransactionRequestMock;
import com.benefitseller.models.Transaction;
import com.benefitseller.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {
    @Mock
    private TransactionService transactionService;

    private TransactionController transactionController;
    @BeforeEach
    public void init(){
        transactionController = new TransactionController(transactionService);
    }
    @Test
    public void testProcessTransaction() {

        TransactionRequest request = new TransactionRequestMock().createTransaction();
        Transaction expectedTransaction = new Transaction();

        expectedTransaction.setId(1);
        when(transactionService.processTransaction("cardNumber",10D,1L,2L)).thenReturn(expectedTransaction);

        ResponseEntity<Transaction> result = transactionController.processTransaction(request);

        assertNotNull(result);
        assertEquals(200,result.getStatusCodeValue());
    }
}