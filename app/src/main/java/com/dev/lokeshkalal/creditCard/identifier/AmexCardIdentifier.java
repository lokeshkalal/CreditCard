package com.dev.lokeshkalal.creditCard.identifier;


import com.dev.lokeshkalal.creditCard.CreditCardType;

public class AmexCardIdentifier implements Identifier {

    String pattern;
    final static int MAX_NUMBER = 15;

    final static int MIN_NUMBER = 15;

    public AmexCardIdentifier() {
        pattern = "^3[47][0-9]{0,13}$";
    }

    @Override
    public CardIdentifierResult validateCard(String cardNumner) {
        if (cardNumner.matches(pattern)) {
            return new CardIdentifierResult(CreditCardType.AMERICAN_EXPRESS, MAX_NUMBER, MIN_NUMBER);
        } else {
            return CardIdentifierResult.InvalidCard();
        }

    }
}
