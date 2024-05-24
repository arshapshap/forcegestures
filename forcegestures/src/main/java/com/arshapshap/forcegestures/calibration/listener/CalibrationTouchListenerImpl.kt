package com.arshapshap.forcegestures.calibration.listener

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper

/**
 * An implementation of the [View.OnTouchListener] interface that handles raw pressure events on a [View].
 * This class is used by the [View.setOnRawPressureListener] extension function to set up the appropriate touch listeners
 * and dispatch raw pressure events to the provided [OnRawPressureListener].
 *
 * The purpose of this class is to provide raw pressure values to the listener during the calibration process,
 * which can be used to determine appropriate weak and force pressure thresholds for the device.
 *
 * @property listener The [OnRawPressureListener] instance that will receive the raw pressure events, or null if no listener is set.
 */
class CalibrationTouchListenerImpl(
    private val listener: OnRawPressureListener?
) : View.OnTouchListener {

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                listener?.onTouch(view, PressureHelper.getRawPressure(event))
                view.performClick()
            }
        }
        return false
    }
}