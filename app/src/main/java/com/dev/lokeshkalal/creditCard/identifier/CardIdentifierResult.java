package com.dev.lokeshkalal.creditCard.identifier;

import com.dev.lokeshkalal.creditCard.Constants;
import com.dev.lokeshkalal.creditCard.CreditCardType;

public class CardIdentifierResult {
    private CreditCardType creditCardType;
    private int maxNumber;
    private int minNumber;


    public CardIdentifierResult(CreditCardType creditCardType, int maxNumber, int minNumber) {
        this.creditCardType = creditCardType;
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    public boolean isValidCard() {
        return creditCardType != CreditCardType.INVALID;
    }

    public CreditCardType getCardType() {
        return creditCardType;
    }

    public String getCardName() {
        return creditCardType.toString();
    }

    @Override
    public String toString() {
        return "CardIdentifierResult{" +
                "creditCardType=" + creditCardType +
                ", maxNumber=" + maxNumber +
                '}';
    }


    public static CardIdentifierResult InvalidCard() {
        return new CardIdentifierResult(CreditCardType.INVALID, Constants.MAX_DEFAULT_CARD_NUMBER, Constants.MAX_DEFAULT_CARD_NUMBER);
    }

    public int maxNumberAllowed() {
        return maxNumber;
    }

    public int minNumberAllowed() {
        return minNumber;
    }
}
