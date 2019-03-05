package com.dev.lokeshkalal.creditCard;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({ValidatorErrorResponseCode.INVALID_CARD, ValidatorErrorResponseCode.INVALID_LENGTH})
@Retention(RetentionPolicy.SOURCE)
public @interface ValidatorErrorResponseCode {

    int INVALID_CARD = 2;
    int INVALID_LENGTH = 3;
}
