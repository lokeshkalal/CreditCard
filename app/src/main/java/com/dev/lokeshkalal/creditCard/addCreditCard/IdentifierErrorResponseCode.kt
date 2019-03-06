package com.dev.lokeshkalal.creditCard.addCreditCard

import androidx.annotation.IntDef

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@IntDef(IdentifierErrorResponseCode.NO_CARD_IDENTIFIED, IdentifierErrorResponseCode.DEBIT_CARD)
@Retention(RetentionPolicy.SOURCE)
annotation class IdentifierErrorResponseCode {
    companion object {
        const val NO_CARD_IDENTIFIED = 2
        const val DEBIT_CARD = 3
    }
}
