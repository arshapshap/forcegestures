package com.arshapshap.forcegestures.forcepress

import android.view.View

/**
 * Listener interface for receiving force press events on a [View].
 *
 * This interface should be implemented by classes that need to handle force press events on a [View].
 * The [onForcePress] method will be called continuously while a force press (a press with increased
 * pressure) is detected on the associated [View], providing the current pressure value.
 *
 * To set an instance of this listener on a [View], use the [View.setOnForcePressListener] extension
 * function.
 */
interface OnForcePressListener {

    /**
     * Called continuously while a force press (a press with increased pressure) is detected on the
     * associated [View].
     *
     * @param view The [View] that received the force press event.
     * @param pressure The current pressure value, ranging from 0.0 (no pressure) to 1.0 (maximum pressure).
     */
    fun onForcePress(view: View, pressure: Float)
}