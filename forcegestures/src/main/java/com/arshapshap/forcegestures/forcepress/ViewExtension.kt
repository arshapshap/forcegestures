package com.arshapshap.forcegestures.forcepress

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper


@SuppressLint("ClickableViewAccessibility")
fun View.setOnForcePressListener(listener: OnForcePressListener?) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                listener?.onForcePress(view, PressureHelper.getNormalizedPressure(event))
            }
        }
        false
    }
}