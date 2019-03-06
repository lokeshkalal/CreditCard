package com.dev.lokeshkalal.creditCard.validator.luhnsValidator

import android.util.Log


class LuhnsValidator : Validator {


    override fun validateCard(cardnumber: String): Boolean {

        if (cardnumber.isNullOrEmpty())
            return false

        fun sumDigits(n: Int) = n / 10 + n % 10

        val reverseString = cardnumber.reversed()
        val s1 = reverseString.filterIndexed { i, _ -> i % 2 == 0 }.sumBy { it - '0' }
        val s2 = reverseString.filterIndexed { i, _ -> i % 2 == 1 }.map { sumDigits((it - '0') * 2) }.sum()
        return (s1 + s2) % 10 == 0
    }

}
