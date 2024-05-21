package com.arshapshap.forcegestures.forcescale

import android.view.View

/**
 * Functional interface for receiving force scale events on a [View].
 *
 * This interface should be implemented by lambda functions that need to handle force scale events
 * on a [View]. The [onForceScale] method will be called continuously while a force scale (a pinch-to-zoom
 * gesture with increased pressure) is detected on the associated [View], providing the current scale factor.
 *
 * To set an instance of this listener on a [View], use the [View.setOnForceScaleListener] extension
 * function.
 */
fun interface OnForceScaleListener {

    /**
     * Called continuously while a force scale (a pinch-to-zoom gesture with increased pressure) is detected
     * on the associated [View].
     *
     * @param view The [View] that received the force scale event.
     * @param scaleFactor The current scale factor, where 1.0 represents no scaling, values less than 1.0
     *                    represent scaling down (zooming out), and values greater than 1.0 represent
     *                    scaling up (zooming in).
     */
    fun onForceScale(view: View, scaleFactor: Float)
}