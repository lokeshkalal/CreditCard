package com.dev.lokeshkalal.creditCard.validator.service

import com.dev.lokeshkalal.creditCard.validator.luhnsValidator.LuhnsValidator
import com.dev.lokeshkalal.creditCard.validator.luhnsValidator.Validator

import javax.inject.Inject

class CardValidatorServiceImpl @Inject
constructor() : CardValidatorService {


    internal var validator: Validator

    init {
        validator = LuhnsValidator()
    }

    override fun validateCard(cardnumber: String): Boolean {
        return validator.validateCard(cardnumber)
    }
}
