package com.dev.lokeshkalal.creditCard.identifier;


import com.dev.lokeshkalal.creditCard.CreditCardType;

public class MasterCardIdentifier implements Identifier {

    String pattern;
    final static int MAX_NUMBER = 16;
    final static int MIN_NUMBER = 16;

    public MasterCardIdentifier() {
        pattern = "^(5[1-5][0-9]{0,14}|2(22[1-9][0-9]{0,12}|2[3-9][0-9]{13}|[3-6][0-9]{0,14}|7[0-1][0-9]{13}|720[0-9]{0,12}))$";
    }

    @Override
    public CardIdentifierResult validateCard(String cardNumner) {
        if (cardNumner.matches(pattern)) {
            return new CardIdentifierResult(CreditCardType.MASTERCARD, MAX_NUMBER, MIN_NUMBER);
        } else {
            return  CardIdentifierResult.InvalidCard();
        }

    }

}
