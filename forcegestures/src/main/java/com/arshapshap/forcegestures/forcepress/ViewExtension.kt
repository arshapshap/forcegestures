package com.arshapshap.forcegestures.forcepress

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper

fun View.setOnForcePressListener(listener: OnForcePressListener?) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                listener?.onForcePress(view, PressureHelper.getNormalizedPressure(event))
            }
        }
        if (event.action == MotionEvent.ACTION_DOWN)
            performClick()
        false
    }
}