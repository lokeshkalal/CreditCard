package com.dev.lokeshkalal.creditCard.addCreditCard

import androidx.annotation.IntDef

import java.lang.annotation.RetentionPolicy

@IntDef(ValidatorErrorResponseCode.INVALID_CARD, ValidatorErrorResponseCode.INVALID_LENGTH)
@Retention(AnnotationRetention.SOURCE)
annotation class ValidatorErrorResponseCode {
    companion object {
        const val INVALID_CARD = 2
        const val INVALID_LENGTH = 3
    }
}
