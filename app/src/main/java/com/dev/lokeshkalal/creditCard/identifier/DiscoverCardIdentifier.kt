package com.dev.lokeshkalal.creditCard.identifier


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

class DiscoverCardIdentifier : AbstractIdentifier(PATTERN) {
    override fun validateCard(cardNumber: String): CardIdentifierResult {
        return if (cardNumber.matches(pattern.toRegex())) {
            CardIdentifierResult(CreditCardType.DISCOVER, MAX_NUMBER, MIN_NUMBER)
        } else {
            CardIdentifierResult.InvalidCard()
        }
    }

    companion object {
        internal val MAX_NUMBER = 16

        internal val MIN_NUMBER = 16

        internal val PATTERN =
            "^65[4-9][0-9]{0,13}|64[4-9][0-9]{0,13}|6011[0-9]{0,12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{0,10})\$"
    }
}
