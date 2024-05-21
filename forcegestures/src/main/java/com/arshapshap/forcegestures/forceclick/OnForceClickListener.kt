package com.arshapshap.forcegestures.forceclick

import android.view.View

/**
 * Listener interface for receiving force click and normal click events on a [View].
 *
 * This interface should be implemented by classes that need to handle force click and normal click
 * events on a [View]. The [onForceClick] method will be called when a force click (a click with
 * increased pressure) is detected, and the [onNormalClick] method will be called for a regular
 * click.
 *
 * To set an instance of this listener on a [View], use the [View.setOnForceClickListener] extension
 * function.
 */
interface OnForceClickListener {

    /**
     * Called when a force click (a click with increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the force click event.
     */
    fun onForceClick(view: View)

    /**
     * Called when a normal click (without increased pressure) is detected on the associated [View].
     *
     * @param view The [View] that received the normal click event.
     */
    fun onNormalClick(view: View)
}
