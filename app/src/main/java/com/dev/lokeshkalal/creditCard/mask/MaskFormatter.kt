package com.dev.lokeshkalal.creditCard.mask

import android.text.Editable

interface MaskFormatter {
    fun format(text: String): String
    fun unformat(formatted: String): String
    fun setMask(mask: String, maskPlaceholder: String)
    fun isPlaceHolder(char: Char) : Boolean
}