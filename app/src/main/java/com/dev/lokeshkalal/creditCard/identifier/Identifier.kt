package com.dev.lokeshkalal.creditCard.identifier

import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

interface Identifier {
    fun validateCard(cardNumber: String): CardIdentifierResult

    fun getResult(isIdentified: Boolean): CardIdentifierResult
}
