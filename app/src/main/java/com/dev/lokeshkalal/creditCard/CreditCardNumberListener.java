package com.dev.lokeshkalal.creditCard;

public interface CreditCardNumberListener {

    void onCardTypeIdentified(CreditCardType creditCardType);

    void onCardTypeNotIdentified(String errorMessage);



    void onValidCreditCardDetected(CreditCard creditCard);

    void invalidCardNumber();

}
