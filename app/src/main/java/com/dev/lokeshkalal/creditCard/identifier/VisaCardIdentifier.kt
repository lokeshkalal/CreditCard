package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

class VisaCardIdentifier : Identifier {

    internal var pattern: String

    init {
        pattern = "^4[0-9]{0,15}\$"
    }

    override fun validateCard(cardNumber: String): CardIdentifierResult {
        return if (cardNumber.matches(pattern.toRegex())) {
            CardIdentifierResult(CreditCardType.VISA, MAX_NUMBER, MIN_NUMBER)
        } else {
            CardIdentifierResult.InvalidCard()
        }

    }

    companion object {
        internal val MAX_NUMBER = 16

        internal val MIN_NUMBER = 16
    }
}
