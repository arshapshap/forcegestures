package com.arshapshap.forcegestures.common

import android.graphics.drawable.RippleDrawable
import android.view.View

internal fun View.setHotspot(x: Float, y: Float) {
    if (background is RippleDrawable)
        background.setHotspot(x, y)
    if (foreground is RippleDrawable)
        foreground.setHotspot(x, y)
}