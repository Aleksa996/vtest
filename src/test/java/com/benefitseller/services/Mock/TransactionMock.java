package com.benefitseller.services.Mock;

import com.benefitseller.models.Card;
import com.benefitseller.models.Transaction;

public class TransactionMock {
    public Transaction createSuccessTransaction(){
        Card card = new Card();
        card.setCardNumber("123456789");
        card.setBalance(100.0);
        Transaction transaction = new Transaction();
        transaction.setCard(card);
        transaction.setAmount(card.getBalance());
        transaction.setSuccess("true");
        return transaction;
    }

    public Transaction createInvalidTransaction(){
        Card card = new Card();
        card.setCardNumber("19879");
        card.setBalance(100.0);
        Transaction transaction = new Transaction();
        transaction.setCard(card);
        transaction.setAmount(card.getBalance());
        transaction.setSuccess("false");
        return transaction;
    }

}
