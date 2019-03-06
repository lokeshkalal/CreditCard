package com.dev.lokeshkalal.creditCard.validator.service

interface CardValidatorService {

    fun validateCard(cardnumber: String): Boolean
}
