package com.arshapshap.forcegestures

import android.view.MotionEvent
import com.arshapshap.forcegestures.calibration.CalibrationHelper

internal object PressureHelper {

    fun isForceTouch(event: MotionEvent): Boolean {
        return event.pressure >= (CalibrationHelper.normalPressure + CalibrationHelper.forcePressure) / 2
    }

    fun getPressure(event: MotionEvent): Float {
        return event.pressure
    }

    fun getPressureDeviance(event: MotionEvent): Float {
        return event.pressure / CalibrationHelper.normalPressure
    }
}