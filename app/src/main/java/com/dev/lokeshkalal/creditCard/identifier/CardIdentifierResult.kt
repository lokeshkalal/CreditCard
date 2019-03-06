package com.dev.lokeshkalal.creditCard.identifier

import com.dev.lokeshkalal.creditCard.common.Constants
import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

data class CardIdentifierResult(val cardType: CreditCardType, val maxNumber: Int, val minNumber: Int) {

    val isValidCard: Boolean
        get() = cardType !== CreditCardType.INVALID

    val cardName: String
        get() = cardType.toString()

    override fun toString(): String {
        return "CardIdentifierResult{" +
                "creditCardType=" + cardType +
                ", maxNumber=" + maxNumber +
                '}'.toString()
    }


    companion object {


        fun InvalidCard(): CardIdentifierResult {
            return CardIdentifierResult(
                CreditCardType.INVALID,
                Constants.MAX_DEFAULT_CARD_NUMBER,
                Constants.MAX_DEFAULT_CARD_NUMBER
            )
        }
    }
}
