package com.dev.lokeshkalal.creditCard.identifier;


import com.dev.lokeshkalal.creditCard.CreditCardType;

public class DinerCardIdentifier implements Identifier {
    String pattern;
    final static int MAX_NUMBER = 14;
    final static int MIN_NUMBER = 14;

    public DinerCardIdentifier() {
        pattern = "^3(?:0[0-5]|[68][0-9])[0-9]{0,11}$";
    }

    @Override
    public CardIdentifierResult validateCard(String cardNumner) {
        if (cardNumner.matches(pattern)) {
            return new CardIdentifierResult(CreditCardType.DINER, MAX_NUMBER, MIN_NUMBER);
        } else {
            return CardIdentifierResult.InvalidCard();
        }
    }
}
