package com.dev.lokeshkalal.creditCard.validator;


import com.dev.lokeshkalal.creditCard.CreditCardType;

import java.util.HashMap;
import java.util.Map;


public class CreditCardValidator {

    private static final Map<CreditCardType, String> regexes = new HashMap<CreditCardType, String>() {{
        put(CreditCardType.VISA, "^4\\d{3}([\\ \\-]?)(?:\\d{4}\\1){2}\\d(?:\\d{3})?$");
        put(CreditCardType.MASTERCARD, "^5[1-5]\\d{2}([\\ \\-]?)\\d{4}\\1\\d{4}\\1\\d{4}$");
        put(CreditCardType.AMERICAN_EXPRESS, "^3[47]\\d\\d([\\ \\-]?)\\d{6}\\1\\d{5}$");
    }};

    public CreditCardType validate(String cardNumber) {
        for (Map.Entry<CreditCardType, String> entry : regexes.entrySet()) {
            if (cardNumber.matches(entry.getValue()))
                return entry.getKey();
        }
        return CreditCardType.INVALID;
    }

    public static class CardResult {
    }
}
