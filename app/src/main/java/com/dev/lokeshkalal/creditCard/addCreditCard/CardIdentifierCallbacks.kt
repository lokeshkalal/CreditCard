package com.dev.lokeshkalal.creditCard.addCreditCard

interface CardIdentifierCallbacks {
    fun onCardIdentified(creditCardType: CreditCardType)

    fun onNoCardIdentified(@IdentifierErrorResponseCode errorCode: Int)

}
