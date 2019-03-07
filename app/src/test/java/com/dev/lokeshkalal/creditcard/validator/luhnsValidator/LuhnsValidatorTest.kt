package com.dev.lokeshkalal.creditcard.validator.luhnsValidator

import com.dev.lokeshkalal.creditCard.validator.luhnsValidator.LuhnsValidator
import org.junit.Test

import org.junit.Assert.*

class LuhnsValidatorTest {

    @Test
    fun testValidCard() {
        val luhnsValidator: LuhnsValidator  = LuhnsValidator()
        assertTrue(luhnsValidator.validateCard("374640238392287"))
    }

    @Test
    fun testInValidCard() {
        val luhnsValidator: LuhnsValidator  = LuhnsValidator()
        assertFalse(luhnsValidator.validateCard("374640238392288"))
    }
}