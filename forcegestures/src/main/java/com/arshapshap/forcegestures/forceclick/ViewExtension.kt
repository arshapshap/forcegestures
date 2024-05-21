package com.arshapshap.forcegestures.forceclick

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.DEFAULT_FORCE_TOUCH_THRESHOLD
import com.arshapshap.forcegestures.PressureHelper

fun View.setOnForceClickListener(
    listener: OnForceClickListener?,
    threshold: Float = DEFAULT_FORCE_TOUCH_THRESHOLD
) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (PressureHelper.isForceTouch(event, threshold))
                    listener?.onForceClick(view)
                else
                    listener?.onNormalClick(view)
                performClick()
            }
        }
        false
    }
}