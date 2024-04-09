package com.arshapshap.forcegestures.sample.utils

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.graphics.drawable.RippleDrawable
import androidx.annotation.ColorInt

internal fun Drawable.setRippleColor(@ColorInt color: Int) {
    (this as RippleDrawable).setColor(ColorStateList.valueOf(color))
}