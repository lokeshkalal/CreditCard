package com.dev.lokeshkalal.creditCard.identifier

import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType
import java.util.regex.Pattern

abstract class AbstractIdentifier(val pattern: String) : Identifier {

    override fun validateCard(cardNumber: String): CardIdentifierResult {
        return getResult(cardNumber.matches(pattern.toRegex()))
    }
}