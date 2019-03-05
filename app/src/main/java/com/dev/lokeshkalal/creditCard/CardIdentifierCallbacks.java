package com.dev.lokeshkalal.creditCard;

public interface CardIdentifierCallbacks {
    void onCardIdentified(CreditCardType creditCardType);

    void onNoCardIdentified(@IdentifierErrorResponseCode int errorCode);

}
