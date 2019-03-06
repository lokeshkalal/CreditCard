package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

class MaestroCardIdentifier : Identifier {

    internal var pattern: String

    init {
        pattern =
            "^(5018|5020|5038|6304|6759|6761|6763)[0-9]{0,15}"
    }

    override fun validateCard(cardNumber: String): CardIdentifierResult {
        return if (cardNumber.matches(pattern.toRegex())) {
            CardIdentifierResult(CreditCardType.MAESTRO, MAX_NUMBER, MIN_NUMBER)
        } else {
            CardIdentifierResult.InvalidCard()
        }

    }

    companion object {
        internal val MAX_NUMBER = 16
        internal val MIN_NUMBER = 16
    }

}
