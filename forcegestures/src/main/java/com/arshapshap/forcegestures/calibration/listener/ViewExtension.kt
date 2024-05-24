package com.arshapshap.forcegestures.calibration.listener

import android.view.View

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
    setOnTouchListener(RawPressureListenerImpl(listener))
}