package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType
import java.util.concurrent.ArrayBlockingQueue

class JCBCardIdentifier : AbstractIdentifier(PATTERN) {
    override fun validateCard(cardNumber: String): CardIdentifierResult {
        return if (cardNumber.matches(pattern.toRegex())) {
            CardIdentifierResult(CreditCardType.JCB, MAX_NUMBER, MIN_NUMBER)
        } else {
            CardIdentifierResult.InvalidCard()
        }
    }

    companion object {
        internal val MAX_NUMBER = 16
        internal val MIN_NUMBER = 16
        internal val PATTERN =  "^(?:2131|1800|35\\d{0,3})\\d{0,11}\$"
    }

}
