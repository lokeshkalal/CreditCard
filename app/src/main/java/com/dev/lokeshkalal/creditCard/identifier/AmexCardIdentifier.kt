package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

class AmexCardIdentifier : AbstractIdentifier(PATTERN) {
    override fun validateCard(cardNumber: String): CardIdentifierResult {
        return if (cardNumber.matches(pattern.toRegex())) {
            CardIdentifierResult(CreditCardType.AMERICAN_EXPRESS, MAX_NUMBER, MIN_NUMBER)
        } else {
            CardIdentifierResult.InvalidCard()
        }
    }

    companion object {
        internal val MAX_NUMBER = 15

        internal val MIN_NUMBER = 15

        internal val PATTERN = "^3[47][0-9]{0,13}\$"
    }
}
