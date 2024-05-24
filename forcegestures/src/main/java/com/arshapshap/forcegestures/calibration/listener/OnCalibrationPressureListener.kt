package com.arshapshap.forcegestures.calibration.listener

import android.view.View

/**
 * Functional interface for receiving touch events on a [View] for calibration purposes.
 *
 * This interface should be implemented by lambda functions that need to handle raw pressure events
 * on a View during the calibration process. The [onTouch] method will be called when a touch
 * event with pressure information is detected on the associated View, providing the raw pressure value.
 *
 * To set an instance of this listener on a View during calibration, use the [View.setOnRawPressureListener]
 * extension function.
 */
fun interface OnCalibrationPressureListener {

    /**
     * Called when a touch event with pressure information is detected on the associated [View].
     *
     * @param view The [View] that received the touch event.
     * @param pressure The raw pressure value, ranging from 0.0 (no pressure) to 1.0 (maximum pressure).
     */
    fun onTouch(view: View, pressure: Float)
}