package com.santi.mercadolibre.utils

import java.text.DecimalFormat

fun String?.imageConverter(): String {
    return this?.substring(0, 4) + "s" + this?.substring(4, this.length)
}

fun Number?.toCurrencyString(): String {
    val format = DecimalFormat("\$ #,##0")
    return try {
        format.format(this ?: 0)
    } catch (e: IllegalArgumentException) {
        format.format(0)
    }
}