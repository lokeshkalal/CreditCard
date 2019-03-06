package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

class DinerCardIdentifier : AbstractIdentifier(PATTERN) {

    override fun getResult(isIdentified: Boolean): CardIdentifierResult {
        return if (isIdentified) {
            CardIdentifierResult(
                CreditCardType.DINER,
                MAX_NUMBER,
                MIN_NUMBER
            )
        } else {
            CardIdentifierResult.InvalidCard()
        }
    }

    companion object {
        internal val MAX_NUMBER = 14
        internal val MIN_NUMBER = 14
        internal val PATTERN = "^36[0-9]{0,12}\$"
    }
}
