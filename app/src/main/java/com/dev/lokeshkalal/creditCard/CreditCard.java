package com.dev.lokeshkalal.creditCard;

public class CreditCard {
    String cardName;
    CreditCardType creditCardType;
    String cardNumber;

    public CreditCard(String cardName, CreditCardType creditCardType, String cardNumber) {
        this.cardName = cardName;
        this.creditCardType = creditCardType;
        this.cardNumber = cardNumber;
    }
}
