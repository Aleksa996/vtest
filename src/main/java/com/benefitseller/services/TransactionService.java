package com.benefitseller.services;

import com.benefitseller.models.Card;
import com.benefitseller.models.Transaction;
import com.benefitseller.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.benefitseller.repositories.CardRepository;
import com.benefitseller.repositories.MerchantRepository;
import com.benefitseller.repositories.TransactionRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    public TransactionService(TransactionRepository transactionRepository,CardRepository cardRepository,MerchantRepository merchantRepository) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
        this.merchantRepository = merchantRepository;
    }

    public Transaction processTransaction(String cardNumber, Double amount, Long merchantId, Long categoryId) {
        Optional<Card> cardOpt = cardRepository.findByCardNumber(cardNumber);
        if (cardOpt.isEmpty()) {
            throw new RuntimeException("Card not found");
        }

        Card card = cardOpt.get();
        if (card.getBalance() < amount) {
            return saveTransaction(card, amount, merchantId, categoryId, "false");
        }

        card.setBalance(card.getBalance() - amount);
        cardRepository.save(card);
        return saveTransaction(card, amount, merchantId, categoryId, "true");
    }

    private Transaction saveTransaction(Card card, Double amount, Long merchantId, Long categoryId, String success) {
        Transaction transaction = new Transaction();
        transaction.setCard(card);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setSuccess(success);
        transaction.setMerchant(merchantRepository.findById(merchantId).orElseThrow(() -> new RuntimeException("Merchant not found")));
        return transactionRepository.save(transaction);
    }

}
