package com.dev.lokeshkalal.creditCard;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({IdentifierErrorResponseCode.NO_CARD_IDENTIFIED, IdentifierErrorResponseCode.DEBIT_CARD})
@Retention(RetentionPolicy.SOURCE)
public @interface IdentifierErrorResponseCode {

    int NO_CARD_IDENTIFIED = 2;
    int DEBIT_CARD = 3;
}
