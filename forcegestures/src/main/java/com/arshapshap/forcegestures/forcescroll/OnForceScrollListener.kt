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
     * @param velocityX The current horizontal scroll velocity, where positive values represent scrolling to the right, and negative values represent scrolling to the left.
     * @param velocityY The current vertical scroll velocity, where positive values represent scrolling down, and negative values represent scrolling up.
     */
    fun onForceScroll(view: View, velocityX: Float, velocityY: Float)
}