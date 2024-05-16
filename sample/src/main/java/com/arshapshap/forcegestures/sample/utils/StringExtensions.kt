package com.arshapshap.forcegestures.sample.utils

internal fun String.firstCap() = this.lowercase().replaceFirstChar {
    it.uppercase()
}