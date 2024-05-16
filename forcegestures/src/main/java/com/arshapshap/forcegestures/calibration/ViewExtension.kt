package com.arshapshap.forcegestures.calibration

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper

@SuppressLint("ClickableViewAccessibility")
fun View.setOnTouchWithPressureListener(listener: OnTouchWithPressureListener?) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                listener?.onTouch(view, PressureHelper.getPressure(event))
            }
        }
        false
    }
}