package com.dev.lokeshkalal.creditCard.identifier

interface Identifier {
    fun validateCard(cardNumber: String): CardIdentifierResult
}
