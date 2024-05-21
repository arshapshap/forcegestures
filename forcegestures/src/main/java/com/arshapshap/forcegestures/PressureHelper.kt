package com.arshapshap.forcegestures

import android.view.MotionEvent
import com.arshapshap.forcegestures.calibration.PressureCalibrator.forcePressure
import com.arshapshap.forcegestures.calibration.PressureCalibrator.weakPressure

internal object PressureHelper {

    fun isForceTouch(event: MotionEvent, threshold: Float = 0.8f): Boolean {
        return getNormalizedPressure(event) >= threshold
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