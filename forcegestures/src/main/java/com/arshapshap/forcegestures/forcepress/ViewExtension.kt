package com.arshapshap.forcegestures.forcepress

import android.view.MotionEvent
import android.view.View
import com.arshapshap.forcegestures.PressureHelper

/**
 * Sets an [OnForcePressListener] on this [View] to receive continuous force press events.
 *
 * @receiver The [View] on which the listener will be set.
 * @param listener The [OnForcePressListener] instance to receive force press events, or null to clear the existing listener.
 *
 * @see OnForcePressListener
 */
fun View.setOnForcePressListener(listener: OnForcePressListener?) {
    setOnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                listener?.onForcePress(view, PressureHelper.getNormalizedPressure(event))
            }
        }
        if (event.action == MotionEvent.ACTION_DOWN)
            performClick()
        false
    }
}