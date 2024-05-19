package com.arshapshap.forcegestures

import android.view.MotionEvent
import com.arshapshap.forcegestures.calibration.CalibrationValues.forcePressure
import com.arshapshap.forcegestures.calibration.CalibrationValues.weakPressure

internal object PressureHelper {

    fun isForceTouch(event: MotionEvent): Boolean {
        return getNormalizedPressure(event) >= 0.8f
    }

    fun getRawPressure(event: MotionEvent): Float {
        return event.pressure
    }

    fun getNormalizedPressure(event: MotionEvent): Float {
        return ((event.pressure - weakPressure) / (forcePressure - weakPressure))
            .coerceIn(0f, 1f)
    }

    fun getPressureDeviance(event: MotionEvent): Float {
        return getNormalizedPressure(event) / 0.5f
    }
}