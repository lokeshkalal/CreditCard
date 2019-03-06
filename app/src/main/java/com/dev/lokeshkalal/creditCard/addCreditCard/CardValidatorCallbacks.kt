package com.dev.lokeshkalal.creditCard.addCreditCard

interface CardValidatorCallbacks {
    fun onValidCard(creditCard: CreditCard)

    fun onInvalidCard(@ValidatorErrorResponseCode errorCode: Int)
}
