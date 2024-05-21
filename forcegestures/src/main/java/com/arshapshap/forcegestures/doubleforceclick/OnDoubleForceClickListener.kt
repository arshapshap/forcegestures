package com.arshapshap.forcegestures.doubleforceclick

import android.view.View

/**
 * Listener interface for receiving double force click and double normal click events on a [View].
 *
 * This interface should be implemented by classes that need to handle double force click and double normal click
 * events on a [View]. The [onDoubleForceClick] method will be called when a double force click (two quick force clicks)
 * is detected, and the [onDoubleNormalClick] method will be called for a regular double click.
 *
 * To set an instance of this listener on a [View], use the [View.setOnDoubleForceClickListener] extension
 * function.
 */
interface OnDoubleForceClickListener {

    /**
     * Called when a double force click (two quick force clicks) is detected on the associated [View].
     *
     * @param view The [View] that received the double force click event.
     */
    fun onDoubleForceClick(view: View)

    /**
     * Called when a double normal click (without increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the double normal click event.
     */
    fun onDoubleNormalClick(view: View)
}