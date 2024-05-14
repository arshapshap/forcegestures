package com.arshapshap.forcegestures

import android.view.MotionEvent

internal object PressureHelper {

    fun isForceTouch(event: MotionEvent): Boolean {
        return event.pressure >= 0.2f
    }

    fun getPressure(event: MotionEvent): Float {
        return event.pressure
    }

    fun getPressureDeviance(event: MotionEvent): Float {
        return event.pressure / 0.15f
    }
}