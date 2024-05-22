package com.arshapshap.forcegestures.forcepress

import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import com.arshapshap.forcegestures.PressureHelper

/**
 * An implementation of the [View.OnTouchListener] interface that handles continuous force press events on a [View].
 * This class is used internally by the [View.setOnForcePressListener] extension function to set up the appropriate touch listeners
 * and dispatch events to the provided [OnForcePressListener].
 *
 * @property listener The [OnForcePressListener] instance that will receive the force press events, or null if no listener is set.
 */
class PressListenerImpl(
    private val listener: OnForcePressListener?
) : OnTouchListener {

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                listener?.onForcePress(view, PressureHelper.getNormalizedPressure(event))
            }

            MotionEvent.ACTION_UP -> {
                view.performClick()
            }
        }
        return false
    }
}