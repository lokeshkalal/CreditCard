package com.dev.lokeshkalal.creditCard.mask


class MaskFormatterImpl : MaskFormatter {

    var mask: String
    var maskPlaceHolder: String

    constructor(mask: String, maskPlaceholder: String) {
        this.mask = mask
        this.maskPlaceHolder = maskPlaceholder
    }


    override fun unformat(formatted: String): String {
        // implementation can be generic but for now it will work
        if (formatted.isNullOrEmpty()) return ""
        return formatted.replace(" ", "")
    }

    override fun setMask(mask: String, maskPlaceholder: String) {
        this.mask = mask
        this.maskPlaceHolder = maskPlaceholder

    }

    override fun format(text: String): String {
        val formatted = StringBuilder()
        text.apply {
            val list = toMutableList()
            mask.forEach { m ->
                if (list.isNullOrEmpty()) return@forEach
                var c = list[0]
                if (isPlaceHolder(m)) {
                    if (!c.isDigit()) {
                        val iterator = list.iterator()
                        while (iterator.hasNext()) {
                            c = iterator.next()
                            if (c.isDigit()) break
                            iterator.remove()
                        }
                    }
                    if (list.isNullOrEmpty()) return@forEach
                    formatted.append(c)
                    list.removeAt(0)
                } else {
                    formatted.append(m)
                    if (m == c) {
                        list.removeAt(0)
                    }
                }
            }

        }

        return formatted.toString()
    }


     override fun isPlaceHolder(c: Char): Boolean {
        return c.toString().equals(maskPlaceHolder)
    }
}