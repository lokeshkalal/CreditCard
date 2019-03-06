package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

class DinerCardIdentifier : Identifier {
    internal var pattern: String

    init {
        pattern = "^3(?:0[0-5]|[68][0-9])[0-9]{0,11}$"
    }

    override fun validateCard(cardNumner: String): CardIdentifierResult {
        return if (cardNumner.matches(pattern.toRegex())) {
            CardIdentifierResult(CreditCardType.DINER, MAX_NUMBER, MIN_NUMBER)
        } else {
            CardIdentifierResult.InvalidCard()
        }
    }

    companion object {
        internal val MAX_NUMBER = 14
        internal val MIN_NUMBER = 14
    }
}
