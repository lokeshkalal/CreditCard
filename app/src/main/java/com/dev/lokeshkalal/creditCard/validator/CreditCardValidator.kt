package com.dev.lokeshkalal.creditCard.validator


import com.dev.lokeshkalal.creditCard.addCreditCard.CreditCardType

import java.util.HashMap


class CreditCardValidator {

    fun validate(cardNumber: String): CreditCardType {
        for ((key, value) in regexes) {
            if (cardNumber.matches(value.toRegex()))
                return key
        }
        return CreditCardType.INVALID
    }

    class CardResult

    companion object {

        private val regexes = object : HashMap<CreditCardType, String>() {
            init {
                put(CreditCardType.VISA, "^4\\d{3}([\\ \\-]?)(?:\\d{4}\\1){2}\\d(?:\\d{3})?$")
                put(CreditCardType.MASTERCARD, "^5[1-5]\\d{2}([\\ \\-]?)\\d{4}\\1\\d{4}\\1\\d{4}$")
                put(CreditCardType.AMERICAN_EXPRESS, "^3[47]\\d\\d([\\ \\-]?)\\d{6}\\1\\d{5}$")
            }
        }
    }
}
