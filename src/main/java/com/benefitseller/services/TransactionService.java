package com.benefitseller.services;

import com.benefitseller.models.Card;
import com.benefitseller.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.benefitseller.repositories.CardRepository;
import com.benefitseller.repositories.MerchantRepository;
import com.benefitseller.repositories.TransactionRepository;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MerchantRepository merchantRepository;

    public Transaction processTransaction(String cardNumber, Double amount, Long merchantId) {
        Optional<Card> cardOpt = cardRepository.findByCardNumber(cardNumber);
        if (cardOpt.isEmpty()) {
            throw new RuntimeException("Card not found");
        }

        Card card = cardOpt.get();
        if (card.getBalance() < amount) {
            return saveTransaction(card, amount, merchantId, false);
        }

        card.setBalance(card.getBalance() - amount);
        cardRepository.save(card);
        return saveTransaction(card, amount, merchantId, true);
    }

    private Transaction saveTransaction(Card card, Double amount, Long merchantId, Boolean success) {
        Transaction transaction = new Transaction();
        transaction.setCard(card);
        transaction.setAmount(amount);
        transaction.setTimestamp(new Timestamp(System.currentTimeMillis()));
        transaction.setSuccess(success);
        transaction.setMerchant(merchantRepository.findById(merchantId).orElseThrow(() -> new RuntimeException("Merchant not found")));
        return transactionRepository.save(transaction);
    }

}
