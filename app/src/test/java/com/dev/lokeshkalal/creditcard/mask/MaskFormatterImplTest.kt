package com.dev.lokeshkalal.creditcard.mask

import com.dev.lokeshkalal.creditCard.mask.MaskFormatter
import com.dev.lokeshkalal.creditCard.mask.MaskFormatterImpl
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MaskFormatterImplTest {


    @Test
    fun testMaskFromatting() {
        val maskFormatter: MaskFormatter = MaskFormatterImpl("#### ####", "#")
        assertEquals(maskFormatter.format("12345678"),"1234 5678")
    }

    @Test
    fun testMaskUnformatting() {
        val maskFormatter: MaskFormatter = MaskFormatterImpl("#### ####", "#")
        assertEquals(maskFormatter.unformat("1234 5678"),"12345678")

    }
}