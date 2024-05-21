package com.benefitseller.services;

import com.benefitseller.models.Card;
import com.benefitseller.models.Merchant;
import com.benefitseller.models.Transaction;
import com.benefitseller.repositories.CardRepository;
import com.benefitseller.repositories.MerchantRepository;
import com.benefitseller.repositories.TransactionRepository;
import com.benefitseller.services.Mock.TransactionMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
 @Mock
    TransactionRepository transactionRepository;
 @Mock
    CardRepository cardRepository;
 @Mock
    MerchantRepository merchantRepository;
    TransactionService transactionService;
    private Merchant merchant;
    @BeforeEach
    public void init(){
        transactionService = new TransactionService(transactionRepository,cardRepository,merchantRepository);

        merchant = new Merchant();
        merchant.setId(1L);
    }
    @Test
    public void testProcessTransaction_CardNotFound() {
        when(cardRepository.findByCardNumber("123456789")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            transactionService.processTransaction("123456789", 50.0, 1L, 1L);
        });
        assertEquals("Card not found", exception.getMessage());
    }

    @Test
    public void testProcessTransaction_InsufficientBalance() {
        Transaction savedTransaction = new TransactionMock().createInvalidTransaction();

        when(cardRepository.findByCardNumber(savedTransaction.getCard().getCardNumber())).thenReturn(Optional.of(savedTransaction.getCard()));
        when(merchantRepository.findById(merchant.getId())).thenReturn(Optional.of(merchant));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(savedTransaction);

        Transaction result = transactionService.processTransaction("19879", 150.0, 1L, 1L);

        assertNotNull(result);
        assertEquals("false", result.getSuccess());
        assertEquals(100.0, savedTransaction.getCard().getBalance());
        verify(transactionRepository,times(1)).save(any(Transaction.class));
    }

    @Test
    public void testProcessTransaction_SuccessfulTransaction() {
        Transaction savedTransaction = new TransactionMock().createSuccessTransaction();

        when(cardRepository.findByCardNumber("123456789")).thenReturn(Optional.of(savedTransaction.getCard()));
        when(merchantRepository.findById(1L)).thenReturn(Optional.of(merchant));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(savedTransaction);

        Transaction result = transactionService.processTransaction("123456789", 50.0, 1L, 1L);

        assertNotNull(result);
        assertEquals("true", result.getSuccess());
        assertEquals(50.0, savedTransaction.getCard().getBalance());
        verify(cardRepository,times(1)).save(savedTransaction.getCard());
        verify(transactionRepository,times(1)).save(any(Transaction.class));
    }

    @Test
    public void testProcessTransaction_MerchantNotFound() {
        Transaction savedTransaction = new TransactionMock().createSuccessTransaction();

        when(cardRepository.findByCardNumber("123456789")).thenReturn(Optional.of(savedTransaction.getCard()));
        when(merchantRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            transactionService.processTransaction("123456789", 50.0, 1L, 1L);
        });
        assertEquals("Merchant not found", exception.getMessage());
    }
}