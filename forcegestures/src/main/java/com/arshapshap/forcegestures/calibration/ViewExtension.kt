package com.arshapshap.forcegestures.calibration

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper

/**
 * Sets an [OnCalibrationPressureListener] on this [View] to receive raw pressure events for calibration purposes.
 *
 * This function should be used during the calibration process to gather raw pressure values for determining
 * the appropriate weak and force pressure thresholds.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnCalibrationPressureListener] instance to receive raw pressure events, or null to clear the existing listener.
 *
 * @see OnCalibrationPressureListener
 */
fun View.setOnRawPressureListener(listener: OnCalibrationPressureListener?) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                listener?.onTouch(view, PressureHelper.getRawPressure(event))
                performClick()
            }
        }
        false
    }
}