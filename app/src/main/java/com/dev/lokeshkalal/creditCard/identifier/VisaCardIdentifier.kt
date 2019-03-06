package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

class VisaCardIdentifier : AbstractIdentifier(PATTERN) {
    override fun getResult(isIdentified: Boolean): CardIdentifierResult {
        return if (isIdentified) {
            CardIdentifierResult(CreditCardType.VISA, MAX_NUMBER, MIN_NUMBER)
        } else {
            CardIdentifierResult.InvalidCard()
        }
    }

    companion object {
        internal val MAX_NUMBER = 16
        internal val MIN_NUMBER = 16
        internal val PATTERN = "^4[0-9]{0,15}\$"
    }
}
