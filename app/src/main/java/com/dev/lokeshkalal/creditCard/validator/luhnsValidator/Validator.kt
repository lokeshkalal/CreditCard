package com.dev.lokeshkalal.creditCard.validator.luhnsValidator

interface Validator {
    fun validateCard(cardnumber: String): Boolean
}
