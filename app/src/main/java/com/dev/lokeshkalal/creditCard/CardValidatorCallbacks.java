package com.dev.lokeshkalal.creditCard;

public interface CardValidatorCallbacks {
    void onValidCard(CreditCard creditCard);

    void onInvalidCard(@ValidatorErrorResponseCode int errorCode);
}
