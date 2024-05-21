package com.arshapshap.forcegestures.forcescroll

import android.view.View

/**
 * Functional interface for receiving force scroll events on a [View].
 *
 * This interface should be implemented by lambda functions that need to handle force scroll events
 * on a [View]. The [onForceScroll] method will be called continuously while a force scroll (a scroll
 * gesture with increased pressure) is detected on the associated [View], providing the current scroll
 * velocity.
 *
 * To set an instance of this listener on a [View], use the [View.setOnForceScrollListener] extension
 * function.
 */
fun interface OnForceScrollListener {

    /**
     * Called continuously while a force scroll (a scroll gesture with increased pressure) is detected
     * on the associated View.
     *
     * @param view The [View] that received the force scroll event.
     * @param velocity The current scroll velocity, where positive values represent scrolling in the
     *                 positive direction (down for vertical orientation, right for horizontal orientation),
     *                 and negative values represent scrolling in the negative direction.
     */
    fun onForceScroll(view: View, velocity: Float)
}